package org.protogalaxy.phss.service.config;

import org.protogalaxy.phss.service.impl.oauth2.bangumi.BangumiApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.client.web.HttpSessionOAuth2AuthorizationRequestRepository;
import org.springframework.security.oauth2.client.web.HttpSessionOAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class PhssOAuth2Config {
    private ClientRegistration bangumiClientRegistration() {
        return ClientRegistration.withRegistrationId("bangumi_scribe")
                                 .clientId("bgm6165b9e794a763e1")
                                 .clientSecret("48aca6275eb4259de87406ec96120e34")
                                 .clientAuthenticationMethod(ClientAuthenticationMethod.POST)
                                 .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                                 .redirectUriTemplate("{baseUrl}/login/oauth2/callback/{registrationId}")
                                 .authorizationUri("https://bgm.tv/oauth/authorize")
                                 .scope("")
                                 .tokenUri("https://bgm.tv/oauth/access_token")
                                 .clientName("Bangumi")
                                 .build();
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(this.bangumiClientRegistration());
    }

    @Bean
    public OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository() {
        return new HttpSessionOAuth2AuthorizedClientRepository();
    }

    @Bean
    public AuthorizationRequestRepository<OAuth2AuthorizationRequest> sessionAuthorizationRequestRepository() {
        return new HttpSessionOAuth2AuthorizationRequestRepository();
    }

    @Bean
    @RequestScope
    public BangumiApi bangumi(OAuth2AuthorizedClientService clientService) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String accessToken = null;
        if (authentication.getClass().isAssignableFrom(OAuth2AuthenticationToken.class)) {
            OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;
            String clientRegistrationId = oAuth2AuthenticationToken.getAuthorizedClientRegistrationId();
            if (clientRegistrationId.equals("bangumi_scribe")) {
                OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(clientRegistrationId, oAuth2AuthenticationToken.getName());
                accessToken = client.getAccessToken().getTokenValue();
            }
        }
        return new BangumiApi(accessToken);
    }
}
