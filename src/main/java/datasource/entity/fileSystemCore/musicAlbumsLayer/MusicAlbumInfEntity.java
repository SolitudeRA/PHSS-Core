package datasource.entity.fileSystemCore.musicAlbumsLayer;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 */

@Entity
@DynamicInsert
@Table(name = "album_music_inf")
public class MusicAlbumInfEntity {
    @Id
    @Column(name = "album_id")
    private UUID albumId;

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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    @OneToOne
    @MapsId
    private MusicAlbumEntity musicAlbumEntity;

    public MusicAlbumInfEntity(){ }

    public MusicAlbumInfEntity(Date gmtCreate, Date gmtModified){
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public UUID getAlbumId(){
        return albumId;
    }

    public void setAlbumId(UUID albumId){
        this.albumId = albumId;
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

    public MusicAlbumEntity getMusicAlbumEntity(){
        return musicAlbumEntity;
    }

    public void setMusicAlbumEntity(MusicAlbumEntity musicAlbumEntity){
        this.musicAlbumEntity = musicAlbumEntity;
    }
}
