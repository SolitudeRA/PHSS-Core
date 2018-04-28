package me.protogalaxy.datasource.entity.repository.user;

import me.protogalaxy.datasource.entity.core.user.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<UserEntity, Integer>, CrudRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
}
