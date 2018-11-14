package org.protogalaxy.phss.datasource.resource.main.entity.user;

import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemMainEntity;
import org.protogalaxy.phss.datasource.entity.personaldata.PersonalDataEntity;
import org.protogalaxy.phss.datasource.entity.setting.SettingMainEntity;
import org.protogalaxy.phss.datasource.entity.user.UserEntity;
import org.protogalaxy.phss.security.config.PhssGrantedAuthority;
import org.springframework.hateoas.ResourceSupport;

import java.time.ZonedDateTime;
import java.util.Set;

public class UserResource extends ResourceSupport {

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
    private ZonedDateTime dateCreate;
    private ZonedDateTime dateModified;

    public UserResource(UserEntity userEntity) {
        this.uid = userEntity.getId();
        this.username = userEntity.getUsername();
        this.avatar = userEntity.getAvatar();
        this.authorities = userEntity.getAuthorities();
        this.fileSystemMainEntity = userEntity.getFileSystemMainEntity();
        this.personalDataEntity = userEntity.getPersonalDataEntity();
        this.settingMainEntity = userEntity.getSettingMainEntity();
        this.isEnabled = userEntity.isEnabled();
        this.isAccountNonLocked = userEntity.isAccountNonLocked();
        this.isAccountNonExpired = userEntity.isAccountNonExpired();
        this.dateCreate = userEntity.getDateCreate();
        this.dateModified = userEntity.getDateModified();
    }

    public UserResource(Integer id, String username, String avatar, Set<PhssGrantedAuthority> authorities, FileSystemMainEntity fileSystemMainEntity, PersonalDataEntity personalDataEntity, SettingMainEntity settingMainEntity, Boolean isEnabled, Boolean isAccountNonLocked, Boolean isAccountNonExpired, ZonedDateTime dateCreate, ZonedDateTime dateModified) {
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
        this.dateCreate = dateCreate;
        this.dateModified = dateModified;
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

    public ZonedDateTime getDateCreate() {
        return dateCreate;
    }

    public ZonedDateTime getDateModified() {
        return dateModified;
    }
}
