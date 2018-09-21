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

    //人物
    @ManyToMany
    @Column(name = "characters")
    private List<AnimeCharacterEntity> characters;

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
    @Column(name = "animation_work")
    private AnimeFirmEntity animationWork;

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

    public AnimeBluRayInfEntity(String summary, List<AnimeCharacterEntity> characters, Date airDate, Date releaseYear, Integer releaseQuarter, String url, AnimeStaffEntity originalWork, AnimeStaffEntity originalIllustrator, AnimeFirmEntity originalProducer, AnimeStaffEntity director, List<AnimeStaffEntity> subdirector, AnimeStaffEntity characterDesignSupervision, List<AnimeStaffEntity> characterDesign, List<AnimeStaffEntity> script, List<AnimeStaffEntity> storyboard, AnimeStaffEntity photographicDirection, List<AnimeStaffEntity> producer, AnimeStaffEntity music, List<AnimeStaffEntity> musicProducer, AnimeFirmEntity musicWork, List<AnimeStaffEntity> artDirector, List<AnimeStaffEntity> artDesigner, AnimeStaffEntity colorDesign, List<AnimeStaffEntity> chiefAnimationDirection, List<AnimeStaffEntity> animationDirection, List<AnimeStaffEntity> keyAnimation, List<AnimeStaffEntity> secondKeyAnimation, AnimeFirmEntity animationWork, AnimeFirmEntity tvStation, Boolean favoriteStatus, Date lastWatched, Date lastDownloaded, AnimeBluRayEntity animeBluRayEntity) {
        this.summary = summary;
        this.characters = characters;
        this.airDate = airDate;
        this.releaseYear = releaseYear;
        this.releaseQuarter = releaseQuarter;
        this.url = url;
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

    public List<AnimeCharacterEntity> getCharacters() {
        return characters;
    }

    public void setCharacters(List<AnimeCharacterEntity> characters) {
        this.characters = characters;
    }

    public Date getAirDate() {
        return airDate;
    }

    public void setAirDate(Date airDate) {
        this.airDate = airDate;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
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

    public AnimeStaffEntity getOriginalWork() {
        return originalWork;
    }

    public void setOriginalWork(AnimeStaffEntity originalWork) {
        this.originalWork = originalWork;
    }

    public AnimeStaffEntity getOriginalIllustrator() {
        return originalIllustrator;
    }

    public void setOriginalIllustrator(AnimeStaffEntity originalIllustrator) {
        this.originalIllustrator = originalIllustrator;
    }

    public AnimeFirmEntity getOriginalProducer() {
        return originalProducer;
    }

    public void setOriginalProducer(AnimeFirmEntity originalProducer) {
        this.originalProducer = originalProducer;
    }

    public AnimeStaffEntity getDirector() {
        return director;
    }

    public void setDirector(AnimeStaffEntity director) {
        this.director = director;
    }

    public List<AnimeStaffEntity> getSubdirector() {
        return subdirector;
    }

    public void setSubdirector(List<AnimeStaffEntity> subdirector) {
        this.subdirector = subdirector;
    }

    public AnimeStaffEntity getCharacterDesignSupervision() {
        return characterDesignSupervision;
    }

    public void setCharacterDesignSupervision(AnimeStaffEntity characterDesignSupervision) {
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

    public AnimeStaffEntity getPhotographicDirection() {
        return photographicDirection;
    }

    public void setPhotographicDirection(AnimeStaffEntity photographicDirection) {
        this.photographicDirection = photographicDirection;
    }

    public List<AnimeStaffEntity> getProducer() {
        return producer;
    }

    public void setProducer(List<AnimeStaffEntity> producer) {
        this.producer = producer;
    }

    public AnimeStaffEntity getMusic() {
        return music;
    }

    public void setMusic(AnimeStaffEntity music) {
        this.music = music;
    }

    public List<AnimeStaffEntity> getMusicProducer() {
        return musicProducer;
    }

    public void setMusicProducer(List<AnimeStaffEntity> musicProducer) {
        this.musicProducer = musicProducer;
    }

    public AnimeFirmEntity getMusicWork() {
        return musicWork;
    }

    public void setMusicWork(AnimeFirmEntity musicWork) {
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

    public AnimeStaffEntity getColorDesign() {
        return colorDesign;
    }

    public void setColorDesign(AnimeStaffEntity colorDesign) {
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

    public AnimeFirmEntity getAnimationWork() {
        return animationWork;
    }

    public void setAnimationWork(AnimeFirmEntity animationWork) {
        this.animationWork = animationWork;
    }

    public AnimeFirmEntity getTvStation() {
        return tvStation;
    }

    public void setTvStation(AnimeFirmEntity tvStation) {
        this.tvStation = tvStation;
    }

    public Boolean getFavoriteStatus() {
        return favoriteStatus;
    }

    public void setFavoriteStatus(Boolean favoriteStatus) {
        this.favoriteStatus = favoriteStatus;
    }

    public Date getLastWatched() {
        return lastWatched;
    }

    public void setLastWatched(Date lastWatched) {
        this.lastWatched = lastWatched;
    }

    public Date getLastDownloaded() {
        return lastDownloaded;
    }

    public void setLastDownloaded(Date lastDownloaded) {
        this.lastDownloaded = lastDownloaded;
    }

    public AnimeBluRayEntity getAnimeBluRayEntity() {
        return animeBluRayEntity;
    }

    public void setAnimeBluRayEntity(AnimeBluRayEntity animeBluRayEntity) {
        this.animeBluRayEntity = animeBluRayEntity;
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
