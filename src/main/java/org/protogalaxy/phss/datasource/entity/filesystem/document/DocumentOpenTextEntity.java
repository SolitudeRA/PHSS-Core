package org.protogalaxy.phss.datasource.entity.filesystem.document;

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

    @Field("created")
    private Date created;

    @Field("modified")
    private Date modified;

    @Field("creator")
    private String creator;

    @Field("modifier")
    private String modifier;

    @Field("path")
    private String path;

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
    public DocumentOpenTextEntity(String title, Date created, Date modified, String creator, String modifier, String path, int wordCount, int characterCount, int imageCount, int parCount, int tableCount, int pageCount) {
        this.title = title;
        this.created = created;
        this.modified = modified;
        this.creator = creator;
        this.modifier = modifier;
        this.path = path;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
