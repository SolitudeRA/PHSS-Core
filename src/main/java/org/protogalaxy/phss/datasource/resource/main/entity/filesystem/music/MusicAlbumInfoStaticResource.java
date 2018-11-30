package org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music;

import org.joda.time.LocalDateTime;
import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicAlbumInfoStaticEntity;
import org.springframework.hateoas.ResourceSupport;

import java.time.Duration;
import java.util.List;

public class MusicAlbumInfoStaticResource extends ResourceSupport {
    private String artwork;

    private String composer;

    private Integer releaseYear;

    private Duration durationTotal;

    private Integer trackTotal;

    private Integer discNumber;

    private Integer discTotal;

    private List<String> genre;

    private Float score;

    private Boolean love;

    private Boolean dislike;

    private String comment;

    private Long sizeTotal;

    private String dateAdded;

    private String dateModified;

    public MusicAlbumInfoStaticResource() {
    }

    public MusicAlbumInfoStaticResource(MusicAlbumInfoStaticEntity musicAlbumInfoStaticEntity) {
        this.artwork = musicAlbumInfoStaticEntity.getArtwork();
        this.composer = musicAlbumInfoStaticEntity.getComposer();
        this.releaseYear = musicAlbumInfoStaticEntity.getReleaseYear();
        this.durationTotal = musicAlbumInfoStaticEntity.getDurationTotal();
        this.trackTotal = musicAlbumInfoStaticEntity.getTrackTotal();
        this.discNumber = musicAlbumInfoStaticEntity.getDiscNumber();
        this.discTotal = musicAlbumInfoStaticEntity.getDiscTotal();
        this.genre = musicAlbumInfoStaticEntity.getGenre();
        this.score = musicAlbumInfoStaticEntity.getScore();
        this.love = musicAlbumInfoStaticEntity.getLove();
        this.dislike = musicAlbumInfoStaticEntity.getDislike();
        this.comment = musicAlbumInfoStaticEntity.getComment();
        this.sizeTotal = musicAlbumInfoStaticEntity.getSizeTotal();
        this.dateAdded = musicAlbumInfoStaticEntity.getDateAdded().toString();
        this.dateModified = musicAlbumInfoStaticEntity.getDateModified().toString();
    }

    public MusicAlbumInfoStaticResource(String artwork, String composer, Integer releaseYear, Duration durationTotal, Integer trackTotal, Integer discNumber, Integer discTotal, List<String> genre, Float score, Boolean love, Boolean dislike, String comment, Long sizeTotal, LocalDateTime dateAdded, LocalDateTime dateModified) {
        this.artwork = artwork;
        this.composer = composer;
        this.releaseYear = releaseYear;
        this.durationTotal = durationTotal;
        this.trackTotal = trackTotal;
        this.discNumber = discNumber;
        this.discTotal = discTotal;
        this.genre = genre;
        this.score = score;
        this.love = love;
        this.dislike = dislike;
        this.comment = comment;
        this.sizeTotal = sizeTotal;
        this.dateAdded = dateAdded.toString();
        this.dateModified = dateModified.toString();
    }

    public String getArtwork() {
        return artwork;
    }

    public String getComposer() {
        return composer;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public Duration getDurationTotal() {
        return durationTotal;
    }

    public Integer getTrackTotal() {
        return trackTotal;
    }

    public Integer getDiscNumber() {
        return discNumber;
    }

    public Integer getDiscTotal() {
        return discTotal;
    }

    public List<String> getGenre() {
        return genre;
    }

    public Float getScore() {
        return score;
    }

    public Boolean getLove() {
        return love;
    }

    public Boolean getDislike() {
        return dislike;
    }

    public String getComment() {
        return comment;
    }

    public Long getSizeTotal() {
        return sizeTotal;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public String getDateModified() {
        return dateModified;
    }
}
