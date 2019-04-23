package org.protogalaxy.phss.datasource.entity.thirdparty;

import org.protogalaxy.phss.datasource.entity.account.AccountEntity;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "bangumi_oauth2")
public class BangumiOAuth2Entity {

    @Id
    private UUID uuid;

    @Column(name = "token")
    private String token;

    @Column(name = "token_type")
    private String tokenType;

    @Column(name = "expires_in")
    private Long expiresIn;

    @Column(name = "refresh_token")
    private String refreshToken;

    @MapsId
    @OneToOne
    @JoinColumn(name = "owner_uuid")
    private AccountEntity accountEntity;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }

    public OAuth2AccessTokenResponse getTokenResponse() {
        return OAuth2AccessTokenResponse.withToken(this.token)
                .tokenType(OAuth2AccessToken.TokenType.BEARER)
                .expiresIn(this.expiresIn)
                .build();
    }
}
