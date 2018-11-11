package org.protogalaxy.phss.service.interfaces.user;

import org.protogalaxy.phss.datasource.entity.user.UserEntity;

public interface UserService {
    String register(String username, String password) throws Exception;

    UserEntity getUser(String username);
}
