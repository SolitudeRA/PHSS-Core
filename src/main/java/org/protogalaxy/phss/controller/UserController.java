package org.protogalaxy.phss.controller;


import org.protogalaxy.phss.datasource.resource.assembler.user.UserResourceAssembler;
import org.protogalaxy.phss.datasource.resource.main.entity.user.UserResource;
import org.protogalaxy.phss.service.main.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/user")
@ExposesResourceFor(UserResource.class)
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    private UserServiceImpl userService;
    private UserResourceAssembler userResourceAssembler = new UserResourceAssembler();

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @RequestMapping("/register")
    public String register(@Param("username") String username, @Param("password") String password) throws Exception {
        return userService.register(username, password);
    }

    @PreAuthorize("isFullyAuthenticated()&&(#username==principal.username)")
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public ResponseEntity<UserResource> getUser(@PathVariable String username) {
        return new ResponseEntity<>(userResourceAssembler.toResource(userService.getUser(username)), HttpStatus.OK);
    }
}
