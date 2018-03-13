package controller;

import datasource.entity.userManagementCore.UserEntity;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/users")
public class UserController {
    @GetMapping("/{user}")
    public UserEntity getUser(@PathVariable Long user) {

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@PathVariable UserEntity userEntity) {

    }

    @DeleteMapping("/{user}")
    public UserEntity deleteUser(@PathVariable Long user) {

    }
}
