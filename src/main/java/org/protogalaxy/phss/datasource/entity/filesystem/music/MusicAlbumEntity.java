package org.protogalaxy.phss.datasource.entity.filesystem.music;

import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemMainEntity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * Entity for music album
 *
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 */

@Entity(name = "MusicAlbum")
@Table(name = "album_music")
public class MusicAlbumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_OWNER_ID_MUSIC"))
    private FileSystemMainEntity owner;

    @Column(name = "title")
    private String title;

    @Column(name = "artist")
    private String artist;

    @Column(name = "location")
    private String location;

    @Column(name = "date_added")
    @CreatedDate
    private ZonedDateTime dateAdded;

    @Column(name = "date_modified")
    @LastModifiedDate
    private ZonedDateTime dateModified;

    @OneToOne(mappedBy = "musicAlbumEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private MusicAlbumInfEntity albumInformation;

    @OneToOne(mappedBy = "musicAlbumEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private MusicAlbumInfStaticEntity albumInformationStatic;

    public MusicAlbumEntity() {
    }

    public MusicAlbumEntity(FileSystemMainEntity owner, String title, String artist, String location) {
        this.owner = owner;
        this.title = title;
        this.artist = artist;
        this.location = location;
    }

    public MusicAlbumEntity(FileSystemMainEntity owner, String title, String artist, String location, MusicAlbumInfStaticEntity albumInformationStatic) {
        this.owner = owner;
        this.title = title;
        this.artist = artist;
        this.location = location;
        this.albumInformationStatic = albumInformationStatic;
    }

    public MusicAlbumEntity(FileSystemMainEntity owner, String title, String artist, String location, MusicAlbumInfEntity albumInformation, MusicAlbumInfStaticEntity albumInformationStatic) {
        this.owner = owner;
        this.title = title;
        this.artist = artist;
        this.location = location;
        this.albumInformation = albumInformation;
        this.albumInformationStatic = albumInformationStatic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FileSystemMainEntity getOwner() {
        return owner;
    }

    public void setOwner(FileSystemMainEntity owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public MusicAlbumInfEntity getAlbumInformation() {
        return albumInformation;
    }

    public void setAlbumInformation(MusicAlbumInfEntity albumInformation) {
        this.albumInformation = albumInformation;
    }

    public MusicAlbumInfStaticEntity getAlbumInformationStatic() {
        return albumInformationStatic;
    }

    public void setAlbumInformationStatic(MusicAlbumInfStaticEntity albumInformationStatic) {
        this.albumInformationStatic = albumInformationStatic;
    }
}
