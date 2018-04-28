package me.protogalaxy.security.main;

import me.protogalaxy.datasource.entity.core.filesystem.main.FileSystemMainEntity;
import me.protogalaxy.datasource.entity.core.filesystem.main.FileSystemSpaceEntity;
import me.protogalaxy.datasource.entity.core.personaldata.PersonalDataEntity;
import me.protogalaxy.datasource.entity.core.setting.SettingMainEntity;
import me.protogalaxy.datasource.entity.core.user.UserEntity;
import me.protogalaxy.datasource.entity.repository.filesystem.main.FilesystemMainRepository;
import me.protogalaxy.datasource.entity.repository.filesystem.main.FilesystemSpaceRepository;
import me.protogalaxy.datasource.entity.repository.personaldata.PersonalDataRepository;
import me.protogalaxy.datasource.entity.repository.setting.SettingMainRepository;
import me.protogalaxy.datasource.entity.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class PhssUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FilesystemMainRepository filesystemMainRepository;

    @Autowired
    private FilesystemSpaceRepository filesystemSpaceRepository;

    @Autowired
    private PersonalDataRepository personalDataRepository;

    @Autowired
    private SettingMainRepository settingMainRepository;

    public UserEntity saveUser(UserEntity userEntity) {
        userRepository.save(userEntity);
        FileSystemMainEntity fileSystemMainEntity = new FileSystemMainEntity(userEntity);
        filesystemMainRepository.save(fileSystemMainEntity);
        filesystemSpaceRepository.save(new FileSystemSpaceEntity(fileSystemMainEntity));
        personalDataRepository.save(new PersonalDataEntity(userEntity));
        settingMainRepository.save(new SettingMainEntity(userEntity));
        return userEntity;
    }

    public UserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public void removeUserById(UserEntity userEntity) {
        userRepository.delete(userEntity);
    }
}
