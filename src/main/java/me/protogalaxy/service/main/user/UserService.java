package me.protogalaxy.service.main.user;

public interface UserService {
    String register(String username, String password) throws Exception;

    String getUser(String username) throws Exception;
}
