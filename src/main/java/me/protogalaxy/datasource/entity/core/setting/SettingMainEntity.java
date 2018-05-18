package me.protogalaxy.datasource.entity.core.setting;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import me.protogalaxy.datasource.entity.core.user.UserEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "setting_main")
public class SettingMainEntity {
    @JsonIgnore
    @Id
    private int ownerId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified")
    @UpdateTimestamp
    private Date gmtModified;

    @JsonBackReference
    @OneToOne
    @MapsId
    @JoinColumn(name = "setting_owner_id")
    private UserEntity userEntity;

    public SettingMainEntity() {
    }

    public SettingMainEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public SettingMainEntity(Date gmtCreate, Date gmtModified) {
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
