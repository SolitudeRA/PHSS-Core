package org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music;

import org.joda.time.LocalDateTime;
import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackInfoEntity;
import org.springframework.hateoas.ResourceSupport;

import java.util.UUID;

public class MusicTrackInfoResource extends ResourceSupport {
    private UUID trackUUID;
    private Integer playbackCount;
    private Integer skipCount;
    private String lastPlayed;
    private String dateAdded;
    private String dateModified;

    public MusicTrackInfoResource() {
    }

    public MusicTrackInfoResource(MusicTrackInfoEntity musicTrackInfoEntity) {
        this.trackUUID = musicTrackInfoEntity.getTrackUUID();
        this.playbackCount = musicTrackInfoEntity.getPlaybackCount();
        this.skipCount = musicTrackInfoEntity.getSkipCount();
        this.lastPlayed = musicTrackInfoEntity.getLastPlayed().toString();
        this.dateAdded = musicTrackInfoEntity.getDateAdded().toString();
        this.dateModified = musicTrackInfoEntity.getDateModified().toString();
    }

    public MusicTrackInfoResource(UUID trackUUID, Integer playbackCount, Integer skipCount, LocalDateTime lastPlayed, LocalDateTime dateAdded, LocalDateTime dateModified) {
        this.trackUUID = trackUUID;
        this.playbackCount = playbackCount;
        this.skipCount = skipCount;
        this.lastPlayed = lastPlayed.toString();
        this.dateAdded = dateAdded.toString();
        this.dateModified = dateModified.toString();
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

    public String getLastPlayed() {
        return lastPlayed;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public String getDateModified() {
        return dateModified;
    }
}
