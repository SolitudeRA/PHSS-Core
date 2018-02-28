package datasource.entity.fileSystemCore.booksLayer;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "book_inf")
@PrimaryKeyJoinColumn(name = "book_id")
public class BookInfEntity extends BookEntity {
    @Column(name = "author")
    private String author;

    @Lob
    @Column(name = "illustrator")
    private Blob illustrator;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "isbn")
    private Integer isbn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    public BookInfEntity(){
    }

    public BookInfEntity(String author, Blob illustrator, Date releaseDate, Integer isbn, Date gmtCreate, Date gmtModified){
        this.author = author;
        this.illustrator = illustrator;
        this.releaseDate = releaseDate;
        this.isbn = isbn;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public Blob getIllustrator(){
        return illustrator;
    }

    public void setIllustrator(Blob illustrator){
        this.illustrator = illustrator;
    }

    public Date getReleaseDate(){
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate){
        this.releaseDate = releaseDate;
    }

    public Integer getIsbn(){
        return isbn;
    }

    public void setIsbn(Integer isbn){
        this.isbn = isbn;
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
}
