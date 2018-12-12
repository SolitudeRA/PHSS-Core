package org.protogalaxy.phss.service.main.account;

import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemMainEntity;
import org.protogalaxy.phss.datasource.entity.personaldata.PersonalDataEntity;
import org.protogalaxy.phss.datasource.entity.setting.SettingMainEntity;
import org.protogalaxy.phss.datasource.entity.account.AccountEntity;
import org.protogalaxy.phss.datasource.repository.jpa.account.AccountRepository;
import org.protogalaxy.phss.exception.PhssErrorCode;
import org.protogalaxy.phss.exception.account.AccountServiceException;
import org.protogalaxy.phss.exception.account.UserNotFoundException;
import org.protogalaxy.phss.service.interfaces.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountEntity register(String username, String password) {
        if (accountRepository.findByUsername(username).isPresent()) {
            AccountEntity accountEntity = new AccountEntity(username, password, true, true, true);
            accountEntity.setFileSystemMainEntity(new FileSystemMainEntity(accountEntity));
            accountEntity.setPersonalDataEntity(new PersonalDataEntity(accountEntity));
            accountEntity.setSettingMainEntity(new SettingMainEntity(accountEntity));
            return accountRepository.saveAndFlush(accountEntity);
        } else {
            throw new AccountServiceException(PhssErrorCode.ACCOUNT_ALREADY_EXISTS);
        }
    }

    @Override
    public AccountEntity getAccount(Integer id) {
        Optional<AccountEntity> accountEntityContainer = accountRepository.findById(id);
        if (accountEntityContainer.isPresent()) {
            return accountEntityContainer.get();
        } else {
            throw new UserNotFoundException(PhssErrorCode.ACCOUNT_INVALID_ID);
        }
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_ADMIN')||(#username==principal.username)")
    public AccountEntity getAccount(String username) {
        Optional<AccountEntity> accountEntityContainer = accountRepository.findByUsername(username);
        if (accountEntityContainer.isPresent()) {
            return accountEntityContainer.get();
        } else {
            throw new UserNotFoundException(PhssErrorCode.ACCOUNT_INVALID_USERNAME);
        }
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_ADMIN')||(#username==principal.username)")
    public void enableAccount(String username) throws UserNotFoundException {
        Optional<AccountEntity> accountEntityContainer = accountRepository.findByUsername(username);
        if (accountEntityContainer.isPresent()) {
            AccountEntity accountEntity = accountEntityContainer.get();
            accountEntity.enableAccount();
            accountRepository.saveAndFlush(accountEntity);
        } else {
            throw new UserNotFoundException(PhssErrorCode.ACCOUNT_INVALID_USERNAME);
        }
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_ADMIN')||(#username==principal.username)")
    public void disableAccount(String username) throws UserNotFoundException {
        Optional<AccountEntity> accountEntityContainer = accountRepository.findByUsername(username);
        if (accountEntityContainer.isPresent()) {
            AccountEntity accountEntity = accountEntityContainer.get();
            accountEntity.disableAccount();
            accountRepository.saveAndFlush(accountEntity);
        } else {
            throw new UserNotFoundException(PhssErrorCode.ACCOUNT_INVALID_USERNAME);
        }
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_ADMIN')||(#username==principal.username)")
    public void lockAccount(String username) throws UserNotFoundException {
        Optional<AccountEntity> accountEntityContainer = accountRepository.findByUsername(username);
        if (accountEntityContainer.isPresent()) {
            AccountEntity accountEntity = accountEntityContainer.get();
            accountEntity.lockAccount();
            accountRepository.saveAndFlush(accountEntity);
        } else {
            throw new UserNotFoundException(PhssErrorCode.ACCOUNT_INVALID_USERNAME);
        }
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_ADMIN')||(#username==principal.username)")
    public void unlockAccount(String username) throws UserNotFoundException {
        Optional<AccountEntity> accountEntityContainer = accountRepository.findByUsername(username);
        if (accountEntityContainer.isPresent()) {
            AccountEntity accountEntity = accountEntityContainer.get();
            accountEntity.unlockAccount();
            accountRepository.saveAndFlush(accountEntity);
        } else {
            throw new UserNotFoundException(PhssErrorCode.ACCOUNT_INVALID_USERNAME);
        }
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_ADMIN')||(#username==principal.username)")
    public void expireAccount(String username) throws UserNotFoundException {
        Optional<AccountEntity> accountEntityContainer = accountRepository.findByUsername(username);
        if (accountEntityContainer.isPresent()) {
            AccountEntity accountEntity = accountEntityContainer.get();
            accountEntity.expireAccount();
            accountRepository.saveAndFlush(accountEntity);
        } else {
            throw new UserNotFoundException(PhssErrorCode.ACCOUNT_INVALID_USERNAME);
        }
    }
}
