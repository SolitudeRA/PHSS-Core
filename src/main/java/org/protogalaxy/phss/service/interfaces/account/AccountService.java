package org.protogalaxy.phss.service.interfaces.account;

import org.protogalaxy.phss.datasource.entity.account.AccountEntity;
import org.protogalaxy.phss.datasource.resource.main.entity.account.AccountResource;
import org.protogalaxy.phss.exception.application.base.account.AccountServiceException;

import java.util.UUID;

public interface AccountService {
    AccountEntity register(String username, String password) throws AccountServiceException;

    AccountEntity getAccount(UUID uuid) throws AccountServiceException;

    AccountEntity getAccount(String username) throws AccountServiceException;

    AccountEntity updateAccount(AccountResource accountResource) throws AccountServiceException;

    AccountEntity updateAccount(AccountEntity accountEntity) throws AccountServiceException;

    void enableAccount(String username) throws AccountServiceException;

    void disableAccount(String username) throws AccountServiceException;

    void lockAccount(String username) throws AccountServiceException;

    void unlockAccount(String username) throws AccountServiceException;

    void expireAccount(String username) throws AccountServiceException;
}
