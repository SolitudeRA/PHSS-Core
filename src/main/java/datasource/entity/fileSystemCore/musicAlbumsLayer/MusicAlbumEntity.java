package datasource.entity.fileSystemCore.musicAlbumsLayer;

import datasource.entity.fileSystemCore.fileSystemInformationLayer.FileSystemInfMainEntity;

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
    private FileSystemInfMainEntity filesystemInfMainEntity;

    @Column(name = "album_name")
    private String albumName;

    @Column(name = "artist")
    private String artist;

    public MusicAlbumEntity() {
    }

    public MusicAlbumEntity(String albumName) {
        this.albumName = albumName;
    }

    public MusicAlbumEntity(String albumName, String artist) {
        this.albumName = albumName;
        this.artist = artist;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public FileSystemInfMainEntity getFilesystemInfMainEntity() {
        return filesystemInfMainEntity;
    }

    public void setFilesystemInfMainEntity(FileSystemInfMainEntity filesystemInfMainEntity) {
        this.filesystemInfMainEntity = filesystemInfMainEntity;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
