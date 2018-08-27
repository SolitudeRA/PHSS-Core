package org.protogalaxy.phss.datasource.entity.filesystem.book;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemMainEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_OWNER_ID_BOOK"))
    private FileSystemMainEntity fileSystemMainEntity;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "path")
    private String path;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified")
    @UpdateTimestamp
    private Date gmtModified;

    @JsonManagedReference
    @OneToOne(mappedBy = "bookEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private BookInfEntity bookInfEntity;

    public BookEntity() {
    }

    public BookEntity(FileSystemMainEntity fileSystemMainEntity, String title, String author, String path) {
        this.fileSystemMainEntity = fileSystemMainEntity;
        this.title = title;
        this.author = author;
        this.path = path;
    }

    public UUID getUuid() {
        return uuid;
    }

    public FileSystemMainEntity getFileSystemMainEntity() {
        return fileSystemMainEntity;
    }

    public void setFileSystemMainEntity(FileSystemMainEntity fileSystemMainEntity) {
        this.fileSystemMainEntity = fileSystemMainEntity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public BookInfEntity getBookInfEntity() {
        return bookInfEntity;
    }

    public void setBookInfEntity(BookInfEntity bookInfEntity) {
        this.bookInfEntity = bookInfEntity;
    }
}
