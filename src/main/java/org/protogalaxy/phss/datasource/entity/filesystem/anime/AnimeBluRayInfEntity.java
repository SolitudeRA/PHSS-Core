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
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "character")
    private List<AnimeCharacterEntity> character;

    //原作
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "original_work")
    private List<AnimeStaffEntity> originalWork;

    //原作插画
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "original_illustrator")
    private List<AnimeStaffEntity> originalIllustrator;

    //原作发行公司
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "original_producer")
    private List<AnimeFirmEntity> originalProducer;

    //导演
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "director")
    private List<AnimeStaffEntity> director;

    //副导演
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "subdirector")
    private List<AnimeStaffEntity> subdirector;

    //人设监修
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "character_design_supervision")
    private List<AnimeStaffEntity> characterDesignSupervision;

    //人设
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "character_design")
    private List<AnimeStaffEntity> characterDesign;

    //脚本
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "script")
    private List<AnimeStaffEntity> script;

    //分镜
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "storyboard")
    private List<AnimeStaffEntity> storyboard;

    //摄影监督
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "photographic_direction")
    private List<AnimeStaffEntity> photographicDirection;

    //制片人
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "producer")
    private List<AnimeStaffEntity> producer;

    //音乐
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "music")
    private List<AnimeStaffEntity> music;

    //音乐制作人
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "music_producer")
    private List<AnimeStaffEntity> musicProducer;

    //音乐制作
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "music_work")
    private List<AnimeFirmEntity> musicWork;

    //美术监督
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "art_director")
    private List<AnimeStaffEntity> artDirector;

    //美术设计
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "art_designer")
    private List<AnimeStaffEntity> artDesigner;

    //色彩设计
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "color_design")
    private List<AnimeStaffEntity> colorDesign;

    //总作画监督
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "chief_animation_direction")
    private List<AnimeStaffEntity> chiefAnimationDirection;

    //作画监督
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "animation_direction")
    private List<AnimeStaffEntity> animationDirection;

    //原画
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "key_animation")
    private List<AnimeStaffEntity> keyAnimation;

    //第二原画
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "second_key_animation")
    private List<AnimeStaffEntity> secondKeyAnimation;

    //动画制作
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "animation_work")
    private List<AnimeFirmEntity> animationWork;

    //放送电视台
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "tv_station")
    private List<AnimeFirmEntity> tvStation;

    @Column(name = "favorite_status")
    private Boolean favoriteStatus;

    @Column(name = "last_watched")
    private LocalDateTime lastWatched;

    @Column(name = "last_downloaded")
    private LocalDateTime lastDownloaded;

    @MapsId
    @OneToOne
    @JoinColumn(name = "anime_bluray_id")
    private AnimeBluRayEntity animeBluRayEntity;

    @CreatedDate
    @Column(name = "gmt_create")
    private ZonedDateTime columnCreate;

    @LastModifiedDate
    @Column(name = "gmt_modified")
    private ZonedDateTime columnModified;

    public AnimeBluRayInfEntity() {
    }

    public AnimeBluRayInfEntity(String summary, LocalDate airDate, Integer releaseQuarter, String url, List<AnimeCharacterEntity> character, List<AnimeStaffEntity> originalWork, List<AnimeStaffEntity> originalIllustrator, List<AnimeFirmEntity> originalProducer, List<AnimeStaffEntity> director, List<AnimeStaffEntity> subdirector, List<AnimeStaffEntity> characterDesignSupervision, List<AnimeStaffEntity> characterDesign, List<AnimeStaffEntity> script, List<AnimeStaffEntity> storyboard, List<AnimeStaffEntity> photographicDirection, List<AnimeStaffEntity> producer, List<AnimeStaffEntity> music, List<AnimeStaffEntity> musicProducer, List<AnimeFirmEntity> musicWork, List<AnimeStaffEntity> artDirector, List<AnimeStaffEntity> artDesigner, List<AnimeStaffEntity> colorDesign, List<AnimeStaffEntity> chiefAnimationDirection, List<AnimeStaffEntity> animationDirection, List<AnimeStaffEntity> keyAnimation, List<AnimeStaffEntity> secondKeyAnimation, List<AnimeFirmEntity> animationWork, List<AnimeFirmEntity> tvStation, Boolean favoriteStatus, LocalDateTime lastWatched, LocalDateTime lastDownloaded, AnimeBluRayEntity animeBluRayEntity) {
        this.summary = summary;
        this.airDate = airDate;
        this.releaseQuarter = releaseQuarter;
        this.url = url;
        this.character = character;
        this.originalWork = originalWork;
        this.originalIllustrator = originalIllustrator;
        this.originalProducer = originalProducer;
        this.director = director;
        this.subdirector = subdirector;
        this.characterDesignSupervision = characterDesignSupervision;
        this.characterDesign = characterDesign;
        this.script = script;
        this.storyboard = storyboard;
        this.photographicDirection = photographicDirection;
        this.producer = producer;
        this.music = music;
        this.musicProducer = musicProducer;
        this.musicWork = musicWork;
        this.artDirector = artDirector;
        this.artDesigner = artDesigner;
        this.colorDesign = colorDesign;
        this.chiefAnimationDirection = chiefAnimationDirection;
        this.animationDirection = animationDirection;
        this.keyAnimation = keyAnimation;
        this.secondKeyAnimation = secondKeyAnimation;
        this.animationWork = animationWork;
        this.tvStation = tvStation;
        this.favoriteStatus = favoriteStatus;
        this.lastWatched = lastWatched;
        this.lastDownloaded = lastDownloaded;
        this.animeBluRayEntity = animeBluRayEntity;
    }

    public UUID getAnimeBluRayId() {
        return animeBluRayId;
    }

    public void setAnimeBluRayId(UUID animeBluRayId) {
        this.animeBluRayId = animeBluRayId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public LocalDate getAirDate() {
        return airDate;
    }

    public void setAirDate(LocalDate airDate) {
        this.airDate = airDate;
    }

    public Integer getReleaseQuarter() {
        return releaseQuarter;
    }

    public void setReleaseQuarter(Integer releaseQuarter) {
        this.releaseQuarter = releaseQuarter;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<AnimeCharacterEntity> getCharacter() {
        return character;
    }

    public void setCharacter(List<AnimeCharacterEntity> character) {
        this.character = character;
    }

    public List<AnimeStaffEntity> getOriginalWork() {
        return originalWork;
    }

    public void setOriginalWork(List<AnimeStaffEntity> originalWork) {
        this.originalWork = originalWork;
    }

    public List<AnimeStaffEntity> getOriginalIllustrator() {
        return originalIllustrator;
    }

    public void setOriginalIllustrator(List<AnimeStaffEntity> originalIllustrator) {
        this.originalIllustrator = originalIllustrator;
    }

    public List<AnimeFirmEntity> getOriginalProducer() {
        return originalProducer;
    }

    public void setOriginalProducer(List<AnimeFirmEntity> originalProducer) {
        this.originalProducer = originalProducer;
    }

    public List<AnimeStaffEntity> getDirector() {
        return director;
    }

    public void setDirector(List<AnimeStaffEntity> director) {
        this.director = director;
    }

    public List<AnimeStaffEntity> getSubdirector() {
        return subdirector;
    }

    public void setSubdirector(List<AnimeStaffEntity> subdirector) {
        this.subdirector = subdirector;
    }

    public List<AnimeStaffEntity> getCharacterDesignSupervision() {
        return characterDesignSupervision;
    }

    public void setCharacterDesignSupervision(List<AnimeStaffEntity> characterDesignSupervision) {
        this.characterDesignSupervision = characterDesignSupervision;
    }

    public List<AnimeStaffEntity> getCharacterDesign() {
        return characterDesign;
    }

    public void setCharacterDesign(List<AnimeStaffEntity> characterDesign) {
        this.characterDesign = characterDesign;
    }

    public List<AnimeStaffEntity> getScript() {
        return script;
    }

    public void setScript(List<AnimeStaffEntity> script) {
        this.script = script;
    }

    public List<AnimeStaffEntity> getStoryboard() {
        return storyboard;
    }

    public void setStoryboard(List<AnimeStaffEntity> storyboard) {
        this.storyboard = storyboard;
    }

    public List<AnimeStaffEntity> getPhotographicDirection() {
        return photographicDirection;
    }

    public void setPhotographicDirection(List<AnimeStaffEntity> photographicDirection) {
        this.photographicDirection = photographicDirection;
    }

    public List<AnimeStaffEntity> getProducer() {
        return producer;
    }

    public void setProducer(List<AnimeStaffEntity> producer) {
        this.producer = producer;
    }

    public List<AnimeStaffEntity> getMusic() {
        return music;
    }

    public void setMusic(List<AnimeStaffEntity> music) {
        this.music = music;
    }

    public List<AnimeStaffEntity> getMusicProducer() {
        return musicProducer;
    }

    public void setMusicProducer(List<AnimeStaffEntity> musicProducer) {
        this.musicProducer = musicProducer;
    }

    public List<AnimeFirmEntity> getMusicWork() {
        return musicWork;
    }

    public void setMusicWork(List<AnimeFirmEntity> musicWork) {
        this.musicWork = musicWork;
    }

    public List<AnimeStaffEntity> getArtDirector() {
        return artDirector;
    }

    public void setArtDirector(List<AnimeStaffEntity> artDirector) {
        this.artDirector = artDirector;
    }

    public List<AnimeStaffEntity> getArtDesigner() {
        return artDesigner;
    }

    public void setArtDesigner(List<AnimeStaffEntity> artDesigner) {
        this.artDesigner = artDesigner;
    }

    public List<AnimeStaffEntity> getColorDesign() {
        return colorDesign;
    }

    public void setColorDesign(List<AnimeStaffEntity> colorDesign) {
        this.colorDesign = colorDesign;
    }

    public List<AnimeStaffEntity> getChiefAnimationDirection() {
        return chiefAnimationDirection;
    }

    public void setChiefAnimationDirection(List<AnimeStaffEntity> chiefAnimationDirection) {
        this.chiefAnimationDirection = chiefAnimationDirection;
    }

    public List<AnimeStaffEntity> getAnimationDirection() {
        return animationDirection;
    }

    public void setAnimationDirection(List<AnimeStaffEntity> animationDirection) {
        this.animationDirection = animationDirection;
    }

    public List<AnimeStaffEntity> getKeyAnimation() {
        return keyAnimation;
    }

    public void setKeyAnimation(List<AnimeStaffEntity> keyAnimation) {
        this.keyAnimation = keyAnimation;
    }

    public List<AnimeStaffEntity> getSecondKeyAnimation() {
        return secondKeyAnimation;
    }

    public void setSecondKeyAnimation(List<AnimeStaffEntity> secondKeyAnimation) {
        this.secondKeyAnimation = secondKeyAnimation;
    }

    public List<AnimeFirmEntity> getAnimationWork() {
        return animationWork;
    }

    public void setAnimationWork(List<AnimeFirmEntity> animationWork) {
        this.animationWork = animationWork;
    }

    public List<AnimeFirmEntity> getTvStation() {
        return tvStation;
    }

    public void setTvStation(List<AnimeFirmEntity> tvStation) {
        this.tvStation = tvStation;
    }

    public Boolean getFavoriteStatus() {
        return favoriteStatus;
    }

    public void setFavoriteStatus(Boolean favoriteStatus) {
        this.favoriteStatus = favoriteStatus;
    }

    public LocalDateTime getLastWatched() {
        return lastWatched;
    }

    public void setLastWatched(LocalDateTime lastWatched) {
        this.lastWatched = lastWatched;
    }

    public LocalDateTime getLastDownloaded() {
        return lastDownloaded;
    }

    public void setLastDownloaded(LocalDateTime lastDownloaded) {
        this.lastDownloaded = lastDownloaded;
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

    public AnimeBluRayEntity getAnimeBluRayEntity() {
        return animeBluRayEntity;
    }

    public void setAnimeBluRayEntity(AnimeBluRayEntity animeBluRayEntity) {
        this.animeBluRayEntity = animeBluRayEntity;
    }
}
