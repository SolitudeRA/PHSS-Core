package org.protogalaxy.phss.datasource.entity.filesystem.anime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class AnimeMovieBluRayInfEntity {
    //简介
    @Column(name = "summary")
    private String summary;

    //上映日期
    @Column(name = "release_date")
    private Date releaseYear;

    //官网
    @Column(name = "url")
    private String url;

    //原作
    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "original")
    private AnimeStaffEntity original;

    //原作发行公司
    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "original_producer")
    private AnimeFirmEntity originalProducer;

    //导演
    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "director")
    private AnimeStaffEntity director;

    //副导演
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "subdirector")
    private List<AnimeStaffEntity> subdirector;

    //制片人
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "producer")
    private List<AnimeStaffEntity> producer;

    //脚本
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "script")
    private List<AnimeStaffEntity> script;

    //分镜
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "storyboard")
    private List<AnimeStaffEntity> storyboard;

    //人物设定
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "character_setting")
    private List<AnimeStaffEntity> characterSetting;

    //音乐
    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "music")
    private AnimeStaffEntity music;

    //音乐制作
    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "music_producer")
    private AnimeFirmEntity musicProducer;

    //美术监督
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "art_director")
    private List<AnimeStaffEntity> artDirector;

    //美术设计
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "art_designer")
    private List<AnimeStaffEntity> artDesigner;

    //色彩设计
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "color_designer")
    private List<AnimeStaffEntity> colorDesigner;

    //作画监督
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "animation director")
    private List<AnimeStaffEntity> animationDirector;

    //动画制作
    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "animation_producer")
    private AnimeFirmEntity animationProducer;

    @Column(name = "favorite_status")
    private Boolean favoriteStatus;

    @Column(name = "last_watched")
    private Date lastWatched;

    @Column(name = "last_downloaded")
    private Date lastDownloaded;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreatedDate
    private Date gmtCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified")
    @LastModifiedDate
    private Date gmtModified;
}
