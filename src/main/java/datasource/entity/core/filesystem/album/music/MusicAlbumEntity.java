package datasource.entity.core.filesystem.album.music;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import datasource.entity.core.filesystem.main.FileSystemMainEntity;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 */

@Entity
@Table(name = "album_music")
public class MusicAlbumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_OWNER_ID_MUSIC"))
    private FileSystemMainEntity owner;

    @Column(name = "name")
    private String name;

    @Column(name = "artist")
    private String artist;

    @Column(name = "location")
    private String location;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_added")
    @CreationTimestamp
    private Date dateAdded;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_modified")
    @CreationTimestamp
    private Date dateModified;

    @JsonManagedReference
    @OneToOne(mappedBy = "musicAlbumEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private MusicAlbumInfEntity albumInformation;

    @JsonManagedReference
    @OneToOne(mappedBy = "musicAlbumEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private MusicAlbumInfStaticEntity albumInformationStatic;

    public MusicAlbumEntity() {
    }

    public MusicAlbumEntity(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public MusicAlbumEntity(String name, String artist, String location) {
        this.name = name;
        this.artist = artist;
        this.location = location;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public MusicAlbumInfEntity getAlbumInformation() {
        return albumInformation;
    }

    public void setAlbumInformation(MusicAlbumInfEntity albumInformation) {
        this.albumInformation = albumInformation;
    }

    public MusicAlbumInfStaticEntity getAlbumInformationStatic() {
        return albumInformationStatic;
    }

    public void setAlbumInformationStatic(MusicAlbumInfStaticEntity albumInformationStatic) {
        this.albumInformationStatic = albumInformationStatic;
    }
}
