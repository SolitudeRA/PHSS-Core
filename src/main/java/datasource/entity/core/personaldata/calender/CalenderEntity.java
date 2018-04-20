package datasource.entity.core.personaldata.calender;

import datasource.entity.core.personaldata.PersonalDataInfEntity;

import javax.persistence.*;
import java.util.UUID;

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
    private PersonalDataInfEntity personalDataInfEntity;

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

    public PersonalDataInfEntity getPersonalDataInfEntity() {
        return personalDataInfEntity;
    }

    public void setPersonalDataInfEntity(PersonalDataInfEntity personalDataInfEntity) {
        this.personalDataInfEntity = personalDataInfEntity;
    }
}
