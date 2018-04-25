package me.protogalaxy.controller;

import org.springframework.web.bind.annotation.*;

//TODO: User controller implement
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @RequestMapping("/register")
    public String register(@RequestBody String user) throws Exception {
        return null;
    }

    @RequestMapping("/profile/{user}")
    public String getProfile(@PathVariable int user) throws Exception {
        return null;
    }

    @RequestMapping("/remove")
    public boolean deleteProfile(@RequestParam int id) throws Exception {
        return false;
    }
}
