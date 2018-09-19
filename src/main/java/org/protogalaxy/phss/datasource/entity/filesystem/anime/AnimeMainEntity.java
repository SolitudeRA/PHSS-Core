package org.protogalaxy.phss.datasource.entity.filesystem.anime;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "anime_main")
public class AnimeMainEntity {
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

    public AnimeMainEntity() {
    }

    public AnimeMainEntity(Integer bangumiId, String title, String titleTranslated, String poster) {
        this.bangumiId = bangumiId;
        this.title = title;
        this.titleTranslated = titleTranslated;
        this.poster = poster;
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
}
