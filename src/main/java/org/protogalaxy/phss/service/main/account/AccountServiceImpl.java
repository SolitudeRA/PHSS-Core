package org.protogalaxy.phss.service.main.account;

import org.protogalaxy.phss.datasource.entity.filesystem.FileSystemMainEntity;
import org.protogalaxy.phss.datasource.entity.setting.SettingsMainEntity;
import org.protogalaxy.phss.datasource.entity.account.AccountEntity;
import org.protogalaxy.phss.datasource.repository.jpa.account.AccountRepository;
import org.protogalaxy.phss.exception.application.base.account.AccountServiceException;
import org.protogalaxy.phss.exception.application.base.account.PhssErrorCodeApplicationBaseAccountService;
import org.protogalaxy.phss.service.interfaces.account.AccountService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.UUID;

public class AccountServiceImpl implements AccountService, UserDetailsService {

    private AccountRepository accountRepository;

    private PasswordEncoder passwordEncoder;

    public AccountServiceImpl(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AccountEntity register(String username, String password) throws AccountServiceException {
        if (accountRepository.findByUsername(username).isPresent()) {
            throw new AccountServiceException(PhssErrorCodeApplicationBaseAccountService.ACCOUNT_ALREADY_EXISTS);
        } else {
            AccountEntity accountEntity = new AccountEntity(username, passwordEncoder.encode(password));
            accountEntity.setFileSystemMainEntity(new FileSystemMainEntity(accountEntity));
            accountEntity.setSettingsMainEntity(new SettingsMainEntity(accountEntity));
            return accountRepository.saveAndFlush(accountEntity);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AccountEntity> accountEntityContainer = accountRepository.findByUsername(username);
        if (accountEntityContainer.isPresent()) {
            return accountEntityContainer.get();
        } else {
            throw new AccountServiceException(PhssErrorCodeApplicationBaseAccountService.ACCOUNT_INVALID_USERNAME_OR_PASSWORD);
        }
    }

    @Override
    public AccountEntity getAccount(UUID uuid) throws AccountServiceException {
        Optional<AccountEntity> accountEntityContainer = accountRepository.findByUuid(uuid);
        if (accountEntityContainer.isPresent()) {
            return accountEntityContainer.get();
        } else {
            throw new AccountServiceException(PhssErrorCodeApplicationBaseAccountService.ACCOUNT_INVALID_ID);
        }
    }

    @Override
    public AccountEntity getAccount(String username) {
        Optional<AccountEntity> accountEntityContainer = accountRepository.findByUsername(username);
        if (accountEntityContainer.isPresent()) {
            return accountEntityContainer.get();
        } else {
            throw new AccountServiceException(PhssErrorCodeApplicationBaseAccountService.ACCOUNT_INVALID_USERNAME_OR_PASSWORD);
        }
    }

    @Override
    public AccountEntity modifyAccount(AccountEntity accountEntity) throws AccountServiceException {
        if (!accountRepository.existsByUuid(accountEntity.getUuid())) {
            throw new AccountServiceException(PhssErrorCodeApplicationBaseAccountService.ACCOUNT_INVALID_ID);
        }
        return accountRepository.saveAndFlush(accountEntity);
    }

    @Override
    public void enableAccount(String username) throws AccountServiceException {
        Optional<AccountEntity> accountEntityContainer = accountRepository.findByUsername(username);
        if (accountEntityContainer.isPresent()) {
            accountRepository.saveAndFlush(accountEntityContainer.get().enableAccount());
        } else {
            throw new AccountServiceException(PhssErrorCodeApplicationBaseAccountService.ACCOUNT_INVALID_USERNAME_OR_PASSWORD);
        }
    }

    @Override
    public void disableAccount(String username) throws AccountServiceException {
        Optional<AccountEntity> accountEntityContainer = accountRepository.findByUsername(username);
        if (accountEntityContainer.isPresent()) {
            accountRepository.saveAndFlush(accountEntityContainer.get().disableAccount());
        } else {
            throw new AccountServiceException(PhssErrorCodeApplicationBaseAccountService.ACCOUNT_INVALID_USERNAME_OR_PASSWORD);
        }
    }

    @Override
    public void lockAccount(String username) throws AccountServiceException {
        Optional<AccountEntity> accountEntityContainer = accountRepository.findByUsername(username);
        if (accountEntityContainer.isPresent()) {
            accountRepository.saveAndFlush(accountEntityContainer.get().lockAccount());
        } else {
            throw new AccountServiceException(PhssErrorCodeApplicationBaseAccountService.ACCOUNT_INVALID_USERNAME_OR_PASSWORD);
        }
    }

    @Override
    public void unlockAccount(String username) throws AccountServiceException {
        Optional<AccountEntity> accountEntityContainer = accountRepository.findByUsername(username);
        if (accountEntityContainer.isPresent()) {
            accountRepository.saveAndFlush(accountEntityContainer.get().unlockAccount());
        } else {
            throw new AccountServiceException(PhssErrorCodeApplicationBaseAccountService.ACCOUNT_INVALID_USERNAME_OR_PASSWORD);
        }
    }

    @Override
    public void expireAccount(String username) throws AccountServiceException {
        Optional<AccountEntity> accountEntityContainer = accountRepository.findByUsername(username);
        if (accountEntityContainer.isPresent()) {
            accountRepository.saveAndFlush(accountEntityContainer.get().expireAccount());
        } else {
            throw new AccountServiceException(PhssErrorCodeApplicationBaseAccountService.ACCOUNT_INVALID_USERNAME_OR_PASSWORD);
        }
    }
}
