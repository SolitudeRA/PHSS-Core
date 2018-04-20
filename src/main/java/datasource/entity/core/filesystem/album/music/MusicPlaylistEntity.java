package datasource.entity.core.filesystem.album.music;

import datasource.entity.core.filesystem.main.FileSystemMainEntity;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.UUID;

@Entity
@DynamicInsert
@Table(name = "music_playlist")
public class MusicPlaylistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = ""))
    private FileSystemMainEntity fileSystemMainEntity;

    @Column(name = "name")
    private String name;

    @Column(name = "playback_count")
    @ColumnDefault("0")
    private Integer playbackCount;

    @Column(name = "location")
    private String location;

    public MusicPlaylistEntity() {
    }

    public MusicPlaylistEntity(FileSystemMainEntity fileSystemMainEntity, String name, String location) {
        this.fileSystemMainEntity = fileSystemMainEntity;
        this.name = name;
        this.location = location;
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

    public void setFileSystemMainEntity(FileSystemMainEntity fileSystemMainEntity) {
        this.fileSystemMainEntity = fileSystemMainEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPlaybackCount() {
        return playbackCount;
    }

    public void setPlaybackCount(Integer playbackCount) {
        this.playbackCount = playbackCount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
