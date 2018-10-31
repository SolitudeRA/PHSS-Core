package org.protogalaxy.phss.service.impl.oauth2;

import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;


public class PhssAuthorizationCodeTokenResponseClient implements OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> {
    @Override
    public OAuth2AccessTokenResponse getTokenResponse(OAuth2AuthorizationCodeGrantRequest authorizationGrantRequest) throws OAuth2AuthenticationException {
        return OAuth2AccessTokenResponse.withToken(accessToken.getAccessToken())
                                        .expiresIn(accessToken.getExpiresIn())
                                        .scopes(scopes)
                                        .tokenType(OAuth2AccessToken.TokenType.BEARER)
                                        .build();
    }
}
