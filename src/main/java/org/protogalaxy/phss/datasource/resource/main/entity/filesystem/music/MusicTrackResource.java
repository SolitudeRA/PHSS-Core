package org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music;

import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackInfoEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackInfoStaticEntity;
import org.springframework.hateoas.ResourceSupport;

import java.time.ZonedDateTime;

public class MusicTrackResource extends ResourceSupport {
    private String title;

    private String album;

    private String artist;

    private String location;

    private ZonedDateTime dateAdded;

    private ZonedDateTime dateModified;

    private MusicTrackInfoEntity trackInformation;

    private MusicTrackInfoStaticEntity trackInformationStatic;

    public MusicTrackResource() {
    }

    public MusicTrackResource(MusicTrackEntity musicTrackEntity) {
        this.title = musicTrackEntity.getTitle();
        this.album = musicTrackEntity.getAlbum();
        this.artist = musicTrackEntity.getArtist();
        this.location = musicTrackEntity.getLocation();
        this.dateAdded = musicTrackEntity.getDateAdded();
        this.dateModified = musicTrackEntity.getDateModified();
        this.trackInformation = musicTrackEntity.getTrackInformation();
        this.trackInformationStatic = musicTrackEntity.getTrackInformationStatic();
    }

    public MusicTrackResource(String title, String album, String artist, String location, ZonedDateTime dateAdded, ZonedDateTime dateModified, MusicTrackInfoEntity trackInformation, MusicTrackInfoStaticEntity trackInformationStatic) {
        this.title = title;
        this.album = album;
        this.artist = artist;
        this.location = location;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
        this.trackInformation = trackInformation;
        this.trackInformationStatic = trackInformationStatic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public MusicTrackInfoEntity getTrackInformation() {
        return trackInformation;
    }

    public void setTrackInformation(MusicTrackInfoEntity trackInformation) {
        this.trackInformation = trackInformation;
    }

    public MusicTrackInfoStaticEntity getTrackInformationStatic() {
        return trackInformationStatic;
    }

    public void setTrackInformationStatic(MusicTrackInfoStaticEntity trackInformationStatic) {
        this.trackInformationStatic = trackInformationStatic;
    }
}
