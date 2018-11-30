package org.protogalaxy.phss.datasource.entity.filesystem.music;

import org.joda.time.LocalDateTime;
import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemMainEntity;
import org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music.MusicTrackResource;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.UUID;

/**
 * Entity for music track
 *
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 */

@Entity(name = "MusicTrack")
@Table(name = "music_track")
@EntityListeners(AuditingEntityListener.class)
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
    private MusicAlbumEntity musicAlbum;

    @Column(name = "title")
    private String title;

    @Column(name = "album")
    private String album;

    @Column(name = "artist")
    private String artist;

    @Column(name = "location")
    private String location;

    @CreatedDate
    @Column(name = "date_added")
    private LocalDateTime dateAdded;

    @LastModifiedDate
    @Column(name = "date_modified")
    private LocalDateTime dateModified;

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

    public MusicTrackEntity(FileSystemMainEntity fileSystemOwner, String title, String album, String artist, String location) {
        this.fileSystemOwner = fileSystemOwner;
        this.title = title;
        this.album = album;
        this.artist = artist;
        this.location = location;
    }

    public MusicTrackEntity(FileSystemMainEntity fileSystemOwner, String title, String album, String artist, String location, MusicTrackInfoEntity trackInformation, MusicTrackInfoStaticEntity trackInformationStatic) {
        this.fileSystemOwner = fileSystemOwner;
        this.title = title;
        this.album = album;
        this.artist = artist;
        this.location = location;
        this.trackInformation = trackInformation;
        this.trackInformationStatic = trackInformationStatic;
    }

    public MusicTrackEntity(FileSystemMainEntity fileSystemOwner, MusicAlbumEntity musicAlbum, String title, String album, String artist, String location, MusicTrackInfoEntity trackInformation, MusicTrackInfoStaticEntity trackInformationStatic) {
        this.fileSystemOwner = fileSystemOwner;
        this.musicAlbum = musicAlbum;
        this.title = title;
        this.album = album;
        this.artist = artist;
        this.location = location;
        this.trackInformation = trackInformation;
        this.trackInformationStatic = trackInformationStatic;
    }

    public MusicTrackEntity updateFromResource(MusicTrackResource musicTrackResource) {
        this.title = musicTrackResource.getTitle();
        this.album = musicTrackResource.getAlbum();
        this.artist = musicTrackResource.getArtist();
        this.trackInformationStatic.setAlbumArtist(musicTrackResource.getAlbumArtist());
        this.trackInformationStatic.setComposer(musicTrackResource.getComposer());
        this.trackInformationStatic.setReleaseYear(musicTrackResource.getReleaseYear());
        this.trackInformationStatic.setTrackNumber(musicTrackResource.getTrackNumber());
        this.trackInformationStatic.setTrackTotal(musicTrackResource.getTrackTotal());
        this.trackInformationStatic.setDiscNumber(musicTrackResource.getDiscNumber());
        this.trackInformationStatic.setDiscTotal(musicTrackResource.getDiscTotal());
        this.trackInformationStatic.setScore(musicTrackResource.getScore());
        this.trackInformationStatic.setGenre(musicTrackResource.getGenre());
        this.trackInformationStatic.setArtwork(musicTrackResource.getArtwork());
        this.trackInformationStatic.setLove(musicTrackResource.getLove());
        this.trackInformationStatic.setDislike(musicTrackResource.getDislike());
        this.trackInformationStatic.setComment(musicTrackResource.getComment());
        this.trackInformationStatic.setKind(musicTrackResource.getKind());
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

    public MusicAlbumEntity getMusicAlbum() {
        return musicAlbum;
    }

    public void setMusicAlbum(MusicAlbumEntity musicAlbum) {
        this.musicAlbum = musicAlbum;
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

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public LocalDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDateTime dateModified) {
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
