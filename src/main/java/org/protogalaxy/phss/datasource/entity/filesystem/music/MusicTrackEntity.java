package org.protogalaxy.phss.datasource.entity.filesystem.music;

import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemMainEntity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 */

@Entity(name = "MusicTrack")
@Table(name = "track")
public class MusicTrackEntity {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false, unique = true, columnDefinition = "BINARY(16)")
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "filesystem_owner_id", foreignKey = @ForeignKey(name = "FK_FILESYSTEM_OWNER_ID_MUSIC_TRACK"))
    private FileSystemMainEntity fileSystemOwner;

    @ManyToOne
    @JoinColumn(name = "album_id", foreignKey = @ForeignKey(name = "FK_ALBUM_ID_MUSIC_TRACK"))
    private MusicAlbumEntity musicAlbumEntity;

    @Column(name = "title")
    private String title;

    @Column(name = "album")
    private String album;

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

    @OneToOne(mappedBy = "musicTrackEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private MusicTrackInfoEntity trackInformation;

    @OneToOne(mappedBy = "musicTrackEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private MusicTrackInfoStaticEntity trackInformationStatic;

    public MusicTrackEntity() {
    }

    public MusicTrackEntity(FileSystemMainEntity fileSystemOwner, String title, String location) {
        this.fileSystemOwner = fileSystemOwner;
        this.title = title;
        this.location = location;
    }

    public MusicTrackEntity(FileSystemMainEntity fileSystemOwner, MusicAlbumEntity musicAlbumEntity, String title, String album, String artist, String location, MusicTrackInfoEntity trackInformation, MusicTrackInfoStaticEntity trackInformationStatic) {
        this.fileSystemOwner = fileSystemOwner;
        this.musicAlbumEntity = musicAlbumEntity;
        this.title = title;
        this.album = album;
        this.artist = artist;
        this.location = location;
        this.trackInformation = trackInformation;
        this.trackInformationStatic = trackInformationStatic;
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

    public MusicAlbumEntity getMusicAlbumEntity() {
        return musicAlbumEntity;
    }

    public void setMusicAlbumEntity(MusicAlbumEntity musicAlbumEntity) {
        this.musicAlbumEntity = musicAlbumEntity;
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
