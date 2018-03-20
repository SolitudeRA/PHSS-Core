package datasource.entity.fileSystemCore.floderLayer;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "folder_ext")
public class FolderExtEntity{
    @Id
    private UUID folderId;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    @OneToOne
    @MapsId
    @JoinColumn(name = "folder_id")
    private FolderEntity folderEntity;

    public FolderExtEntity(){
    }

    public FolderExtEntity(Date gmtCreate, Date gmtModified){
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public Date getGmtCreate(){
        return gmtCreate;
    }

    public Date getGmtModified(){
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified){
        this.gmtModified = gmtModified;
    }
}
