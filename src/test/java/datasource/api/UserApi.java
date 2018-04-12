package datasource.api;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import service.impl.UserServiceImpl;

import java.util.UUID;


@DisplayName("User API test case")
public class UserApi {
    @Test
    @DisplayName("User check test")
    public void userCheckTest() throws Exception {
        UserServiceImpl userService = new UserServiceImpl();
        System.out.println(userService.checkUser("Alpha", "sol123456"));
    }

    @Test
    @DisplayName("User get test")
    public void userGetTest() throws Exception {
        UserServiceImpl userService = new UserServiceImpl();
        System.out.println(userService.getUser(UUID.fromString("03533281-b2bf-4aa8-be5f-6fbef9434bb8")));
    }
}
