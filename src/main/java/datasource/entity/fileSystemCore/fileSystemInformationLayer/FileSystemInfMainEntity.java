package datasource.entity.fileSystemCore.fileSystemInformationLayer;

import datasource.entity.userManagementCore.UserEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 * TODO: 2018/1/26 Entity Design
 */

@Entity
@Table(name = "filesystem_inf_main")
public class FileSystemInfMainEntity {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private UserEntity user;

    @Column(name = "album_count")
    private Integer albumCount;

    @Column(name = "track_count")
    private Integer trackCount;

    @Column(name = "book_count")
    private Integer bookCount;

    @Column(name = "illustration_count")
    private Integer illustrationCount;

    @Column(name = "movie_count")
    private Integer movieCount;

    @Column(name = "photo_count")
    private Integer photoCount;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    @OneToOne(mappedBy = "filesystemInfMain", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private FileSystemInfSpaceEntity fileSystemInfSpaceEntity;

    @OneToOne(mappedBy = "filesystemInfMain", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private FileSystemFileEntity fileSystemFileEntity;

    public FileSystemInfMainEntity() {
    }

    public FileSystemInfMainEntity(UserEntity user, Integer albumCount, Integer trackCount, Integer bookCount, Integer illustrationCount, Integer movieCount, Integer photoCount, Date gmtCreate, Date gmtModified) {
        this.user = user;
        this.albumCount = albumCount;
        this.trackCount = trackCount;
        this.bookCount = bookCount;
        this.illustrationCount = illustrationCount;
        this.movieCount = movieCount;
        this.photoCount = photoCount;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public UserEntity getUser() {
        return user;
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

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public FileSystemInfSpaceEntity getFileSystemInfSpaceEntity() {
        return fileSystemInfSpaceEntity;
    }

    public FileSystemFileEntity getFileSystemFileEntity() {
        return fileSystemFileEntity;
    }
}
