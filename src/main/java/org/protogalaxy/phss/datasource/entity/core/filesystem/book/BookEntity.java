package org.protogalaxy.phss.datasource.entity.core.filesystem.book;

import org.protogalaxy.phss.datasource.entity.core.filesystem.main.FileSystemMainEntity;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_OWNER_ID_BOOK"))
    private FileSystemMainEntity filesystemInfMainEntity;

    @Column(name = "book_name")
    private String bookName;

    @NaturalId
    @Column(name = "isbn")
    private Integer isbn;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    public BookEntity() {
    }

    public BookEntity(String bookName) {
        this.bookName = bookName;
    }

    public BookEntity(String bookName, Integer isbn) {
        this.bookName = bookName;
        this.isbn = isbn;
    }

    public UUID getId() {
        return id;
    }

    public FileSystemMainEntity getFilesystemInfMainEntity() {
        return filesystemInfMainEntity;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
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
}
