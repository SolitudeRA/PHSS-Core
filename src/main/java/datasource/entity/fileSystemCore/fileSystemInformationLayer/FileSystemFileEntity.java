package datasource.entity.fileSystemCore.fileSystemInformationLayer;

import datasource.entity.userManagementCore.UserEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "filesystem_file")
public class FilesystemFileEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_USER_ID"))
    private UserEntity userEntity;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    public FilesystemFileEntity(){
    }

    public FilesystemFileEntity(String name, String type, Date gmtCreate, Date gmtModified){
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

    public UserEntity getUserEntity(){
        return userEntity;
    }

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
