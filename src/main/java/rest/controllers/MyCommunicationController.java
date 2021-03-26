package rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import rest.models.User;

import java.util.List;

@Component
public class MyCommunicationController {

    public static final String URL = "http://91.241.64.178:7081/api/users";
    public static String cookies;
    private final RestTemplate restTemplate;

    @Autowired
    public MyCommunicationController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<User> getAllUsers(){
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<User>>(){});
        List<User> allUsers = responseEntity.getBody();
        cookies = responseEntity.getHeaders().get("Set-Cookie").get(0);
//        System.out.println(cookies);
        return allUsers;
    }

    public String saveNewUser(){
        User user3 = getUser(3L, "James", "Brown", (byte) 17);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Cookie", cookies);
        HttpEntity<User> httpEntity = new HttpEntity<>(user3, httpHeaders);
        ResponseEntity<String> entity = restTemplate.exchange(URL, HttpMethod.POST,
                httpEntity, String.class);
        return  entity.getBody();
    }

    public String updateUser3(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Cookie", cookies);
        User user3 = getUser(3L,"Thomas", "Shelby", (byte) 12);
        ResponseEntity<String > entity = restTemplate.exchange(URL, HttpMethod.PUT,
                new HttpEntity<>(user3, httpHeaders), String.class);
        return entity.getBody();
    }

    public String deleteUser3(int id){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Cookie", cookies);
        User user3 = getUser(0L,"", "", (byte) 17);
        ResponseEntity<String > entity = restTemplate.exchange(URL + "/" + id, HttpMethod.DELETE,
                new HttpEntity<>(user3, httpHeaders), String.class);
        return entity.getBody();
    }

    private User getUser(Long id, String name, String lastName, byte age){
        User user3 = new User();
        user3.setId(id);
        user3.setName(name);
        user3.setLastName(lastName);
        user3.setAge(age);
        return user3;
    }
}
