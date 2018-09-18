package org.protogalaxy.phss.datasource.entity.filesystem.anime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


@Entity
@Table(name = "anime_seiyuu")
public class AnimeSeiyuuEntity {
    @Id
    @GeneratedValue
    private UUID uuid;

    @Column(name = "bangumi_id")
    private Integer bangumiId;

    @Column(name = "name")
    private String name;

    @Column(name = "name_translated")
    private String nameTranslated;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "image")
    private String image;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birth")
    private Date birth;

    @Column(name = "height")
    private Integer height;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "blood_type")
    private String bloodType;

    @Column(name = "bwh")
    private String bwh;

    @ManyToOne
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

    public AnimeSeiyuuEntity(Integer bangumiId, String name, String nameTranslated, String roleName, String image, String gender, Date birth, Integer height, Integer weight, String bloodType, String bwh, AnimeFirmEntity animeFirmEntity) {
        this.bangumiId = bangumiId;
        this.name = name;
        this.nameTranslated = nameTranslated;
        this.roleName = roleName;
        this.image = image;
        this.gender = gender;
        this.birth = birth;
        this.height = height;
        this.weight = weight;
        this.bloodType = bloodType;
        this.bwh = bwh;
        this.animeFirmEntity = animeFirmEntity;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Integer getBangumiId() {
        return bangumiId;
    }

    public void setBangumiId(Integer bangumiId) {
        this.bangumiId = bangumiId;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getBwh() {
        return bwh;
    }

    public void setBwh(String bwh) {
        this.bwh = bwh;
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
