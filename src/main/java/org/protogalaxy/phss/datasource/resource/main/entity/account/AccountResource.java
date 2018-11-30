package org.protogalaxy.phss.datasource.resource.main.entity.account;

import org.joda.time.LocalDateTime;
import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemMainEntity;
import org.protogalaxy.phss.datasource.entity.personaldata.PersonalDataEntity;
import org.protogalaxy.phss.datasource.entity.setting.SettingMainEntity;
import org.protogalaxy.phss.datasource.entity.account.AccountEntity;
import org.protogalaxy.phss.security.config.PhssGrantedAuthority;
import org.springframework.hateoas.ResourceSupport;

import java.util.Set;

public class AccountResource extends ResourceSupport {

    private Integer uid;
    private String username;
    private String avatar;
    private Set<PhssGrantedAuthority> authorities;
    private FileSystemMainEntity fileSystemMainEntity;
    private PersonalDataEntity personalDataEntity;
    private SettingMainEntity settingMainEntity;
    private Boolean isEnabled;
    private Boolean isAccountNonLocked;
    private Boolean isAccountNonExpired;
    private String dateCreate;
    private String dateModified;

    public AccountResource(AccountEntity accountEntity) {
        this.uid = accountEntity.getId();
        this.username = accountEntity.getUsername();
        this.avatar = accountEntity.getAvatar();
        this.authorities = accountEntity.getAuthorities();
        this.fileSystemMainEntity = accountEntity.getFileSystemMainEntity();
        this.personalDataEntity = accountEntity.getPersonalDataEntity();
        this.settingMainEntity = accountEntity.getSettingMainEntity();
        this.isEnabled = accountEntity.isEnabled();
        this.isAccountNonLocked = accountEntity.isAccountNonLocked();
        this.isAccountNonExpired = accountEntity.isAccountNonExpired();
        this.dateCreate = accountEntity.getDateCreate().toString();
        this.dateModified = accountEntity.getDateModified().toString();
    }

    public AccountResource(Integer id, String username, String avatar, Set<PhssGrantedAuthority> authorities, FileSystemMainEntity fileSystemMainEntity, PersonalDataEntity personalDataEntity, SettingMainEntity settingMainEntity, Boolean isEnabled, Boolean isAccountNonLocked, Boolean isAccountNonExpired, LocalDateTime dateCreate, LocalDateTime dateModified) {
        this.uid = id;
        this.username = username;
        this.avatar = avatar;
        this.authorities = authorities;
        this.fileSystemMainEntity = fileSystemMainEntity;
        this.personalDataEntity = personalDataEntity;
        this.settingMainEntity = settingMainEntity;
        this.isEnabled = isEnabled;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isAccountNonExpired = isAccountNonExpired;
        this.dateCreate = dateCreate.toString();
        this.dateModified = dateModified.toString();
    }

    public Integer getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getAvatar() {
        return avatar;
    }

    public Set<PhssGrantedAuthority> getAuthorities() {
        return authorities;
    }

    public FileSystemMainEntity getFileSystemMainEntity() {
        return fileSystemMainEntity;
    }

    public PersonalDataEntity getPersonalDataEntity() {
        return personalDataEntity;
    }

    public SettingMainEntity getSettingMainEntity() {
        return settingMainEntity;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public Boolean getAccountNonLocked() {
        return isAccountNonLocked;
    }

    public Boolean getAccountNonExpired() {
        return isAccountNonExpired;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public String getDateModified() {
        return dateModified;
    }
}
