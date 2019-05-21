package org.protogalaxy.phss.datasource.entity.account;

import org.joda.time.LocalDateTime;
import org.protogalaxy.phss.datasource.entity.filesystem.FileSystemMainEntity;
import org.protogalaxy.phss.datasource.entity.setting.SettingsMainEntity;
import org.protogalaxy.phss.datasource.entity.thirdparty.BangumiOAuth2Entity;
import org.protogalaxy.phss.security.config.PhssGrantedAuthority;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Main account entity
 *
 * @author SolitudeRA
 * @see SettingsMainEntity
 * @see FileSystemMainEntity
 * @see BangumiOAuth2Entity
 * @since v1.0
 */

@Entity
@Table(name = "account")
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

    @Column(name = "email")
    private String email;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "authorities")
    private String authorities;

    @Column(name = "isEnabled")
    private Boolean isEnabled;

    @Column(name = "isAccountNonExpired")
    private Boolean isAccountNonExpired;

    @Column(name = "isAccountNonLocked")
    private Boolean isAccountNonLocked;

    @CreatedDate
    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @LastModifiedDate
    @Column(name = "date_modified")
    private LocalDateTime dateModified;

    @OneToOne(mappedBy = "accountEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private SettingsMainEntity settingsMainEntity;

    @OneToOne(mappedBy = "accountEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private FileSystemMainEntity fileSystemMainEntity;

    @OneToOne(mappedBy = "accountEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private BangumiOAuth2Entity bangumiOAuth2Entity;

    public AccountEntity() {
    }

    /**
     * User entity default constructor with default authority ROLE_USER
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
     * User entity constructor with authorities
     *
     * @param username       name of the account
     * @param password       password of the account
     * @param authoritiesSet authorities of the account
     */
    public AccountEntity(String username, String password, Set<PhssGrantedAuthority> authoritiesSet) {
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
        this.isEnabled = true;
        this.isAccountNonLocked = true;
        this.isAccountNonExpired = true;
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
     * @param settingsMainEntity   settingMain Entity of the account
     */
    public AccountEntity(String username, String password, String passwordExt1, String passwordExt2, String passwordExt3, Set<PhssGrantedAuthority> authoritiesSet, FileSystemMainEntity fileSystemMainEntity, SettingsMainEntity settingsMainEntity) {
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
        this.settingsMainEntity = settingsMainEntity;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.toLowerCase();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    private Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        this.isEnabled = enabled;
    }

    public Boolean getAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.isAccountNonExpired = accountNonExpired;
    }

    public Boolean getAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.isAccountNonLocked = accountNonLocked;
    }

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

    public boolean isAccountNonExpired() {
        return this.isAccountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return this.getEnabled();
    }

    public void eraseCredentials() {
        this.setPassword("7355608");
    }

    public void enableAccount() {
        this.setEnabled(true);
    }

    public void disableAccount() {
        this.setEnabled(false);
    }

    public void lockAccount() {
        this.setAccountNonLocked(false);
    }

    public void unlockAccount() {
        this.setAccountNonLocked(true);
    }

    public void expireAccount() {
        this.setAccountNonExpired(false);
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
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

    public SettingsMainEntity getSettingsMainEntity() {
        return settingsMainEntity;
    }

    public void setSettingsMainEntity(SettingsMainEntity settingsMainEntity) {
        this.settingsMainEntity = settingsMainEntity;
    }

    public BangumiOAuth2Entity getBangumiOAuth2Entity() {
        return bangumiOAuth2Entity;
    }

    public void setBangumiOAuth2Entity(BangumiOAuth2Entity bangumiOAuth2Entity) {
        this.bangumiOAuth2Entity = bangumiOAuth2Entity;
    }
}