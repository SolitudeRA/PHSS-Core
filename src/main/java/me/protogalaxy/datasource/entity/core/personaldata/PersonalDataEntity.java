package me.protogalaxy.datasource.entity.core.personaldata;

import me.protogalaxy.datasource.entity.core.user.UserEntity;

import javax.persistence.*;

@Entity
@Table(name = "personaldata_inf")
public class PersonalDataEntity {
    @Id
    private int ownerId;

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
