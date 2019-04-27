package org.protogalaxy.phss.datasource.entity.filesystem;

import org.protogalaxy.phss.datasource.entity.account.AccountEntity;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@DynamicInsert
@Table(name = "filesystem_main")
public class FileSystemMainEntity {
    @Id
    private UUID ownerUUID;

    @Column(name = "album_count")
    private Integer albumCount;

    @Column(name = "track_count")
    private Integer trackCount;

    @Column(name = "anime_count")
    private Integer animeCount;

    @Column(name = "movie_count")
    private Integer movieCount;

    @Column(name = "video_count")
    private Integer videoCount;

    @Column(name = "book_count")
    private Integer bookCount;

    @Column(name = "document_count")
    private Integer documentCount;

    @Column(name = "illustration_count")
    private Integer illustrationCount;

    @Column(name = "photo_count")
    private Integer photoCount;

    @Column(name = "file_total")
    private Integer fileTotal;

    @Column(name = "space_available")
    private Long spaceAvailable;

    @Column(name = "space_total")
    private Long spaceTotal;

    @CreatedDate
    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @LastModifiedDate
    @Column(name = "date_modified")
    private LocalDateTime dateModified;

    @MapsId
    @OneToOne
    @JoinColumn(name = "owner_uuid")
    private AccountEntity accountEntity;

    public FileSystemMainEntity() {
    }

    public FileSystemMainEntity(AccountEntity accountEntity) {
        this.albumCount = 0;
        this.trackCount = 0;
        this.animeCount = 0;
        this.movieCount = 0;
        this.videoCount = 0;
        this.bookCount = 0;
        this.documentCount = 0;
        this.illustrationCount = 0;
        this.photoCount = 0;
        this.fileTotal = 0;
        this.accountEntity = accountEntity;
    }

    public UUID getOwnerUUID() {
        return ownerUUID;
    }

    public void setOwnerUUID(UUID ownerUUID) {
        this.ownerUUID = ownerUUID;
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

    public Integer getAnimeCount() {
        return animeCount;
    }

    public void setAnimeCount(Integer animeCount) {
        this.animeCount = animeCount;
    }

    public Integer getMovieCount() {
        return movieCount;
    }

    public void setMovieCount(Integer movieCount) {
        this.movieCount = movieCount;
    }

    public Integer getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(Integer videoCount) {
        this.videoCount = videoCount;
    }

    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }

    public Integer getDocumentCount() {
        return documentCount;
    }

    public void setDocumentCount(Integer documentCount) {
        this.documentCount = documentCount;
    }

    public Integer getIllustrationCount() {
        return illustrationCount;
    }

    public void setIllustrationCount(Integer illustrationCount) {
        this.illustrationCount = illustrationCount;
    }

    public Integer getPhotoCount() {
        return photoCount;
    }

    public void setPhotoCount(Integer photoCount) {
        this.photoCount = photoCount;
    }

    public Integer getFileTotal() {
        return fileTotal;
    }

    public void setFileTotal(Integer fileTotal) {
        this.fileTotal = fileTotal;
    }

    public Long getSpaceAvailable() {
        return spaceAvailable;
    }

    public void setSpaceAvailable(Long spaceAvailable) {
        this.spaceAvailable = spaceAvailable;
    }

    public Long getSpaceTotal() {
        return spaceTotal;
    }

    public void setSpaceTotal(Long spaceTotal) {
        this.spaceTotal = spaceTotal;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDateTime dateModified) {
        this.dateModified = dateModified;
    }

    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }
}
