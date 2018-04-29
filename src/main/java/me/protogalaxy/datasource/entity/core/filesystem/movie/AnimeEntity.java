package me.protogalaxy.datasource.entity.core.filesystem.movie;

import me.protogalaxy.datasource.entity.core.filesystem.main.FileSystemMainEntity;

import javax.persistence.*;

@Entity
@Table(name = "anime")
public class AnimeEntity {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_OWNER_ID_ANIME"))
    private FileSystemMainEntity filesystemInfMainEntity;

    @Column(name = "anime_name")
    private String animeName;

    public AnimeEntity(){
    }

    public AnimeEntity(String animeName){
        this.animeName = animeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FileSystemMainEntity getFilesystemInfMainEntity(){
        return filesystemInfMainEntity;
    }

    public String getAnimeName(){
        return animeName;
    }

    public void setAnimeName(String animeName){
        this.animeName = animeName;
    }
}
