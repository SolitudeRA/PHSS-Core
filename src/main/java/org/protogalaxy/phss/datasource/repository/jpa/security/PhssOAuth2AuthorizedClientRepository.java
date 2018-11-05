package org.protogalaxy.phss.datasource.repository.jpa.security;

import org.protogalaxy.phss.datasource.entity.security.PhssOAuth2AuthorizedClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PhssOAuth2AuthorizedClientRepository extends JpaRepository<PhssOAuth2AuthorizedClientEntity, Integer>, CrudRepository<PhssOAuth2AuthorizedClientEntity, Integer> {
    PhssOAuth2AuthorizedClientEntity findByClientRegistrationId(String clientRegistrationId);

    void deleteByClientRegistrationId(String clientRegistrationId);
}
