package org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music;

import org.joda.time.LocalDateTime;
import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicAlbumInfoEntity;
import org.springframework.hateoas.ResourceSupport;


public class MusicAlbumInfoResource extends ResourceSupport {
    private Integer playbackCount;

    private Integer skipCount;

    private String lastPlayed;

    private String dateAdded;

    private String dateModified;

    public MusicAlbumInfoResource() {
    }

    public MusicAlbumInfoResource(MusicAlbumInfoEntity musicAlbumInfoEntity) {
        this.playbackCount = musicAlbumInfoEntity.getPlaybackCount();
        this.skipCount = musicAlbumInfoEntity.getSkipCount();
        this.lastPlayed = musicAlbumInfoEntity.getLastPlayed().toString();
        this.dateAdded = musicAlbumInfoEntity.getDateAdded().toString();
        this.dateModified = musicAlbumInfoEntity.getDateModified().toString();
    }

    public MusicAlbumInfoResource(Integer playbackCount, Integer skipCount, LocalDateTime lastPlayed, LocalDateTime dateAdded, LocalDateTime dateModified) {
        this.playbackCount = playbackCount;
        this.skipCount = skipCount;
        this.lastPlayed = lastPlayed.toString();
        this.dateAdded = dateAdded.toString();
        this.dateModified = dateModified.toString();
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
