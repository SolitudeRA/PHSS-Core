package datasource.entity.fileSystemCore.fileSystemInformationLayer;

import javax.persistence.*;
import java.util.Date;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 * TODO: 2018/1/26 Entity Design
 */

@Entity
@Table(name = "filesystem_inf_space")
public class FileSystemInfSpaceEntity {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private FileSystemInfMainEntity ownerId;

    @Column(name = "space")
    private Integer space;

    @Column(name = "file_count")
    private Integer fileCount;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    public FileSystemInfSpaceEntity() {
    }

    public FileSystemInfMainEntity getOwnerId() {
        return ownerId;
    }

    public Integer getSpace() {
        return space;
    }

    public void setSpace(Integer space) {
        this.space = space;
    }

    public Integer getFileCount() {
        return fileCount;
    }

    public void setFileCount(Integer fileCount) {
        this.fileCount = fileCount;
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
