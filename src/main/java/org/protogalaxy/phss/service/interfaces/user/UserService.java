package org.protogalaxy.phss.service.interfaces.user;

public interface UserService {
    String register(String username, String password) throws Exception;

    String getUser(String username) throws Exception;
}
