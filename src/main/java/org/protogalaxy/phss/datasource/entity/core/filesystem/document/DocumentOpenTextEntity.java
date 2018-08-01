package org.protogalaxy.phss.datasource.entity.core.filesystem.document;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.protogalaxy.phss.datasource.entity.core.filesystem.main.FileSystemMainEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "document_open_text")
public class DocumentOpenTextEntity {
    @Id
    @GeneratedValue
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_OWNER_ID_DOCUMENT_OPEN_TEXT"))
    private FileSystemMainEntity fileSystemMainEntity;

    @Column(name = "title")
    private String title;

    @Column(name = "initial_author")
    private String initialAuthor;

    @Column(name = "author")
    private String author;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "save_date")
    private Date saveDate;

    @Column(name = "word_count")
    private int wordCount;

    @Column(name = "character_count")
    private int characterCount;

    @Column(name = "image_count")
    private int imageCount;

    @Column(name = "par_count")
    private int parCount;

    @Column(name = "table_count")
    private int tableCount;

    @Column(name = "page_count")
    private int pageCount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified")
    @UpdateTimestamp
    private Date gmtModified;

    public DocumentOpenTextEntity() {
    }

    public DocumentOpenTextEntity(FileSystemMainEntity fileSystemMainEntity, String title, String initialAuthor, String author, Date creationDate, Date saveDate, int wordCount, int characterCount, int imageCount, int parCount, int tableCount, int pageCount) {
        this.fileSystemMainEntity = fileSystemMainEntity;
        this.title = title;
        this.initialAuthor = initialAuthor;
        this.author = author;
        this.creationDate = creationDate;
        this.saveDate = saveDate;
        this.wordCount = wordCount;
        this.characterCount = characterCount;
        this.imageCount = imageCount;
        this.parCount = parCount;
        this.tableCount = tableCount;
        this.pageCount = pageCount;
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

    public String getInitialAuthor() {
        return initialAuthor;
    }

    public void setInitialAuthor(String initialAuthor) {
        this.initialAuthor = initialAuthor;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(Date saveDate) {
        this.saveDate = saveDate;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getCharacterCount() {
        return characterCount;
    }

    public void setCharacterCount(int characterCount) {
        this.characterCount = characterCount;
    }

    public int getImageCount() {
        return imageCount;
    }

    public void setImageCount(int imageCount) {
        this.imageCount = imageCount;
    }

    public int getParCount() {
        return parCount;
    }

    public void setParCount(int parCount) {
        this.parCount = parCount;
    }

    public int getTableCount() {
        return tableCount;
    }

    public void setTableCount(int tableCount) {
        this.tableCount = tableCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }
}
