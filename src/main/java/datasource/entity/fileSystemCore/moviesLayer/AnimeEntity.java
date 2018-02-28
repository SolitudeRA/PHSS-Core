package datasource.entity.fileSystemCore.moviesLayer;

import datasource.entity.fileSystemCore.fileSystemInformationLayer.FilesystemInfMainEntity;
import datasource.entity.userManagementCore.UserEntity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "anime")
@Inheritance(strategy = InheritanceType.JOINED)
public class AnimeEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_OWNER_ID_ANIME"))
    private FilesystemInfMainEntity filesystemInfMainEntity;

    @Column(name = "anime_name")
    private String animeName;

    public AnimeEntity(){
    }

    public AnimeEntity(String animeName){
        this.animeName = animeName;
    }

    public UUID getId(){
        return id;
    }

    public void setId(UUID id){
        this.id = id;
    }

    public FilesystemInfMainEntity getFilesystemInfMainEntity(){
        return filesystemInfMainEntity;
    }

    public String getAnimeName(){
        return animeName;
    }

    public void setAnimeName(String animeName){
        this.animeName = animeName;
    }
}
