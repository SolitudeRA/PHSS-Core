package org.protogalaxy.phss.datasource.entity.filesystem.movie;

import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemMainEntity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "video")
public class VideoEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_OWNER_ID_VIDEO"))
    private FileSystemMainEntity fileSystemMainEntity;

    @Column(name = "video_name")
    private String videoName;

    public VideoEntity() {
    }

    public VideoEntity(String videoName) {
        this.videoName = videoName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public FileSystemMainEntity getFileSystemMainEntity() {
        return fileSystemMainEntity;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }
}
