package datasource.entity.fileSystemCore.photoAlbumsLayer;

import datasource.entity.userManagementCore.UserEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "album_phpto")
public class PhotoAlbumEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_USER_ID"))
    private UserEntity userEntity;

    @Column(name = "album_name")
    private String albumName;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    @OneToOne(mappedBy = "photoAlbumEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private PhotoAlbumInfEntity photoAlbumInfEntity;

    public PhotoAlbumEntity(){
    }

    public PhotoAlbumEntity(String albumName, Date gmtCreate, Date gmtModified){
        this.albumName = albumName;
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

    public String getAlbumName(){
        return albumName;
    }

    public void setAlbumName(String albumName){
        this.albumName = albumName;
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

    public PhotoAlbumInfEntity getPhotoAlbumInfEntity(){
        return photoAlbumInfEntity;
    }
}
