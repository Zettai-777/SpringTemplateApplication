package rest.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = "rest")
public class RestTemplateConfig {

//    @Bean
//    public RestTemplateBuilder templateBuilder(){
//        return new RestTemplateBuilder();
//    }
//
//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder templateBuilder){
//        return templateBuilder.
//                requestFactory(new BufferingClientHttpRequestFactory(new HttpComponentsClientHttpRequestFactory()))
//                .interceptors(new RestTemplateInterceptor())
//                .build();
//    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
