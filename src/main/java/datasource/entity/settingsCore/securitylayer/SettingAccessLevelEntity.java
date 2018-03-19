package datasource.entity.settingsCore.securitylayer;

import datasource.entity.settingsCore.SettingMainEntity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "setting_access_level")
public class SettingAccessLevelEntity {
    @Id
    private UUID ownerId;

    @Column(name = "name")
    private String name;

    @Column(name = "encrypted")
    private Boolean encrypted;

    @Column(name = "keyneeded")
    private Boolean keyneeded;

    @OneToOne
    @MapsId
    @JoinColumn(name = "setting_owner_id")
    private SettingMainEntity settingMainEntity;

    public SettingAccessLevelEntity() {
    }

    public SettingAccessLevelEntity(String name, Boolean encrypted, Boolean keyneeded) {
        this.name = name;
        this.encrypted = encrypted;
        this.keyneeded = keyneeded;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
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

    public SettingMainEntity getSettingMainEntity() {
        return settingMainEntity;
    }

    public void setSettingMainEntity(SettingMainEntity settingMainEntity) {
        this.settingMainEntity = settingMainEntity;
    }
}
