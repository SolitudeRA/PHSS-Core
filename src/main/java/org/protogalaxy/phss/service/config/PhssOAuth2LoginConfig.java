package org.protogalaxy.phss.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

@Configuration
public class PhssOAuth2LoginConfig {
    @Bean
    public OAuth2AuthorizedClientService auth2AuthorizedClientService() {
        return new InMemoryOAuth2AuthorizedClientService(this.clientRegistrationRepository());
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(this.bangumiClientRegistration());
    }

    private ClientRegistration bangumiClientRegistration() {
        return ClientRegistration.withRegistrationId("bangumi")
                                 .clientId("bgm6165b9e794a763e1")
                                 .clientSecret("48aca6275eb4259de87406ec96120e34")
                                 .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                                 .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                                 .redirectUriTemplate("{baseUrl}/login/oauth2/code/{registrationId}")
                                 .authorizationUri("https://bgm.tv/oauth/authorize")
                                 .scope("")
                                 .tokenUri("https://bgm.tv/oauth/access_token")
                                 .clientName("Bangumi")
                                 .build();
    }
}
