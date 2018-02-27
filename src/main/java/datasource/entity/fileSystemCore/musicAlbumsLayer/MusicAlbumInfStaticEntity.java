package datasource.entity.fileSystemCore.musicAlbumsLayer;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;
import java.util.UUID;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 */

@Entity
@Table(name = "album_music_inf_static")
public class MusicAlbumInfStaticEntity {
    @Id
    @Column(name = "album_id")
    private UUID albumId;

    @Lob
    @Column(name = "album_artwork")
    private Blob albumArtwork;

    @Column(name = "release_year")
    private Date releaseYear;

    @Column(name = "tracks")
    private Integer tracks;

    @Column(name = "disc_number")
    private Integer discNumber;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "comments")
    private String comments;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    @OneToOne
    @MapsId
    private MusicAlbumEntity musicAlbumEntity;

    public MusicAlbumInfStaticEntity(){
    }

    public MusicAlbumInfStaticEntity(Blob albumArtwork, Date releaseYear, Integer tracks, Integer discNumber, Float rating, String comments, Date gmtCreate, Date gmtModified){
        this.albumArtwork = albumArtwork;
        this.releaseYear = releaseYear;
        this.tracks = tracks;
        this.discNumber = discNumber;
        this.rating = rating;
        this.comments = comments;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public UUID getAlbumId(){
        return albumId;
    }

    public void setAlbumId(UUID albumId){
        this.albumId = albumId;
    }

    public Blob getAlbumArtwork(){
        return albumArtwork;
    }

    public void setAlbumArtwork(Blob albumArtwork){
        this.albumArtwork = albumArtwork;
    }

    public Date getReleaseYear(){
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear){
        this.releaseYear = releaseYear;
    }

    public Integer getTracks(){
        return tracks;
    }

    public void setTracks(Integer tracks){
        this.tracks = tracks;
    }

    public Integer getDiscNumber(){
        return discNumber;
    }

    public void setDiscNumber(Integer discNumber){
        this.discNumber = discNumber;
    }

    public Float getRating(){
        return rating;
    }

    public void setRating(Float rating){
        this.rating = rating;
    }

    public String getComments(){
        return comments;
    }

    public void setComments(String comments){
        this.comments = comments;
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
}
