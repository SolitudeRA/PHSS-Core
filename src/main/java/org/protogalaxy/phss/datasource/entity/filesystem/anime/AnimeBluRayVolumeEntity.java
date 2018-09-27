package org.protogalaxy.phss.datasource.entity.filesystem.anime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;
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
    private AnimeBluRayEntity animeBluRayEntity;

    @Column(name = "ep_number")
    private String epNumber;

    @Column(name = "title")
    private String title;

    @Column(name = "title_translated")
    private String titleTranslated;

    @CreatedDate
    @Column(name = "gmt_create")
    private ZonedDateTime columnCreate;

    @LastModifiedDate
    @Column(name = "gmt_modified")
    private ZonedDateTime columnModified;

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

    public ZonedDateTime getColumnCreate() {
        return columnCreate;
    }

    public void setColumnCreate(ZonedDateTime columnCreate) {
        this.columnCreate = columnCreate;
    }

    public ZonedDateTime getColumnModified() {
        return columnModified;
    }

    public void setColumnModified(ZonedDateTime columnModified) {
        this.columnModified = columnModified;
    }
}
