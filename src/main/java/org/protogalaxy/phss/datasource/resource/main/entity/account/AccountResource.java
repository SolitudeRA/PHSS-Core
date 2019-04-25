package org.protogalaxy.phss.datasource.resource.main.entity.account;

import org.joda.time.LocalDateTime;
import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemMainEntity;
import org.protogalaxy.phss.datasource.entity.personaldata.PersonalDataEntity;
import org.protogalaxy.phss.datasource.entity.setting.SettingsMainEntity;
import org.protogalaxy.phss.datasource.entity.account.AccountEntity;
import org.protogalaxy.phss.security.config.PhssGrantedAuthority;
import org.springframework.hateoas.ResourceSupport;

import java.util.Set;
import java.util.UUID;

public class AccountResource extends ResourceSupport {

    private UUID uuid;
    private String username;
    private String avatar;
    private Set<PhssGrantedAuthority> authorities;
    private FileSystemMainEntity fileSystemMainEntity;
    private PersonalDataEntity personalDataEntity;
    private SettingsMainEntity settingsMainEntity;
    private Boolean isEnabled;
    private Boolean isAccountNonLocked;
    private Boolean isAccountNonExpired;
    private String dateCreate;
    private String dateModified;

    public AccountResource(AccountEntity accountEntity) {
        this.uuid = accountEntity.getUuid();
        this.username = accountEntity.getUsername();
        this.avatar = accountEntity.getAvatar();
        this.authorities = accountEntity.getAuthorities();
        this.fileSystemMainEntity = accountEntity.getFileSystemMainEntity();
        this.personalDataEntity = accountEntity.getPersonalDataEntity();
        this.settingsMainEntity = accountEntity.getSettingsMainEntity();
        this.isEnabled = accountEntity.isEnabled();
        this.isAccountNonLocked = accountEntity.isAccountNonLocked();
        this.isAccountNonExpired = accountEntity.isAccountNonExpired();
        this.dateCreate = accountEntity.getDateCreated().toString();
        this.dateModified = accountEntity.getDateModified().toString();
    }

    public AccountResource(UUID uuid, String username, String avatar, Set<PhssGrantedAuthority> authorities, FileSystemMainEntity fileSystemMainEntity, PersonalDataEntity personalDataEntity, SettingsMainEntity settingsMainEntity, Boolean isEnabled, Boolean isAccountNonLocked, Boolean isAccountNonExpired, LocalDateTime dateCreate, LocalDateTime dateModified) {
        this.uuid = uuid;
        this.username = username;
        this.avatar = avatar;
        this.authorities = authorities;
        this.fileSystemMainEntity = fileSystemMainEntity;
        this.personalDataEntity = personalDataEntity;
        this.settingsMainEntity = settingsMainEntity;
        this.isEnabled = isEnabled;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isAccountNonExpired = isAccountNonExpired;
        this.dateCreate = dateCreate.toString();
        this.dateModified = dateModified.toString();
    }

    public UUID getUuid() {
        return uuid;
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

    public SettingsMainEntity getSettingsMainEntity() {
        return settingsMainEntity;
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
