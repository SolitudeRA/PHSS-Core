package me.protogalaxy.service.impl.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.protogalaxy.datasource.entity.core.filesystem.main.FileSystemMainEntity;
import me.protogalaxy.datasource.entity.core.personaldata.PersonalDataEntity;
import me.protogalaxy.datasource.entity.core.setting.SettingMainEntity;
import me.protogalaxy.datasource.entity.core.user.UserEntity;
import me.protogalaxy.datasource.entity.repository.user.UserRepository;
import me.protogalaxy.service.main.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String register(String username, String password) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        UserEntity userEntity = new UserEntity(username, password, true, true, true);
        userEntity.setFileSystemMainEntity(new FileSystemMainEntity(userEntity));
        userEntity.setPersonalDataEntity(new PersonalDataEntity(userEntity));
        userEntity.setSettingMainEntity(new SettingMainEntity(userEntity));
        userRepository.save(userEntity);
        return mapper.writeValueAsString(userEntity);
    }

    @Override
    public String getUser(String username) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(userRepository.findByUsername(username));
    }
}
