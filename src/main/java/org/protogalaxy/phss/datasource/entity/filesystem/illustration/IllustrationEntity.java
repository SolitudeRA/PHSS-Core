package org.protogalaxy.phss.datasource.entity.filesystem.illustration;

import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemMainEntity;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "illustration")
public class IllustrationEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_OWNER_ID_ILLUSTRATION"))
    private FileSystemMainEntity fileSystemMainEntity;

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

    public FileSystemMainEntity getFileSystemMainEntity() {
        return fileSystemMainEntity;
    }

    public String getIllustrationName(){
        return illustrationName;
    }

    public void setIllustrationName(String illustrationName){
        this.illustrationName = illustrationName;
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
