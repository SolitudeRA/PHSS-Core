package datasource.entity.fileSystemCore.musicAlbumsLayer;

import javax.persistence.*;
import java.sql.Blob;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 * TODO: 2018/1/26 Entity Design
 */

@Entity
@Table(name = "track_inf_static")
public class MusicTrackInfStaticEntity {
    @Id
    @ManyToOne
    @Column(name = "tracks_id")
    private MusicTrackEntity trackId;

    @Column(name = "album_artwork")
    private Blob albumArtwork;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "disc_number")
    private Integer discNumber;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "comments")
    private String commnets;

    @Column(name = "lyrics")
    private String lyric;

    @Column(name = "mv")
    private String mv;

    public MusicTrackInfStaticEntity() {
    }

    public MusicTrackEntity getTrackId() {
        return trackId;
    }

    public Blob getAlbumArtwork() {
        return albumArtwork;
    }

    public void setAlbumArtwork(Blob albumArtwork) {
        this.albumArtwork = albumArtwork;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
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

    public String getCommnets() {
        return commnets;
    }

    public void setCommnets(String commnets) {
        this.commnets = commnets;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public String getMv() {
        return mv;
    }

    public void setMv(String mv) {
        this.mv = mv;
    }
}
