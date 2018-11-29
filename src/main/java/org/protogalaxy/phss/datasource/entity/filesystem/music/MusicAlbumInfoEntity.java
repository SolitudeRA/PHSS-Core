package org.protogalaxy.phss.datasource.entity.filesystem.music;

import org.hibernate.annotations.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Entity for music album information
 *
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 */

@Entity(name = "MusicAlbumInformation")
@DynamicInsert
@Table(name = "music_album_info")
public class MusicAlbumInfoEntity {
    @Id
    private UUID albumUUID;

    @Column(name = "playback_count")
    @ColumnDefault("0")
    private Integer playbackCount;

    @Column(name = "skip_count")
    @ColumnDefault("0")
    private Integer skipCount;

    @Column(name = "last_played")
    private LocalDateTime lastPlayed;

    @Column(name = "date_added")
    @CreatedDate
    private ZonedDateTime dateAdded;

    @Column(name = "date_modified")
    @LastModifiedDate
    private ZonedDateTime dateModified;

    @MapsId
    @OneToOne
    @JoinColumn(name = "album_id", nullable = false, updatable = false, unique = true, columnDefinition = "BINARY(16)")
    private MusicAlbumEntity musicAlbumEntity;

    public MusicAlbumInfoEntity() {
    }

    public MusicAlbumInfoEntity(MusicAlbumEntity musicAlbumEntity) {
        this.musicAlbumEntity = musicAlbumEntity;
    }

    public UUID getAlbumUUID() {
        return albumUUID;
    }

    public void setAlbumUUID(UUID albumUUID) {
        this.albumUUID = albumUUID;
    }

    public Integer getPlaybackCount() {
        return playbackCount;
    }

    public void setPlaybackCount(Integer playbackCount) {
        this.playbackCount = playbackCount;
    }

    public Integer getSkipCount() {
        return skipCount;
    }

    public void setSkipCount(Integer skipCount) {
        this.skipCount = skipCount;
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
