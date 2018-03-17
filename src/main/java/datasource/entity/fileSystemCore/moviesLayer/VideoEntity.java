package datasource.entity.fileSystemCore.moviesLayer;

import datasource.entity.fileSystemCore.fileSystemInformationLayer.FileSystemInfMainEntity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "video")
@Inheritance(strategy = InheritanceType.JOINED)
public class VideoEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_OWNER_ID_VIDEO"))
    private FileSystemInfMainEntity fileSystemInfMainEntity;

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

    public FileSystemInfMainEntity getFileSystemInfMainEntity() {
        return fileSystemInfMainEntity;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }
}
