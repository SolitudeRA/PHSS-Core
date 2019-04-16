package org.protogalaxy.phss.service.main.account;

import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemMainEntity;
import org.protogalaxy.phss.datasource.entity.personaldata.PersonalDataEntity;
import org.protogalaxy.phss.datasource.entity.setting.SettingMainEntity;
import org.protogalaxy.phss.datasource.entity.account.AccountEntity;
import org.protogalaxy.phss.datasource.repository.jpa.account.AccountRepository;
import org.protogalaxy.phss.exception.application.base.account.AccountServiceException;
import org.protogalaxy.phss.exception.application.base.account.PhssErrorCodeApplicationBaseAccountService;
import org.protogalaxy.phss.exception.application.database.DatabaseException;
import org.protogalaxy.phss.exception.application.database.PhssErrorCodeApplicationDatabaseSeries;
import org.protogalaxy.phss.service.interfaces.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {
    private AccountRepository accountRepository;

    public AccountServiceImpl() {
    }

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AccountEntity> accountEntityContainer = accountRepository.findByUsername(username);
        if (accountEntityContainer.isPresent()) {
            return accountEntityContainer.get();
        } else {
            throw new UsernameNotFoundException("Invalid account name");
        }
    }

    @Override
    public AccountEntity register(String username, String password) throws DatabaseException, AccountServiceException {
        try {
            if (accountRepository.findByUsername(username).isPresent()) {
                throw new AccountServiceException(PhssErrorCodeApplicationBaseAccountService.ACCOUNT_ALREADY_EXISTS);
            } else {
                AccountEntity accountEntity = new AccountEntity(username, password);
                accountEntity.setFileSystemMainEntity(new FileSystemMainEntity(accountEntity));
                accountEntity.setPersonalDataEntity(new PersonalDataEntity(accountEntity));
                accountEntity.setSettingMainEntity(new SettingMainEntity(accountEntity));
                return accountRepository.saveAndFlush(accountEntity);
            }
        } catch (DataAccessException e) {
            throw new DatabaseException(PhssErrorCodeApplicationDatabaseSeries.CONNECTION);
        }
    }

    @Override
    public AccountEntity getAccount(UUID uuid) throws DatabaseException, AccountServiceException {
        try {
            Optional<AccountEntity> accountEntityContainer = accountRepository.findByUuid(uuid);
            if (accountEntityContainer.isPresent()) {
                return accountEntityContainer.get();
            } else {
                throw new AccountServiceException(PhssErrorCodeApplicationBaseAccountService.ACCOUNT_INVALID_USERNAME_OR_PASSWORD);
            }
        } catch (Exception e) {
            throw new DatabaseException(PhssErrorCodeApplicationDatabaseSeries.CONNECTION);
        }
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_ADMIN')||(#username==principal.username)")
    public AccountEntity getAccount(String username) {
        Optional<AccountEntity> accountEntityContainer = accountRepository.findByUsername(username);
        if (accountEntityContainer.isPresent()) {
            return accountEntityContainer.get();
        } else {
            throw new AccountServiceException(PhssErrorCodeApplicationBaseAccountService.ACCOUNT_INVALID_USERNAME_OR_PASSWORD);
        }
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_ADMIN')||(#username==principal.username)")
    public void enableAccount(String username) throws AccountServiceException {
        Optional<AccountEntity> accountEntityContainer = accountRepository.findByUsername(username);
        if (accountEntityContainer.isPresent()) {
            AccountEntity accountEntity = accountEntityContainer.get();
            accountEntity.enableAccount();
            accountRepository.saveAndFlush(accountEntity);
        } else {
            throw new AccountServiceException(PhssErrorCodeApplicationBaseAccountService.ACCOUNT_INVALID_USERNAME_OR_PASSWORD);
        }
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_ADMIN')||(#username==principal.username)")
    public void disableAccount(String username) throws AccountServiceException {
        Optional<AccountEntity> accountEntityContainer = accountRepository.findByUsername(username);
        if (accountEntityContainer.isPresent()) {
            AccountEntity accountEntity = accountEntityContainer.get();
            accountEntity.disableAccount();
            accountRepository.saveAndFlush(accountEntity);
        } else {
            throw new AccountServiceException(PhssErrorCodeApplicationBaseAccountService.ACCOUNT_INVALID_USERNAME_OR_PASSWORD);
        }
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_ADMIN')||(#username==principal.username)")
    public void lockAccount(String username) throws AccountServiceException {
        Optional<AccountEntity> accountEntityContainer = accountRepository.findByUsername(username);
        if (accountEntityContainer.isPresent()) {
            AccountEntity accountEntity = accountEntityContainer.get();
            accountEntity.lockAccount();
            accountRepository.saveAndFlush(accountEntity);
        } else {
            throw new AccountServiceException(PhssErrorCodeApplicationBaseAccountService.ACCOUNT_INVALID_USERNAME_OR_PASSWORD);
        }
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_ADMIN')||(#username==principal.username)")
    public void unlockAccount(String username) throws AccountServiceException {
        Optional<AccountEntity> accountEntityContainer = accountRepository.findByUsername(username);
        if (accountEntityContainer.isPresent()) {
            AccountEntity accountEntity = accountEntityContainer.get();
            accountEntity.unlockAccount();
            accountRepository.saveAndFlush(accountEntity);
        } else {
            throw new AccountServiceException(PhssErrorCodeApplicationBaseAccountService.ACCOUNT_INVALID_USERNAME_OR_PASSWORD);
        }
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_ADMIN')||(#username==principal.username)")
    public void expireAccount(String username) throws AccountServiceException {
        Optional<AccountEntity> accountEntityContainer = accountRepository.findByUsername(username);
        if (accountEntityContainer.isPresent()) {
            AccountEntity accountEntity = accountEntityContainer.get();
            accountEntity.expireAccount();
            accountRepository.saveAndFlush(accountEntity);
        } else {
            throw new AccountServiceException(PhssErrorCodeApplicationBaseAccountService.ACCOUNT_INVALID_USERNAME_OR_PASSWORD);
        }
    }
}
