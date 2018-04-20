package datasource.entity.core.filesystem.album.music;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import datasource.entity.core.filesystem.main.FileSystemMainEntity;

import javax.persistence.*;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 */

@Entity
@Table(name = "track")
public class MusicTrackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_TRACK_OWNER_ID"))
    private FileSystemMainEntity owner;

    @ManyToOne
    @JoinColumn(name = "album_id", foreignKey = @ForeignKey(name = "FK_TRACK_ALBUM_MUSIC_ID"))
    private MusicAlbumEntity musicAlbumEntity;

    @Column(name = "name")
    private String name;

    @Column(name = "album")
    private String album;

    @Column(name = "artist")
    private String artist;

    @Column(name = "album_artist")
    private String albumArtist;

    @JsonManagedReference
    @OneToOne(mappedBy = "musicTrackEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private MusicTrackInfEntity trackInformation;

    @JsonManagedReference
    @OneToOne(mappedBy = "musicTrackEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private MusicTrackInfStaticEntity trackInformationStatic;

    public MusicTrackEntity() {
    }

    public MusicTrackEntity(String name) {
        this.name = name;
    }

    public MusicTrackEntity(String name, String album, String artist, String albumArtist) {
        this.name = name;
        this.album = album;
        this.artist = artist;
        this.albumArtist = albumArtist;
    }

    public MusicTrackEntity(String name, String album, String artist, String albumArtist, MusicTrackInfEntity trackInformation, MusicTrackInfStaticEntity trackInformationStatic) {
        this.name = name;
        this.album = album;
        this.artist = artist;
        this.albumArtist = albumArtist;
        this.trackInformation = trackInformation;
        this.trackInformationStatic = trackInformationStatic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FileSystemMainEntity getOwner() {
        return owner;
    }

    public void setOwner(FileSystemMainEntity owner) {
        this.owner = owner;
    }

    public MusicAlbumEntity getMusicAlbumEntity() {
        return musicAlbumEntity;
    }

    public void setMusicAlbumEntity(MusicAlbumEntity musicAlbumEntity) {
        this.musicAlbumEntity = musicAlbumEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public MusicTrackInfEntity getTrackInformation() {
        return trackInformation;
    }

    public void setTrackInformation(MusicTrackInfEntity trackInformation) {
        this.trackInformation = trackInformation;
    }

    public MusicTrackInfStaticEntity getTrackInformationStatic() {
        return trackInformationStatic;
    }

    public void setTrackInformationStatic(MusicTrackInfStaticEntity trackInformationStatic) {
        this.trackInformationStatic = trackInformationStatic;
    }
}
