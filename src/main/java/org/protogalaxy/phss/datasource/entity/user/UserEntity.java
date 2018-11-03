package org.protogalaxy.phss.datasource.entity.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemMainEntity;
import org.protogalaxy.phss.datasource.entity.personaldata.PersonalDataEntity;
import org.protogalaxy.phss.datasource.entity.setting.SettingMainEntity;
import org.protogalaxy.phss.security.config.GrantedAuthority;
import org.hibernate.annotations.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@DynamicInsert
@Table(name = "user")
public class UserEntity implements UserDetails, CredentialsContainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @JsonIgnore
    @Column(name = "password_ext1")
    private String passwordExt1;

    @JsonIgnore
    @Column(name = "password_ext2")
    private String passwordExt2;

    @JsonIgnore
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "date_create")
    @CreatedDate
    private ZonedDateTime dateCreate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "date_modified")
    @LastModifiedDate
    private ZonedDateTime dateModified;

    @JsonManagedReference
    @OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private FileSystemMainEntity fileSystemMainEntity;

    @JsonManagedReference
    @OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private PersonalDataEntity personalDataEntity;

    @JsonManagedReference
    @OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private SettingMainEntity settingMainEntity;

    public UserEntity() {
    }

    /**
     * User entity simple constructor with default ROLE_USER
     *
     * @param username            name of the user
     * @param password            password of the user
     * @param isEnabled           whether account is enabled
     * @param isAccountNonExpired whether account is not expired
     * @param isAccountNonLocked  whether account is not locked
     */
    public UserEntity(String username, String password, Boolean isEnabled, Boolean isAccountNonExpired, Boolean isAccountNonLocked) {
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
     * @param username            name of the user
     * @param password            password of the user
     * @param authoritiesSet      authorities of the user
     * @param isEnabled           whether account is enabled
     * @param isAccountNonExpired whether account is not expired
     * @param isAccountNonLocked  whether account is not locked
     */
    public UserEntity(String username, String password, Set<GrantedAuthority> authoritiesSet, Boolean isEnabled, Boolean isAccountNonExpired, Boolean isAccountNonLocked) {
        if (((username == null) || "".equals(username)) || (password == null)) {
            throw new IllegalArgumentException(
                    "Cannot pass null or empty values to constructor");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        Set<String> roleStrSet = new HashSet<>();
        for (GrantedAuthority authority : authoritiesSet) {
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
     * @param username             name of the user
     * @param password             password of the user
     * @param passwordExt1         USB key content of the user
     * @param passwordExt2         fingerprint data of the user
     * @param passwordExt3         face ID data of the user
     * @param authoritiesSet       authorities of the user
     * @param fileSystemMainEntity fileSystem entity of the user
     * @param personalDataEntity   personalDataInf Entity of the user
     * @param settingMainEntity    settingMain Entity of the user
     */
    public UserEntity(String username, String password, String passwordExt1, String passwordExt2, String passwordExt3, Set<GrantedAuthority> authoritiesSet, FileSystemMainEntity fileSystemMainEntity, PersonalDataEntity personalDataEntity, SettingMainEntity settingMainEntity) {
        if (((username == null) || "".equals(username)) || (password == null)) {
            throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        Set<String> roleStrSet = new HashSet<>();
        for (GrantedAuthority authority : authoritiesSet) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        isEnabled = enabled;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isAccountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public Set<GrantedAuthority> getAuthorities() {
        String[] authoritiesString = authorities.split(",");
        Set<GrantedAuthority> authoritiesSet = new HashSet<>();
        for (String anAuthoritiesString : authoritiesString) {
            authoritiesSet.add(new GrantedAuthority(("ROLE_" + anAuthoritiesString)));
        }
        return authoritiesSet;
    }

    public void setAuthorities(Set<GrantedAuthority> authoritiesSet) {
        Set<String> roleStrSet = new HashSet<>();
        for (GrantedAuthority authority : authoritiesSet) {
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

    @JsonIgnore
    public OAuth2AccessTokenResponse getBangumiOAuth2AccessTokenResponse() {
        return OAuth2AccessTokenResponse.withToken(tokenBangumi)
                                        .tokenType(OAuth2AccessToken.TokenType.BEARER)
                                        .expiresIn(tokenBangumiExpiresIn)
                                        .build();
    }

    public ZonedDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(ZonedDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public ZonedDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(ZonedDateTime dateModified) {
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