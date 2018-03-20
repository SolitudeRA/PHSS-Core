package datasource.entity.fileSystemCore.fileSystemInformationLayer;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "filesystem_file")
public class FileSystemFileEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_OWNER_ID_FILE"))
    private FileSystemInfMainEntity filesystemInfMainEntity;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    public FileSystemFileEntity(){
    }

    public FileSystemFileEntity(String name, String type, Date gmtCreate, Date gmtModified){
        this.name = name;
        this.type = type;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public UUID getId(){
        return id;
    }

    public void setId(UUID id){
        this.id = id;
    }

    public FileSystemInfMainEntity getFilesystemInfMainEntity(){ return filesystemInfMainEntity; }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
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
