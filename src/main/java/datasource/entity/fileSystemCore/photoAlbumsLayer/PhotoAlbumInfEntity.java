package datasource.entity.fileSystemCore.photoAlbumsLayer;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "album_photo_inf")
public class PhotoAlbumInfEntity {
    @Id
    @Column(name = "album_id")
    private UUID albumId;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    @OneToOne
    @MapsId
    private PhotoAlbumEntity photoAlbumEntity;

    public PhotoAlbumInfEntity(){
    }

    public PhotoAlbumInfEntity(Date gmtCreate, Date gmtModified){
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public UUID getAlbumId(){
        return albumId;
    }

    public void setAlbumId(UUID albumId){
        this.albumId = albumId;
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

    public PhotoAlbumEntity getPhotoAlbumEntity(){
        return photoAlbumEntity;
    }
}
