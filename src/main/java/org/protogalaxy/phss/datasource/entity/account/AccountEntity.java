package org.protogalaxy.phss.datasource.entity.account;

import org.joda.time.LocalDateTime;
import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemMainEntity;
import org.protogalaxy.phss.datasource.entity.personaldata.PersonalDataEntity;
import org.protogalaxy.phss.datasource.entity.setting.SettingMainEntity;
import org.protogalaxy.phss.security.config.PhssGrantedAuthority;
import org.hibernate.annotations.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@DynamicInsert
@Table(name = "account")
@Entity(name = "Account")
@EntityListeners(AuditingEntityListener.class)
public class AccountEntity implements UserDetails, CredentialsContainer {
    @Id
    @GeneratedValue
    private UUID uuid;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "password_ext1")
    private String passwordExt1;

    @Column(name = "password_ext2")
    private String passwordExt2;

    @Column(name = "password_ext3")
    private String passwordExt3;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "isEnabled")
    @ColumnDefault("true")
    private Boolean isEnabled;

    @Column(name = "isAccountNonExpired")
    @ColumnDefault("true")
    private Boolean isAccountNonExpired;

    @Column(name = "isAccountNonLocked")
    @ColumnDefault("true")
    private Boolean isAccountNonLocked;

    @Column(name = "authorities")
    private String authorities;

    @Column(name = "token_bangumi")
    private String tokenBangumi;

    @Column(name = "token_bangumi_token_type")
    private String tokenBangumiTokenType;

    @Column(name = "token_bangumi_expires_in")
    private Long tokenBangumiExpiresIn;

    @Column(name = "token_bangumi_refresh_token")
    private String tokenBangumiRefreshToken;

    @Column(name = "date_create")
    @CreatedDate
    private LocalDateTime dateCreate;

    @Column(name = "date_modified")
    @LastModifiedDate
    private LocalDateTime dateModified;

    @OneToOne(mappedBy = "accountEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private FileSystemMainEntity fileSystemMainEntity;

    @OneToOne(mappedBy = "accountEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private PersonalDataEntity personalDataEntity;

    @OneToOne(mappedBy = "accountEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private SettingMainEntity settingMainEntity;

    public AccountEntity() {
    }

    /**
     * User entity simple constructor with default ROLE_USER
     *
     * @param username name of the account
     * @param password password of the account
     */
    public AccountEntity(String username, String password) {
        this.username = username;
        this.password = password;
        this.authorities = "USER";
        this.isEnabled = true;
        this.isAccountNonExpired = true;
        this.isAccountNonLocked = true;
    }

    /**
     * User entity  constructor with default ROLE_USER and whether account is expired or locked
     *
     * @param username            name of the account
     * @param password            password of the account
     * @param isEnabled           whether account is enabled
     * @param isAccountNonExpired whether account is not expired
     * @param isAccountNonLocked  whether account is not locked
     */
    public AccountEntity(String username, String password, Boolean isEnabled, Boolean isAccountNonExpired, Boolean isAccountNonLocked) {
        if (((username == null) || "".equals(username)) || (password == null)) {
            throw new IllegalArgumentException(
                    "Cannot pass null or empty values to constructor");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        this.username = username.toLowerCase();
        this.password = encoder.encode(password);
        this.authorities = "USER";
        this.isEnabled = isEnabled;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
    }

    /**
     * User entity constructor with authorities
     *
     * @param username            name of the account
     * @param password            password of the account
     * @param authoritiesSet      authorities of the account
     * @param isEnabled           whether account is enabled
     * @param isAccountNonExpired whether account is not expired
     * @param isAccountNonLocked  whether account is not locked
     */
    public AccountEntity(String username, String password, Set<PhssGrantedAuthority> authoritiesSet, Boolean isEnabled, Boolean isAccountNonExpired, Boolean isAccountNonLocked) {
        if (((username == null) || "".equals(username)) || (password == null)) {
            throw new IllegalArgumentException(
                    "Cannot pass null or empty values to constructor");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        Set<String> roleStrSet = new HashSet<>();
        for (PhssGrantedAuthority authority : authoritiesSet) {
            roleStrSet.add(authority.toString().substring(5));
        }
        this.username = username.toLowerCase();
        this.password = encoder.encode(password);
        this.authorities = String.join(",", roleStrSet);
        this.isEnabled = isEnabled;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
    }

    /**
     * User entity full constructor
     *
     * @param username             name of the account
     * @param password             password of the account
     * @param passwordExt1         USB key content of the account
     * @param passwordExt2         fingerprint data of the account
     * @param passwordExt3         face ID data of the account
     * @param authoritiesSet       authorities of the account
     * @param fileSystemMainEntity fileSystem entity of the account
     * @param personalDataEntity   personalDataInf Entity of the account
     * @param settingMainEntity    settingMain Entity of the account
     */
    public AccountEntity(String username, String password, String passwordExt1, String passwordExt2, String passwordExt3, Set<PhssGrantedAuthority> authoritiesSet, FileSystemMainEntity fileSystemMainEntity, PersonalDataEntity personalDataEntity, SettingMainEntity settingMainEntity) {
        if (((username == null) || "".equals(username)) || (password == null)) {
            throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        Set<String> roleStrSet = new HashSet<>();
        for (PhssGrantedAuthority authority : authoritiesSet) {
            roleStrSet.add(authority.toString().substring(5));
        }
        this.username = username.toLowerCase();
        this.password = encoder.encode(password);
        this.passwordExt1 = passwordExt1;
        this.passwordExt2 = passwordExt2;
        this.passwordExt3 = passwordExt3;
        this.authorities = String.join(",", roleStrSet);
        this.fileSystemMainEntity = fileSystemMainEntity;
        this.personalDataEntity = personalDataEntity;
        this.settingMainEntity = settingMainEntity;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.toLowerCase();
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordExt1() {
        return passwordExt1;
    }

    public void setPasswordExt1(String passwordExt1) {
        this.passwordExt1 = passwordExt1;
    }

    public String getPasswordExt2() {
        return passwordExt2;
    }

    public void setPasswordExt2(String passwordExt2) {
        this.passwordExt2 = passwordExt2;
    }

    public String getPasswordExt3() {
        return passwordExt3;
    }

    public void setPasswordExt3(String passwordExt3) {
        this.passwordExt3 = passwordExt3;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void setEnabled(boolean enabled) {
        this.isEnabled = enabled;
    }

    public void enableAccount() {
        this.isEnabled = true;
    }

    public void disableAccount() {
        this.isEnabled = false;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isAccountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.isAccountNonExpired = accountNonExpired;
    }

    public void expireAccount() {
        this.isAccountNonExpired = false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public void lockAccount() {
        this.isAccountNonLocked = false;
    }

    public void unlockAccount() {
        this.isAccountNonLocked = true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public Set<PhssGrantedAuthority> getAuthorities() {
        String[] authoritiesString = authorities.split(",");
        Set<PhssGrantedAuthority> authoritiesSet = new HashSet<>();
        for (String anAuthoritiesString : authoritiesString) {
            authoritiesSet.add(new PhssGrantedAuthority(("ROLE_" + anAuthoritiesString)));
        }
        return authoritiesSet;
    }

    public void setAuthorities(Set<PhssGrantedAuthority> authoritiesSet) {
        Set<String> roleStrSet = new HashSet<>();
        for (PhssGrantedAuthority authority : authoritiesSet) {
            roleStrSet.add(authority.toString().substring(5));
        }
        this.authorities = String.join(",", roleStrSet);
    }

    public String getTokenBangumi() {
        return tokenBangumi;
    }

    public void setTokenBangumi(String tokenBangumi) {
        this.tokenBangumi = tokenBangumi;
    }

    public String getTokenBangumiTokenType() {
        return tokenBangumiTokenType;
    }

    public void setTokenBangumiTokenType(String tokenBangumiTokenType) {
        this.tokenBangumiTokenType = tokenBangumiTokenType;
    }

    public Long getTokenBangumiExpiresIn() {
        return tokenBangumiExpiresIn;
    }

    public void setTokenBangumiExpiresIn(Long tokenBangumiExpiresIn) {
        this.tokenBangumiExpiresIn = tokenBangumiExpiresIn;
    }

    public String getTokenBangumiRefreshToken() {
        return tokenBangumiRefreshToken;
    }

    public void setTokenBangumiRefreshToken(String tokenBangumiRefreshToken) {
        this.tokenBangumiRefreshToken = tokenBangumiRefreshToken;
    }

    public OAuth2AccessTokenResponse getBangumiOAuth2AccessTokenResponse() {
        return OAuth2AccessTokenResponse.withToken(tokenBangumi)
                                        .tokenType(OAuth2AccessToken.TokenType.BEARER)
                                        .expiresIn(tokenBangumiExpiresIn)
                                        .build();
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public LocalDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDateTime dateModified) {
        this.dateModified = dateModified;
    }

    public FileSystemMainEntity getFileSystemMainEntity() {
        return fileSystemMainEntity;
    }

    public void setFileSystemMainEntity(FileSystemMainEntity fileSystemMainEntity) {
        this.fileSystemMainEntity = fileSystemMainEntity;
    }

    public PersonalDataEntity getPersonalDataEntity() {
        return personalDataEntity;
    }

    public void setPersonalDataEntity(PersonalDataEntity personalDataEntity) {
        this.personalDataEntity = personalDataEntity;
    }

    public SettingMainEntity getSettingMainEntity() {
        return settingMainEntity;
    }

    public void setSettingMainEntity(SettingMainEntity settingMainEntity) {
        this.settingMainEntity = settingMainEntity;
    }

    @Override
    public void eraseCredentials() {
        password = null;
    }
}