package org.protogalaxy.phss.datasource.entity.filesystem.album.photo;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "album_photo_inf")
public class PhotoAlbumInfEntity {
    @Id
    private UUID albumId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    @OneToOne
    @MapsId
    @JoinColumn(name = "album_id")
    private PhotoAlbumEntity photoAlbumEntity;

    public PhotoAlbumInfEntity() {
    }

    public PhotoAlbumInfEntity(Date gmtCreate, Date gmtModified) {
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public UUID getAlbumId() {
        return albumId;
    }

    public void setAlbumId(UUID albumId) {
        this.albumId = albumId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public PhotoAlbumEntity getPhotoAlbumEntity() {
        return photoAlbumEntity;
    }

    public void setPhotoAlbumEntity(PhotoAlbumEntity photoAlbumEntity) {
        this.photoAlbumEntity = photoAlbumEntity;
    }
}
