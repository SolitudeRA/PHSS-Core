package org.protogalaxy.phss.datasource.entity.filesystem.anime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "anime")
public class AnimeEpisodeEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "anime_id")
    private AnimeMainEntity animeMainEntity;

    @Column(name = "ep_number")
    private Integer episode;

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

    public AnimeEpisodeEntity() {
    }

    public AnimeEpisodeEntity(AnimeMainEntity animeMainEntity, Integer episode, String title, String titleTranslated) {
        this.animeMainEntity = animeMainEntity;
        this.episode = episode;
        this.title = title;
        this.titleTranslated = titleTranslated;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public AnimeMainEntity getAnimeMainEntity() {
        return animeMainEntity;
    }

    public void setAnimeMainEntity(AnimeMainEntity animeMainEntity) {
        this.animeMainEntity = animeMainEntity;
    }

    public Integer getEpisode() {
        return episode;
    }

    public void setEpisode(Integer episode) {
        this.episode = episode;
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
