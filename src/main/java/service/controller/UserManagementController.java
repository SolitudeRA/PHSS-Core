package service.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class UserManagementController {
    @RequestMapping("/login")
    public String login(){
        return "hello world";
    }

    public static void main(String args[]) throws Exception{
        SpringApplication.run(UserManagementController.class, args);
    }
}
