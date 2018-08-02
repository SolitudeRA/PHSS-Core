package org.protogalaxy.phss.datasource.entity.core.filesystem.document;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Document(collection = "document")
public class DocumentOpenTextEntity {
    @Id
    @GeneratedValue
    private UUID uuid;

    @Field("title")
    private String title;

    @Field("initial_author")
    private String initialAuthor;

    @Field("author")
    private String author;

    @Field("creation_date")
    private Date creationDate;

    @Field("save_date")
    private Date saveDate;

    @Field("word_count")
    private int wordCount;

    @Field("character_count")
    private int characterCount;

    @Field("image_count")
    private int imageCount;

    @Field("par_count")
    private int parCount;

    @Field("table_count")
    private int tableCount;

    @Field("page_count")
    private int pageCount;

    @Temporal(TemporalType.TIMESTAMP)
    @Field("gmt_create")
    @CreatedDate
    private Date gmtCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Field("gmt_modified")
    @LastModifiedDate
    private Date gmtModified;

    @PersistenceConstructor
    public DocumentOpenTextEntity(String title, String initialAuthor, String author, Date creationDate, Date saveDate, int wordCount, int characterCount, int imageCount, int parCount, int tableCount, int pageCount) {
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
