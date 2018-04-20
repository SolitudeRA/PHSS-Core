package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import service.main.UserService;
import service.impl.UserServiceImpl;
import service.object.JsonUser;

//TODO: User controller implement
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping("/register")
    public String register(@RequestBody String user) throws Exception {
        UserService userService = new UserServiceImpl();
        return userService.saveUser(user);
    }

    @RequestMapping("/login")
    public String login(@RequestBody String user) throws Exception {
        UserService userService = new UserServiceImpl();
        ObjectMapper mapper = new ObjectMapper();
        JsonUser jsonUser = mapper.readValue(user, JsonUser.class);
        return userService.checkUser(jsonUser.getUsername(), jsonUser.getPassword());
    }

    @RequestMapping("/profile/{user}")
    public String getProfile(@PathVariable int user) throws Exception {
        UserService userService = new UserServiceImpl();
        return userService.getUser(user);
    }

    @RequestMapping("/remove")
    public boolean deleteProfile(@RequestParam int id) throws Exception {
        UserService userService = new UserServiceImpl();
        return userService.removeUser(id);
    }
}
