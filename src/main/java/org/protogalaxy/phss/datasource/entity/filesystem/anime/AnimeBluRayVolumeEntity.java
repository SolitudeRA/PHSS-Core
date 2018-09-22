package org.protogalaxy.phss.datasource.entity.filesystem.anime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Arrays;
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

    public AnimeBluRayVolumeEntity(AnimeBluRayEntity animeBluRayEntity, List<String> epNumber, List<String> title, List<String> titleTranslated) {
        this.animeBluRayEntity = animeBluRayEntity;
        this.epNumber = String.join("_", epNumber);
        this.title = String.join("_", title);
        this.titleTranslated = String.join("_", titleTranslated);
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

    public List<String> getEpNumber() {
        return Arrays.asList(epNumber.split("_"));
    }

    public void setEpNumber(List<String> epNumber) {
        this.epNumber = String.join("_", epNumber);
    }

    public List<String> getTitle() {
        return Arrays.asList(epNumber.split("_"));
    }

    public void setTitle(String title) {
        this.title = String.join("_", title);
    }

    public List<String> getTitleTranslated() {
        return Arrays.asList(titleTranslated.split("_"));
    }

    public void setTitleTranslated(String titleTranslated) {
        this.titleTranslated = String.join("_", titleTranslated);
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
