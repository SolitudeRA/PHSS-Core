package org.protogalaxy.phss.datasource.entity.filesystem.anime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "anime_bluray_volume")
public class AnimeBluRayVolumeEntity {
    @Id
    @GeneratedValue
    private UUID uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "anime_bluray_main")
    private AnimeBluRayEntity animeBluRayEntity;

    @Column(name = "ep_number")
    private String epNumber;

    @Column(name = "title")
    private String title;

    @Column(name = "title_translated")
    private String titleTranslated;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreatedDate
    private Date gmtCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified")
    @LastModifiedDate
    private Date gmtModified;

    public AnimeBluRayVolumeEntity() {
    }

    public AnimeBluRayVolumeEntity(AnimeBluRayEntity animeBluRayEntity, String epNumber, String title, String titleTranslated) {
        this.animeBluRayEntity = animeBluRayEntity;
        this.epNumber = epNumber;
        this.title = title;
        this.titleTranslated = titleTranslated;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public AnimeBluRayEntity getAnimeBluRayEntity() {
        return animeBluRayEntity;
    }

    public void setAnimeBluRayEntity(AnimeBluRayEntity animeBluRayEntity) {
        this.animeBluRayEntity = animeBluRayEntity;
    }

    public String getEpNumber() {
        return epNumber;
    }

    public void setEpNumber(String epNumber) {
        this.epNumber = epNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleTranslated() {
        return titleTranslated;
    }

    public void setTitleTranslated(String titleTranslated) {
        this.titleTranslated = titleTranslated;
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
