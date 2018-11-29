package org.protogalaxy.phss.datasource.entity.filesystem.music;

import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemMainEntity;
import org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music.MusicAlbumResource;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Entity for music album
 *
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 */

@Entity(name = "MusicAlbum")
@Table(name = "music_album")
public class MusicAlbumEntity {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false, unique = true, columnDefinition = "BINARY(16)")
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "filesystem_owner_id", foreignKey = @ForeignKey(name = "FK_FILESYSTEM_OWNER_ID_MUSIC_ALBUM"))
    private FileSystemMainEntity fileSystemOwner;

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
    private MusicAlbumInfoEntity albumInformation;

    @OneToOne(mappedBy = "musicAlbumEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private MusicAlbumInfoStaticEntity albumInformationStatic;

    public MusicAlbumEntity() {
    }

    public MusicAlbumEntity(FileSystemMainEntity fileSystemOwner, String title, String location) {
        this.fileSystemOwner = fileSystemOwner;
        this.title = title;
        this.location = location;
    }

    public MusicAlbumEntity(FileSystemMainEntity fileSystemOwner, String title, String artist, String location) {
        this.fileSystemOwner = fileSystemOwner;
        this.title = title;
        this.artist = artist;
        this.location = location;
    }

    public MusicAlbumEntity(FileSystemMainEntity fileSystemOwner, String title, String artist, String location, MusicAlbumInfoEntity albumInformation, MusicAlbumInfoStaticEntity albumInformationStatic) {
        this.fileSystemOwner = fileSystemOwner;
        this.title = title;
        this.artist = artist;
        this.location = location;
        this.albumInformation = albumInformation;
        this.albumInformationStatic = albumInformationStatic;
    }

    public MusicAlbumEntity updateFromResource(MusicAlbumResource musicAlbumResource) {
        this.title = musicAlbumResource.getTitle();
        this.artist = musicAlbumResource.getArtist();
        this.albumInformationStatic.setArtwork(musicAlbumResource.getArtwork());
        this.albumInformationStatic.setComposer(musicAlbumResource.getComposer());
        this.albumInformationStatic.setReleaseYear(musicAlbumResource.getReleaseYear());
        this.albumInformationStatic.setDurationTotal(musicAlbumResource.getDurationTotal());
        this.albumInformationStatic.setDiscNumber(musicAlbumResource.getDiscNumber());
        this.albumInformationStatic.setDiscTotal(musicAlbumResource.getDiscTotal());
        this.albumInformationStatic.setGenre(musicAlbumResource.getGenre());
        this.albumInformationStatic.setScore(musicAlbumResource.getScore());
        this.albumInformationStatic.setLove(musicAlbumResource.getLove());
        this.albumInformationStatic.setDislike(musicAlbumResource.getDislike());
        this.albumInformationStatic.setComment(musicAlbumResource.getComment());
        return this;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public FileSystemMainEntity getFileSystemOwner() {
        return fileSystemOwner;
    }

    public void setFileSystemOwner(FileSystemMainEntity fileSystemOwner) {
        this.fileSystemOwner = fileSystemOwner;
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

    public MusicAlbumInfoEntity getAlbumInformation() {
        return albumInformation;
    }

    public void setAlbumInformation(MusicAlbumInfoEntity albumInformation) {
        this.albumInformation = albumInformation;
    }

    public MusicAlbumInfoStaticEntity getAlbumInformationStatic() {
        return albumInformationStatic;
    }

    public void setAlbumInformationStatic(MusicAlbumInfoStaticEntity albumInformationStatic) {
        this.albumInformationStatic = albumInformationStatic;
    }
}
