package org.protogalaxy.phss.datasource.entity.setting;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.protogalaxy.phss.datasource.entity.account.AccountEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "settings_main")
public class SettingsMainEntity {
    @Id
    private UUID ownerId;

    @CreatedDate
    @Column(name = "created_date")
    private Date createDate;

    @LastModifiedDate
    @Column(name = "modified_date")
    private Date modifiedDate;

    @JsonBackReference
    @OneToOne
    @MapsId
    @JoinColumn(name = "setting_owner_id")
    private AccountEntity accountEntity;

    public SettingsMainEntity() {
    }

    public SettingsMainEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }

    public SettingsMainEntity(Date createDate, Date modifiedDate) {
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }
}
