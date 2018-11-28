package org.protogalaxy.phss.security.user;

import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemMainEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemSpaceEntity;
import org.protogalaxy.phss.datasource.entity.personaldata.PersonalDataEntity;
import org.protogalaxy.phss.datasource.entity.setting.SettingMainEntity;
import org.protogalaxy.phss.datasource.entity.account.AccountEntity;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.main.FilesystemMainRepository;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.main.FilesystemSpaceRepository;
import org.protogalaxy.phss.datasource.repository.jpa.personaldata.PersonalDataRepository;
import org.protogalaxy.phss.datasource.repository.jpa.setting.SettingMainRepository;
import org.protogalaxy.phss.datasource.repository.jpa.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class PhssUserDetailsService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private FilesystemMainRepository filesystemMainRepository;

    @Autowired
    private FilesystemSpaceRepository filesystemSpaceRepository;

    @Autowired
    private PersonalDataRepository personalDataRepository;

    @Autowired
    private SettingMainRepository settingMainRepository;

    public AccountEntity save(AccountEntity accountEntity) {
        accountRepository.save(accountEntity);
        FileSystemMainEntity fileSystemMainEntity = new FileSystemMainEntity(accountEntity);
        filesystemMainRepository.save(fileSystemMainEntity);
        filesystemSpaceRepository.save(new FileSystemSpaceEntity(fileSystemMainEntity));
        personalDataRepository.save(new PersonalDataEntity(accountEntity));
        settingMainRepository.save(new SettingMainEntity(accountEntity));
        return accountEntity;
    }

    public AccountEntity update(AccountEntity accountEntity) {
        return accountRepository.save(accountEntity);
    }

    public void deleteUserByUsername(String username) throws UsernameNotFoundException {
        accountRepository.deleteByUsername(username);
    }

    public AccountEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        if (accountRepository.findByUsername(username).isPresent()) {
            return accountRepository.findByUsername(username).get();
        } else {
            throw new UsernameNotFoundException("Invalid account name");
        }
    }
}
