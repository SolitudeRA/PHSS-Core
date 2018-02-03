package DAO.entity.fileSystemCore.musicAlbumsLayer;

import javax.persistence.*;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 * TODO: 2018/1/26 Entity Design
 */

@Entity
@Table(name = "track_inf")
public class MusicTrackInfEntity {
    @Id
    @ManyToOne
    @Column(name = "tracks_id")
    private MusicTrackEntity trackId;

    @Column(name = "artist")
    private String artist;

    @Column(name = "album_artist")
    private String albumArtist;

    @Column(name = "composer")
    private String composer;

    @Column(name = "genre")
    private String genre;

    @Column(name = "playback_count")
    private Integer playbackCount;

    public MusicTrackInfEntity() {
    }

    public MusicTrackEntity getTrackId() {
        return trackId;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbumArtist() {
        return albumArtist;
    }

    public void setAlbumArtist(String albumArtist) {
        this.albumArtist = albumArtist;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getPlaybackCount() {
        return playbackCount;
    }

    public void setPlaybackCount(Integer playbackCount) {
        this.playbackCount = playbackCount;
    }
}
