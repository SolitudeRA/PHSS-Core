package org.protogalaxy.phss.datasource.entity.core.filesystem.movie;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "video_inf")
public class VideoInfEntity {
    @Id
    private UUID videoId;

    @Column(name = "type")
    private String type;

    @Column(name = "x_resolution")
    private Integer xResolution;

    @Column(name = "y_resolution")
    private Integer yResolution;

    @Column(name = "genre_1")
    private String genre1;

    @Column(name = "genre_2")
    private String genre2;

    @Column(name = "genre_3")
    private String genre3;

    @Column(name = "genre_4")
    private String genre4;

    @Column(name = "genre_5")
    private String genre5;

    @OneToOne
    @MapsId
    @JoinColumn(name = "video_id")
    private VideoEntity videoEntity;

    public VideoInfEntity() {
    }

    public VideoInfEntity(String type, Integer xResolution, Integer yResolution, String genre1, String genre2, String genre3, String genre4, String genre5) {
        this.type = type;
        this.xResolution = xResolution;
        this.yResolution = yResolution;
        this.genre1 = genre1;
        this.genre2 = genre2;
        this.genre3 = genre3;
        this.genre4 = genre4;
        this.genre5 = genre5;
    }

    public UUID getVideoId() {
        return videoId;
    }

    public void setVideoId(UUID videoId) {
        this.videoId = videoId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getxResolution() {
        return xResolution;
    }

    public void setxResolution(Integer xResolution) {
        this.xResolution = xResolution;
    }

    public Integer getyResolution() {
        return yResolution;
    }

    public void setyResolution(Integer yResolution) {
        this.yResolution = yResolution;
    }

    public String getGenre1() {
        return genre1;
    }

    public void setGenre1(String genre1) {
        this.genre1 = genre1;
    }

    public String getGenre2() {
        return genre2;
    }

    public void setGenre2(String genre2) {
        this.genre2 = genre2;
    }

    public String getGenre3() {
        return genre3;
    }

    public void setGenre3(String genre3) {
        this.genre3 = genre3;
    }

    public String getGenre4() {
        return genre4;
    }

    public void setGenre4(String genre4) {
        this.genre4 = genre4;
    }

    public String getGenre5() {
        return genre5;
    }

    public void setGenre5(String genre5) {
        this.genre5 = genre5;
    }

    public VideoEntity getVideoEntity() {
        return videoEntity;
    }

    public void setVideoEntity(VideoEntity videoEntity) {
        this.videoEntity = videoEntity;
    }
}
