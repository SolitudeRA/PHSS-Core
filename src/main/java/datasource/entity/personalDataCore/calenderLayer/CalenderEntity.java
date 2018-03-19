package datasource.entity.personalDataCore.calenderLayer;

import datasource.entity.personalDataCore.PersonalDataInfEntity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "calender")
public class CalenderEntity {
    @Id
    private UUID ownerId;

    @Column(name = "event_static_setting")
    private String eventStaticSetting;

    @OneToOne
    @MapsId
    @JoinColumn(name = "owner_id")
    private PersonalDataInfEntity personalDataInfEntity;

    public CalenderEntity() {
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
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
