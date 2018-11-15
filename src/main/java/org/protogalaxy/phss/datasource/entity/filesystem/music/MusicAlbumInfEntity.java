package org.protogalaxy.phss.datasource.entity.filesystem.music;

import org.hibernate.annotations.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * Entity for music album information
 *
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 */

@Entity
@DynamicInsert
@Table(name = "album_music_inf")
public class MusicAlbumInfEntity {
    @Id
    private Integer albumId;

    @Column(name = "playback_count")
    @ColumnDefault("0")
    private Integer playbackCount;

    @Column(name = "pass_count")
    @ColumnDefault("0")
    private Integer passCount;

    @Column(name = "last_played")
    private LocalDateTime lastPlayed;

    @Column(name = "date_added")
    @CreatedDate
    private ZonedDateTime dateAdded;

    @Column(name = "date_modified")
    @LastModifiedDate
    private ZonedDateTime dateModified;

    @OneToOne
    @MapsId
    @JoinColumn(name = "album_id")
    private MusicAlbumEntity musicAlbumEntity;

    public MusicAlbumInfEntity() {
    }

    public MusicAlbumInfEntity(MusicAlbumEntity musicAlbumEntity) {
        this.musicAlbumEntity = musicAlbumEntity;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getPlaybackCount() {
        return playbackCount;
    }

    public void setPlaybackCount(Integer playbackCount) {
        this.playbackCount = playbackCount;
    }

    public Integer getPassCount() {
        return passCount;
    }

    public void setPassCount(Integer passCount) {
        this.passCount = passCount;
    }

    public LocalDateTime getLastPlayed() {
        return lastPlayed;
    }

    public void setLastPlayed(LocalDateTime lastPlayed) {
        this.lastPlayed = lastPlayed;
    }

    public ZonedDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(ZonedDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public ZonedDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(ZonedDateTime dateModified) {
        this.dateModified = dateModified;
    }

    public MusicAlbumEntity getMusicAlbumEntity() {
        return musicAlbumEntity;
    }

    public void setMusicAlbumEntity(MusicAlbumEntity musicAlbumEntity) {
        this.musicAlbumEntity = musicAlbumEntity;
    }
}
