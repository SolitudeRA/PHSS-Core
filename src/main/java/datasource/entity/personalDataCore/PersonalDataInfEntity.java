package datasource.entity.personalDataCore;

import datasource.entity.userManagementCore.UserEntity;

import javax.persistence.*;

@Entity
@Table(name = "personaldata_inf")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "owner_id")
public class PersonalDataInfEntity extends UserEntity {
    public PersonalDataInfEntity(){
    }
}
