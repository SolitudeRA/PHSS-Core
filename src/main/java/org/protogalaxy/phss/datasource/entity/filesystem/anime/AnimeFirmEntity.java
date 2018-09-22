package org.protogalaxy.phss.datasource.entity.filesystem.anime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "anime_firm")
public class AnimeFirmEntity {
    @Id
    @GeneratedValue
    private UUID uuid;

    @Column(name = "bangumi_id")
    private Integer bangumiId;

    @Column(name = "name")
    private String name;

    @Column(name = "name_translated")
    private String nameTranslated;

    @Column(name = "birth")
    private Date birth;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreatedDate
    private Date gmtCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified")
    @LastModifiedDate
    private Date gmtModified;

    public AnimeFirmEntity() {
    }

    public AnimeFirmEntity(Integer bangumiId, String name, String nameTranslated, Date birth) {
        this.bangumiId = bangumiId;
        this.name = name;
        this.nameTranslated = nameTranslated;
        this.birth = birth;
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
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
