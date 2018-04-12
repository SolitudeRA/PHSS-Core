package service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import datasource.JPAUtil;
import datasource.entity.core.user.UserEntity;
import org.springframework.stereotype.Service;
import service.UserService;

import javax.persistence.EntityManager;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

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
    public String getUser(UUID uuid) throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        UserEntity userEntity = entityManager.find(UserEntity.class, uuid);
        return mapper.writeValueAsString(userEntity);
    }

    @Override
    public String updateUser(UUID uuid, String profile) throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        return null;
    }

    @Override
    public String saveUser(String profile) throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        return null;
    }

    @Override
    public boolean removeUser(UUID uuid) {
        return false;
    }
}