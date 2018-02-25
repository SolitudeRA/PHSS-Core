package datasource.entity.fileSystemCore.moviesLayer;

import datasource.entity.userManagementCore.UserEntity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "anime")
public class AnimeEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_USER_ID"))
    private UserEntity userEntity;

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

    public UserEntity getUserEntity(){
        return userEntity;
    }

    public String getAnimeName(){
        return animeName;
    }

    public void setAnimeName(String animeName){
        this.animeName = animeName;
    }
}
