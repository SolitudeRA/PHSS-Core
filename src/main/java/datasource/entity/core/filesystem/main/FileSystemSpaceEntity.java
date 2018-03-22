package datasource.entity.core.filesystem.main;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@DynamicInsert
@Table(name = "filesystem_space")
public class FileSystemSpaceEntity {
    @Id
    private UUID fileSystemId;

    @Column(name = "space")
    @ColumnDefault("0")
    private Integer space;

    @Column(name = "file_count")
    @ColumnDefault("0")
    private Integer fileCount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    @OneToOne
    @MapsId
    @JoinColumn(name = "filesystem_id")
    private FileSystemMainEntity fileSystemMainEntity;

    public FileSystemSpaceEntity() {
    }

    public FileSystemSpaceEntity(FileSystemMainEntity fileSystemMainEntity) {
        this.fileSystemMainEntity = fileSystemMainEntity;
    }

    public FileSystemSpaceEntity(Integer space, Integer fileCount, Date gmtCreate, Date gmtModified) {
        this.space = space;
        this.fileCount = fileCount;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
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

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public void setFileSystemMainEntity(FileSystemMainEntity fileSystemMainEntity) {
        this.fileSystemMainEntity = fileSystemMainEntity;
    }
}
