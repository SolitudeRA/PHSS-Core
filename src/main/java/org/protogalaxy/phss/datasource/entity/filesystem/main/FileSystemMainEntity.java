package org.protogalaxy.phss.datasource.entity.filesystem.main;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.protogalaxy.phss.datasource.entity.account.AccountEntity;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@DynamicInsert
@Table(name = "filesystem_main")
public class FileSystemMainEntity {
    @JsonIgnore
    @Id
    private int ownerId;

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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified")
    @UpdateTimestamp
    private Date gmtModified;

    @JsonBackReference
    @OneToOne
    @MapsId
    @JoinColumn(name = "owner_id")
    private AccountEntity accountEntity;

    public FileSystemMainEntity() {
    }

    public FileSystemMainEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }

    public FileSystemMainEntity(Integer albumCount, Integer trackCount, Integer bookCount, Integer illustrationCount, Integer movieCount, Integer photoCount) {
        this.albumCount = albumCount;
        this.trackCount = trackCount;
        this.bookCount = bookCount;
        this.illustrationCount = illustrationCount;
        this.movieCount = movieCount;
        this.photoCount = photoCount;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
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

    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }
}
