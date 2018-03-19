package datasource.entity.settingsCore.runtimeLayer;

import datasource.entity.settingsCore.SettingMainEntity;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "setting_runtime_plugin")
public class SettingRuntimePluginEntity {
    @Id
    private UUID ownerId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    @OneToOne
    @MapsId
    @JoinColumn(name = "setting_owner_id")
    private SettingMainEntity settingMainEntity;

    public SettingRuntimePluginEntity() {
    }

    public SettingRuntimePluginEntity(Date gmtCreate, Date gmtModified) {
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public SettingMainEntity getSettingMainEntity() {
        return settingMainEntity;
    }

    public void setSettingMainEntity(SettingMainEntity settingMainEntity) {
        this.settingMainEntity = settingMainEntity;
    }
}
