package me.protogalaxy.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.protogalaxy.datasource.JPAUtil;
import me.protogalaxy.datasource.entity.core.user.UserEntity;
import me.protogalaxy.service.main.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserServiceImpl() {
    }

    @Override
    public String checkUser(String username, String password) throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        UserEntity userEntity = entityManager.createQuery("select user from UserEntity user where user.username=:username", UserEntity.class).setParameter("username", username).getSingleResult();
        if (password.equals(userEntity.getPassword())) {
            return mapper.writeValueAsString(userEntity);
        } else {
            return null;
        }
    }

    @Override
    public String getUser(int id) throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        UserEntity userEntity = entityManager.find(UserEntity.class, id);
        return mapper.writeValueAsString(userEntity);
    }

    @Override
    public String updateUser(String profile) throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        entityManager.getTransaction().begin();
        UserEntity updatedUserEntity = mapper.readValue(profile, UserEntity.class);
        UserEntity handledUserEntity = entityManager.find(UserEntity.class, updatedUserEntity.getId());
        handledUserEntity.setUsername(updatedUserEntity.getUsername());
        handledUserEntity.setPassword(updatedUserEntity.getPassword());
        handledUserEntity.setPasswordExt1(updatedUserEntity.getPasswordExt1());
        handledUserEntity.setPasswordExt2(updatedUserEntity.getPasswordExt2());
        handledUserEntity.setPasswordExt3(updatedUserEntity.getPasswordExt3());
        entityManager.flush();
        entityManager.getTransaction().commit();
        return mapper.writeValueAsString(handledUserEntity);
    }

    @Override
    public String saveUser(String profile) throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        entityManager.getTransaction().begin();
        UserEntity userEntity = mapper.readValue(profile, UserEntity.class);
        entityManager.persist(userEntity);
        entityManager.refresh(userEntity);
        entityManager.getTransaction().commit();
        return mapper.writeValueAsString(userEntity);
    }

    @Override
    public boolean removeUser(int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(UserEntity.class, id));
        entityManager.getTransaction().commit();
        return true;
    }
}