package org.protogalaxy.phss.datasource.resource.jpa.user;

        import org.protogalaxy.phss.datasource.entity.user.UserEntity;
        import org.springframework.hateoas.ResourceSupport;

public class UserResource extends ResourceSupport {
    private final UserEntity userEntity;

    public UserResource(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }
}
