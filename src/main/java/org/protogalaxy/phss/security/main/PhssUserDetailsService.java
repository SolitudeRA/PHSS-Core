package org.protogalaxy.phss.security.main;

import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemMainEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemSpaceEntity;
import org.protogalaxy.phss.datasource.entity.personaldata.PersonalDataEntity;
import org.protogalaxy.phss.datasource.entity.setting.SettingMainEntity;
import org.protogalaxy.phss.datasource.entity.user.UserEntity;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.main.FilesystemMainRepository;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.main.FilesystemSpaceRepository;
import org.protogalaxy.phss.datasource.repository.jpa.personaldata.PersonalDataRepository;
import org.protogalaxy.phss.datasource.repository.jpa.setting.SettingMainRepository;
import org.protogalaxy.phss.datasource.repository.jpa.user.UserRepository;
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
