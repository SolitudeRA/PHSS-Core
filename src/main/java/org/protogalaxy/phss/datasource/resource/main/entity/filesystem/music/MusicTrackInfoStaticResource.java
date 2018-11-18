package org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music;

import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackInfoStaticEntity;
import org.springframework.hateoas.ResourceSupport;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class MusicTrackInfoStaticResource extends ResourceSupport {
    private UUID trackUUID;

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

    private ZonedDateTime dateAdded;

    private ZonedDateTime dateModified;

    public MusicTrackInfoStaticResource() {
    }

    public MusicTrackInfoStaticResource(MusicTrackInfoStaticEntity musicTrackInfoStaticEntity) {
        this.trackUUID = musicTrackInfoStaticEntity.getTrackUUID();
        this.albumArtist = musicTrackInfoStaticEntity.getAlbumArtist();
        this.composer = musicTrackInfoStaticEntity.getComposer();
        this.releaseYear = musicTrackInfoStaticEntity.getReleaseYear();
        this.trackNumber = musicTrackInfoStaticEntity.getTrackNumber();
        this.trackTotal = musicTrackInfoStaticEntity.getTrackTotal();
        this.discNumber = musicTrackInfoStaticEntity.getDiscNumber();
        this.discTotal = musicTrackInfoStaticEntity.getDiscTotal();
        this.score = musicTrackInfoStaticEntity.getScore();
        this.genre = musicTrackInfoStaticEntity.getGenre();
        this.artwork = musicTrackInfoStaticEntity.getArtwork();
        this.love = musicTrackInfoStaticEntity.getLove();
        this.dislike = musicTrackInfoStaticEntity.getDislike();
        this.comment = musicTrackInfoStaticEntity.getComment();
        this.kind = musicTrackInfoStaticEntity.getKind();
        this.duration = musicTrackInfoStaticEntity.getDuration();
        this.size = musicTrackInfoStaticEntity.getSize();
        this.bitRate = musicTrackInfoStaticEntity.getBitRate();
        this.bitDepth = musicTrackInfoStaticEntity.getBitDepth();
        this.sampleRate = musicTrackInfoStaticEntity.getSampleRate();
        this.dateAdded = musicTrackInfoStaticEntity.getDateAdded();
        this.dateModified = musicTrackInfoStaticEntity.getDateModified();
    }

    public MusicTrackInfoStaticResource(UUID trackUUID, String albumArtist, String composer, Integer releaseYear, Integer trackNumber, Integer trackTotal, Integer discNumber, Integer discTotal, Float score, List<String> genre, String artwork, Boolean love, Boolean dislike, String comment, String kind, Duration duration, Long size, String bitRate, String bitDepth, String sampleRate, ZonedDateTime dateAdded, ZonedDateTime dateModified) {
        this.trackUUID = trackUUID;
        this.albumArtist = albumArtist;
        this.composer = composer;
        this.releaseYear = releaseYear;
        this.trackNumber = trackNumber;
        this.trackTotal = trackTotal;
        this.discNumber = discNumber;
        this.discTotal = discTotal;
        this.score = score;
        this.genre = genre;
        this.artwork = artwork;
        this.love = love;
        this.dislike = dislike;
        this.comment = comment;
        this.kind = kind;
        this.duration = duration;
        this.size = size;
        this.bitRate = bitRate;
        this.bitDepth = bitDepth;
        this.sampleRate = sampleRate;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    public UUID getTrackUUID() {
        return trackUUID;
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

    public ZonedDateTime getDateAdded() {
        return dateAdded;
    }

    public ZonedDateTime getDateModified() {
        return dateModified;
    }
}
