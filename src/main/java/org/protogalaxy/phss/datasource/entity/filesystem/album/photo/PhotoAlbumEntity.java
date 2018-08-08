package org.protogalaxy.phss.datasource.entity.filesystem.album.photo;

import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemMainEntity;
import org.hibernate.annotations.CreationTimestamp;

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
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_OWNER_ID_PHOTO"))
    private FileSystemMainEntity filesystemInfMainEntity;

    @Column(name = "album_name")
    private String albumName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    public PhotoAlbumEntity() {
    }

    public PhotoAlbumEntity(String albumName) {
        this.albumName = albumName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public FileSystemMainEntity getFilesystemInfMainEntity() {
        return filesystemInfMainEntity;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
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
}
