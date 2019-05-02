package org.protogalaxy.phss.datasource.repository.jpa.security;

import org.protogalaxy.phss.datasource.entity.security.OAuth2AuthorizedClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PhssOAuth2AuthorizedClientRepository extends JpaRepository<OAuth2AuthorizedClientEntity, Integer>, CrudRepository<OAuth2AuthorizedClientEntity, Integer> {
    OAuth2AuthorizedClientEntity findByClientRegistrationId(String clientRegistrationId);

    void deleteByClientRegistrationId(String clientRegistrationId);
}
