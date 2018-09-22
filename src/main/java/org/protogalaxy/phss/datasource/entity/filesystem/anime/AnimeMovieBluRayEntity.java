package org.protogalaxy.phss.datasource.entity.filesystem.anime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "anime_movie_bluray")
public class AnimeMovieBluRayEntity {
    @Id
    @GeneratedValue
    private UUID uuid;

    @Column(name = "title_official")
    private String nameOfficial;

    @Column(name = "name_translated")
    private String nameTranslated;

    @Column(name = "year")
    private Date year;

    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "character")
    private List<AnimeCharacterEntity> character;

    @Column(name = "duration")
    private String duration;

    @Column(name = "original_work")
    private String originalWork;

    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "direction")
    private List<AnimeStaffEntity> direction;

    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "producer")
    private List<AnimeStaffEntity> producer;

    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "character_design")
    private List<AnimeStaffEntity> characterDesign;

    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "storyboard")
    private AnimeStaffEntity storyboard;

    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "script")
    private AnimeStaffEntity script;

    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "sound_direction")
    private List<AnimeStaffEntity> soundDirection;

    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "sound_effects")
    private List<AnimeStaffEntity> soundEffects;

    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "sound_work")
    private AnimeFirmEntity soundWork;

    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "music")
    private AnimeStaffEntity music;

    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "music_producer")
    private List<AnimeStaffEntity> musicProducer;

    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "art_direction")
    private List<AnimeStaffEntity> artDirection;

    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "art_design")
    private List<AnimeStaffEntity> artDesign;

    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "color_design")
    private List<AnimeStaffEntity> colorDesign;

    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "key_animation")
    private List<AnimeStaffEntity> keyAnimation;

    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "second_key_animation")
    private List<AnimeStaffEntity> secondKeyAnimation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreatedDate
    private Date gmtCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified")
    @LastModifiedDate
    private Date gmtModified;

    public AnimeMovieBluRayEntity(String nameOfficial, String nameTranslated, Date year, List<AnimeCharacterEntity> character, String duration, String originalWork, List<AnimeStaffEntity> direction, List<AnimeStaffEntity> producer, List<AnimeStaffEntity> characterDesign, AnimeStaffEntity storyboard, AnimeStaffEntity script, List<AnimeStaffEntity> soundDirection, List<AnimeStaffEntity> soundEffects, AnimeFirmEntity soundWork, AnimeStaffEntity music, List<AnimeStaffEntity> musicProducer, List<AnimeStaffEntity> artDirection, List<AnimeStaffEntity> artDesign, List<AnimeStaffEntity> colorDesign, List<AnimeStaffEntity> keyAnimation, List<AnimeStaffEntity> secondKeyAnimation) {
        this.nameOfficial = nameOfficial;
        this.nameTranslated = nameTranslated;
        this.year = year;
        this.character = character;
        this.duration = duration;
        this.originalWork = originalWork;
        this.direction = direction;
        this.producer = producer;
        this.characterDesign = characterDesign;
        this.storyboard = storyboard;
        this.script = script;
        this.soundDirection = soundDirection;
        this.soundEffects = soundEffects;
        this.soundWork = soundWork;
        this.music = music;
        this.musicProducer = musicProducer;
        this.artDirection = artDirection;
        this.artDesign = artDesign;
        this.colorDesign = colorDesign;
        this.keyAnimation = keyAnimation;
        this.secondKeyAnimation = secondKeyAnimation;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getNameOfficial() {
        return nameOfficial;
    }

    public void setNameOfficial(String nameOfficial) {
        this.nameOfficial = nameOfficial;
    }

    public String getNameTranslated() {
        return nameTranslated;
    }

    public void setNameTranslated(String nameTranslated) {
        this.nameTranslated = nameTranslated;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public List<AnimeCharacterEntity> getCharacter() {
        return character;
    }

    public void setCharacter(List<AnimeCharacterEntity> character) {
        this.character = character;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getOriginalWork() {
        return originalWork;
    }

    public void setOriginalWork(String originalWork) {
        this.originalWork = originalWork;
    }

    public List<AnimeStaffEntity> getDirection() {
        return direction;
    }

    public void setDirection(List<AnimeStaffEntity> direction) {
        this.direction = direction;
    }

    public List<AnimeStaffEntity> getProducer() {
        return producer;
    }

    public void setProducer(List<AnimeStaffEntity> producer) {
        this.producer = producer;
    }

    public List<AnimeStaffEntity> getCharacterDesign() {
        return characterDesign;
    }

    public void setCharacterDesign(List<AnimeStaffEntity> characterDesign) {
        this.characterDesign = characterDesign;
    }

    public AnimeStaffEntity getStoryboard() {
        return storyboard;
    }

    public void setStoryboard(AnimeStaffEntity storyboard) {
        this.storyboard = storyboard;
    }

    public AnimeStaffEntity getScript() {
        return script;
    }

    public void setScript(AnimeStaffEntity script) {
        this.script = script;
    }

    public List<AnimeStaffEntity> getSoundDirection() {
        return soundDirection;
    }

    public void setSoundDirection(List<AnimeStaffEntity> soundDirection) {
        this.soundDirection = soundDirection;
    }

    public List<AnimeStaffEntity> getSoundEffects() {
        return soundEffects;
    }

    public void setSoundEffects(List<AnimeStaffEntity> soundEffects) {
        this.soundEffects = soundEffects;
    }

    public AnimeFirmEntity getSoundWork() {
        return soundWork;
    }

    public void setSoundWork(AnimeFirmEntity soundWork) {
        this.soundWork = soundWork;
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

    public List<AnimeStaffEntity> getArtDirection() {
        return artDirection;
    }

    public void setArtDirection(List<AnimeStaffEntity> artDirection) {
        this.artDirection = artDirection;
    }

    public List<AnimeStaffEntity> getArtDesign() {
        return artDesign;
    }

    public void setArtDesign(List<AnimeStaffEntity> artDesign) {
        this.artDesign = artDesign;
    }

    public List<AnimeStaffEntity> getColorDesign() {
        return colorDesign;
    }

    public void setColorDesign(List<AnimeStaffEntity> colorDesign) {
        this.colorDesign = colorDesign;
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
