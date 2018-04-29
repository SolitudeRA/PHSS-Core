package me.protogalaxy.datasource.entity.repository.user;

import me.protogalaxy.datasource.entity.core.user.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.UUID;

public interface UserRepository extends Repository<UserEntity, Integer>, CrudRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Iterable<UserEntity> findAll();

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteAll();
}
