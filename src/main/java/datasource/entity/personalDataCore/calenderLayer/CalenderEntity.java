package datasource.entity.personalDataCore.calenderLayer;

import datasource.entity.personalDataCore.PersonalDataInfEntity;

import javax.persistence.*;

@Entity
@Table(name = "calender")
@PrimaryKeyJoinColumn(name = "owner_id")
public class CalenderEntity extends PersonalDataInfEntity {
    @Column(name = "event_static_setting")
    private String eventStaticSetting;

    public CalenderEntity(){
    }

    public CalenderEntity(String eventStaticSetting){
        this.eventStaticSetting = eventStaticSetting;
    }

    public String getEventStaticSetting(){
        return eventStaticSetting;
    }

    public void setEventStaticSetting(String eventStaticSetting){
        this.eventStaticSetting = eventStaticSetting;
    }
}
