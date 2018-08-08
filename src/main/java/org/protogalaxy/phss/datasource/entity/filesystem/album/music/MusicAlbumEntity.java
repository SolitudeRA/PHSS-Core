package org.protogalaxy.phss.datasource.entity.filesystem.album.music;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemMainEntity;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 */

@Entity
@Table(name = "album_music")
public class MusicAlbumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_OWNER_ID_MUSIC"))
    private FileSystemMainEntity owner;

    @Column(name = "title")
    private String title;

    @Column(name = "artist")
    private String artist;

    @JsonIgnore
    @Column(name = "location")
    private String location;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_added")
    @CreationTimestamp
    private Date dateAdded;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_modified")
    @CreationTimestamp
    private Date dateModified;

    @JsonManagedReference
    @OneToOne(mappedBy = "musicAlbumEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private MusicAlbumInfEntity albumInformation;

    @JsonManagedReference
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getDateAdded() {
        return dateAdded;
    }

    public Date getDateModified() {
        return dateModified;
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
