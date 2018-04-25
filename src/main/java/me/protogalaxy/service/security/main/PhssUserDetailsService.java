package me.protogalaxy.service.security.main;

import me.protogalaxy.datasource.JPAUtil;
import me.protogalaxy.datasource.entity.core.user.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.persistence.EntityManager;

public class PhssUserDetailsService implements UserDetailsService {
    public UserEntity saveUser(UserEntity userEntity) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(userEntity);
        entityManager.refresh(userEntity);
        entityManager.getTransaction().commit();
        return userEntity;
    }

    public UserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        return entityManager.createQuery("select user from UserEntity user where user.username=:username", UserEntity.class).setParameter("username", username).getSingleResult();
    }

    public UserEntity updateUser(UserEntity updatedUserEntity) throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        UserEntity handledUserEntity = entityManager.find(UserEntity.class, updatedUserEntity.getId());
        handledUserEntity.setUsername(updatedUserEntity.getUsername());
        handledUserEntity.setPassword(updatedUserEntity.getPassword());
        handledUserEntity.setPasswordExt1(updatedUserEntity.getPasswordExt1());
        handledUserEntity.setPasswordExt2(updatedUserEntity.getPasswordExt2());
        handledUserEntity.setPasswordExt3(updatedUserEntity.getPasswordExt3());
        entityManager.flush();
        entityManager.getTransaction().commit();
        return handledUserEntity;
    }

    public boolean removeUserById(int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(UserEntity.class, id));
        entityManager.getTransaction().commit();
        return entityManager.find(UserEntity.class, id) == null;
    }
}
