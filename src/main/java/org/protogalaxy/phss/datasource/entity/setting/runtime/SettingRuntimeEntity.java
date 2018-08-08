package org.protogalaxy.phss.datasource.entity.setting.runtime;

import org.protogalaxy.phss.datasource.entity.setting.SettingMainEntity;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "setting_runtime")
public class SettingRuntimeEntity {
    @Id
    private int ownerId;

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

    public SettingRuntimeEntity() {
    }

    public SettingRuntimeEntity(Date gmtCreate, Date gmtModified) {
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
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
