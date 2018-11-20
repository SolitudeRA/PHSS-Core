package org.protogalaxy.phss.controller;


import org.protogalaxy.phss.datasource.resource.assembler.account.AccountResourceAssembler;
import org.protogalaxy.phss.datasource.resource.main.entity.account.AccountResource;
import org.protogalaxy.phss.exception.UserNotFoundException;
import org.protogalaxy.phss.service.main.account.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/account")
@ExposesResourceFor(AccountResource.class)
@CrossOrigin(origins = "*", maxAge = 3600)
public class AccountController {
    private AccountServiceImpl accountService;
    private AccountResourceAssembler accountResourceAssembler = new AccountResourceAssembler();

    @Autowired
    public AccountController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Param("username") String username, @Param("password") String password) throws Exception {
        return accountService.register(username, password);
    }

    @PreAuthorize("isFullyAuthenticated()&&(#username==principal.username)")
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public ResponseEntity<AccountResource> getUser(@PathVariable String username) throws UserNotFoundException {
        return new ResponseEntity<>(accountResourceAssembler.toResource(accountService.getAccount(username)), HttpStatus.OK);
    }

    @PreAuthorize("isFullyAuthenticated()&&(#username==principal.username)")
    @RequestMapping(value = "/{username}/enable", method = RequestMethod.PATCH)
    public ResponseEntity enableAccount(@PathVariable String username) throws UserNotFoundException {
        accountService.enableAccount(username);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PreAuthorize("isFullyAuthenticated()&&(#username==principal.username)")
    @RequestMapping(value = "/{username}/disable", method = RequestMethod.PATCH)
    public ResponseEntity disableAccount(@PathVariable String username) throws UserNotFoundException {
        accountService.disableAccount(username);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PreAuthorize("isFullyAuthenticated()&&(#username==principal.username)")
    @RequestMapping(value = "/{username}/lock", method = RequestMethod.PATCH)
    public ResponseEntity lockAccount(@PathVariable String username) throws UserNotFoundException {
        accountService.lockAccount(username);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PreAuthorize("isFullyAuthenticated()&&(#username==principal.username)")
    @RequestMapping(value = "/{username}/unlock", method = RequestMethod.PATCH)
    public ResponseEntity unlockAccount(@PathVariable String username) throws UserNotFoundException {
        accountService.unlockAccount(username);
        return new ResponseEntity(HttpStatus.OK);

    }

    @PreAuthorize("isFullyAuthenticated()&&(#username==principal.username)")
    @RequestMapping(value = "/{username}/expire", method = RequestMethod.PATCH)
    public ResponseEntity expireAccount(@PathVariable String username) throws UserNotFoundException {
        accountService.expireAccount(username);
        return new ResponseEntity(HttpStatus.OK);
    }
}
