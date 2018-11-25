package org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music;

import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicAlbumEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicAlbumInfoEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicAlbumInfoStaticEntity;
import org.springframework.hateoas.ResourceSupport;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

public class MusicAlbumResource extends ResourceSupport {
    private String title;
    private String artist;
    private String location;
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
    private Integer playbackCount;
    private Integer skipCount;
    private LocalDateTime lastPlayed;
    private ZonedDateTime dateAdded;
    private ZonedDateTime dateModified;

    public MusicAlbumResource() {
    }

    public MusicAlbumResource(MusicAlbumEntity musicAlbumEntity) {
        this.title = musicAlbumEntity.getTitle();
        this.artist = musicAlbumEntity.getArtist();
        this.location = musicAlbumEntity.getLocation();
        this.artwork = musicAlbumEntity.getAlbumInformationStatic().getArtwork();
        this.composer = musicAlbumEntity.getAlbumInformationStatic().getComposer();
        this.releaseYear = musicAlbumEntity.getAlbumInformationStatic().getReleaseYear();
        this.durationTotal = musicAlbumEntity.getAlbumInformationStatic().getDurationTotal();
        this.trackTotal = musicAlbumEntity.getAlbumInformationStatic().getTrackTotal();
        this.discNumber = musicAlbumEntity.getAlbumInformationStatic().getDiscNumber();
        this.discTotal = musicAlbumEntity.getAlbumInformationStatic().getDiscTotal();
        this.genre = musicAlbumEntity.getAlbumInformationStatic().getGenre();
        this.score = musicAlbumEntity.getAlbumInformationStatic().getScore();
        this.love = musicAlbumEntity.getAlbumInformationStatic().getLove();
        this.dislike = musicAlbumEntity.getAlbumInformationStatic().getDislike();
        this.comment = musicAlbumEntity.getAlbumInformationStatic().getComment();
        this.sizeTotal = musicAlbumEntity.getAlbumInformationStatic().getSizeTotal();
        this.playbackCount = musicAlbumEntity.getAlbumInformation().getPlaybackCount();
        this.skipCount = musicAlbumEntity.getAlbumInformation().getSkipCount();
        this.lastPlayed = musicAlbumEntity.getAlbumInformation().getLastPlayed();
        this.dateAdded = musicAlbumEntity.getDateAdded();
        this.dateModified = musicAlbumEntity.getDateModified();
    }

    public MusicAlbumResource(String title, String artist, String location, ZonedDateTime dateAdded, ZonedDateTime dateModified) {
        this.title = title;
        this.artist = artist;
        this.location = location;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    public MusicAlbumResource(String title, String artist, String location, MusicAlbumInfoEntity musicAlbumInf, MusicAlbumInfoStaticEntity musicAlbumInfStatic, ZonedDateTime dateAdded, ZonedDateTime dateModified) {
        this.title = title;
        this.artist = artist;
        this.location = location;
        this.artwork = musicAlbumInfStatic.getArtwork();
        this.composer = musicAlbumInfStatic.getComposer();
        this.releaseYear = musicAlbumInfStatic.getReleaseYear();
        this.durationTotal = musicAlbumInfStatic.getDurationTotal();
        this.trackTotal = musicAlbumInfStatic.getTrackTotal();
        this.discNumber = musicAlbumInfStatic.getDiscNumber();
        this.discTotal = musicAlbumInfStatic.getDiscTotal();
        this.genre = musicAlbumInfStatic.getGenre();
        this.score = musicAlbumInfStatic.getScore();
        this.love = musicAlbumInfStatic.getLove();
        this.dislike = musicAlbumInfStatic.getDislike();
        this.comment = musicAlbumInfStatic.getComment();
        this.sizeTotal = musicAlbumInfStatic.getSizeTotal();
        this.playbackCount = musicAlbumInf.getPlaybackCount();
        this.skipCount = musicAlbumInf.getSkipCount();
        this.lastPlayed = musicAlbumInf.getLastPlayed();
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getLocation() {
        return location;
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

    public Integer getPlaybackCount() {
        return playbackCount;
    }

    public Integer getSkipCount() {
        return skipCount;
    }

    public LocalDateTime getLastPlayed() {
        return lastPlayed;
    }

    public ZonedDateTime getDateAdded() {
        return dateAdded;
    }

    public ZonedDateTime getDateModified() {
        return dateModified;
    }
}
