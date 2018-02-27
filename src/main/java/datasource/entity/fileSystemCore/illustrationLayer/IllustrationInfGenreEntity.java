package datasource.entity.fileSystemCore.illustrationLayer;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "illustration_inf_genre")
public class IllustrationInfGenreEntity {
    @Id
    @Column(name = "illustration_id")
    private UUID illustrationId;

    @Column(name = "genre_1")
    private String genre_1;

    @Column(name = "genre_2")
    private String genre_2;

    @Column(name = "genre_3")
    private String genre_3;

    @Column(name = "genre_4")
    private String genre_4;

    @Column(name = "genre_5")
    private String genre_5;

    @Column(name = "genre_6")
    private String genre_6;

    @Column(name = "genre_7")
    private String genre_7;

    @Column(name = "genre_8")
    private String genre_8;

    @Column(name = "genre_9")
    private String genre_9;

    @Column(name = "genre_10")
    private String genre_10;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    @OneToOne
    @MapsId
    private IllustrationEntity illustrationEntity;

    public IllustrationInfGenreEntity(){
    }

    public IllustrationInfGenreEntity(String genre_1, String genre_2, String genre_3, String genre_4, String genre_5, String genre_6, String genre_7, String genre_8, String genre_9, String genre_10, Date gmtCreate, Date gmtModified){
        this.genre_1 = genre_1;
        this.genre_2 = genre_2;
        this.genre_3 = genre_3;
        this.genre_4 = genre_4;
        this.genre_5 = genre_5;
        this.genre_6 = genre_6;
        this.genre_7 = genre_7;
        this.genre_8 = genre_8;
        this.genre_9 = genre_9;
        this.genre_10 = genre_10;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public UUID getIllustrationId(){
        return illustrationId;
    }

    public void setIllustrationId(UUID illustrationId){
        this.illustrationId = illustrationId;
    }

    public String getGenre_1(){
        return genre_1;
    }

    public void setGenre_1(String genre_1){
        this.genre_1 = genre_1;
    }

    public String getGenre_2(){
        return genre_2;
    }

    public void setGenre_2(String genre_2){
        this.genre_2 = genre_2;
    }

    public String getGenre_3(){
        return genre_3;
    }

    public void setGenre_3(String genre_3){
        this.genre_3 = genre_3;
    }

    public String getGenre_4(){
        return genre_4;
    }

    public void setGenre_4(String genre_4){
        this.genre_4 = genre_4;
    }

    public String getGenre_5(){
        return genre_5;
    }

    public void setGenre_5(String genre_5){
        this.genre_5 = genre_5;
    }

    public String getGenre_6(){
        return genre_6;
    }

    public void setGenre_6(String genre_6){
        this.genre_6 = genre_6;
    }

    public String getGenre_7(){
        return genre_7;
    }

    public void setGenre_7(String genre_7){
        this.genre_7 = genre_7;
    }

    public String getGenre_8(){
        return genre_8;
    }

    public void setGenre_8(String genre_8){
        this.genre_8 = genre_8;
    }

    public String getGenre_9(){
        return genre_9;
    }

    public void setGenre_9(String genre_9){
        this.genre_9 = genre_9;
    }

    public String getGenre_10(){
        return genre_10;
    }

    public void setGenre_10(String genre_10){
        this.genre_10 = genre_10;
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

    public IllustrationEntity getIllustrationEntity(){
        return illustrationEntity;
    }
}
