package org.protogalaxy.phss.datasource.resource.assembler.account;

import org.protogalaxy.phss.controller.AccountController;
import org.protogalaxy.phss.datasource.entity.account.AccountEntity;
import org.protogalaxy.phss.datasource.resource.main.entity.account.AccountResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class AccountResourceAssembler extends ResourceAssemblerSupport<AccountEntity, AccountResource> {

    public AccountResourceAssembler() {
        super(AccountController.class, AccountResource.class);
    }

    @Override
    public AccountResource toResource(AccountEntity accountEntity) {
        return new AccountResource(accountEntity);
    }
}
