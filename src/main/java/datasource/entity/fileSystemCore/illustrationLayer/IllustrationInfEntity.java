package datasource.entity.fileSystemCore.illustrationLayer;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "illustration_inf")
@PrimaryKeyJoinColumn(name = "illustration_id")
public class IllustrationInfEntity extends IllustrationEntity {
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

    public IllustrationInfEntity(){
    }

    public IllustrationInfEntity(Integer xResolution, Integer yResolution, String illustrator, Float rating, String pixivLink, Date gmtCreate, Date gmtModified){
        this.xResolution = xResolution;
        this.yResolution = yResolution;
        this.illustrator = illustrator;
        this.rating = rating;
        this.pixivLink = pixivLink;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public Integer getxResolution(){
        return xResolution;
    }

    public void setxResolution(Integer xResolution){
        this.xResolution = xResolution;
    }

    public Integer getyResolution(){
        return yResolution;
    }

    public void setyResolution(Integer yResolution){
        this.yResolution = yResolution;
    }

    public String getIllustrator(){
        return illustrator;
    }

    public void setIllustrator(String illustrator){
        this.illustrator = illustrator;
    }

    public Float getRating(){
        return rating;
    }

    public void setRating(Float rating){
        this.rating = rating;
    }

    public String getPixivLink(){
        return pixivLink;
    }

    public void setPixivLink(String pixivLink){
        this.pixivLink = pixivLink;
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
}
