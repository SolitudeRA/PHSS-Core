package org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music;

import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicAlbumInfoEntity;
import org.springframework.hateoas.ResourceSupport;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class MusicAlbumInfoResource extends ResourceSupport {
    private Integer playbackCount;

    private Integer skipCount;

    private LocalDateTime lastPlayed;

    private ZonedDateTime dateAdded;

    private ZonedDateTime dateModified;

    public MusicAlbumInfoResource() {
    }

    public MusicAlbumInfoResource(MusicAlbumInfoEntity musicAlbumInfoEntity) {
        this.playbackCount = musicAlbumInfoEntity.getPlaybackCount();
        this.skipCount = musicAlbumInfoEntity.getSkipCount();
        this.lastPlayed = musicAlbumInfoEntity.getLastPlayed();
        this.dateAdded = musicAlbumInfoEntity.getDateAdded();
        this.dateModified = musicAlbumInfoEntity.getDateModified();
    }

    public MusicAlbumInfoResource(Integer playbackCount, Integer skipCount, LocalDateTime lastPlayed, ZonedDateTime dateAdded, ZonedDateTime dateModified) {
        this.playbackCount = playbackCount;
        this.skipCount = skipCount;
        this.lastPlayed = lastPlayed;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    public Integer getPlaybackCount() {
        return playbackCount;
    }

    public Integer getSkipCount() {
        return skipCount;
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
