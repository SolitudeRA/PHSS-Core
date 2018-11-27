package org.protogalaxy.phss.datasource.repository.jpa.account;

import org.protogalaxy.phss.datasource.entity.account.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "accounts", path = "accounts")
public interface AccountRepository extends JpaRepository<AccountEntity, Integer>, CrudRepository<AccountEntity, Integer> {
    Optional<AccountEntity> findByUsername(String username);

    void deleteByUsername(String username);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    List<AccountEntity> findAll();

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteAll();
}
