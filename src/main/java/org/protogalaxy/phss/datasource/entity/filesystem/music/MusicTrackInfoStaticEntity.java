package org.protogalaxy.phss.datasource.entity.filesystem.music;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 */

@Entity
@Table(name = "track_inf_static")
public class MusicTrackInfoStaticEntity {
    @Id
    private UUID trackId;

    @Column(name = "size")
    private String size;

    @Column(name = "duration")
    private String duration;

    @Column(name = "track_number")
    private String trackNumber;

    @Column(name = "track_count")
    private String trackCount;

    @Column(name = "disc")
    private String disc;

    @Column(name = "date")
    private String date;

    @Column(name = "genre")
    private String genre;

    @Column(name = "kind")
    private String kind;

    @Column(name = "bit_rate")
    private String bitRate;

    @Column(name = "sample_rate")
    private String sampleRate;

    @Column(name = "bit_depth")
    private String bitDepth;

    @Column(name = "artwork")
    private String artwork;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_added")
    @CreatedDate
    private Date dateAdded;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_modified")
    @LastModifiedDate
    private Date dateModified;

    @JsonBackReference
    @OneToOne
    @MapsId
    @JoinColumn(name = "track_id")
    private MusicTrackEntity musicTrackEntity;

    public MusicTrackInfoStaticEntity() {
    }

    public MusicTrackInfoStaticEntity(String kind, MusicTrackEntity musicTrackEntity) {
        this.kind = kind;
        this.musicTrackEntity = musicTrackEntity;
    }

    public MusicTrackInfoStaticEntity(String size, String duration, String trackNumber, String disc, String date, String genre, String bitRate, String sampleRate, String bitDepth, String artwork, MusicTrackEntity musicTrackEntity) throws Exception {
        this.size = size;
        this.duration = duration;
        this.trackNumber = trackNumber;
        this.disc = disc;
        this.date = date;
        this.genre = genre;
        this.bitRate = bitRate;
        this.sampleRate = sampleRate;
        this.bitDepth = bitDepth;
        this.artwork = artwork;
        this.musicTrackEntity = musicTrackEntity;
    }

    public UUID getTrackId() {
        return trackId;
    }

    public void setTrackId(UUID trackId) {
        this.trackId = trackId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(String trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(String trackCount) {
        this.trackCount = trackCount;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getBitRate() {
        return bitRate;
    }

    public void setBitRate(String bitRate) {
        this.bitRate = bitRate;
    }

    public String getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(String sampleRate) {
        this.sampleRate = sampleRate;
    }

    public String getBitDepth() {
        return bitDepth;
    }

    public void setBitDepth(String bitDepth) {
        this.bitDepth = bitDepth;
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

    public String getArtwork() {
        return artwork;
    }

    public void setArtwork(String artwork) throws Exception {
        this.artwork = artwork;
    }

    public MusicTrackEntity getMusicTrackEntity() {
        return musicTrackEntity;
    }

    public void setMusicTrackEntity(MusicTrackEntity musicTrackEntity) {
        this.musicTrackEntity = musicTrackEntity;
    }
}
