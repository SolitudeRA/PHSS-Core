package org.protogalaxy.phss.datasource.entity.filesystem.anime;

import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemMainEntity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "anime")
public class AnimeEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_OWNER_ID_ANIME"))
    private FileSystemMainEntity filesystemInfMainEntity;

    @Column(name = "title")
    private String title;

    @Column(name = "title_translated")
    private String titleTranslated;

    @Column(name = "series")
    private String series;

    @Column(name = "season")
    private Integer season;

    @Column(name = "episode")
    private Integer episode;

    @Column(name = "episode_title")
    private String episodeTitle;

    @Column(name = "episode_title_translated")
    private String episodeTitleTranslated;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreatedDate
    private Date gmtCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified")
    @LastModifiedDate
    private Date gmtModified;

    public AnimeEntity() {
    }

    public AnimeEntity(FileSystemMainEntity filesystemInfMainEntity, String title, String titleTranslated, String series, Integer season, Integer episode, String episodeTitle, String episodeTitleTranslated) {
        this.filesystemInfMainEntity = filesystemInfMainEntity;
        this.title = title;
        this.titleTranslated = titleTranslated;
        this.series = series;
        this.season = season;
        this.episode = episode;
        this.episodeTitle = episodeTitle;
        this.episodeTitleTranslated = episodeTitleTranslated;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public FileSystemMainEntity getFilesystemInfMainEntity() {
        return filesystemInfMainEntity;
    }

    public void setFilesystemInfMainEntity(FileSystemMainEntity filesystemInfMainEntity) {
        this.filesystemInfMainEntity = filesystemInfMainEntity;
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

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Integer getEpisode() {
        return episode;
    }

    public void setEpisode(Integer episode) {
        this.episode = episode;
    }

    public String getEpisodeTitle() {
        return episodeTitle;
    }

    public void setEpisodeTitle(String episodeTitle) {
        this.episodeTitle = episodeTitle;
    }

    public String getEpisodeTitleTranslated() {
        return episodeTitleTranslated;
    }

    public void setEpisodeTitleTranslated(String episodeTitleTranslated) {
        this.episodeTitleTranslated = episodeTitleTranslated;
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
