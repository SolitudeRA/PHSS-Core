package org.protogalaxy.phss.datasource.resource.assembler.user;

import org.protogalaxy.phss.controller.UserController;
import org.protogalaxy.phss.datasource.entity.user.UserEntity;
import org.protogalaxy.phss.datasource.resource.main.entity.user.UserResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class UserResourceAssembler extends ResourceAssemblerSupport<UserEntity, UserResource> {

    public UserResourceAssembler() {
        super(UserController.class, UserResource.class);
    }

    @Override
    public UserResource toResource(UserEntity userEntity) {
        return new UserResource(userEntity.getId(),
                                userEntity.getUsername(),
                                userEntity.getAvatar(),
                                userEntity.getAuthorities(),
                                userEntity.getFileSystemMainEntity(),
                                userEntity.getPersonalDataEntity(),
                                userEntity.getSettingMainEntity(),
                                userEntity.isEnabled(),
                                userEntity.isAccountNonLocked(),
                                userEntity.isCredentialsNonExpired(),
                                userEntity.getDateCreate(),
                                userEntity.getDateModified());
    }
}
