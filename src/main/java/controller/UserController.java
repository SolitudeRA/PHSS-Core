package controller;

import datasource.entity.core.user.UserEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import service.UserService;
import service.impl.UserServiceImpl;

//TODO: User controller implement
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/users")
public class UserController {
    @RequestMapping("/login")
    public String login() throws Exception {
        UserService userService = new UserServiceImpl();
        return null;
    }

    @RequestMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@PathVariable UserEntity userEntity) {

    }

    @RequestMapping("/{user}")
    public void deleteUser(@PathVariable Long user) {

    }
}
