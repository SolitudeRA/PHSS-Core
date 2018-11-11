package org.protogalaxy.phss.datasource.repository.jpa.user;

import org.protogalaxy.phss.datasource.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends JpaRepository<UserEntity, Integer>, CrudRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    List<UserEntity> findAll();

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteAll();
}
