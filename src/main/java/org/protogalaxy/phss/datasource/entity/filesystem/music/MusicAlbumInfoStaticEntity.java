package org.protogalaxy.phss.datasource.entity.filesystem.music;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Entity for music album static information
 *
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 */

@Entity(name = "MusicAlbumStaticInformation")
@Table(name = "album_music_info_static")
public class MusicAlbumInfoStaticEntity {
    @Id
    private UUID albumUUID;

    @Column(name = "artwork")
    private String artwork;

    @Column(name = "composer")
    private String composer;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "duration_total")
    private Duration durationTotal;

    @Column(name = "track_total")
    private Integer trackTotal;

    @Column(name = "disc_number")
    private Integer discNumber;

    @Column(name = "disc_total")
    private Integer discTotal;

    @Column(name = "genre")
    private String genre;

    @Column(name = "score")
    private Float score;

    @Column(name = "like")
    private Boolean like;

    @Column(name = "dislike")
    private Boolean dislike;

    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

    @Column(name = "size_total")
    private Long sizeTotal;

    @Column(name = "date_added")
    @CreatedDate
    private ZonedDateTime dateAdded;

    @Column(name = "date_modified")
    @LastModifiedDate
    private ZonedDateTime dateModified;

    @MapsId
    @OneToOne
    @JoinColumn(name = "album_id")
    private MusicAlbumEntity musicAlbumEntity;

    public MusicAlbumInfoStaticEntity() {
    }

    public MusicAlbumInfoStaticEntity(MusicAlbumEntity musicAlbumEntity) {
        this.musicAlbumEntity = musicAlbumEntity;
    }

    public MusicAlbumInfoStaticEntity(String artwork, String composer, Integer releaseYear, Duration durationTotal, Integer trackTotal, Integer discNumber, Integer discTotal, List<String> genre, Float score, Boolean like, Boolean dislike, String comment, Long sizeTotal, MusicAlbumEntity musicAlbumEntity) {
        this.artwork = artwork;
        this.composer = composer;
        this.releaseYear = releaseYear;
        this.durationTotal = durationTotal;
        this.trackTotal = trackTotal;
        this.discNumber = discNumber;
        this.discTotal = discTotal;
        this.genre = String.join(";", genre);
        this.score = score;
        this.like = like;
        this.dislike = dislike;
        this.comment = comment;
        this.sizeTotal = sizeTotal;
        this.musicAlbumEntity = musicAlbumEntity;
    }

    public UUID getAlbumUUID() {
        return albumUUID;
    }

    public void setAlbumUUID(UUID albumUUID) {
        this.albumUUID = albumUUID;
    }

    public String getArtwork() {
        return artwork;
    }

    public void setArtwork(String artwork) {
        this.artwork = artwork;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Duration getDurationTotal() {
        return durationTotal;
    }

    public void setDurationTotal(Duration durationTotal) {
        this.durationTotal = durationTotal;
    }

    public Integer getTrackTotal() {
        return trackTotal;
    }

    public void setTrackTotal(Integer trackTotal) {
        this.trackTotal = trackTotal;
    }

    public Integer getDiscNumber() {
        return discNumber;
    }

    public void setDiscNumber(Integer discNumber) {
        this.discNumber = discNumber;
    }

    public Integer getDiscTotal() {
        return discTotal;
    }

    public void setDiscTotal(Integer discTotal) {
        this.discTotal = discTotal;
    }

    public List<String> getGenre() {
        return Arrays.asList(genre.split(";"));
    }

    public void setGenre(List<String> genre) {
        this.genre = String.join(";", genre);
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Boolean getLike() {
        return like;
    }

    public void setLike(Boolean like) {
        this.like = like;
    }

    public Boolean getDislike() {
        return dislike;
    }

    public void setDislike(Boolean dislike) {
        this.dislike = dislike;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getSizeTotal() {
        return sizeTotal;
    }

    public void setSizeTotal(Long sizeTotal) {
        this.sizeTotal = sizeTotal;
    }

    public ZonedDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(ZonedDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public ZonedDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(ZonedDateTime dateModified) {
        this.dateModified = dateModified;
    }

    public MusicAlbumEntity getMusicAlbumEntity() {
        return musicAlbumEntity;
    }

    public void setMusicAlbumEntity(MusicAlbumEntity musicAlbumEntity) {
        this.musicAlbumEntity = musicAlbumEntity;
    }
}
