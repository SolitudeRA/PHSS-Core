package org.protogalaxy.phss.datasource.entity.core.personaldata;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.protogalaxy.phss.datasource.entity.core.user.UserEntity;

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
    private UserEntity userEntity;

    public PersonalDataEntity() {
    }

    public PersonalDataEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
