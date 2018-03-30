package datasource.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import datasource.entity.core.user.UserEntity;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;


@DisplayName("User API test case")
public class UserApi {
    @Test
    @DisplayName("JSON serialize")
    public void jsonTest() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("username1");
        userEntity.setPassword("password1");
        ObjectMapper mapper = new ObjectMapper();
        String jsonUser = mapper.writeValueAsString(userEntity);
        System.out.println(jsonUser);
    }

}
