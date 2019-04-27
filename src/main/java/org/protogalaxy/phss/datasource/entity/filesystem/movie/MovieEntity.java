package org.protogalaxy.phss.datasource.entity.filesystem.movie;

import org.protogalaxy.phss.datasource.entity.filesystem.FileSystemMainEntity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "movie")
public class MovieEntity {
    @Id
    @GeneratedValue
    private UUID id;

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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
