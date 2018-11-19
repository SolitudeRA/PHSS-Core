package org.protogalaxy.phss.datasource.entity.personaldata;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.protogalaxy.phss.datasource.entity.account.AccountEntity;

import javax.persistence.*;

@Entity
@Table(name = "personaldata_inf")
public class PersonalDataEntity {
    @JsonIgnore
    @Id
    private int ownerId;

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "owner_id")
    private AccountEntity accountEntity;

    public PersonalDataEntity() {
    }

    public PersonalDataEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }
}
