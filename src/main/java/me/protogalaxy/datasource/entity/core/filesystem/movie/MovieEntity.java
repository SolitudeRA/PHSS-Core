package me.protogalaxy.datasource.entity.core.filesystem.movie;

import me.protogalaxy.datasource.entity.core.filesystem.main.FileSystemMainEntity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "movie")
public class MovieEntity {
    @Id
    @GeneratedValue
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_OWNER_ID_MOVIE"))
    private FileSystemMainEntity fileSystemMainEntity;

    @Column(name = "movie_name")
    private String movieName;

    public MovieEntity() {
    }

    public MovieEntity(String movieName) {
        this.movieName = movieName;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public FileSystemMainEntity getFileSystemMainEntity() {
        return fileSystemMainEntity;
    }

    public void setFileSystemMainEntity(FileSystemMainEntity fileSystemMainEntity) {
        this.fileSystemMainEntity = fileSystemMainEntity;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
