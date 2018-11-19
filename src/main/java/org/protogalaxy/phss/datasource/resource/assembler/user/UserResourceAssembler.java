package org.protogalaxy.phss.datasource.resource.assembler.user;

import org.protogalaxy.phss.controller.UserController;
import org.protogalaxy.phss.datasource.entity.account.AccountEntity;
import org.protogalaxy.phss.datasource.resource.main.entity.account.AccountResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class UserResourceAssembler extends ResourceAssemblerSupport<AccountEntity, AccountResource> {

    public UserResourceAssembler() {
        super(UserController.class, AccountResource.class);
    }

    @Override
    public AccountResource toResource(AccountEntity accountEntity) {
        return new AccountResource(accountEntity.getId(),
                                   accountEntity.getUsername(),
                                   accountEntity.getAvatar(),
                                   accountEntity.getAuthorities(),
                                   accountEntity.getFileSystemMainEntity(),
                                   accountEntity.getPersonalDataEntity(),
                                   accountEntity.getSettingMainEntity(),
                                   accountEntity.isEnabled(),
                                   accountEntity.isAccountNonLocked(),
                                   accountEntity.isCredentialsNonExpired(),
                                   accountEntity.getDateCreate(),
                                   accountEntity.getDateModified());
    }
}
