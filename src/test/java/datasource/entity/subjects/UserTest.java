package datasource.entity.subjects;

import datasource.entity.userManagementCore.UserEntity;

import javax.persistence.EntityManager;

public class UserTest {
    public void beginTest(EntityManager entityManager){
        entityManager.getTransaction().begin();
        entityManager.persist(new UserEntity());
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
