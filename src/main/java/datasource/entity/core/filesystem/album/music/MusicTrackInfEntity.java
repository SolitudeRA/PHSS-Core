package datasource.entity.core.filesystem.album.music;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 */

@Entity
@DynamicInsert
@Table(name = "track_inf")
public class MusicTrackInfEntity {
    @Id
    private UUID trackId;

    @Column(name = "playback_count")
    @ColumnDefault("0")
    private Integer playbackCount;

    @Column(name = "playback_date")
    private Date playbackDate;

    @Column(name = "skip_count")
    @ColumnDefault("0")
    private Integer skipCount;

    @Column(name = "skip_date")
    private Date skipDate;

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

    public MusicTrackInfEntity() {
    }

    public MusicTrackInfEntity(MusicTrackEntity musicTrackEntity) {
        this.musicTrackEntity = musicTrackEntity;
    }

    public MusicTrackInfEntity(Integer playbackCount, Date playbackDate, Integer skipCount, Date skipDate, Date dateAdded, Date dateModified, MusicTrackEntity musicTrackEntity) {
        this.playbackCount = playbackCount;
        this.playbackDate = playbackDate;
        this.skipCount = skipCount;
        this.skipDate = skipDate;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
        this.musicTrackEntity = musicTrackEntity;
    }

    public UUID getTrackId() {
        return trackId;
    }

    public Integer getPlaybackCount() {
        return playbackCount;
    }

    public Date getPlaybackDate() {
        return playbackDate;
    }

    public void setPlaybackDate(Date playbackDate) {
        this.playbackDate = playbackDate;
    }

    public Integer getSkipCount() {
        return skipCount;
    }

    public Date getSkipDate() {
        return skipDate;
    }

    public void setSkipDate(Date skipDate) {
        this.skipDate = skipDate;
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
