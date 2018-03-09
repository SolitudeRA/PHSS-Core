package datasource.entity.fileSystemCore.floderLayer;

import datasource.entity.fileSystemCore.fileSystemInformationLayer.FilesystemInfMainEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "folder")
public class FolderEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_OWNER_ID_FOLDER"))
    private FilesystemInfMainEntity filesystemInfMainEntity;

    @Column(name = "access_level")
    private Integer accessLevel;

    @Column(name = "folder_name")
    private String folderName;

    @Column(name = "space")
    private Integer space;

    @Column(name = "file_count")
    private Integer fileCount;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    public FolderEntity(){
    }

    public FolderEntity(FilesystemInfMainEntity filesystemInfMainEntity, Integer accessLevel, String folderName, Integer space, Integer fileCount, Date gmtCreate, Date gmtModified){
        this.filesystemInfMainEntity = filesystemInfMainEntity;
        this.accessLevel = accessLevel;
        this.folderName = folderName;
        this.space = space;
        this.fileCount = fileCount;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public UUID getId(){
        return id;
    }

    public void setId(UUID id){
        this.id = id;
    }

    public FilesystemInfMainEntity getFilesystemInfMainEntity(){
        return filesystemInfMainEntity;
    }

    public Integer getAccessLevel(){
        return accessLevel;
    }

    public void setAccessLevel(Integer accessLevel){
        this.accessLevel = accessLevel;
    }

    public String getFolderName(){
        return folderName;
    }

    public void setFolderName(String folderName){
        this.folderName = folderName;
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
