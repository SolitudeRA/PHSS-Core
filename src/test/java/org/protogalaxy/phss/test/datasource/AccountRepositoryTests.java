package org.protogalaxy.phss.test.datasource;

import org.junit.Test;
import org.protogalaxy.phss.datasource.entity.account.AccountEntity;
import org.protogalaxy.phss.datasource.repository.jpa.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
public class AccountRepositoryTests {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void findByUsername() {
        this.testEntityManager.persist(new AccountEntity("test_account", "123456"));
        Optional<AccountEntity> accountEntityContainer = this.accountRepository.findByUsername("test_account");
        if (accountEntityContainer.isPresent()) {
            assertThat(accountEntityContainer.get().getUsername()).isEqualTo("test_account");
            assertThat(passwordEncoder.matches("123456", accountEntityContainer.get().getPassword())).isTrue();
        }
    }

    @Test
    void findByUUID() {
        UUID uuid = this.testEntityManager.persistAndGetId(new AccountEntity("test_account", "123456"), UUID.class);
        Optional<AccountEntity> accountEntityContainer = this.accountRepository.findByUuid(uuid);
        if (accountEntityContainer.isPresent()) {
            assertThat(accountEntityContainer.get().getUsername()).isEqualTo("test_account");
            assertThat(passwordEncoder.matches("123456", accountEntityContainer.get().getPassword())).isTrue();
        }
    }

    @Test
    void deleteByUUID() {
        UUID uuid = this.testEntityManager.persistAndGetId(new AccountEntity("test_account", "123456"), UUID.class);
        Optional<AccountEntity> accountEntityContainer = this.accountRepository.findByUuid(uuid);
        assertThat(accountEntityContainer.isPresent()).isFalse();
    }
}
