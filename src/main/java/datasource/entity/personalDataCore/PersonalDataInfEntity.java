package datasource.entity.personalDataCore;

import datasource.entity.userManagementCore.UserEntity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "personaldata_inf")
public class PersonalDataInfEntity {
    @Id
    private UUID ownerId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "owner_id")
    private UserEntity userEntity;

    public PersonalDataInfEntity() {
    }

    public PersonalDataInfEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
