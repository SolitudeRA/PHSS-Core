package datasource.entity.fileSystemCore.fileSystemInformationLayer;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "filesystem_inf_space")
public class FilesystemInfSpaceEntity extends FilesystemInfMainEntity{
    @Column(name = "space")
    private Integer space;

    @Column(name = "file_count")
    private Integer fileCount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    public FilesystemInfSpaceEntity(){
    }

    public FilesystemInfSpaceEntity(Integer space, Integer fileCount, Date gmtCreate, Date gmtModified){
        this.space = space;
        this.fileCount = fileCount;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public Integer getSpace(){
        return space;
    }

    public void setSpace(Integer space){
        this.space = space;
    }

    public Integer getFileCount(){
        return fileCount;
    }

    public void setFileCount(Integer fileCount){
        this.fileCount = fileCount;
    }

    public Date getGmtCreate(){
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate){
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified(){
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified){
        this.gmtModified = gmtModified;
    }
}
