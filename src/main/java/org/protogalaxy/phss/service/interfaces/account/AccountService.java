package org.protogalaxy.phss.service.interfaces.account;

import org.protogalaxy.phss.datasource.entity.account.AccountEntity;
import org.protogalaxy.phss.exception.application.database.DatabaseException;
import org.protogalaxy.phss.exception.application.base.account.AccountServiceException;

import java.util.UUID;

public interface AccountService {
    AccountEntity register(String username, String password) throws DatabaseException, AccountServiceException;

    AccountEntity getAccount(UUID uuid) throws DatabaseException, AccountServiceException;

    AccountEntity getAccount(String username) throws DatabaseException, AccountServiceException;

    void enableAccount(String username) throws DatabaseException, AccountServiceException;

    void disableAccount(String username) throws DatabaseException, AccountServiceException;

    void lockAccount(String username) throws DatabaseException, AccountServiceException;

    void unlockAccount(String username) throws DatabaseException, AccountServiceException;

    void expireAccount(String username) throws DatabaseException, AccountServiceException;
}
