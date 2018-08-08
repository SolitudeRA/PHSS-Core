package org.protogalaxy.phss.datasource.entity.filesystem.album.music;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemMainEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 */

@Entity
@Table(name = "track")
public class MusicTrackEntity {
    @JsonIgnore
    @Id
    @GeneratedValue
    private UUID id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_TRACK_OWNER_ID"))
    private FileSystemMainEntity owner;

    @ManyToOne
    @JoinColumn(name = "album_id", foreignKey = @ForeignKey(name = "FK_TRACK_ALBUM_MUSIC_ID"))
    private MusicAlbumEntity musicAlbumEntity;

    @Column(name = "title")
    private String title;

    @Column(name = "album")
    private String album;

    @Column(name = "artist")
    private String artist;

    @Column(name = "album_artist")
    private String albumArtist;

    @JsonIgnore
    @Column(name = "location")
    private String location;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_added")
    @CreationTimestamp
    private Date dateAdded;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_modified")
    @UpdateTimestamp
    private Date dateModified;

    @JsonManagedReference
    @OneToOne(mappedBy = "musicTrackEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private MusicTrackInfEntity trackInformation;

    @JsonManagedReference
    @OneToOne(mappedBy = "musicTrackEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private MusicTrackInfStaticEntity trackInformationStatic;

    public MusicTrackEntity() {
    }

    public MusicTrackEntity(FileSystemMainEntity owner, String title, String album, String artist, String albumArtist, String location) {
        this.owner = owner;
        this.title = title;
        this.album = album;
        this.artist = artist;
        this.albumArtist = albumArtist;
        this.location = location;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public FileSystemMainEntity getOwner() {
        return owner;
    }

    public void setOwner(FileSystemMainEntity owner) {
        this.owner = owner;
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

    public String getAlbumArtist() {
        return albumArtist;
    }

    public void setAlbumArtist(String albumArtist) {
        this.albumArtist = albumArtist;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public MusicTrackInfEntity getTrackInformation() {
        return trackInformation;
    }

    public void setTrackInformation(MusicTrackInfEntity trackInformation) {
        this.trackInformation = trackInformation;
    }

    public MusicTrackInfStaticEntity getTrackInformationStatic() {
        return trackInformationStatic;
    }

    public void setTrackInformationStatic(MusicTrackInfStaticEntity trackInformationStatic) {
        this.trackInformationStatic = trackInformationStatic;
    }
}
