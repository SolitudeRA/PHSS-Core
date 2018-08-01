package org.protogalaxy.phss.datasource.entity.core.filesystem.document;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.protogalaxy.phss.datasource.entity.core.filesystem.main.FileSystemMainEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "document_microsoft_excel_old")
public class DocumentMicrosoftExcelOldEntity {
    @Id
    @GeneratedValue
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_OWNER_ID_DOCUMENT_MICROSOFT_EXCEL_OLD"))
    private FileSystemMainEntity fileSystemMainEntity;

    @Column(name = "author")
    private String author;

    @Column(name = "last_author")
    private String lastAuthor;

    @Column(name = "app_name")
    private String appName;

    @Column(name = "create_dtm")
    private Date createDtm;

    @Column(name = "last_save_dtm")
    private Date lastSaveDtm;

    @Column(name = "doc_parts")
    private int doc_parts;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified")
    @UpdateTimestamp
    private Date gmtModified;

    public DocumentMicrosoftExcelOldEntity() {
    }

    public DocumentMicrosoftExcelOldEntity(FileSystemMainEntity fileSystemMainEntity, String author, String lastAuthor, String appName, Date createDtm, Date lastSaveDtm, int doc_parts) {
        this.fileSystemMainEntity = fileSystemMainEntity;
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

    public FileSystemMainEntity getFileSystemMainEntity() {
        return fileSystemMainEntity;
    }

    public void setFileSystemMainEntity(FileSystemMainEntity fileSystemMainEntity) {
        this.fileSystemMainEntity = fileSystemMainEntity;
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
