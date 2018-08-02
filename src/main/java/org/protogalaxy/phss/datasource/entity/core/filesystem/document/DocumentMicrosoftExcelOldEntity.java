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
public class DocumentMicrosoftExcelOldEntity {
    @Id
    @GeneratedValue
    private UUID uuid;

    @Field("author")
    private String author;

    @Field("last_author")
    private String lastAuthor;

    @Field("app_name")
    private String appName;

    @Field("create_dtm")
    private Date createDtm;

    @Field("last_save_dtm")
    private Date lastSaveDtm;

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
    public DocumentMicrosoftExcelOldEntity(String author, String lastAuthor, String appName, Date createDtm, Date lastSaveDtm, int doc_parts) {
        this.author = author;
        this.lastAuthor = lastAuthor;
        this.appName = appName;
        this.createDtm = createDtm;
        this.lastSaveDtm = lastSaveDtm;
        this.doc_parts = doc_parts;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLastAuthor() {
        return lastAuthor;
    }

    public void setLastAuthor(String lastAuthor) {
        this.lastAuthor = lastAuthor;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Date getCreateDtm() {
        return createDtm;
    }

    public void setCreateDtm(Date createDtm) {
        this.createDtm = createDtm;
    }

    public Date getLastSaveDtm() {
        return lastSaveDtm;
    }

    public void setLastSaveDtm(Date lastSaveDtm) {
        this.lastSaveDtm = lastSaveDtm;
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
