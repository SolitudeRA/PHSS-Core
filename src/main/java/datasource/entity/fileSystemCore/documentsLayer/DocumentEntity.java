package datasource.entity.fileSystemCore.documentsLayer;

import datasource.entity.fileSystemCore.fileSystemInformationLayer.FileSystemInfMainEntity;
import org.hibernate.annotations.CreationTimestamp;

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
    private FileSystemInfMainEntity filesystemInfMainEntity;

    @Column(name = "document_name")
    private String documentName;

    @Column(name = "type")
    private String type;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    public DocumentEntity() {
    }

    public DocumentEntity(String documentName) {
        this.documentName = documentName;
    }

    public DocumentEntity(String documentName, String type, Date gmtCreate, Date gmtModified) {
        this.documentName = documentName;
        this.type = type;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public FileSystemInfMainEntity getFilesystemInfMainEntity() {
        return filesystemInfMainEntity;
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

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
