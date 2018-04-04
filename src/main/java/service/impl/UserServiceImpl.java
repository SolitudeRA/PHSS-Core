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
        UserEntity user = entityManager.createQuery("select user from UserEntity user where user.username=:username", UserEntity.class).setParameter("username", username).getSingleResult();
        if (password.equals(user.getPassword())) {
            return mapper.writeValueAsString(user);
        } else {
            return null;
        }
    }

    @Override
    public String getUser(UUID uuid) {
        return null;
    }

    @Override
    public String updateUser(UUID uuid, String profile) {
        return null;
    }

    @Override
    public String saveUser(String profile) {
        return null;
    }

    @Override
    public boolean removeUser(UUID uuid) {
        return false;
    }
}
