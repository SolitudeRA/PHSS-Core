package DAO.entity.fileSystemCore.musicAlbumsLayer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 * TODO: 2018/1/26 Entity Design
 */

@Entity
@Table(name = "album_music")
public class MusicAlbumEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "album_name")
    private String albumName;

    @OneToOne(mappedBy = "albumId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private MusicAlbumInfEntity musicAlbumInfEntity;

    @OneToOne(mappedBy = "albumId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private MusicAlbumInfStaticEntity musicAlbumInfStaticEntity;

    @OneToMany(mappedBy = "albumId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MusicTrackEntity> musicTracks = new ArrayList<>();

    public MusicAlbumEntity() {
    }

    public Integer getId() {
        return id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public MusicAlbumInfEntity getMusicAlbumInfEntity() {
        return musicAlbumInfEntity;
    }

    public MusicAlbumInfStaticEntity getMusicAlbumInfStaticEntity() {
        return musicAlbumInfStaticEntity;
    }

    public List<MusicTrackEntity> getMusicTracks() {
        return musicTracks;
    }
}
