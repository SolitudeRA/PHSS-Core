package org.protogalaxy.phss.datasource.entity.core.filesystem.document;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Document(collection = "document")
public class DocumentAdobePdfEntity {
    @Id
    @GeneratedValue
    private UUID uuid;

    @Field("title")
    private String title;

    @Field("version")
    private String version;

    @Field("author")
    private String author;

    @Field("producer")
    private String producer;

    @Field("created")
    private Date created;

    @Field("modified")
    private Date modified;

    @Field("gmt_create")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gmtCreate;

    @Field("gmt_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gmtModified;

    @PersistenceConstructor
    public DocumentAdobePdfEntity(String title, String version, String author, String producer, Date created, Date modified) {
        this.title = title;
        this.version = version;
        this.author = author;
        this.producer = producer;
        this.created = created;
        this.modified = modified;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
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

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }
}
