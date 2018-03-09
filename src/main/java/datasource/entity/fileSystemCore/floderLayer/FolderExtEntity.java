package datasource.entity.fileSystemCore.floderLayer;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "folder_ext")
@PrimaryKeyJoinColumn(name = "folder_id")
public class FolderExtEntity extends FolderEntity {
    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    public FolderExtEntity(){
    }

    public FolderExtEntity(Date gmtCreate, Date gmtModified){
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
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
