package org.protogalaxy.phss.datasource.entity.setting;

import org.protogalaxy.phss.datasource.entity.account.AccountEntity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "settings_main")
@EntityListeners(AuditingEntityListener.class)
public class SettingsMainEntity {
    @Id
    private UUID ownerId;

    @CreatedDate
    @Column(name = "date_created")
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(name = "date_modified")
    private LocalDateTime modifiedDate;

    @MapsId
    @OneToOne
    @JoinColumn(name = "owner_uuid")
    private AccountEntity accountEntity;

    public SettingsMainEntity() {
    }

    public SettingsMainEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }
}
