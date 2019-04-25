package org.protogalaxy.phss.datasource.entity.setting.security;

import org.protogalaxy.phss.datasource.entity.setting.SettingsMainEntity;

import javax.persistence.*;

@Entity
@Table(name = "setting_access_level")
public class SettingAccessLevelEntity {
    @Id
    private int ownerId;

    @Column(name = "name")
    private String name;

    @Column(name = "encrypted")
    private Boolean encrypted;

    @Column(name = "keyneeded")
    private Boolean keyneeded;

    @OneToOne
    @MapsId
    @JoinColumn(name = "setting_owner_id")
    private SettingsMainEntity settingsMainEntity;

    public SettingAccessLevelEntity() {
    }

    public SettingAccessLevelEntity(String name, Boolean encrypted, Boolean keyneeded) {
        this.name = name;
        this.encrypted = encrypted;
        this.keyneeded = keyneeded;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEncrypted() {
        return encrypted;
    }

    public void setEncrypted(Boolean encrypted) {
        this.encrypted = encrypted;
    }

    public Boolean getKeyneeded() {
        return keyneeded;
    }

    public void setKeyneeded(Boolean keyneeded) {
        this.keyneeded = keyneeded;
    }

    public SettingsMainEntity getSettingsMainEntity() {
        return settingsMainEntity;
    }

    public void setSettingsMainEntity(SettingsMainEntity settingsMainEntity) {
        this.settingsMainEntity = settingsMainEntity;
    }
}
