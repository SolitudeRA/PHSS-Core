package org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music;

import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackInfoEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackInfoStaticEntity;
import org.springframework.hateoas.ResourceSupport;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

public class MusicTrackResource extends ResourceSupport {
    private String title;

    private String album;

    private String artist;

    private String location;

    private String albumArtist;

    private String composer;

    private Integer releaseYear;

    private Integer trackNumber;

    private Integer trackTotal;

    private Integer discNumber;

    private Integer discTotal;

    private Float score;

    private List<String> genre;

    private String artwork;

    private Boolean love;

    private Boolean dislike;

    private String comment;

    private String kind;

    private Duration duration;

    private Long size;

    private String bitRate;

    private String bitDepth;

    private String sampleRate;

    private Integer playbackCount;

    private Integer skipCount;

    private LocalDateTime lastPlayed;

    private ZonedDateTime dateAdded;

    private ZonedDateTime dateModified;

    public MusicTrackResource() {
    }

    public MusicTrackResource(MusicTrackEntity musicTrackEntity) {
        this.title = musicTrackEntity.getTitle();
        this.album = musicTrackEntity.getAlbum();
        this.artist = musicTrackEntity.getArtist();
        this.location = musicTrackEntity.getLocation();
        this.albumArtist = musicTrackEntity.getTrackInformationStatic().getAlbumArtist();
        this.composer = musicTrackEntity.getTrackInformationStatic().getComposer();
        this.releaseYear = musicTrackEntity.getTrackInformationStatic().getReleaseYear();
        this.trackNumber = musicTrackEntity.getTrackInformationStatic().getTrackNumber();
        this.trackTotal = musicTrackEntity.getTrackInformationStatic().getTrackTotal();
        this.discNumber = musicTrackEntity.getTrackInformationStatic().getDiscNumber();
        this.discTotal = musicTrackEntity.getTrackInformationStatic().getDiscTotal();
        this.score = musicTrackEntity.getTrackInformationStatic().getScore();
        this.genre = musicTrackEntity.getTrackInformationStatic().getGenre();
        this.artwork = musicTrackEntity.getTrackInformationStatic().getArtwork();
        this.love = musicTrackEntity.getTrackInformationStatic().getLove();
        this.dislike = musicTrackEntity.getTrackInformationStatic().getDislike();
        this.comment = musicTrackEntity.getTrackInformationStatic().getComment();
        this.kind = musicTrackEntity.getTrackInformationStatic().getKind();
        this.duration = musicTrackEntity.getTrackInformationStatic().getDuration();
        this.size = musicTrackEntity.getTrackInformationStatic().getSize();
        this.bitRate = musicTrackEntity.getTrackInformationStatic().getBitRate();
        this.bitDepth = musicTrackEntity.getTrackInformationStatic().getBitDepth();
        this.sampleRate = musicTrackEntity.getTrackInformationStatic().getSampleRate();
        this.playbackCount = musicTrackEntity.getTrackInformation().getPlaybackCount();
        this.skipCount = musicTrackEntity.getTrackInformation().getSkipCount();
        this.lastPlayed = musicTrackEntity.getTrackInformation().getLastPlayed();
        this.dateAdded = musicTrackEntity.getDateAdded();
        this.dateModified = musicTrackEntity.getDateModified();
    }

    public MusicTrackResource(String title, String album, String artist, String location, ZonedDateTime dateAdded, ZonedDateTime dateModified, MusicTrackInfoEntity trackInformation, MusicTrackInfoStaticEntity trackInformationStatic) {
        this.title = title;
        this.album = album;
        this.artist = artist;
        this.location = location;
        this.albumArtist = trackInformationStatic.getAlbumArtist();
        this.composer = trackInformationStatic.getComposer();
        this.releaseYear = trackInformationStatic.getReleaseYear();
        this.trackNumber = trackInformationStatic.getTrackNumber();
        this.trackTotal = trackInformationStatic.getTrackTotal();
        this.discNumber = trackInformationStatic.getDiscNumber();
        this.discTotal = trackInformationStatic.getDiscTotal();
        this.score = trackInformationStatic.getScore();
        this.genre = trackInformationStatic.getGenre();
        this.artwork = trackInformationStatic.getArtwork();
        this.love = trackInformationStatic.getLove();
        this.dislike = trackInformationStatic.getDislike();
        this.comment = trackInformationStatic.getComment();
        this.kind = trackInformationStatic.getKind();
        this.duration = trackInformationStatic.getDuration();
        this.size = trackInformationStatic.getSize();
        this.bitRate = trackInformationStatic.getBitRate();
        this.bitDepth = trackInformationStatic.getBitDepth();
        this.sampleRate = trackInformationStatic.getSampleRate();
        this.playbackCount = trackInformation.getPlaybackCount();
        this.skipCount = trackInformation.getSkipCount();
        this.lastPlayed = trackInformation.getLastPlayed();
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    public String getTitle() {
        return title;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }

    public String getLocation() {
        return location;
    }

    public String getAlbumArtist() {
        return albumArtist;
    }

    public String getComposer() {
        return composer;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public Integer getTrackNumber() {
        return trackNumber;
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

    public Float getScore() {
        return score;
    }

    public List<String> getGenre() {
        return genre;
    }

    public String getArtwork() {
        return artwork;
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

    public String getKind() {
        return kind;
    }

    public Duration getDuration() {
        return duration;
    }

    public Long getSize() {
        return size;
    }

    public String getBitRate() {
        return bitRate;
    }

    public String getBitDepth() {
        return bitDepth;
    }

    public String getSampleRate() {
        return sampleRate;
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
