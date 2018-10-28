package org.protogalaxy.phss.security.oauth2;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.github.scribejava.httpclient.ning.NingHttpClientConfig;
import com.nimbusds.oauth2.sdk.*;
import com.nimbusds.oauth2.sdk.auth.ClientAuthentication;
import com.nimbusds.oauth2.sdk.auth.ClientSecretBasic;
import com.nimbusds.oauth2.sdk.auth.ClientSecretPost;
import com.nimbusds.oauth2.sdk.auth.Secret;
import com.nimbusds.oauth2.sdk.http.HTTPRequest;
import com.nimbusds.oauth2.sdk.id.ClientID;
import com.ning.http.client.AsyncHttpClientConfig;
import org.protogalaxy.phss.exception.security.OAuth2FailedException;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.net.URI;
import java.util.*;

public class PhssAuthorizationCodeTokenResponseClient implements OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> {
    private static final String INVALID_TOKEN_RESPONSE_ERROR_CODE = "invalid_token_response";

    @Override
    public OAuth2AccessTokenResponse getTokenResponse(OAuth2AuthorizationCodeGrantRequest authorizationGrantRequest) throws OAuth2AuthenticationException {

        ClientRegistration clientRegistration = authorizationGrantRequest.getClientRegistration();

        // Build the authorization code grant request for the token endpoint
        AuthorizationCode authorizationCode = new AuthorizationCode(authorizationGrantRequest.getAuthorizationExchange().getAuthorizationResponse().getCode());
        URI redirectUri = toURI(authorizationGrantRequest.getAuthorizationExchange().getAuthorizationRequest().getRedirectUri());
        AuthorizationGrant authorizationCodeGrant = new AuthorizationCodeGrant(authorizationCode, redirectUri);
        URI tokenUri = toURI(clientRegistration.getProviderDetails().getTokenUri());

        // Switch to correct method to get token response(HTTP Param/JSON)
        return scribeJavaAuthorizationCodeTokenResponse(authorizationCode, clientRegistration, redirectUri);
    }

    /**
     * Get token response with PHSS custom SDK
     *
     * @param authorizationCode  Authorization Code
     * @param clientRegistration ClientRegistration created in config
     * @param redirectUri        Redirect URI
     * @return OAuth2AccessTokenResponse
     */
    private OAuth2AccessTokenResponse scribeJavaAuthorizationCodeTokenResponse(AuthorizationCode authorizationCode, ClientRegistration clientRegistration, URI redirectUri) {
        final com.github.scribejava.core.model.OAuth2AccessToken accessToken;
        final NingHttpClientConfig clientConfig = new NingHttpClientConfig(new AsyncHttpClientConfig.Builder()
                                                                                   .setMaxConnections(5)
                                                                                   .setRequestTimeout(10_000)
                                                                                   .setAllowPoolingConnections(false)
                                                                                   .setPooledConnectionIdleTimeout(1_000)
                                                                                   .setReadTimeout(5_000)
                                                                                   .build());
        final OAuth20Service oAuth20Service = new ServiceBuilder(clientRegistration.getClientId())
                .apiSecret(clientRegistration.getClientSecret())
                .callback(redirectUri.toString())
                .httpClientConfig(clientConfig)
                .build(BangumiApi20.instance());
        try {
            accessToken = oAuth20Service.getAccessTokenAsync(authorizationCode.getValue()).get();
            Set<String> scopes;
            if (accessToken.getScope() != null) {
                scopes = new HashSet<>(Arrays.asList(accessToken.getScope().split(" ")));
            } else {
                scopes = new HashSet<>();
                scopes.add("");
            }
            return OAuth2AccessTokenResponse.withToken(accessToken.getAccessToken())
                                            .expiresIn(accessToken.getExpiresIn())
                                            .scopes(scopes)
                                            .tokenType(OAuth2AccessToken.TokenType.BEARER)
                                            .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new OAuth2FailedException("Scribe OAuth2 process failed");
    }


    private static URI toURI(String uriStr) {
        try {
            return new URI(uriStr);
        } catch (Exception ex) {
            throw new IllegalArgumentException("An error occurred parsing URI: " + uriStr, ex);
        }
    }
}
