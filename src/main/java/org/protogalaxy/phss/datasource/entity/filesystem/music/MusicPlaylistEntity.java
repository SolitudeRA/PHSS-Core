package org.protogalaxy.phss.datasource.entity.filesystem.music;

import org.joda.time.LocalDateTime;
import org.protogalaxy.phss.datasource.entity.filesystem.FileSystemMainEntity;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Duration;
import java.util.List;
import java.util.UUID;

@DynamicInsert
@Table(name = "music_playlist")
@Entity(name = "MusicPlaylist")
@EntityListeners(AuditingEntityListener.class)
public class MusicPlaylistEntity {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false, unique = true, columnDefinition = "BINARY(16)")
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_FILESYSTEM_OWNER_ID_MUSIC_PLAYLIST"))
    private FileSystemMainEntity fileSystemOwner;

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @OneToMany(cascade = CascadeType.DETACH, orphanRemoval = true)
    @Column(name = "list")
    private List<MusicTrackEntity> list;

    @Column(name = "track_total")
    private Integer trackTotal;

    @Column(name = "duration_total")
    private Duration durationTotal;

    @Column(name = "playback_count")
    @ColumnDefault("0")
    private Integer playbackCount;

    @CreatedDate
    @Column(name = "date_added")
    private LocalDateTime dateAdded;

    @LastModifiedDate
    @Column(name = "date_modified")
    private LocalDateTime dateModified;

    public MusicPlaylistEntity() {
    }

    public MusicPlaylistEntity(FileSystemMainEntity fileSystemOwner, String name) {
        this.fileSystemOwner = fileSystemOwner;
        this.name = name;
    }

    public MusicPlaylistEntity(FileSystemMainEntity fileSystemOwner, String name, List<MusicTrackEntity> list) {
        this.fileSystemOwner = fileSystemOwner;
        this.name = name;
        this.list = list;
    }

    public MusicPlaylistEntity(FileSystemMainEntity fileSystemOwner, String name, String description, List<MusicTrackEntity> list) {
        this.fileSystemOwner = fileSystemOwner;
        this.name = name;
        this.description = description;
        this.list = list;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public FileSystemMainEntity getFileSystemOwner() {
        return fileSystemOwner;
    }

    public void setFileSystemOwner(FileSystemMainEntity fileSystemOwner) {
        this.fileSystemOwner = fileSystemOwner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MusicTrackEntity> getList() {
        return list;
    }

    public void setList(List<MusicTrackEntity> list) {
        this.list = list;
    }

    public Integer getTrackTotal() {
        return trackTotal;
    }

    public void setTrackTotal(Integer trackTotal) {
        this.trackTotal = trackTotal;
    }

    public Duration getDurationTotal() {
        return durationTotal;
    }

    public void setDurationTotal(Duration durationTotal) {
        this.durationTotal = durationTotal;
    }

    public Integer getPlaybackCount() {
        return playbackCount;
    }

    public void setPlaybackCount(Integer playbackCount) {
        this.playbackCount = playbackCount;
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
}
