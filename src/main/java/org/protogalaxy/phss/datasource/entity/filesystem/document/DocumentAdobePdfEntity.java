package org.protogalaxy.phss.datasource.entity.filesystem.document;

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

    @Field("modifier")
    private String modifier;

    @Field("path")
    private String path;

    @Field("version")
    private String version;

    @Field("producer")
    private String producer;

    @Field("gmt_create")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gmtCreate;

    @Field("gmt_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gmtModified;

    @PersistenceConstructor
    public DocumentAdobePdfEntity(String title, Date created, Date modified, String creator, String modifier, String path, String version, String producer) {
        this.title = title;
        this.created = created;
        this.modified = modified;
        this.creator = creator;
        this.modifier = modifier;
        this.path = path;
        this.version = version;
        this.producer = producer;
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

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }
}
