package datasource.entity.core.filesystem.album.music;

import datasource.entity.core.filesystem.main.FileSystemMainEntity;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 */

@Entity
@Table(name = "track")
public class MusicTrackEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "owner_id",foreignKey = @ForeignKey(name = "FK_TRACK_OWNER_ID"))
    private FileSystemMainEntity fileSystemMainEntity;

    @ManyToOne
    @JoinColumn(name = "album_id", foreignKey = @ForeignKey(name = "FK_TRACK_ALBUM_MUSIC_ID"))
    private MusicAlbumEntity musicAlbumEntity;

    @Column(name = "name")
    private String Name;

    @Column(name = "album")
    private String album;

    @Column(name = "artist")
    private String artist;

    @Column(name = "album_artist")
    private String albumArtist;

    public MusicTrackEntity() {
    }

    public MusicTrackEntity(String name) {
        Name = name;
    }

    public MusicTrackEntity(String name, String album, String artist, String albumArtist) {
        Name = name;
        this.album = album;
        this.artist = artist;
        this.albumArtist = albumArtist;
    }

    public MusicTrackEntity(MusicAlbumEntity musicAlbumEntity, String name, String album, String artist, String albumArtist) {
        this.musicAlbumEntity = musicAlbumEntity;
        Name = name;
        this.album = album;
        this.artist = artist;
        this.albumArtist = albumArtist;
    }

    public UUID getId() {
        return id;
    }

    public MusicAlbumEntity getMusicAlbumEntity() {
        return musicAlbumEntity;
    }

    public void setMusicAlbumEntity(MusicAlbumEntity musicAlbumEntity) {
        this.musicAlbumEntity = musicAlbumEntity;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
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
}
