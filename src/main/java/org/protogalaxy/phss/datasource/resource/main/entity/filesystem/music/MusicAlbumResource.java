package org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music;

import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicAlbumEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicAlbumInfEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicAlbumInfStaticEntity;
import org.springframework.hateoas.ResourceSupport;

import java.time.ZonedDateTime;

public class MusicAlbumResource extends ResourceSupport {
    private Integer id;
    private String title;
    private String artist;
    private String location;
    private MusicAlbumInfEntity musicAlbumInf;
    private MusicAlbumInfStaticEntity musicAlbumInfStatic;
    private ZonedDateTime dateAdded;
    private ZonedDateTime dateModified;

    public MusicAlbumResource() {
    }

    public MusicAlbumResource(MusicAlbumEntity musicAlbumEntity) {
        this.id = musicAlbumEntity.getId();
        this.title = musicAlbumEntity.getTitle();
        this.artist = musicAlbumEntity.getArtist();
        this.location = musicAlbumEntity.getLocation();
        this.musicAlbumInf = musicAlbumEntity.getAlbumInformation();
        this.musicAlbumInfStatic = musicAlbumEntity.getAlbumInformationStatic();
        this.dateAdded = musicAlbumEntity.getDateAdded();
        this.dateModified = musicAlbumEntity.getDateModified();
    }

    public MusicAlbumResource(Integer id, String title, String artist, String location, ZonedDateTime dateAdded, ZonedDateTime dateModified) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.location = location;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    public MusicAlbumResource(Integer id, String title, String artist, String location, MusicAlbumInfEntity musicAlbumInf, MusicAlbumInfStaticEntity musicAlbumInfStatic, ZonedDateTime dateAdded, ZonedDateTime dateModified) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.location = location;
        this.musicAlbumInf = musicAlbumInf;
        this.musicAlbumInfStatic = musicAlbumInfStatic;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    public Integer getAlbumId() {
        return id;
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

    public MusicAlbumInfEntity getMusicAlbumInf() {
        return musicAlbumInf;
    }

    public MusicAlbumInfStaticEntity getMusicAlbumInfStatic() {
        return musicAlbumInfStatic;
    }

    public ZonedDateTime getDateAdded() {
        return dateAdded;
    }

    public ZonedDateTime getDateModified() {
        return dateModified;
    }
}
