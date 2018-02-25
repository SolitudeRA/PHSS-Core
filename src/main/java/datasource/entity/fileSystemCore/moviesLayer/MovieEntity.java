package datasource.entity.fileSystemCore.moviesLayer;

import datasource.entity.userManagementCore.UserEntity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "movie")
public class MovieEntity {
    @Id
    @GeneratedValue
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_USER_ID"))
    private UserEntity userEntity;

    @Column(name = "movie_name")
    private String movieName;

    @OneToOne(mappedBy = "movieEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private MovieInfEntity movieInfEntity;

    public MovieEntity(){
    }

    public MovieEntity(String movieName){
        this.movieName = movieName;
    }

    public UUID getUuid(){
        return uuid;
    }

    public void setUuid(UUID uuid){
        this.uuid = uuid;
    }

    public UserEntity getUserEntity(){
        return userEntity;
    }

    public String getMovieName(){
        return movieName;
    }

    public void setMovieName(String movieName){
        this.movieName = movieName;
    }

    public MovieInfEntity getMovieInfEntity(){
        return movieInfEntity;
    }
}
