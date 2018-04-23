package datasource.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.protogalaxy.datasource.entity.core.user.UserEntity;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import me.protogalaxy.service.impl.UserServiceImpl;


@DisplayName("User API test case")
public class UserApiTest {
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
        System.out.println(userService.getUser(1));
    }

    @Test
    @DisplayName("User update test")
    public void userUpdateTest() throws Exception {
        UserServiceImpl userService = new UserServiceImpl();
        ObjectMapper mapper = new ObjectMapper();
        UserEntity userEntity = mapper.readValue(userService.getUser(1), UserEntity.class);
        userEntity.setPasswordExt1("UpdateTest1");
        System.out.println(userService.updateUser(mapper.writeValueAsString(userEntity)));
    }

    @Test
    @DisplayName("User save test")
    public void userSaveTest() throws Exception {
        UserServiceImpl userService = new UserServiceImpl();
        ObjectMapper mapper = new ObjectMapper();
        UserEntity userEntity = new UserEntity("UserSaveTest", "UserSaveTest");
        System.out.println(userService.saveUser(mapper.writeValueAsString(userEntity)));
    }

    @Test
    @DisplayName("User rempve test")
    public void userRemoveTest() throws Exception {
        UserServiceImpl userService = new UserServiceImpl();
        userService.removeUser(5);
    }
}
