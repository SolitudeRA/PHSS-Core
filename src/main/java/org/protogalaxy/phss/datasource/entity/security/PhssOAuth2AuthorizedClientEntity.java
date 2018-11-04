package org.protogalaxy.phss.datasource.entity.security;


import org.springframework.lang.Nullable;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;

import javax.persistence.*;
import java.time.Instant;

//TODO:Not Completed
@Entity
@Table(name = "oauth2_authorized_client")
public class PhssOAuth2AuthorizedClientEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "client_registration_id")
    private String clientRegistrationId;

    @Column(name = "principal_name")
    private String principalName;

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "access_token_type")
    private String accessTokenType;

    @Column(name = "access_token_issued_at")
    private Instant accessTokenIssuedAt;

    @Column(name = "access_token_expire_at")
    private Instant accessTokenExpiresAt;

    @Column(name = "access_token_scopes")
    private String accessTokenScopes;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Column(name = "refresh_token_issued_at")
    private Instant refreshTokenIssuedAt;

    public PhssOAuth2AuthorizedClientEntity(ClientRegistration clientRegistration, String principalName, OAuth2AccessToken accessToken, @Nullable OAuth2RefreshToken refreshToken) {
        this.clientRegistrationId = clientRegistration.getRegistrationId();
        this.principalName = principalName;
        this.accessToken = accessToken.getTokenValue();
        this.accessTokenType = accessToken.getTokenType().getValue();
        this.accessTokenIssuedAt = accessToken.getIssuedAt();
        this.accessTokenExpiresAt = accessToken.getExpiresAt();
        if (accessToken.getScopes() != null) {
            this.accessTokenScopes = accessToken.getScopes().toString();
        }
        if (refreshToken != null) {
            this.refreshToken = refreshToken.getTokenValue();
            this.refreshTokenIssuedAt = refreshToken.getIssuedAt();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientRegistrationId() {
        return clientRegistrationId;
    }

    public void setClientRegistrationId(String clientRegistrationId) {
        this.clientRegistrationId = clientRegistrationId;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessTokenType() {
        return accessTokenType;
    }

    public void setAccessTokenType(String accessTokenType) {
        this.accessTokenType = accessTokenType;
    }

    public Instant getAccessTokenIssuedAt() {
        return accessTokenIssuedAt;
    }

    public void setAccessTokenIssuedAt(Instant accessTokenIssuedAt) {
        this.accessTokenIssuedAt = accessTokenIssuedAt;
    }

    public Instant getAccessTokenExpiresAt() {
        return accessTokenExpiresAt;
    }

    public void setAccessTokenExpiresAt(Instant accessTokenExpiresAt) {
        this.accessTokenExpiresAt = accessTokenExpiresAt;
    }

    public String getAccessTokenScopes() {
        return accessTokenScopes;
    }

    public void setAccessTokenScopes(String accessTokenScopes) {
        this.accessTokenScopes = accessTokenScopes;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Instant getRefreshTokenIssuedAt() {
        return refreshTokenIssuedAt;
    }

    public void setRefreshTokenIssuedAt(Instant refreshTokenIssuedAt) {
        this.refreshTokenIssuedAt = refreshTokenIssuedAt;
    }

    public OAuth2AuthorizedClient getAuthorizedClient(ClientRegistrationRepository clientRegistrationRepository) {
        if (this.accessTokenScopes != null) {
            return new OAuth2AuthorizedClient(
                    clientRegistrationRepository.findByRegistrationId(this.clientRegistrationId),
                    this.principalName,
                    new OAuth2AccessToken(
                            OAuth2AccessToken.TokenType.BEARER,
                            this.accessToken,
                            this.accessTokenIssuedAt,
                            this.accessTokenExpiresAt)
            );
        } else {
            return new OAuth2AuthorizedClient(
                    clientRegistrationRepository.findByRegistrationId(this.clientRegistrationId),
                    this.principalName,
                    new OAuth2AccessToken(
                            OAuth2AccessToken.TokenType.BEARER,
                            this.accessToken,
                            this.accessTokenIssuedAt,
                            this.accessTokenExpiresAt)
            );
        }
    }
}
