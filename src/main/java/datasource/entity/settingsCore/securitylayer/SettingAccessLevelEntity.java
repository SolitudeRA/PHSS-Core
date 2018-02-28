package datasource.entity.settingsCore.securitylayer;

import datasource.entity.settingsCore.SettingMainEntity;

import javax.persistence.*;

@Entity
@Table(name = "setting_access_level")
@PrimaryKeyJoinColumn(name = "setting_owner_id")
public class SettingAccessLevelEntity extends SettingMainEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "encrypted")
    private Boolean encrypted;

    @Column(name = "keyneeded")
    private Boolean keyneeded;

    public SettingAccessLevelEntity(){
    }

    public SettingAccessLevelEntity(String name, Boolean encrypted, Boolean keyneeded){
        this.name = name;
        this.encrypted = encrypted;
        this.keyneeded = keyneeded;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Boolean getEncrypted(){
        return encrypted;
    }

    public void setEncrypted(Boolean encrypted){
        this.encrypted = encrypted;
    }

    public Boolean getKeyneeded(){
        return keyneeded;
    }

    public void setKeyneeded(Boolean keyneeded){
        this.keyneeded = keyneeded;
    }
}
