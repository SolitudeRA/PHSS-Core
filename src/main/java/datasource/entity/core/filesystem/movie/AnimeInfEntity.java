package datasource.entity.core.filesystem.movie;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "anime_inf")
public class AnimeInfEntity {
    @Id
    private UUID animeId;

    @Lob
    @Column(name = "poster")
    private Blob poster;

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

    @Column(name = "season_time")
    private String season_time;

    @Column(name = "season_anime")
    private String seasonAnime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    @OneToOne
    @MapsId
    @JoinColumn(name = "anime_id")
    private AnimeEntity animeEntity;

    public AnimeInfEntity() {
    }

    public AnimeInfEntity(Blob poster, String gensaku, String gensakuIrasuto, String seiyuu, String kantoku, String ongaku, Date releaseYear, String season_time, String seasonAnime) {
        this.poster = poster;
        this.gensaku = gensaku;
        this.gensakuIrasuto = gensakuIrasuto;
        this.seiyuu = seiyuu;
        this.kantoku = kantoku;
        this.ongaku = ongaku;
        this.releaseYear = releaseYear;
        this.season_time = season_time;
        this.seasonAnime = seasonAnime;
    }

    public UUID getAnimeId() {
        return animeId;
    }

    public void setAnimeId(UUID animeId) {
        this.animeId = animeId;
    }

    public Blob getPoster() {
        return poster;
    }

    public void setPoster(Blob poster) {
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

    public String getSeason_time() {
        return season_time;
    }

    public void setSeason_time(String season_time) {
        this.season_time = season_time;
    }

    public String getSeasonAnime() {
        return seasonAnime;
    }

    public void setSeasonAnime(String seasonAnime) {
        this.seasonAnime = seasonAnime;
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

    public AnimeEntity getAnimeEntity() {
        return animeEntity;
    }

    public void setAnimeEntity(AnimeEntity animeEntity) {
        this.animeEntity = animeEntity;
    }
}
