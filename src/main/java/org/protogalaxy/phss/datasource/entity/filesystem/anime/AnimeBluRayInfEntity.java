package org.protogalaxy.phss.datasource.entity.filesystem.anime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
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
    private LocalDate airDate;

    //上映季度
    @Column(name = "release_quarter")
    private Integer releaseQuarter;

    //官网
    @Column(name = "url")
    private String url;

    //人物
    @ManyToMany(mappedBy = "animeBluRayInfEntity", fetch = FetchType.EAGER)
    @Column(name = "character")
    private List<AnimeCharacterEntity> character;

    //原作
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "original_work")
    private List<AnimeStaffEntity> originalWork;

    //原作插画
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "original_illustrator")
    private List<AnimeStaffEntity> originalIllustrator;

    //原作发行公司
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "original_producer")
    private List<AnimeFirmEntity> originalProducer;

    //导演
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "director")
    private List<AnimeStaffEntity> director;

    //副导演
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "subdirector")
    private List<AnimeStaffEntity> subdirector;

    //人设监修
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "character_design_supervision")
    private List<AnimeStaffEntity> characterDesignSupervision;

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
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "photographic_direction")
    private List<AnimeStaffEntity> photographicDirection;

    //制片人
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "producer")
    private List<AnimeStaffEntity> producer;

    //音乐
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "music")
    private List<AnimeStaffEntity> music;

    //音乐制作人
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "music_producer")
    private List<AnimeStaffEntity> musicProducer;

    //音乐制作
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "music_work")
    private List<AnimeFirmEntity> musicWork;

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
    @Column(name = "color_design")
    private List<AnimeStaffEntity> colorDesign;

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
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "animation_work")
    private List<AnimeFirmEntity> animationWork;

    //放送电视台
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "tv_station")
    private List<AnimeFirmEntity> tvStation;

    @Column(name = "favorite_status")
    private Boolean favoriteStatus;

    @Column(name = "last_watched")
    private LocalDateTime lastWatched;

    @Column(name = "last_downloaded")
    private LocalDateTime lastDownloaded;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreatedDate
    private ZonedDateTime columnCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified")
    @LastModifiedDate
    private ZonedDateTime columnModified;

    @MapsId
    @OneToOne
    @JoinColumn(name = "anime_bluray_id")
    private AnimeBluRayEntity animeBluRayEntity;

}
