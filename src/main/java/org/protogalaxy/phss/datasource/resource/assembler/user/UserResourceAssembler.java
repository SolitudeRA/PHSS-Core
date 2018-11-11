package org.protogalaxy.phss.datasource.resource.assembler.user;

import org.protogalaxy.phss.datasource.entity.user.UserEntity;
import org.protogalaxy.phss.datasource.resource.main.user.UserResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class UserResourceAssembler extends ResourceAssemblerSupport<UserEntity, UserResource> {

    public UserResourceAssembler(Class<?> controllerClass, Class<UserResource> resourceType) {
        super(controllerClass, resourceType);
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
