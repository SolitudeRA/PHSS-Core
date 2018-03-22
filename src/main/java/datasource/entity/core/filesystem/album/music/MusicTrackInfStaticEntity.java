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
@Table(name = "track_inf_static")
public class MusicTrackInfStaticEntity {
    @Id
    private UUID trackId;

    @Column(name = "size")
    private Integer size;

    @Column(name = "total_time")
    private Integer totalTime;

    @Column(name = "track_number")
    private Integer trackNumber;

    @Column(name = "track_count")
    private Integer trackCount;

    @Column(name = "year")
    private Integer year;

    @Column(name = "bit_rate")
    private Integer bitRate;

    @Column(name = "sample_rate")
    private Integer sampleRate;

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

    @Column(name = "date_modified")
    private Date dateModified;

    @OneToOne
    @MapsId
    @JoinColumn(name = "track_id")
    private MusicTrackEntity musicTrackEntity;

    public MusicTrackInfStaticEntity() {
    }

    public MusicTrackInfStaticEntity(Integer size, Integer totalTime, Integer trackNumber, Integer trackCount, Integer year, Integer bitRate, Integer sampleRate, Blob artwork, String genre, String kind, String location, MusicTrackEntity musicTrackEntity) {
        this.size = size;
        this.totalTime = totalTime;
        this.trackNumber = trackNumber;
        this.trackCount = trackCount;
        this.year = year;
        this.bitRate = bitRate;
        this.sampleRate = sampleRate;
        this.artwork = artwork;
        this.genre = genre;
        this.kind = kind;
        this.location = location;
        this.musicTrackEntity = musicTrackEntity;
    }

    public UUID getTrackId() {
        return trackId;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

    public Integer getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Integer getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(Integer trackCount) {
        this.trackCount = trackCount;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getBitRate() {
        return bitRate;
    }

    public void setBitRate(Integer bitRate) {
        this.bitRate = bitRate;
    }

    public Integer getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(Integer sampleRate) {
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
