package datasource.entity.fileSystemCore.musicAlbumsLayer;

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

    @Column(name = "album_name")
    private String albumName;

    @OneToOne(mappedBy = "musicAlbumEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private MusicAlbumInfEntity musicAlbumInfEntity;

    @OneToOne(mappedBy = "musicAlbumEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private MusicAlbumInfStaticEntity musicAlbumInfStaticEntity;

    public MusicAlbumEntity(){ }

    public MusicAlbumEntity(String albumName){
        this.albumName = albumName;
    }

    public UUID getId(){
        return id;
    }

    public void setId(UUID id){
        this.id = id;
    }

    public String getAlbumName(){
        return albumName;
    }

    public void setAlbumName(String albumName){
        this.albumName = albumName;
    }

    public MusicAlbumInfEntity getMusicAlbumInfEntity(){
        return musicAlbumInfEntity;
    }

    public MusicAlbumInfStaticEntity getMusicAlbumInfStaticEntity(){
        return musicAlbumInfStaticEntity;
    }
}
