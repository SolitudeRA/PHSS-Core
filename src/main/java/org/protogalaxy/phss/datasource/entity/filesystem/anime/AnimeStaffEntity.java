package org.protogalaxy.phss.datasource.entity.filesystem.anime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "anime_staff")
public class AnimeStaffEntity {
    @Id
    @GeneratedValue
    private UUID uuid;

    @Column(name = "name")
    private String name;

    @Column(name = "name_translated")
    private String nameTranslated;

    @Column(name = "image")
    private String image;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birth")
    private Date birth;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "firm")
    private AnimeFirmEntity animeFirmEntity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreatedDate
    private Date gmtCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified")
    @LastModifiedDate
    private Date gmtModified;

    public AnimeStaffEntity() {
    }

    public AnimeStaffEntity(String name, String nameTranslated, String image, String gender, Date birth, AnimeFirmEntity animeFirmEntity) {
        this.name = name;
        this.nameTranslated = nameTranslated;
        this.image = image;
        this.gender = gender;
        this.birth = birth;
        this.animeFirmEntity = animeFirmEntity;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameTranslated() {
        return nameTranslated;
    }

    public void setNameTranslated(String nameTranslated) {
        this.nameTranslated = nameTranslated;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public AnimeFirmEntity getAnimeFirmEntity() {
        return animeFirmEntity;
    }

    public void setAnimeFirmEntity(AnimeFirmEntity animeFirmEntity) {
        this.animeFirmEntity = animeFirmEntity;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}