package org.protogalaxy.phss.datasource.repository.jpa.account;

import org.protogalaxy.phss.datasource.entity.account.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "accounts", path = "accounts")
public interface AccountRepository extends JpaRepository<AccountEntity, UUID>, CrudRepository<AccountEntity, UUID> {
    Boolean existsByUuid(UUID uuid);

    Boolean existsByUsername(String username);

    Optional<AccountEntity> findByUsername(String username);

    Optional<AccountEntity> findByUuid(UUID uuid);

    void deleteByUuid(UUID uuid);
}
