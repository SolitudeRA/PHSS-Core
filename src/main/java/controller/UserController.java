package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import datasource.DataSource;
import datasource.entity.core.user.UserEntity;
import org.springframework.boot.SpringApplication;
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
    public String login() throws Exception {
        DataSource dataSource = new DataSource();
        EntityManager entityManager = dataSource.getEntityManagerFactory().createEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Hibernate5Module());
        return mapper.writeValueAsString(entityManager.createQuery("select user from UserEntity user where user.username=:username").setParameter("username", "Alpha"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@PathVariable UserEntity userEntity) {

    }

    @DeleteMapping("/{user}")
    public void deleteUser(@PathVariable Long user) {

    }

    public static void main(String args[]) throws Exception {
        SpringApplication.run(UserController.class, args);
    }
}
