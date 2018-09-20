package org.protogalaxy.phss.datasource.entity.filesystem.anime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "anime_bluray_inf")
public class AnimeBluRayInfEntity {
    @Id
    private UUID animeBluRayId;

    //简介
    @Column(name = "summary")
    private String summary;

    //放送日期
    @Column(name = "air_date")
    private Date airDate;

    //上映年份
    @Column(name = "release_year")
    private Date releaseYear;

    //上映季度
    @Column(name = "release_quarter")
    private Integer releaseQuarter;

    //官网
    @Column(name = "url")
    private String url;

    //原作
    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "original_work")
    private AnimeStaffEntity originalWork;

    //原作插画
    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "original_illustrator")
    private AnimeStaffEntity originalIllustrator;

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

    //人设监修
    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "character_design_supervision")
    private AnimeStaffEntity characterDesignSupervision;

    //人设
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "character_design")
    private List<AnimeStaffEntity> characterDesign;

    //脚本
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "script")
    private List<AnimeStaffEntity> script;

    //分镜
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "storyboard")
    private List<AnimeStaffEntity> storyboard;

    //摄影监督
    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "photographic_direction")
    private AnimeStaffEntity photographicDirection;

    //制片人
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "producer")
    private List<AnimeStaffEntity> producer;

    //音乐
    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "music")
    private AnimeStaffEntity music;

    //音乐制作人
    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "music_producer")
    private List<AnimeStaffEntity> musicProducer;

    //音乐制作
    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "music_work")
    private AnimeFirmEntity musicWork;

    //美术监督
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "art_director")
    private List<AnimeStaffEntity> artDirector;

    //美术设计
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "art_designer")
    private List<AnimeStaffEntity> artDesigner;

    //色彩设计
    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "color_design")
    private AnimeStaffEntity colorDesign;

    //总作画监督
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "chief_animation_direction")
    private List<AnimeStaffEntity> chiefAnimationDirection;

    //作画监督
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "animation_direction")
    private List<AnimeStaffEntity> animationDirection;

    //原画
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "key_animation")
    private List<AnimeStaffEntity> keyAnimation;

    //第二原画
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "second_key_animation")
    private List<AnimeStaffEntity> secondKeyAnimation;

    //动画制作
    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "animation_producer")
    private AnimeFirmEntity animationProducer;

    //放送电视台
    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "tv_station")
    private AnimeFirmEntity tvStation;

    @Column(name = "favorite_status")
    private Boolean favoriteStatus;

    @Column(name = "last_watched")
    private Date lastWatched;

    @Column(name = "last_downloaded")
    private Date lastDownloaded;

    @OneToOne
    @MapsId
    @JoinColumn(name = "anime_bluray_id")
    private AnimeBluRayEntity animeBluRayEntity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreatedDate
    private Date gmtCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified")
    @LastModifiedDate
    private Date gmtModified;

    public AnimeBluRayInfEntity() {
    }


}
