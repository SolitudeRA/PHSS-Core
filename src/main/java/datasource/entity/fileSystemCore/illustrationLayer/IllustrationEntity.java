package datasource.entity.fileSystemCore.illustrationLayer;

import datasource.entity.userManagementCore.UserEntity;
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
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_USER_ID"))
    private UserEntity userEntity;

    @Column(name = "illustration_name")
    private String illustrationName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    @OneToOne(mappedBy = "illustrationEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private IllustrationInfGenreEntity illustrationInfGenreEntity;

    @OneToOne(mappedBy = "illustrationEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private IllustrationInfEntity illustrationInfEntity;

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

    public UserEntity getUserEntity(){
        return userEntity;
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

    public void setGmtCreate(Date gmtCreate){
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified(){
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified){
        this.gmtModified = gmtModified;
    }

    public IllustrationInfGenreEntity getIllustrationInfGenreEntity(){
        return illustrationInfGenreEntity;
    }

    public IllustrationInfEntity getIllustrationInfEntity(){
        return illustrationInfEntity;
    }
}
