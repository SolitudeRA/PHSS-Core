package org.protogalaxy.phss.datasource.entity.filesystem.anime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "anime_inf")
public class AnimeInfEntity {
    @Id
    private UUID animeId;

    @Column(name = "poster")
    private String poster;

    @Column(name = "gensaku")
    private String gensaku;

    @Column(name = "gensaku_irasuto")
    private String gensakuIrasuto;

    @Column(name = "seiyuu")
    private String seiyuu;

    @Column(name = "kantoku")
    private String kantoku;

    @Column(name = "ongaku")
    private String ongaku;

    @Column(name = "release_year")
    private Date releaseYear;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreatedDate
    private Date gmtCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified")
    @LastModifiedDate
    private Date gmtModified;

    @OneToOne
    @MapsId
    @JoinColumn(name = "anime_id")
    private AnimeEntity animeEntity;

    public AnimeInfEntity() {
    }

    public AnimeInfEntity(String poster, String gensaku, String gensakuIrasuto, String seiyuu, String kantoku, String ongaku, Date releaseYear, AnimeEntity animeEntity) {
        this.poster = poster;
        this.gensaku = gensaku;
        this.gensakuIrasuto = gensakuIrasuto;
        this.seiyuu = seiyuu;
        this.kantoku = kantoku;
        this.ongaku = ongaku;
        this.releaseYear = releaseYear;
        this.animeEntity = animeEntity;
    }

    public UUID getAnimeId() {
        return animeId;
    }

    public void setAnimeId(UUID animeId) {
        this.animeId = animeId;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getGensaku() {
        return gensaku;
    }

    public void setGensaku(String gensaku) {
        this.gensaku = gensaku;
    }

    public String getGensakuIrasuto() {
        return gensakuIrasuto;
    }

    public void setGensakuIrasuto(String gensakuIrasuto) {
        this.gensakuIrasuto = gensakuIrasuto;
    }

    public String getSeiyuu() {
        return seiyuu;
    }

    public void setSeiyuu(String seiyuu) {
        this.seiyuu = seiyuu;
    }

    public String getKantoku() {
        return kantoku;
    }

    public void setKantoku(String kantoku) {
        this.kantoku = kantoku;
    }

    public String getOngaku() {
        return ongaku;
    }

    public void setOngaku(String ongaku) {
        this.ongaku = ongaku;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
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

    public AnimeEntity getAnimeEntity() {
        return animeEntity;
    }

    public void setAnimeEntity(AnimeEntity animeEntity) {
        this.animeEntity = animeEntity;
    }
}
