package org.protogalaxy.phss.datasource.entity.filesystem.anime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "anime_bluray")
public class AnimeBluRayEntity {
    @Id
    @GeneratedValue
    private UUID uuid;

    @Column(name = "bangumi_id")
    private Integer bangumiId;

    @Column(name = "title")
    private String title;

    @Column(name = "title_translated")
    private String titleTranslated;

    @Column(name = "poster")
    private String poster;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create", nullable = false)
    @CreatedDate
    private ZonedDateTime columnCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified", nullable = false)
    @LastModifiedDate
    private ZonedDateTime columnModified;

    @OneToOne(mappedBy = "animeBluRayEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private AnimeBluRayInfEntity animeBluRayInfEntity;

    public AnimeBluRayEntity() {
    }

    public AnimeBluRayEntity(Integer bangumiId, String title, String titleTranslated, String poster, AnimeBluRayInfEntity animeBluRayInfEntity) {
        this.bangumiId = bangumiId;
        this.title = title;
        this.titleTranslated = titleTranslated;
        this.poster = poster;
        this.animeBluRayInfEntity = animeBluRayInfEntity;
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

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
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

    public AnimeBluRayInfEntity getAnimeBluRayInfEntity() {
        return animeBluRayInfEntity;
    }

    public void setAnimeBluRayInfEntity(AnimeBluRayInfEntity animeBluRayInfEntity) {
        this.animeBluRayInfEntity = animeBluRayInfEntity;
    }
}
