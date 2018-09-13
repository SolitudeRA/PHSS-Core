package org.protogalaxy.phss.datasource.entity.filesystem.anime;

import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemMainEntity;

import javax.persistence.*;
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

    public AnimeEntity() {
    }

    public AnimeEntity(FileSystemMainEntity filesystemInfMainEntity, String title, String titleTranslated, String series, Integer season, Integer episode) {
        this.filesystemInfMainEntity = filesystemInfMainEntity;
        this.title = title;
        this.titleTranslated = titleTranslated;
        this.series = series;
        this.season = season;
        this.episode = episode;
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
}
