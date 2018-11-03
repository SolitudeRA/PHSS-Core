package org.protogalaxy.phss.controller;

import org.protogalaxy.phss.service.main.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping("/register")
    public String register(@Param("username") String username, @Param("password") String password) throws Exception {
        return userService.register(username, password);
    }

    @PreAuthorize("isFullyAuthenticated()&&(#username==principal.username)")
    @GetMapping("/{username}")
    public String getUser(@PathVariable String username) throws Exception {
        return userService.getUser(username);
    }
}
