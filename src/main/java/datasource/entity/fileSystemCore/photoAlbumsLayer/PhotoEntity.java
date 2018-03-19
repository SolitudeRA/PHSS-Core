package datasource.entity.fileSystemCore.photoAlbumsLayer;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "photo")
public class PhotoEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "album_id", foreignKey = @ForeignKey(name = "FK_ALBUM_ID"))
    private PhotoAlbumEntity photoAlbumEntity;

    @Column(name = "photo_name")
    private String photoName;

    public PhotoEntity() {
    }

    public PhotoEntity(String photoName) {
        this.photoName = photoName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PhotoAlbumEntity getPhotoAlbumEntity() {
        return photoAlbumEntity;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }
}
