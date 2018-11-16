package org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music;

import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicAlbumEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicAlbumInfoEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicAlbumInfoStaticEntity;
import org.springframework.hateoas.ResourceSupport;

import java.time.ZonedDateTime;
import java.util.UUID;

public class MusicAlbumResource extends ResourceSupport {
    private String title;
    private String artist;
    private String location;
    private MusicAlbumInfoEntity musicAlbumInf;
    private MusicAlbumInfoStaticEntity musicAlbumInfStatic;
    private ZonedDateTime dateAdded;
    private ZonedDateTime dateModified;

    public MusicAlbumResource() {
    }

    public MusicAlbumResource(MusicAlbumEntity musicAlbumEntity) {
        this.title = musicAlbumEntity.getTitle();
        this.artist = musicAlbumEntity.getArtist();
        this.location = musicAlbumEntity.getLocation();
        this.musicAlbumInf = musicAlbumEntity.getAlbumInformation();
        this.musicAlbumInfStatic = musicAlbumEntity.getAlbumInformationStatic();
        this.dateAdded = musicAlbumEntity.getDateAdded();
        this.dateModified = musicAlbumEntity.getDateModified();
    }

    public MusicAlbumResource(String title, String artist, String location, ZonedDateTime dateAdded, ZonedDateTime dateModified) {
        this.title = title;
        this.artist = artist;
        this.location = location;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    public MusicAlbumResource(String title, String artist, String location, MusicAlbumInfoEntity musicAlbumInf, MusicAlbumInfoStaticEntity musicAlbumInfStatic, ZonedDateTime dateAdded, ZonedDateTime dateModified) {
        this.title = title;
        this.artist = artist;
        this.location = location;
        this.musicAlbumInf = musicAlbumInf;
        this.musicAlbumInfStatic = musicAlbumInfStatic;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getLocation() {
        return location;
    }

    public MusicAlbumInfoEntity getMusicAlbumInf() {
        return musicAlbumInf;
    }

    public MusicAlbumInfoStaticEntity getMusicAlbumInfStatic() {
        return musicAlbumInfStatic;
    }

    public ZonedDateTime getDateAdded() {
        return dateAdded;
    }

    public ZonedDateTime getDateModified() {
        return dateModified;
    }
}
