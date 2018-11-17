package org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music;

import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackInfoEntity;
import org.springframework.hateoas.ResourceSupport;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;

public class MusicTrackInfoResource extends ResourceSupport {
    private UUID trackUUID;
    private Integer playbackCount;
    private Integer skipCount;
    private LocalDateTime lastPlayed;
    private ZonedDateTime dateAdded;
    private ZonedDateTime dateModified;

    public MusicTrackInfoResource() {
    }

    public MusicTrackInfoResource(MusicTrackInfoEntity musicTrackInfoEntity) {
        this.trackUUID = musicTrackInfoEntity.getTrackUUID();
        this.playbackCount = musicTrackInfoEntity.getPlaybackCount();
        this.skipCount = musicTrackInfoEntity.getSkipCount();
        this.lastPlayed = musicTrackInfoEntity.getLastPlayed();
        this.dateAdded = musicTrackInfoEntity.getDateAdded();
        this.dateModified = musicTrackInfoEntity.getDateModified();
    }

    public MusicTrackInfoResource(UUID trackUUID, Integer playbackCount, Integer skipCount, LocalDateTime lastPlayed, ZonedDateTime dateAdded, ZonedDateTime dateModified) {
        this.trackUUID = trackUUID;
        this.playbackCount = playbackCount;
        this.skipCount = skipCount;
        this.lastPlayed = lastPlayed;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    public UUID getTrackUUID() {
        return trackUUID;
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
