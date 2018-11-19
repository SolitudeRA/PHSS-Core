package org.protogalaxy.phss.service.interfaces.account;

import org.protogalaxy.phss.datasource.entity.account.AccountEntity;
import org.protogalaxy.phss.exception.UserNotFoundException;

public interface AccountService {
    String register(String username, String password) throws Exception;

    AccountEntity getAccount(Integer id) throws UserNotFoundException;

    AccountEntity getAccount(String username) throws UserNotFoundException;

    void enableAccount(String username) throws UserNotFoundException;

    void disableAccount(String username) throws UserNotFoundException;

    void lockAccount(String username) throws UserNotFoundException;

    void unlockAccount(String username) throws UserNotFoundException;

    void expireAccount(String username) throws UserNotFoundException;
}
