package rest.configs;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {
    private String cookie;

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        if(cookie != null){
            httpRequest.getHeaders().add(HttpHeaders.COOKIE, cookie);
        }
        ClientHttpResponse response = clientHttpRequestExecution.execute(httpRequest, bytes);

        if(cookie == null){
            cookie = response.getHeaders().getFirst(HttpHeaders.SET_COOKIE);
        }

        return response;
    }


}
