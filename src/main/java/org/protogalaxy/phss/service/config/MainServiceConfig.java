package org.protogalaxy.phss.service.config;

import org.protogalaxy.phss.datasource.repository.jpa.account.AccountRepository;
import org.protogalaxy.phss.service.interfaces.account.AccountService;
import org.protogalaxy.phss.service.main.account.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MainServiceConfig {
    private AccountRepository accountRepository;
    private PasswordEncoder passwordEncoder;

    @Bean
    public AccountService accountService() {
        return new AccountServiceImpl(this.accountRepository, this.passwordEncoder);
    }

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
