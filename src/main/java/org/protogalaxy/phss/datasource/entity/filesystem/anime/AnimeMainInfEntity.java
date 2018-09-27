package org.protogalaxy.phss.datasource.entity.filesystem.anime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
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
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @Column(name = "original")
    private List<AnimeStaffEntity> original;

    //原作发行公司
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @Column(name = "original_producer")
    private List<AnimeFirmEntity> originalProducer;

    //导演
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @Column(name = "director")
    private List<AnimeStaffEntity> director;

    //副导演
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @Column(name = "subdirector")
    private List<AnimeStaffEntity> subdirector;

    //制片人
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @Column(name = "producer")
    private List<AnimeStaffEntity> producer;

    //脚本
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @Column(name = "script")
    private List<AnimeStaffEntity> script;

    //分镜
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @Column(name = "storyboard")
    private List<AnimeStaffEntity> storyboard;

    //人物设定
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @Column(name = "character_setting")
    private List<AnimeStaffEntity> characterSetting;

    //音乐
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @Column(name = "music")
    private List<AnimeStaffEntity> music;

    //音乐制作
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @Column(name = "music_producer")
    private List<AnimeFirmEntity> musicProducer;

    //美术监督
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @Column(name = "art_director")
    private List<AnimeStaffEntity> artDirector;

    //美术设计
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @Column(name = "art_designer")
    private List<AnimeFirmEntity> artDesigner;

    //色彩设计
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @Column(name = "color_designer")
    private List<AnimeStaffEntity> colorDesigner;

    //作画监督
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @Column(name = "animation director")
    private List<AnimeStaffEntity> animationDirector;

    //动画制作
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @Column(name = "animation_producer")
    private List<AnimeFirmEntity> animationProducer;

    //放送电视台
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @Column(name = "tv_station")
    private List<AnimeFirmEntity> tvStation;

    @Column(name = "favorite_status")
    private Boolean favoriteStatus;

    @Column(name = "last_watched")
    private LocalDateTime lastWatched;

    @Column(name = "last_downloaded")
    private LocalDateTime lastDownloaded;

    @OneToOne
    @MapsId
    @JoinColumn(name = "anime_id")
    private AnimeMainEntity animeMainEntity;

    @CreatedDate
    @Column(name = "gmt_create")
    private ZonedDateTime columnCreate;

    @LastModifiedDate
    @Column(name = "gmt_modified")
    private ZonedDateTime columnModified;

    public AnimeMainInfEntity() {
    }

    public AnimeMainInfEntity(String summary, Date airDate, Date releaseYear, Integer releaseQuarter, String url, List<AnimeStaffEntity> original, List<AnimeFirmEntity> originalProducer, List<AnimeStaffEntity> director, List<AnimeStaffEntity> subdirector, List<AnimeStaffEntity> producer, List<AnimeStaffEntity> script, List<AnimeStaffEntity> storyboard, List<AnimeStaffEntity> characterSetting, List<AnimeStaffEntity> music, List<AnimeFirmEntity> musicProducer, List<AnimeStaffEntity> artDirector, List<AnimeFirmEntity> artDesigner, List<AnimeStaffEntity> colorDesigner, List<AnimeStaffEntity> animationDirector, List<AnimeFirmEntity> animationProducer, List<AnimeFirmEntity> tvStation, Boolean favoriteStatus, LocalDateTime lastWatched, LocalDateTime lastDownloaded, AnimeMainEntity animeMainEntity) {
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

    public List<AnimeStaffEntity> getOriginal() {
        return original;
    }

    public void setOriginal(List<AnimeStaffEntity> original) {
        this.original = original;
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

    public List<AnimeStaffEntity> getProducer() {
        return producer;
    }

    public void setProducer(List<AnimeStaffEntity> producer) {
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

    public List<AnimeStaffEntity> getMusic() {
        return music;
    }

    public void setMusic(List<AnimeStaffEntity> music) {
        this.music = music;
    }

    public List<AnimeFirmEntity> getMusicProducer() {
        return musicProducer;
    }

    public void setMusicProducer(List<AnimeFirmEntity> musicProducer) {
        this.musicProducer = musicProducer;
    }

    public List<AnimeStaffEntity> getArtDirector() {
        return artDirector;
    }

    public void setArtDirector(List<AnimeStaffEntity> artDirector) {
        this.artDirector = artDirector;
    }

    public List<AnimeFirmEntity> getArtDesigner() {
        return artDesigner;
    }

    public void setArtDesigner(List<AnimeFirmEntity> artDesigner) {
        this.artDesigner = artDesigner;
    }

    public List<AnimeStaffEntity> getColorDesigner() {
        return colorDesigner;
    }

    public void setColorDesigner(List<AnimeStaffEntity> colorDesigner) {
        this.colorDesigner = colorDesigner;
    }

    public List<AnimeStaffEntity> getAnimationDirector() {
        return animationDirector;
    }

    public void setAnimationDirector(List<AnimeStaffEntity> animationDirector) {
        this.animationDirector = animationDirector;
    }

    public List<AnimeFirmEntity> getAnimationProducer() {
        return animationProducer;
    }

    public void setAnimationProducer(List<AnimeFirmEntity> animationProducer) {
        this.animationProducer = animationProducer;
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

    public AnimeMainEntity getAnimeMainEntity() {
        return animeMainEntity;
    }

    public void setAnimeMainEntity(AnimeMainEntity animeMainEntity) {
        this.animeMainEntity = animeMainEntity;
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
}
