package me.protogalaxy.datasource.entity.core.filesystem.document;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "document_inf")
public class DocumentInfEntity {
    @Id
    private UUID documentId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    @OneToOne
    @MapsId
    @JoinColumn(name = "document_id")
    @JsonBackReference
    private DocumentEntity documentEntity;

    public DocumentInfEntity() {
    }

    public DocumentInfEntity(DocumentEntity documentEntity) {
        this.documentEntity = documentEntity;
    }

    public DocumentInfEntity(Date gmtCreate, Date gmtModified) {
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public UUID getDocumentId() {
        return documentId;
    }

    public void setDocumentId(UUID documentId) {
        this.documentId = documentId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public DocumentEntity getDocumentEntity() {
        return documentEntity;
    }

    public void setDocumentEntity(DocumentEntity documentEntity) {
        this.documentEntity = documentEntity;
    }
}
