package datasource.entity.fileSystemCore.documentsLayer;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "document_inf")
@PrimaryKeyJoinColumn(name = "document_id")
public class DocumentInfEntity extends DocumentEntity {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    public DocumentInfEntity(){
    }

    public DocumentInfEntity(Date gmtCreate, Date gmtModified){
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    @Override
    public Date getGmtCreate(){
        return gmtCreate;
    }

    @Override
    public void setGmtCreate(Date gmtCreate){
        this.gmtCreate = gmtCreate;
    }

    @Override
    public Date getGmtModified(){
        return gmtModified;
    }

    @Override
    public void setGmtModified(Date gmtModified){
        this.gmtModified = gmtModified;
    }
}
