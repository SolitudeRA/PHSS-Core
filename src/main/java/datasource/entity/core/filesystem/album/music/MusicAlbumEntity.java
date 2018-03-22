package datasource.entity.core.filesystem.album.music;

import datasource.entity.core.filesystem.main.FileSystemMainEntity;

import javax.persistence.*;
import java.util.*;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 */

@Entity
@Table(name = "album_music")
public class MusicAlbumEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_OWNER_ID_MUSIC"))
    private FileSystemMainEntity filesystemInfMainEntity;

    @Column(name = "name")
    private String name;

    @Column(name = "artist")
    private String artist;

    @Column(name = "location")
    private String location;

    public MusicAlbumEntity() {
    }

    public MusicAlbumEntity(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public MusicAlbumEntity(String name, String artist, String location) {
        this.name = name;
        this.artist = artist;
        this.location = location;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public FileSystemMainEntity getFilesystemInfMainEntity() {
        return filesystemInfMainEntity;
    }

    public void setFilesystemInfMainEntity(FileSystemMainEntity filesystemInfMainEntity) {
        this.filesystemInfMainEntity = filesystemInfMainEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
