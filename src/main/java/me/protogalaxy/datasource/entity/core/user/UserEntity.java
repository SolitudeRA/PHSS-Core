package me.protogalaxy.datasource.entity.core.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import me.protogalaxy.datasource.entity.core.filesystem.main.FileSystemMainEntity;
import me.protogalaxy.datasource.entity.core.personaldata.PersonalDataEntity;
import me.protogalaxy.datasource.entity.core.setting.SettingMainEntity;
import me.protogalaxy.security.config.PhssGrantedAuthority;
import org.hibernate.annotations.*;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.sql.Blob;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//TODO:isCredentialsNonExpired

@Entity
@DynamicInsert
@Table(name = "user")
public class UserEntity implements UserDetails, CredentialsContainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Lob
    @Column(name = "password")
    private String password;

    @Column(name = "password_ext1")
    private String passwordExt1;

    @Column(name = "password_ext2")
    private String passwordExt2;

    @Column(name = "password_ext3")
    private String passwordExt3;

    @Lob
    @Column(name = "avatar")
    private Blob avatar;

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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create")
    @CreationTimestamp
    private Date dateCreate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_modified")
    @UpdateTimestamp
    private Date dateModified;

    @JsonIgnore
    @OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private FileSystemMainEntity fileSystemMainEntity;

    @JsonIgnore
    @OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private PersonalDataEntity personalDataEntity;

    @JsonIgnore
    @OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private SettingMainEntity settingMainEntity;

    public UserEntity() {
    }

    /**
     * User entity simple constructor
     *
     * @param username       name of the user
     * @param password       password of the user
     * @param authoritiesSet authorities of the user
     */
    public UserEntity(String username, String password, Set<PhssGrantedAuthority> authoritiesSet) {
        if (((username == null) || "".equals(username)) || (password == null)) {
            throw new IllegalArgumentException(
                    "Cannot pass null or empty values to constructor");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        Set<String> roleStrSet = new HashSet<>();
        for (PhssGrantedAuthority authority : authoritiesSet) {
            roleStrSet.add(authority.toString().substring(5));
        }
        this.username = username;
        this.password = encoder.encode(password);
        this.authorities = String.join(",", roleStrSet);
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
    public UserEntity(String username, String password, String passwordExt1, String passwordExt2, String passwordExt3, Set<PhssGrantedAuthority> authoritiesSet, FileSystemMainEntity fileSystemMainEntity, PersonalDataEntity personalDataEntity, SettingMainEntity settingMainEntity) {
        if (((username == null) || "".equals(username)) || (password == null)) {
            throw new IllegalArgumentException(
                    "Cannot pass null or empty values to constructor");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        Set<String> roleStrSet = new HashSet<>();
        for (PhssGrantedAuthority authority : authoritiesSet) {
            roleStrSet.add(authority.toString().substring(5));
        }
        this.username = username;
        this.password = encoder.encode(password);
        this.passwordExt1 = passwordExt1;
        this.passwordExt2 = passwordExt2;
        this.passwordExt3 = passwordExt3;
        this.authorities = String.join(",", roleStrSet);
        this.fileSystemMainEntity = fileSystemMainEntity;
        this.personalDataEntity = personalDataEntity;
        this.settingMainEntity = settingMainEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Blob getAvatar() {
        return avatar;
    }

    public void setAvatar(Blob avatar) {
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

    public Date getDateCreate() {
        return dateCreate;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
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