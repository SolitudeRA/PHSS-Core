package datasource.entity.fileSystemCore.moviesLayer;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "movie_inf")
public class MovieInfEntity {
    @Id
    @Column(name = "movie_id")
    private UUID movieId;

    @Column(name = "content_rating")
    private Float contentRating;

    @Column(name = "movie_time")
    private String movieTime;

    @Column(name = "genre")
    private String genre;

    @Column(name = "release_date")
    private Date releaseDate;

    @Lob
    @Column(name = "poster")
    private Blob poster;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "director")
    private String director;

    @Column(name = "writers")
    private String writers;

    @Column(name = "stars")
    private String stars;

    @Column(name = "metascore")
    private Integer metascore;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    @OneToOne
    @MapsId
    private MovieEntity movieEntity;

    public MovieInfEntity(){
    }

    public MovieInfEntity(UUID movieId, Float contentRating, String movieTime, String genre, Date releaseDate, Blob poster, Float rating, String director, String writers, String stars, Integer metascore, Date gmtCreate, Date gmtModified){
        this.movieId = movieId;
        this.contentRating = contentRating;
        this.movieTime = movieTime;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.poster = poster;
        this.rating = rating;
        this.director = director;
        this.writers = writers;
        this.stars = stars;
        this.metascore = metascore;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public UUID getMovieId(){
        return movieId;
    }

    public void setMovieId(UUID movieId){
        this.movieId = movieId;
    }

    public Float getContentRating(){
        return contentRating;
    }

    public void setContentRating(Float contentRating){
        this.contentRating = contentRating;
    }

    public String getMovieTime(){
        return movieTime;
    }

    public void setMovieTime(String movieTime){
        this.movieTime = movieTime;
    }

    public String getGenre(){
        return genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public Date getReleaseDate(){
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate){
        this.releaseDate = releaseDate;
    }

    public Blob getPoster(){
        return poster;
    }

    public void setPoster(Blob poster){
        this.poster = poster;
    }

    public Float getRating(){
        return rating;
    }

    public void setRating(Float rating){
        this.rating = rating;
    }

    public String getDirector(){
        return director;
    }

    public void setDirector(String director){
        this.director = director;
    }

    public String getWriters(){
        return writers;
    }

    public void setWriters(String writers){
        this.writers = writers;
    }

    public String getStars(){
        return stars;
    }

    public void setStars(String stars){
        this.stars = stars;
    }

    public Integer getMetascore(){
        return metascore;
    }

    public void setMetascore(Integer metascore){
        this.metascore = metascore;
    }

    public Date getGmtCreate(){
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate){
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified(){
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified){
        this.gmtModified = gmtModified;
    }

    public MovieEntity getMovieEntity(){
        return movieEntity;
    }
}
