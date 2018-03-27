package datasource.entity.core.filesystem.main;

import datasource.entity.core.user.UserEntity;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@DynamicInsert
@Table(name = "filesystem_main")
public class FileSystemMainEntity {
    @Id
    private UUID ownerId;

    @Column(name = "album_count")
    @ColumnDefault("0")
    private Integer albumCount;

    @Column(name = "track_count")
    @ColumnDefault("0")
    private Integer trackCount;

    @Column(name = "book_count")
    @ColumnDefault("0")
    private Integer bookCount;

    @Column(name = "illustration_count")
    @ColumnDefault("0")
    private Integer illustrationCount;

    @Column(name = "movie_count")
    @ColumnDefault("0")
    private Integer movieCount;

    @Column(name = "photo_count")
    @ColumnDefault("0")
    private Integer photoCount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    @OneToOne
    @MapsId
    @JoinColumn(name = "owner_id")
    private UserEntity userEntity;

    public FileSystemMainEntity() {
    }

    public FileSystemMainEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public FileSystemMainEntity(Integer albumCount, Integer trackCount, Integer bookCount, Integer illustrationCount, Integer movieCount, Integer photoCount) {
        this.albumCount = albumCount;
        this.trackCount = trackCount;
        this.bookCount = bookCount;
        this.illustrationCount = illustrationCount;
        this.movieCount = movieCount;
        this.photoCount = photoCount;
    }

    public Integer getAlbumCount() {
        return albumCount;
    }

    public void setAlbumCount(Integer albumCount) {
        this.albumCount = albumCount;
    }

    public Integer getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(Integer trackCount) {
        this.trackCount = trackCount;
    }

    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }

    public Integer getIllustrationCount() {
        return illustrationCount;
    }

    public void setIllustrationCount(Integer illustrationCount) {
        this.illustrationCount = illustrationCount;
    }

    public Integer getMovieCount() {
        return movieCount;
    }

    public void setMovieCount(Integer movieCount) {
        this.movieCount = movieCount;
    }

    public Integer getPhotoCount() {
        return photoCount;
    }

    public void setPhotoCount(Integer photoCount) {
        this.photoCount = photoCount;
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

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }
}
