package me.protogalaxy.datasource.entity.core.personaldata.calender;

import me.protogalaxy.datasource.entity.core.personaldata.PersonalDataEntity;

import javax.persistence.*;

@Entity
@Table(name = "calender")
public class CalenderEntity {
    @Id
    private int ownerId;

    @Column(name = "event_static_setting")
    private String eventStaticSetting;

    @OneToOne
    @MapsId
    @JoinColumn(name = "owner_id")
    private PersonalDataEntity personalDataEntity;

    public CalenderEntity() {
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public CalenderEntity(String eventStaticSetting) {
        this.eventStaticSetting = eventStaticSetting;
    }

    public String getEventStaticSetting() {
        return eventStaticSetting;
    }

    public void setEventStaticSetting(String eventStaticSetting) {
        this.eventStaticSetting = eventStaticSetting;
    }

    public PersonalDataEntity getPersonalDataEntity() {
        return personalDataEntity;
    }

    public void setPersonalDataEntity(PersonalDataEntity personalDataEntity) {
        this.personalDataEntity = personalDataEntity;
    }
}
