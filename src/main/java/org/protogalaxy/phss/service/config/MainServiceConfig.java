package org.protogalaxy.phss.service.config;

import org.protogalaxy.phss.datasource.repository.jpa.account.AccountRepository;
import org.protogalaxy.phss.service.interfaces.account.AccountService;
import org.protogalaxy.phss.service.main.account.AccountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainServiceConfig {

    @Bean
    public AccountService accountService(AccountRepository accountRepository){
        return new AccountServiceImpl(accountRepository);
    }
}
