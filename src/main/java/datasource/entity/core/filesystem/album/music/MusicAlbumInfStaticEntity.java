package datasource.entity.core.filesystem.album.music;

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
    private UUID albumId;

    @Lob
    @Column(name = "artwork")
    private Blob artwork;

    @Column(name = "composer")
    private String composer;

    @Column(name = "year")
    private Integer year;

    @Column(name = "total_time")
    private Integer totalTime;

    @Column(name = "track_count")
    private Integer trackCount;

    @Column(name = "album_nmuber")
    private Integer albumNumber;

    @Column(name = "album_count")
    private Integer albumCount;

    @Column(name = "genre_summary")
    private String genreSummary;

    @Column(name = "genre_sub1")
    private String genreSub1;

    @Column(name = "genre_sub2")
    private String genreSub2;

    @Column(name = "genre_sub3")
    private String genreSub3;

    @Column(name = "star")
    private Integer star;

    @Column(name = "is_favorite")
    private Integer isFavorite;

    @Column(name = "comment")
    private String comment;

    @Column(name = "size")
    private Integer size;

    @Column(name = "location")
    private String location;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_added")
    @CreationTimestamp
    private Date dateAdded;

    @Column(name = "date_modified")
    private Date dateModified;

    @OneToOne
    @MapsId
    @JoinColumn(name = "album_id")
    private MusicAlbumEntity musicAlbumEntity;

    public MusicAlbumInfStaticEntity() {
    }

    public MusicAlbumInfStaticEntity(MusicAlbumEntity musicAlbumEntity) {
        this.musicAlbumEntity = musicAlbumEntity;
    }

    public MusicAlbumInfStaticEntity(Blob artwork, String composer, Integer year, Integer totalTime, Integer trackCount, Integer albumNumber, Integer albumCount, String genreSummary, String genreSub1, String genreSub2, String genreSub3, Integer star, Integer isFavorite, String comment, Integer size, String location) {
        this.artwork = artwork;
        this.composer = composer;
        this.year = year;
        this.totalTime = totalTime;
        this.trackCount = trackCount;
        this.albumNumber = albumNumber;
        this.albumCount = albumCount;
        this.genreSummary = genreSummary;
        this.genreSub1 = genreSub1;
        this.genreSub2 = genreSub2;
        this.genreSub3 = genreSub3;
        this.star = star;
        this.isFavorite = isFavorite;
        this.comment = comment;
        this.size = size;
        this.location = location;
    }

    public UUID getAlbumId() {
        return albumId;
    }

    public void setAlbumId(UUID albumId) {
        this.albumId = albumId;
    }

    public Blob getArtwork() {
        return artwork;
    }

    public void setArtwork(Blob artwork) {
        this.artwork = artwork;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

    public Integer getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(Integer trackCount) {
        this.trackCount = trackCount;
    }

    public Integer getAlbumNumber() {
        return albumNumber;
    }

    public void setAlbumNumber(Integer albumNumber) {
        this.albumNumber = albumNumber;
    }

    public Integer getAlbumCount() {
        return albumCount;
    }

    public void setAlbumCount(Integer albumCount) {
        this.albumCount = albumCount;
    }

    public String getGenreSummary() {
        return genreSummary;
    }

    public void setGenreSummary(String genreSummary) {
        this.genreSummary = genreSummary;
    }

    public String getGenreSub1() {
        return genreSub1;
    }

    public void setGenreSub1(String genreSub1) {
        this.genreSub1 = genreSub1;
    }

    public String getGenreSub2() {
        return genreSub2;
    }

    public void setGenreSub2(String genreSub2) {
        this.genreSub2 = genreSub2;
    }

    public String getGenreSub3() {
        return genreSub3;
    }

    public void setGenreSub3(String genreSub3) {
        this.genreSub3 = genreSub3;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Integer isFavorite) {
        this.isFavorite = isFavorite;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public MusicAlbumEntity getMusicAlbumEntity() {
        return musicAlbumEntity;
    }

    public void setMusicAlbumEntity(MusicAlbumEntity musicAlbumEntity) {
        this.musicAlbumEntity = musicAlbumEntity;
    }
}
