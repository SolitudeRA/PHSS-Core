package datasource.entity.core.personaldata.calender;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "calender_event")
public class CalenderEventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_PERSONAL_DATA_ID"))
    private CalenderEntity calenderEntity;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "content")
    private String content;

    @Column(name = "time_range")
    private String timeRange;

    @Column(name = "alarm")
    private Date alarm;

    @Column(name = "alarm_range")
    private String alarmRange;

    @Column(name = "file_attachment")
    private String fileAttachment;

    public CalenderEventEntity(){
    }

    public CalenderEventEntity(CalenderEntity calenderEntity, String eventName, String content, String timeRange, Date alarm, String alarmRange, String fileAttachment){
        this.calenderEntity = calenderEntity;
        this.eventName = eventName;
        this.content = content;
        this.timeRange = timeRange;
        this.alarm = alarm;
        this.alarmRange = alarmRange;
        this.fileAttachment = fileAttachment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CalenderEntity getCalenderEntity(){
        return calenderEntity;
    }

    public String getEventName(){
        return eventName;
    }

    public void setEventName(String eventName){
        this.eventName = eventName;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getTimeRange(){
        return timeRange;
    }

    public void setTimeRange(String timeRange){
        this.timeRange = timeRange;
    }

    public Date getAlarm(){
        return alarm;
    }

    public void setAlarm(Date alarm){
        this.alarm = alarm;
    }

    public String getAlarmRange(){
        return alarmRange;
    }

    public void setAlarmRange(String alarmRange){
        this.alarmRange = alarmRange;
    }

    public String getFileAttachment(){
        return fileAttachment;
    }

    public void setFileAttachment(String fileAttachment){
        this.fileAttachment = fileAttachment;
    }
}
