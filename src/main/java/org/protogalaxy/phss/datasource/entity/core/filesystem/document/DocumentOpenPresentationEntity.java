package org.protogalaxy.phss.datasource.entity.core.filesystem.document;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.protogalaxy.phss.datasource.entity.core.filesystem.main.FileSystemMainEntity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Document(collection = "document")
public class DocumentOpenPresentationEntity {
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

    @Temporal(TemporalType.TIMESTAMP)
    @Field("gmt_create")
    @CreatedDate
    private Date gmtCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Field("gmt_modified")
    @LastModifiedDate
    private Date gmtModified;

    @PersistenceConstructor
    public DocumentOpenPresentationEntity(String title, String initialAuthor, String author, Date creationDate, Date saveDate) {
        this.title = title;
        this.initialAuthor = initialAuthor;
        this.author = author;
        this.creationDate = creationDate;
        this.saveDate = saveDate;
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

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }
}

