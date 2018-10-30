package org.protogalaxy.phss.service.impl.oauth2;

import static org.asynchttpclient.Dsl.*;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;

import org.asynchttpclient.*;
import org.json.simple.JSONObject;
import org.protogalaxy.phss.exception.security.OAuth2FailedException;
import org.protogalaxy.phss.service.impl.oauth2.bangumi.BangumiApi20;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class PhssAuthorizationCodeTokenResponseClient implements OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> {
    @Override
    public OAuth2AccessTokenResponse getTokenResponse(OAuth2AuthorizationCodeGrantRequest authorizationGrantRequest) throws OAuth2AuthenticationException {
        AsyncHttpClient asyncHttpClient = asyncHttpClient();
        ClientRegistration clientRegistration = authorizationGrantRequest.getClientRegistration();
        // Switch to correct method to get token response(HTTP Param/JSON)
        final com.github.scribejava.core.model.OAuth2AccessToken accessToken;
        final OAuth20Service oAuth20Service = new ServiceBuilder(clientRegistration.getClientId())
                .apiSecret(clientRegistration.getClientSecret())
                .callback(authorizationGrantRequest.getAuthorizationExchange().getAuthorizationRequest().getRedirectUri())
                .build(BangumiApi20.instance());
        try (AsyncHttpClient asyncHttpClient1 = asyncHttpClient()) {
            asyncHttpClient.prepareGet(clientRegistration.getProviderDetails().getAuthorizationUri())
                           .addFormParam("client_id", clientRegistration.getClientId())
                           .addFormParam("response_type", clientRegistration.getAuthorizationGrantType().getValue())
                           .execute()
                           .toCompletableFuture()
                           .thenApply(Response::toString)
                           .thenAccept(System.out::println)
                           .join();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            accessToken = oAuth20Service.getAccessTokenAsync("test").get();
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
}
