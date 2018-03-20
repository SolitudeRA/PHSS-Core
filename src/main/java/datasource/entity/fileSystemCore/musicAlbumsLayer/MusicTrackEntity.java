package datasource.entity.fileSystemCore.musicAlbumsLayer;

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
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "album_id", foreignKey = @ForeignKey(name = "FK_ALBUM_MUSIC_ID"))
    private MusicAlbumEntity musicAlbumEntity;

    @Column(name = "track_name")
    private String trackName;

    @Column(name = "album_name")
    private String albumName;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    public MusicTrackEntity() {
    }

    public MusicTrackEntity(String trackName) {
        this.trackName = trackName;
    }

    public MusicTrackEntity(String trackName, String albumName) {
        this.trackName = trackName;
        this.albumName = albumName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public MusicAlbumEntity getMusicAlbumEntity() {
        return musicAlbumEntity;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
