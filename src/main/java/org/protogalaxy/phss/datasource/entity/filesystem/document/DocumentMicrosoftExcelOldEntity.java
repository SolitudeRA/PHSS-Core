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
public class DocumentMicrosoftExcelOldEntity {
    @Id
    @GeneratedValue
    private UUID uuid;

    @Field("title")
    private String title;

    @Field("created")
    private Date created;

    @Field("modified")
    private Date modified;

    @Field("last_access")
    private Date lastAccess;

    @Field("path")
    private String path;

    @Field("app_name")
    private String appName;

    @Field("doc_parts")
    private int doc_parts;

    @Temporal(TemporalType.TIMESTAMP)
    @Field("gmt_create")
    @CreatedDate
    private Date gmtCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Field("gmt_modified")
    @LastModifiedDate
    private Date gmtModified;

    @PersistenceConstructor
    public DocumentMicrosoftExcelOldEntity(String title, Date created, Date modified, Date lastAccess, String path, String appName, int doc_parts){
        this.title = title;
        this.created = created;
        this.modified = modified;
        this.lastAccess = lastAccess;
        this.path = path;
        this.appName = appName;
        this.doc_parts = doc_parts;
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

    public Date getLastAccess(){
        return lastAccess;
    }

    public void setLastAccess(Date lastAccess){
        this.lastAccess = lastAccess;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getDoc_parts() {
        return doc_parts;
    }

    public void setDoc_parts(int doc_parts) {
        this.doc_parts = doc_parts;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }
}
