package org.protogalaxy.phss.datasource.entity.resource.filesystem;

import org.protogalaxy.phss.datasource.entity.core.filesystem.album.music.MusicTrackEntity;
import org.springframework.hateoas.ResourceSupport;

public class MusicTrackResource extends ResourceSupport {
    private int trackIid;

    private String title;

    private String album;

    private String artist;

    private String albumArtist;

    public MusicTrackResource(MusicTrackEntity musicTrackEntity) {
        this.trackIid = musicTrackEntity.getId();
        this.title = musicTrackEntity.getTitle();
        this.album = musicTrackEntity.getAlbum();
        this.artist = musicTrackEntity.getArtist();
        this.albumArtist = musicTrackEntity.getAlbumArtist();
    }

    public int getTrackIid() {
        return trackIid;
    }

    public String getTitle() {
        return title;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbumArtist() {
        return albumArtist;
    }
}
