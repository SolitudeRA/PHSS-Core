package datasource.entity.userManagementCore;

import datasource.entity.fileSystemCore.fileSystemInformationLayer.FilesystemInfMainEntity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "password_ext1")
    private String passwordExt1;

    @Column(name = "password_ext2")
    private String passwordExt2;

    @Column(name = "password_ext3")
    private String passwordExt3;

    @OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private FilesystemInfMainEntity filesystemInfMainEntity;

    public UserEntity(){
    }

    public UserEntity(String username, String password, String passwordExt1, String passwordExt2, String passwordExt3){
        this.username = username;
        this.password = password;
        this.passwordExt1 = passwordExt1;
        this.passwordExt2 = passwordExt2;
        this.passwordExt3 = passwordExt3;
    }

    public UUID getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPasswordExt1(){
        return passwordExt1;
    }

    public void setPasswordExt1(String passwordExt1){
        this.passwordExt1 = passwordExt1;
    }

    public String getPasswordExt2(){
        return passwordExt2;
    }

    public void setPasswordExt2(String passwordExt2){
        this.passwordExt2 = passwordExt2;
    }

    public String getPasswordExt3(){
        return passwordExt3;
    }

    public void setPasswordExt3(String passwordExt3){
        this.passwordExt3 = passwordExt3;
    }

    public FilesystemInfMainEntity getFilesystemInfMainEntity(){
        return filesystemInfMainEntity;
    }
}