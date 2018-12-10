package org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music;

import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackEntity;
import org.springframework.hateoas.ResourceSupport;

import java.time.Duration;
import java.util.List;

public class MusicTrackResource extends ResourceSupport {
    private String title;

    private String album;

    private String artist;

    private String location;

    private String albumArtist;

    private String composer;

    private String releaseYear;

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

    private String lastPlayed;

    private String dateAdded;

    private String dateModified;

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
        if (musicTrackEntity.getTrackInformation().getLastPlayed() != null) {
            this.lastPlayed = musicTrackEntity.getTrackInformation().getLastPlayed().toString();
        } else {
            this.lastPlayed = null;
        }
        this.dateAdded = musicTrackEntity.getDateAdded().toString();
        this.dateModified = musicTrackEntity.getDateModified().toString();
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

    public String getReleaseYear() {
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

    public String getLastPlayed() {
        return lastPlayed;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public String getDateModified() {
        return dateModified;
    }
}
