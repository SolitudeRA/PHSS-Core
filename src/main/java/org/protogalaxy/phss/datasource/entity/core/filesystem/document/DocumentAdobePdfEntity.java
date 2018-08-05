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

    @Field("created")
    private Date created;

    @Field("modified")
    private Date modified;

    @Field("creator")
    private String creator;

    @Field("version")
    private String version;

    @Field("producer")
    private String producer;

    @Field("path")
    private String path;

    @Field("gmt_create")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gmtCreate;

    @Field("gmt_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gmtModified;

    @PersistenceConstructor
    public DocumentAdobePdfEntity(String title, Date created, Date modified, String creator, String version, String producer, String path) {
        this.title = title;
        this.created = created;
        this.modified = modified;
        this.creator = creator;
        this.version = version;
        this.producer = producer;
        this.path = path;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
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
}
