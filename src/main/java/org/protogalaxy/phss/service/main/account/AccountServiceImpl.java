package org.protogalaxy.phss.service.main.account;

import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemMainEntity;
import org.protogalaxy.phss.datasource.entity.personaldata.PersonalDataEntity;
import org.protogalaxy.phss.datasource.entity.setting.SettingMainEntity;
import org.protogalaxy.phss.datasource.entity.account.AccountEntity;
import org.protogalaxy.phss.datasource.repository.jpa.account.AccountRepository;
import org.protogalaxy.phss.exception.account.UserNotFoundException;
import org.protogalaxy.phss.service.interfaces.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountEntity register(String username, String password) {
        AccountEntity accountEntity = new AccountEntity(username, password, true, true, true);
        accountEntity.setFileSystemMainEntity(new FileSystemMainEntity(accountEntity));
        accountEntity.setPersonalDataEntity(new PersonalDataEntity(accountEntity));
        accountEntity.setSettingMainEntity(new SettingMainEntity(accountEntity));
        return accountRepository.saveAndFlush(accountEntity);
    }

    @Override
    public AccountEntity getAccount(Integer id) throws UserNotFoundException {
        if (accountRepository.findById(id).isPresent())
            return accountRepository.findById(id).get();
        else
            throw new UserNotFoundException();
    }

    @Override
    public AccountEntity getAccount(String username) throws UserNotFoundException {
        if (accountRepository.findByUsername(username).isPresent()) {
            return accountRepository.findByUsername(username).get();
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_USER')&&(#username==principal.username)")
    public void enableAccount(String username) throws UserNotFoundException {
        if (accountRepository.findByUsername(username).isPresent()) {
            AccountEntity accountEntity = accountRepository.findByUsername(username).get();
            accountEntity.enableAccount();
            accountRepository.save(accountEntity);
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_USER')&&(#username==principal.username)")
    public void disableAccount(String username) throws UserNotFoundException {
        if (accountRepository.findByUsername(username).isPresent()) {
            AccountEntity accountEntity = accountRepository.findByUsername(username).get();
            accountEntity.disableAccount();
            accountRepository.save(accountEntity);
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_USER')&&(#username==principal.username)")
    public void lockAccount(String username) throws UserNotFoundException {
        if (accountRepository.findByUsername(username).isPresent()) {
            AccountEntity accountEntity = accountRepository.findByUsername(username).get();
            accountEntity.lockAccount();
            accountRepository.save(accountEntity);
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_USER')&&(#username==principal.username)")
    public void unlockAccount(String username) throws UserNotFoundException {
        if (accountRepository.findByUsername(username).isPresent()) {
            AccountEntity accountEntity = accountRepository.findByUsername(username).get();
            accountEntity.unlockAccount();
            accountRepository.save(accountEntity);
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_USER')&&(#username==principal.username)")
    public void expireAccount(String username) throws UserNotFoundException {
        if (accountRepository.findByUsername(username).isPresent()) {
            AccountEntity accountEntity = accountRepository.findByUsername(username).get();
            accountEntity.expireAccount();
            accountRepository.save(accountEntity);
        } else {
            throw new UserNotFoundException();
        }
    }
}
