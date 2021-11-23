package com.example.aftercoivdspringfront.controller;


import com.example.aftercoivdspringfront.dto.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    @Value("${after-coivd-api.host}")
    private String apiHost;

    private final Environment env;


    @PostMapping("/create-user")
    @ResponseBody
    public void createUser(@RequestBody final CreateUserRequest  request) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Void> voidResponseEntity = restTemplate.postForEntity(apiHost + "/users", request, Void.class);
        HttpStatus statusCode = voidResponseEntity.getStatusCode();
    }



}
