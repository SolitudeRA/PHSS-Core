package DAO.entity.fileSystemCore.musicAlbumsLayer;

import javax.persistence.*;
import java.util.List;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 * TODO: 2018/1/26 Entity Design
 */

@Entity
@Table(name = "tracks")
public class MusicTrackEntity {
    @Id
    private Integer id;

    @ManyToOne
    @Column(name = "album_id")
    private MusicAlbumEntity albumId;

    @Column(name = "track_name")
    private String trackName;

    @OneToMany(mappedBy = "trackId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MusicTrackInfEntity> musicTrackInfEntities;

    public MusicTrackEntity() {
    }

    public Integer getId() {
        return id;
    }

    public MusicAlbumEntity getAlbumId() {
        return albumId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public List<MusicTrackInfEntity> getMusicTrackInfEntities() {
        return musicTrackInfEntities;
    }
}
