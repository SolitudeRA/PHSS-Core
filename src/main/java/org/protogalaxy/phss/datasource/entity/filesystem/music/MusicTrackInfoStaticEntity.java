package org.protogalaxy.phss.datasource.entity.filesystem.music;

import org.joda.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Entity for music track static information
 *
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 */

@Table(name = "music_track_info_static")
@Entity(name = "MusicTrackStaticInformation")
@EntityListeners(AuditingEntityListener.class)
public class MusicTrackInfoStaticEntity {
    @Id
    private UUID trackUUID;

    @Column(name = "album_artist")
    private String albumArtist;

    @Column(name = "composer")
    private String composer;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "track_number")
    private Integer trackNumber;

    @Column(name = "track_total")
    private Integer trackTotal;

    @Column(name = "disc_number")
    private Integer discNumber;

    @Column(name = "disc_total")
    private Integer discTotal;

    @Column(name = "score")
    private Float score;

    @Column(name = "genre")
    private String genre;

    @Column(name = "artwork")
    private String artwork;

    @Column(name = "love")
    private Boolean love;

    @Column(name = "dislike")
    private Boolean dislike;

    @Column(name = "comment", columnDefinition = "text")
    private String comment;

    @Column(name = "kind")
    private String kind;

    @Column(name = "duration")
    private Duration duration;

    @Column(name = "size")
    private Long size;

    @Column(name = "bit_rate")
    private String bitRate;

    @Column(name = "bit_depth")
    private String bitDepth;

    @Column(name = "sample_rate")
    private String sampleRate;

    @CreatedDate
    @Column(name = "date_added")
    private LocalDateTime dateAdded;

    @LastModifiedDate
    @Column(name = "date_modified")
    private LocalDateTime dateModified;

    @MapsId
    @OneToOne
    @JoinColumn(name = "track_id", nullable = false, updatable = false, unique = true, columnDefinition = "BINARY(16)")
    private MusicTrackEntity musicTrackEntity;

    public MusicTrackInfoStaticEntity() {
    }

    public MusicTrackInfoStaticEntity(MusicTrackEntity musicTrackEntity) {
        this.musicTrackEntity = musicTrackEntity;
    }

    public MusicTrackInfoStaticEntity(String albumArtist, String composer, Integer releaseYear, String genre, String artwork, String comment, Duration duration, Long size, String bitRate, String bitDepth, String sampleRate, MusicTrackEntity musicTrackEntity) {
        this.albumArtist = albumArtist;
        this.composer = composer;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.artwork = artwork;
        this.comment = comment;
        this.duration = duration;
        this.size = size;
        this.bitRate = bitRate;
        this.bitDepth = bitDepth;
        this.sampleRate = sampleRate;
        this.musicTrackEntity = musicTrackEntity;
    }

    public MusicTrackInfoStaticEntity(String albumArtist, String composer, Integer releaseYear, Integer trackNumber, Integer trackTotal, Integer discNumber, Integer discTotal, Float score, List<String> genre, String artwork, Boolean love, Boolean dislike, String comment, String kind, Duration duration, Long size, String bitRate, String bitDepth, String sampleRate, MusicTrackEntity musicTrackEntity) {
        this.albumArtist = albumArtist;
        this.composer = composer;
        this.releaseYear = releaseYear;
        this.trackNumber = trackNumber;
        this.trackTotal = trackTotal;
        this.discNumber = discNumber;
        this.discTotal = discTotal;
        this.score = score;
        this.genre = String.join(";", genre);
        this.artwork = artwork;
        this.love = love;
        this.dislike = dislike;
        this.comment = comment;
        this.kind = kind;
        this.duration = duration;
        this.size = size;
        this.bitRate = bitRate;
        this.bitDepth = bitDepth;
        this.sampleRate = sampleRate;
        this.musicTrackEntity = musicTrackEntity;
    }

    public UUID getTrackUUID() {
        return trackUUID;
    }

    public void setTrackUUID(UUID trackUUID) {
        this.trackUUID = trackUUID;
    }

    public String getAlbumArtist() {
        return albumArtist;
    }

    public void setAlbumArtist(String albumArtist) {
        this.albumArtist = albumArtist;
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

    public Integer getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
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

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public List<String> getGenre() {
        return Arrays.asList(genre.split(";"));
    }

    public void setGenre(List<String> genre) {
        this.genre = String.join(";", genre);
    }

    public String getArtwork() {
        return artwork;
    }

    public void setArtwork(String artwork) {
        this.artwork = artwork;
    }

    public Boolean getLove() {
        return love;
    }

    public void setLove(Boolean love) {
        this.love = love;
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

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getBitRate() {
        return bitRate;
    }

    public void setBitRate(String bitRate) {
        this.bitRate = bitRate;
    }

    public String getBitDepth() {
        return bitDepth;
    }

    public void setBitDepth(String bitDepth) {
        this.bitDepth = bitDepth;
    }

    public String getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(String sampleRate) {
        this.sampleRate = sampleRate;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public LocalDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDateTime dateModified) {
        this.dateModified = dateModified;
    }

    public MusicTrackEntity getMusicTrackEntity() {
        return musicTrackEntity;
    }

    public void setMusicTrackEntity(MusicTrackEntity musicTrackEntity) {
        this.musicTrackEntity = musicTrackEntity;
    }
}
