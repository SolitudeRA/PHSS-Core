package datasource.entity.fileSystemCore.fileSystemInformationLayer;

import datasource.entity.userManagementCore.UserEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "filesystem_inf_space")
public class FilesystemInfSpaceEntity {
    @Id
    @Column(name = "owner_id")
    private UUID ownerId;

    @Column(name = "space")
    private Integer space;

    @Column(name = "file_count")
    private Integer fileCount;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    @OneToOne
    @MapsId
    private UserEntity userEntity;

    public FilesystemInfSpaceEntity(){
    }

    public FilesystemInfSpaceEntity(Integer space, Integer fileCount, Date gmtCreate, Date gmtModified){
        this.space = space;
        this.fileCount = fileCount;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public UUID getOwnerId(){
        return ownerId;
    }

    public void setOwnerId(UUID ownerId){
        this.ownerId = ownerId;
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

    public UserEntity getUserEntity(){
        return userEntity;
    }
}
