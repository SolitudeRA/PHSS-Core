package datasource.entity.fileSystemCore.fileSystemInformationLayer;

import javax.persistence.*;
import java.util.Date;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 * TODO: 2018/1/26 Entity Design
 */

@Entity
@Table(name = "filesystem_file")
public class FileSystemFileEntity {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private FileSystemInfMainEntity ownerId;

    @Column(name = "name")
    private String fileName;

    @Column(name = "type")
    private String type;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    public FileSystemFileEntity(String fileName, String type, Date gmtCreate, Date gmtModified) {
        this.fileName = fileName;
        this.type = type;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public FileSystemInfMainEntity getOwnerId() {
        return ownerId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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
}
