package datasource.entity.fileSystemCore.illustrationLayer;

import datasource.entity.fileSystemCore.fileSystemInformationLayer.FilesystemInfMainEntity;
import datasource.entity.userManagementCore.UserEntity;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "illustration")
@Inheritance(strategy = InheritanceType.JOINED)
public class IllustrationEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_OWNER_ID_ILLUSTRATION"))
    private FilesystemInfMainEntity filesystemInfMainEntity;

    @Column(name = "illustration_name")
    private String illustrationName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    public IllustrationEntity(){
    }

    public IllustrationEntity(String illustrationName, Date gmtCreate, Date gmtModified){
        this.illustrationName = illustrationName;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public UUID getId(){
        return id;
    }

    public void setId(UUID id){
        this.id = id;
    }

    public FilesystemInfMainEntity getFilesystemInfMainEntity(){ return filesystemInfMainEntity; }

    public String getIllustrationName(){
        return illustrationName;
    }

    public void setIllustrationName(String illustrationName){
        this.illustrationName = illustrationName;
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
