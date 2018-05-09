package me.protogalaxy.datasource.entity.core.filesystem.album.music;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 */

@Entity
@Table(name = "track_inf_static")
public class MusicTrackInfStaticEntity {
    @Id
    private int trackId;

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

    @Column(name = "year")
    private String year;

    @Column(name = "bit_rate")
    private String bitRate;

    @Column(name = "sample_rate")
    private String sampleRate;

    @Lob
    @Column(name = "artwork")
    private Blob artwork;

    @Column(name = "genre")
    private String genre;

    @Column(name = "kind")
    private String kind;

    @Column(name = "location")
    private String location;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_added")
    @CreationTimestamp
    private Date dateAdded;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_modified")
    @UpdateTimestamp
    private Date dateModified;

    @JsonBackReference
    @OneToOne
    @MapsId
    @JoinColumn(name = "track_id")
    private MusicTrackEntity musicTrackEntity;

    public MusicTrackInfStaticEntity() {
    }

    public MusicTrackInfStaticEntity(String location, MusicTrackEntity musicTrackEntity) {
        this.location = location;
        this.musicTrackEntity = musicTrackEntity;
    }

    public MusicTrackInfStaticEntity(String size, String duration, String trackNumber, String disc, String bitRate, String sampleRate, Blob artwork, String genre, String location, MusicTrackEntity musicTrackEntity) {
        this.size = size;
        this.duration = duration;
        this.trackNumber = trackNumber;
        this.disc = disc;
        this.bitRate = bitRate;
        this.sampleRate = sampleRate;
        this.artwork = artwork;
        this.genre = genre;
        this.location = location;
        this.musicTrackEntity = musicTrackEntity;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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

    public Blob getArtwork() {
        return artwork;
    }

    public void setArtwork(Blob artwork) {
        this.artwork = artwork;
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

    public MusicTrackEntity getMusicTrackEntity() {
        return musicTrackEntity;
    }

    public void setMusicTrackEntity(MusicTrackEntity musicTrackEntity) {
        this.musicTrackEntity = musicTrackEntity;
    }
}
