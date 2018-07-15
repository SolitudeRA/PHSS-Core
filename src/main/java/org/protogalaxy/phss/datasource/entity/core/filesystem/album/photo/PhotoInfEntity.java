package org.protogalaxy.phss.datasource.entity.core.filesystem.album.photo;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "photo_inf")
public class PhotoInfEntity {
    @Id
    private UUID photoId;

    @Column(name = "x_resolution")
    private Integer xResolution;

    @Column(name = "y_resolution")
    private Integer yResolution;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "model")
    private String model;

    @Column(name = "date_time")
    private Date dateTime;

    @Column(name = "compression")
    private String compression;

    @Column(name = "exposure_time")
    private String exposureTime;

    @Column(name = "f_number")
    private Float fNumber;

    @Column(name = "flash")
    private Float flash;

    @Column(name = "focal_length")
    private String focalLength;

    @Column(name = "color_space")
    private String colorSpace;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    @OneToOne
    @MapsId
    @JoinColumn(name = "photo_id")
    private PhotoEntity photoEntity;

    public PhotoInfEntity() {
    }

    public PhotoInfEntity(Integer xResolution, Integer yResolution, String manufacturer, String model, Date dateTime, String compression, String exposureTime, Float fNumber, Float flash, String focalLength, String colorSpace) {
        this.xResolution = xResolution;
        this.yResolution = yResolution;
        this.manufacturer = manufacturer;
        this.model = model;
        this.dateTime = dateTime;
        this.compression = compression;
        this.exposureTime = exposureTime;
        this.fNumber = fNumber;
        this.flash = flash;
        this.focalLength = focalLength;
        this.colorSpace = colorSpace;
    }

    public UUID getPhotoId() {
        return photoId;
    }

    public void setPhotoId(UUID photoId) {
        this.photoId = photoId;
    }

    public Integer getxResolution() {
        return xResolution;
    }

    public void setxResolution(Integer xResolution) {
        this.xResolution = xResolution;
    }

    public Integer getyResolution() {
        return yResolution;
    }

    public void setyResolution(Integer yResolution) {
        this.yResolution = yResolution;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getCompression() {
        return compression;
    }

    public void setCompression(String compression) {
        this.compression = compression;
    }

    public String getExposureTime() {
        return exposureTime;
    }

    public void setExposureTime(String exposureTime) {
        this.exposureTime = exposureTime;
    }

    public Float getfNumber() {
        return fNumber;
    }

    public void setfNumber(Float fNumber) {
        this.fNumber = fNumber;
    }

    public Float getFlash() {
        return flash;
    }

    public void setFlash(Float flash) {
        this.flash = flash;
    }

    public String getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(String focalLength) {
        this.focalLength = focalLength;
    }

    public String getColorSpace() {
        return colorSpace;
    }

    public void setColorSpace(String colorSpace) {
        this.colorSpace = colorSpace;
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

    public PhotoEntity getPhotoEntity() {
        return photoEntity;
    }

    public void setPhotoEntity(PhotoEntity photoEntity) {
        this.photoEntity = photoEntity;
    }
}
