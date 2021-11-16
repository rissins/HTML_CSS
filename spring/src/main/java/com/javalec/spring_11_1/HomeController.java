package com.javalec.spring_11_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class HomeController {

    @RequestMapping("/")
    String home() {
        return "Hello World111111!";
    }

    public static void main(String[] args) {
        SpringApplication.run(HomeController.class, args);
    }
}



