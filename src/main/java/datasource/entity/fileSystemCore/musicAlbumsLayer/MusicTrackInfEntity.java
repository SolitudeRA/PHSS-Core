package datasource.entity.fileSystemCore.musicAlbumsLayer;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 */

@Entity
@DynamicInsert
@Table(name = "track_inf")
public class MusicTrackInfEntity {
    @Id
    @Column(name = "track_id")
    private UUID id;

    @Column(name = "artist")
    private String artist;

    @Column(name = "album_artist")
    private String albumArtist;

    @Column(name = "composer")
    private String composer;

    @Column(name = "genre")
    private String genre;

    @Column(name = "playback_count")
    @ColumnDefault("0")
    private Integer playbackCount;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    @OneToOne
    @MapsId
    private MusicTrackEntity musicTrackEntity;

    public MusicTrackInfEntity(){
    }

    public MusicTrackInfEntity(String artist, String albumArtist, String composer, String genre, Integer playbackCount, Date gmtCreate, Date gmtModified){
        this.artist = artist;
        this.albumArtist = albumArtist;
        this.composer = composer;
        this.genre = genre;
        this.playbackCount = playbackCount;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public UUID getId(){
        return id;
    }

    public void setId(UUID id){
        this.id = id;
    }

    public String getArtist(){
        return artist;
    }

    public void setArtist(String artist){
        this.artist = artist;
    }

    public String getAlbumArtist(){
        return albumArtist;
    }

    public void setAlbumArtist(String albumArtist){
        this.albumArtist = albumArtist;
    }

    public String getComposer(){
        return composer;
    }

    public void setComposer(String composer){
        this.composer = composer;
    }

    public String getGenre(){
        return genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public Integer getPlaybackCount(){
        return playbackCount;
    }

    public void setPlaybackCount(Integer playbackCount){
        this.playbackCount = playbackCount;
    }

    public Date getGmtCreate(){
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate){
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified(){
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified){
        this.gmtModified = gmtModified;
    }

    public MusicTrackEntity getMusicTrackEntity(){
        return musicTrackEntity;
    }
}
