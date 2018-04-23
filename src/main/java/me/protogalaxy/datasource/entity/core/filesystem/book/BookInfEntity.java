package me.protogalaxy.datasource.entity.core.filesystem.book;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "book_inf")
public class BookInfEntity {
    @Id
    private UUID uuid;

    @Column(name = "author")
    private String author;

    @Lob
    @Column(name = "illustrator")
    private Blob illustrator;

    @Column(name = "release_date")
    private Date releaseDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    @OneToOne
    @MapsId
    @JoinColumn(name = "book_id")
    private BookEntity bookEntity;

    public BookInfEntity() {
    }

    public BookInfEntity(String author, Blob illustrator, Date releaseDate) {
        this.author = author;
        this.illustrator = illustrator;
        this.releaseDate = releaseDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Blob getIllustrator() {
        return illustrator;
    }

    public void setIllustrator(Blob illustrator) {
        this.illustrator = illustrator;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public void setBookEntity(BookEntity bookEntity) {
        this.bookEntity = bookEntity;
    }
}
