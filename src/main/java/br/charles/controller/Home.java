package br.charles.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @RequestMapping("/")
    public String home() {
        return " Contact Microservice Spring Boot with Docker And Swagger2 => <a href='http://localhost:8080/swagger-ui.html'>http://localhost:8080/swagger-ui.html</a>";
    }

}
