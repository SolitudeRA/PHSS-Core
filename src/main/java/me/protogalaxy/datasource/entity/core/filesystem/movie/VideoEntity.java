package me.protogalaxy.datasource.entity.core.filesystem.movie;

import me.protogalaxy.datasource.entity.core.filesystem.main.FileSystemMainEntity;

import javax.persistence.*;

@Entity
@Table(name = "video")
public class VideoEntity {
    @Id
    @GeneratedValue
    private int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
