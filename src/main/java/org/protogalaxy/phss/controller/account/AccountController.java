package org.protogalaxy.phss.controller.account;


import org.protogalaxy.phss.datasource.resource.assembler.account.AccountResourceAssembler;
import org.protogalaxy.phss.datasource.resource.main.entity.account.AccountResource;
import org.protogalaxy.phss.exception.application.base.account.AccountServiceException;
import org.protogalaxy.phss.service.interfaces.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/account")
@ExposesResourceFor(AccountResource.class)
@CrossOrigin(origins = "*", maxAge = 3600)
public class AccountController {
    private AccountService accountService;
    private AccountResourceAssembler accountResourceAssembler = new AccountResourceAssembler();

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<AccountResource> register(@Param("username") String username, @Param("password") String password) throws AccountServiceException {
        return new ResponseEntity<>(accountResourceAssembler.toResource(accountService.register(username, password)), HttpStatus.OK);
    }

    @PreAuthorize("isFullyAuthenticated()&&(#username==principal.username)")
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public ResponseEntity<AccountResource> getAccount(@PathVariable String username) throws AccountServiceException {
        return new ResponseEntity<>(accountResourceAssembler.toResource(accountService.getAccount(username)), HttpStatus.OK);
    }

    @PreAuthorize("isFullyAuthenticated()&&(#username==principal.username)")
    @RequestMapping(value = "/{username}/update", method = RequestMethod.PUT)
    public ResponseEntity<AccountResource> updateAccount(@PathVariable String username, AccountResource accountResource) throws AccountServiceException {
        return new ResponseEntity<>(accountResourceAssembler.toResource(accountService.updateAccount(accountResource)), HttpStatus.OK);
    }

    @PreAuthorize("isFullyAuthenticated()&&(#username==principal.username)")
    @RequestMapping(value = "/{username}/enable", method = RequestMethod.PATCH)
    public ResponseEntity enableAccount(@PathVariable String username) throws AccountServiceException {
        accountService.enableAccount(username);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PreAuthorize("isFullyAuthenticated()&&(#username==principal.username)")
    @RequestMapping(value = "/{username}/disable", method = RequestMethod.PATCH)
    public ResponseEntity disableAccount(@PathVariable String username) throws AccountServiceException {
        accountService.disableAccount(username);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PreAuthorize("isFullyAuthenticated()&&(#username==principal.username)")
    @RequestMapping(value = "/{username}/lock", method = RequestMethod.PATCH)
    public ResponseEntity lockAccount(@PathVariable String username) throws AccountServiceException {
        accountService.lockAccount(username);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PreAuthorize("isFullyAuthenticated()&&(#username==principal.username)")
    @RequestMapping(value = "/{username}/unlock", method = RequestMethod.PATCH)
    public ResponseEntity unlockAccount(@PathVariable String username) throws AccountServiceException {
        accountService.unlockAccount(username);
        return new ResponseEntity(HttpStatus.OK);

    }

    @PreAuthorize("isFullyAuthenticated()&&(#username==principal.username)")
    @RequestMapping(value = "/{username}/expire", method = RequestMethod.PATCH)
    public ResponseEntity expireAccount(@PathVariable String username) throws AccountServiceException {
        accountService.expireAccount(username);
        return new ResponseEntity(HttpStatus.OK);
    }
}
