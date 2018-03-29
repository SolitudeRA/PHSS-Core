package controller;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import datasource.DataSource;
import datasource.entity.core.user.UserEntity;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;

//TODO: User controller implement
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/users")
public class UserController {
    @GetMapping("/login")
    public void login(@RequestParam(name = "userInf") String userInf) {
        DataSource dataSource = new DataSource();
        EntityManager entityManager = dataSource.getEntityManagerFactory().createEntityManager();
        ReadContext ctx = JsonPath.parse(userInf);
        UserEntity userEntity = entityManager.createQuery("select user from UserEntity user where user.username=:username", UserEntity.class).setParameter("username", ctx.read("$.username")).getSingleResult();
        if (ctx.read("$.password") == userEntity.getPassword()) {

        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@PathVariable UserEntity userEntity) {

    }

    @DeleteMapping("/{user}")
    public void deleteUser(@PathVariable Long user) {

    }
}
