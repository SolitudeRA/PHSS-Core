package org.protogalaxy.phss.datasource.entity.setting;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.protogalaxy.phss.datasource.entity.account.AccountEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "setting_main")
public class SettingMainEntity {
    @JsonIgnore
    @Id
    private int ownerId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified")
    @UpdateTimestamp
    private Date gmtModified;

    @JsonBackReference
    @OneToOne
    @MapsId
    @JoinColumn(name = "setting_owner_id")
    private AccountEntity accountEntity;

    public SettingMainEntity() {
    }

    public SettingMainEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }

    public SettingMainEntity(Date gmtCreate, Date gmtModified) {
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

    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }
}
