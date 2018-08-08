package org.protogalaxy.phss.datasource.entity.filesystem.illustration;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "illustration_inf")
public class IllustrationInfEntity {
    @Id
    private UUID illustrationId;

    @Column(name = "x_resolution")
    private Integer xResolution;

    @Column(name = "y_resolution")
    private Integer yResolution;

    @Column(name = "illustrator")
    private String illustrator;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "pixiv_link")
    private String pixivLink;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    @OneToOne
    @MapsId
    @JoinColumn(name = "illustration_id")
    private IllustrationEntity illustrationEntity;

    public IllustrationInfEntity() {
    }

    public IllustrationInfEntity(Integer xResolution, Integer yResolution, String illustrator, Float rating, String pixivLink) {
        this.xResolution = xResolution;
        this.yResolution = yResolution;
        this.illustrator = illustrator;
        this.rating = rating;
        this.pixivLink = pixivLink;
    }

    public UUID getIllustrationId() {
        return illustrationId;
    }

    public void setIllustrationId(UUID illustrationId) {
        this.illustrationId = illustrationId;
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

    public String getIllustrator() {
        return illustrator;
    }

    public void setIllustrator(String illustrator) {
        this.illustrator = illustrator;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getPixivLink() {
        return pixivLink;
    }

    public void setPixivLink(String pixivLink) {
        this.pixivLink = pixivLink;
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

    public IllustrationEntity getIllustrationEntity() {
        return illustrationEntity;
    }

    public void setIllustrationEntity(IllustrationEntity illustrationEntity) {
        this.illustrationEntity = illustrationEntity;
    }
}
