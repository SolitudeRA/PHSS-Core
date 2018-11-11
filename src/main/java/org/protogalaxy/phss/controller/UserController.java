package org.protogalaxy.phss.controller;

import org.protogalaxy.phss.datasource.resource.main.user.UserResource;
import org.protogalaxy.phss.service.main.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*", maxAge = 3600)
@ExposesResourceFor(UserResource.class)
public class UserController {
    private EntityLinks entityLinks;
    private UserServiceImpl userService;

    @Autowired
    public UserController(
            EntityLinks entityLinks,
            UserServiceImpl userService) {
        this.entityLinks = entityLinks;
        this.userService = userService;
    }

    @RequestMapping("/register")
    public String register(@Param("username") String username, @Param("password") String password) throws Exception {
        return userService.register(username, password);
    }

    @PreAuthorize("isFullyAuthenticated()&&(#username==principal.username)")
    @GetMapping("/{username}")
    public ResponseEntity getUser(@PathVariable String username) {
        return new ResponseEntity<>(new UserResource(userService.getUser(username)), HttpStatus.OK);
    }
}
