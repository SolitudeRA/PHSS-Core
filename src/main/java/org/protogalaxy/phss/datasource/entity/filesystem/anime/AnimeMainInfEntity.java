package org.protogalaxy.phss.datasource.entity.filesystem.anime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "anime_main_inf")
public class AnimeMainInfEntity {
    @Id
    private UUID animeId;

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
    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "subdirector")
    private List<AnimeStaffEntity> subdirector;

    //制片人
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "producer")
    private AnimeStaffEntity producer;

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
    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "art_director")
    private AnimeStaffEntity artDirector;

    //美术设计
    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "art_designer")
    private AnimeFirmEntity artDesigner;

    //色彩设计
    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "color_designer")
    private AnimeStaffEntity colorDesigner;

    //作画监督
    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "animation director")
    private AnimeStaffEntity animationDirector;

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
    @JoinColumn(name = "anime_id")
    private AnimeMainEntity animeMainEntity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreatedDate
    private Date gmtCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified")
    @LastModifiedDate
    private Date gmtModified;

    public AnimeMainInfEntity() {
    }

    public AnimeMainInfEntity(String summary, Date airDate, Date releaseYear, Integer releaseQuarter, String url, AnimeStaffEntity original, AnimeFirmEntity originalProducer, AnimeStaffEntity director, List<AnimeStaffEntity> subdirector, AnimeStaffEntity producer, List<AnimeStaffEntity> script, List<AnimeStaffEntity> storyboard, List<AnimeStaffEntity> characterSetting, AnimeStaffEntity music, AnimeFirmEntity musicProducer, AnimeStaffEntity artDirector, AnimeFirmEntity artDesigner, AnimeStaffEntity colorDesigner, AnimeStaffEntity animationDirector, AnimeFirmEntity animationProducer, AnimeFirmEntity tvStation, Boolean favoriteStatus, Date lastWatched, Date lastDownloaded, AnimeMainEntity animeMainEntity) {
        this.summary = summary;
        this.airDate = airDate;
        this.releaseYear = releaseYear;
        this.releaseQuarter = releaseQuarter;
        this.url = url;
        this.original = original;
        this.originalProducer = originalProducer;
        this.director = director;
        this.subdirector = subdirector;
        this.producer = producer;
        this.script = script;
        this.storyboard = storyboard;
        this.characterSetting = characterSetting;
        this.music = music;
        this.musicProducer = musicProducer;
        this.artDirector = artDirector;
        this.artDesigner = artDesigner;
        this.colorDesigner = colorDesigner;
        this.animationDirector = animationDirector;
        this.animationProducer = animationProducer;
        this.tvStation = tvStation;
        this.favoriteStatus = favoriteStatus;
        this.lastWatched = lastWatched;
        this.lastDownloaded = lastDownloaded;
        this.animeMainEntity = animeMainEntity;
    }

    public UUID getAnimeId() {
        return animeId;
    }

    public void setAnimeId(UUID animeId) {
        this.animeId = animeId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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

    public AnimeStaffEntity getOriginal() {
        return original;
    }

    public void setOriginal(AnimeStaffEntity original) {
        this.original = original;
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

    public AnimeStaffEntity getProducer() {
        return producer;
    }

    public void setProducer(AnimeStaffEntity producer) {
        this.producer = producer;
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

    public List<AnimeStaffEntity> getCharacterSetting() {
        return characterSetting;
    }

    public void setCharacterSetting(List<AnimeStaffEntity> characterSetting) {
        this.characterSetting = characterSetting;
    }

    public AnimeStaffEntity getMusic() {
        return music;
    }

    public void setMusic(AnimeStaffEntity music) {
        this.music = music;
    }

    public AnimeFirmEntity getMusicProducer() {
        return musicProducer;
    }

    public void setMusicProducer(AnimeFirmEntity musicProducer) {
        this.musicProducer = musicProducer;
    }

    public AnimeStaffEntity getArtDirector() {
        return artDirector;
    }

    public void setArtDirector(AnimeStaffEntity artDirector) {
        this.artDirector = artDirector;
    }

    public AnimeFirmEntity getArtDesigner() {
        return artDesigner;
    }

    public void setArtDesigner(AnimeFirmEntity artDesigner) {
        this.artDesigner = artDesigner;
    }

    public AnimeStaffEntity getColorDesigner() {
        return colorDesigner;
    }

    public void setColorDesigner(AnimeStaffEntity colorDesigner) {
        this.colorDesigner = colorDesigner;
    }

    public AnimeStaffEntity getAnimationDirector() {
        return animationDirector;
    }

    public void setAnimationDirector(AnimeStaffEntity animationDirector) {
        this.animationDirector = animationDirector;
    }

    public AnimeFirmEntity getAnimationProducer() {
        return animationProducer;
    }

    public void setAnimationProducer(AnimeFirmEntity animationProducer) {
        this.animationProducer = animationProducer;
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

    public AnimeMainEntity getAnimeMainEntity() {
        return animeMainEntity;
    }

    public void setAnimeMainEntity(AnimeMainEntity animeMainEntity) {
        this.animeMainEntity = animeMainEntity;
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
