package org.protogalaxy.phss.datasource.entity.core.filesystem.document;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.protogalaxy.phss.datasource.entity.core.filesystem.main.FileSystemMainEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "document")
public class DocumentEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_OWNER_ID_DOCUMENT"))
    private FileSystemMainEntity filesystemInfMainEntity;

    @Column(name = "document_name")
    private String documentName;

    @Column(name = "type")
    private String type;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified")
    @UpdateTimestamp
    private Date gmtModified;

    @JsonManagedReference
    @OneToOne(mappedBy = "documentEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private DocumentInfEntity documentInfEntity;

    public DocumentEntity() {
    }

    public DocumentEntity(FileSystemMainEntity filesystemInfMainEntity, String documentName) {
        this.filesystemInfMainEntity = filesystemInfMainEntity;
        this.documentName = documentName;
    }

    public DocumentEntity(FileSystemMainEntity filesystemInfMainEntity, String documentName, String type) {
        this.filesystemInfMainEntity = filesystemInfMainEntity;
        this.documentName = documentName;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public FileSystemMainEntity getFilesystemInfMainEntity() {
        return filesystemInfMainEntity;
    }

    public void setFilesystemInfMainEntity(FileSystemMainEntity filesystemInfMainEntity) {
        this.filesystemInfMainEntity = filesystemInfMainEntity;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public DocumentInfEntity getDocumentInfEntity() {
        return documentInfEntity;
    }

    public void setDocumentInfEntity(DocumentInfEntity documentInfEntity) {
        this.documentInfEntity = documentInfEntity;
    }
}
