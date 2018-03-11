package datasource.entity.fileSystemCore.moviesLayer;

import datasource.entity.fileSystemCore.fileSystemInformationLayer.FileSystemInfMainEntity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "movie")
@Inheritance(strategy = InheritanceType.JOINED)
public class MovieEntity {
    @Id
    @GeneratedValue
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_OWNER_ID_MOVIE"))
    private FileSystemInfMainEntity filesystemInfMainEntity;

    @Column(name = "movie_name")
    private String movieName;

    public MovieEntity(){ }

    public MovieEntity(String movieName){
        this.movieName = movieName;
    }

    public UUID getUuid(){
        return uuid;
    }

    public void setUuid(UUID uuid){
        this.uuid = uuid;
    }

    public FileSystemInfMainEntity getFilesystemInfMainEntity(){ return filesystemInfMainEntity; }

    public String getMovieName(){
        return movieName;
    }

    public void setMovieName(String movieName){
        this.movieName = movieName;
    }
}
