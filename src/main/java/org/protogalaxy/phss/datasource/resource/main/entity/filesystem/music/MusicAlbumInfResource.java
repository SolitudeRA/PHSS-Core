package org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music;

import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicAlbumInfEntity;
import org.springframework.hateoas.ResourceSupport;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class MusicAlbumInfResource extends ResourceSupport {
    private Integer albumId;

    private Integer playbackCount;

    private Integer passCount;

    private LocalDateTime lastPlayed;

    private ZonedDateTime dateAdded;

    private ZonedDateTime dateModified;

    public MusicAlbumInfResource() {
    }

    public MusicAlbumInfResource(MusicAlbumInfEntity musicAlbumInfEntity) {
        this.albumId = musicAlbumInfEntity.getAlbumId();
        this.playbackCount = musicAlbumInfEntity.getPlaybackCount();
        this.passCount = musicAlbumInfEntity.getPassCount();
        this.lastPlayed = musicAlbumInfEntity.getLastPlayed();
        this.dateAdded = musicAlbumInfEntity.getDateAdded();
        this.dateModified = musicAlbumInfEntity.getDateModified();
    }

    public MusicAlbumInfResource(Integer albumId, Integer playbackCount, Integer passCount, LocalDateTime lastPlayed, ZonedDateTime dateAdded, ZonedDateTime dateModified) {
        this.albumId = albumId;
        this.playbackCount = playbackCount;
        this.passCount = passCount;
        this.lastPlayed = lastPlayed;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public Integer getPlaybackCount() {
        return playbackCount;
    }

    public Integer getPassCount() {
        return passCount;
    }

    public LocalDateTime getLastPlayed() {
        return lastPlayed;
    }

    public ZonedDateTime getDateAdded() {
        return dateAdded;
    }

    public ZonedDateTime getDateModified() {
        return dateModified;
    }
}
