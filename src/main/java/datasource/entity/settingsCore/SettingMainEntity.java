package datasource.entity.settingsCore;

import datasource.entity.userManagementCore.UserEntity;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "setting_main")
@Inheritance(strategy = InheritanceType.JOINED)
public class SettingMainEntity extends UserEntity {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    public SettingMainEntity(){
    }

    public SettingMainEntity(Date gmtCreate, Date gmtModified){
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public Date getGmtCreate(){
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate){
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified(){
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified){
        this.gmtModified = gmtModified;
    }
}
