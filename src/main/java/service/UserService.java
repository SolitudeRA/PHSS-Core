package service;

import datasource.DataSource;
import datasource.entity.userManagementCore.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.UUID;

@Service
public class UserService {
    private DataSource dataSource = new DataSource();
    private EntityManager entityManager = dataSource.getEntityManagerFactory().createEntityManager();

    @Autowired
    public UserEntity userAdd(String username, String password) {
        entityManager.getTransaction().begin();
        entityManager.persist(new UserEntity(username, password));
        entityManager.getTransaction().commit();
    }

    @Autowired
    public void userModify(UUID uuid, String username, String password) {
        UserEntity userEntity = entityManager.find(UserEntity.class, uuid);
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        entityManager.flush();
    }

    @Autowired
    public void userDelete(UUID uuid) {
        UserEntity userEntity = entityManager.find(UserEntity.class, uuid);
        entityManager.remove(userEntity);
    }
}
