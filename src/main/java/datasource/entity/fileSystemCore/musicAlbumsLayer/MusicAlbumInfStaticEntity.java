package datasource.entity.fileSystemCore.musicAlbumsLayer;

import javax.persistence.*;
import java.sql.Blob;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 * TODO: 2018/1/26 Entity Design
 */

@Entity
@Table(name = "album_music_inf_static")
public class MusicAlbumInfStaticEntity {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_music_id")
    private MusicAlbumEntity albumId;

    @Column(name = "album_artwork")
    private Blob albumArtwork;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "tracks")
    private Integer tracks;

    @Column(name = "disc_number")
    private Integer discNumber;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "comments")
    private String comments;

    public MusicAlbumInfStaticEntity() {
    }

    public MusicAlbumEntity getAlbumId() {
        return albumId;
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

    public Integer getTracks() {
        return tracks;
    }

    public void setTracks(Integer tracks) {
        this.tracks = tracks;
    }

    public Integer getDiscNumber() {
        return discNumber;
    }

    public void setDiscNumber(Integer discNumber) {
        this.discNumber = discNumber;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
