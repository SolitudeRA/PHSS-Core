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

    public MusicAlbumEntity() {
    }

    public MusicAlbumEntity(String albumName) {
        this.albumName = albumName;
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

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
}
