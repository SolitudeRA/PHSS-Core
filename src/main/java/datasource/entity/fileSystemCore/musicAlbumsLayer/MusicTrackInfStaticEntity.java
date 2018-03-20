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
@Table(name = "track_inf_static")
public class MusicTrackInfStaticEntity {
    @Id
    private UUID trackId;

    @Lob
    @Column(name = "album_artwork")
    private Blob albumArtwork;

    @Column(name = "release_year")
    private Date releaseYear;

    @Column(name = "disc_number")
    private Integer discNumber;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "comments")
    private String comments;

    @Column(name = "lyrics")
    private String lyrics;

    @Column(name = "mv")
    private String mv;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    @OneToOne
    @MapsId
    @JoinColumn(name = "track_id")
    private MusicTrackEntity musicTrackEntity;

    public MusicTrackInfStaticEntity() {
    }

    public MusicTrackInfStaticEntity(Blob albumArtwork, Date releaseYear, Integer discNumber, Float rating, String comments, String lyrics, String mv) {
        this.albumArtwork = albumArtwork;
        this.releaseYear = releaseYear;
        this.discNumber = discNumber;
        this.rating = rating;
        this.comments = comments;
        this.lyrics = lyrics;
        this.mv = mv;
    }

    public UUID getTrackId() {
        return trackId;
    }

    public void setTrackId(UUID trackId) {
        this.trackId = trackId;
    }

    public Blob getAlbumArtwork() {
        return albumArtwork;
    }

    public void setAlbumArtwork(Blob albumArtwork) {
        this.albumArtwork = albumArtwork;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getDiscNumber() {
        return discNumber;
    }

    public void setDiscNumber(Integer discNumber) {
        this.discNumber = discNumber;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getMv() {
        return mv;
    }

    public void setMv(String mv) {
        this.mv = mv;
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

    public MusicTrackEntity getMusicTrackEntity() {
        return musicTrackEntity;
    }

    public void setMusicTrackEntity(MusicTrackEntity musicTrackEntity) {
        this.musicTrackEntity = musicTrackEntity;
    }
}
