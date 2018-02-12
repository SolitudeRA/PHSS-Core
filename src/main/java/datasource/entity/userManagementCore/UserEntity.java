package datasource.entity.userManagementCore;

import datasource.entity.fileSystemCore.fileSystemInformationLayer.FileSystemInfMainEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 * TODO: 2018/1/26 Entity Design
 */

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

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

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private FileSystemInfMainEntity fileSystemInfMainEntity;

    public UserEntity() {
    }

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordExt1() {
        return passwordExt1;
    }

    public void setPasswordExt1(String passwordExt1) {
        this.passwordExt1 = passwordExt1;
    }

    public String getPasswordExt2() {
        return passwordExt2;
    }

    public void setPasswordExt2(String passwordExt2) {
        this.passwordExt2 = passwordExt2;
    }

    public String getPasswordExt3() {
        return passwordExt3;
    }

    public void setPasswordExt3(String passwordExt3) {
        this.passwordExt3 = passwordExt3;
    }

    public FileSystemInfMainEntity getFileSystemInfMainEntity() {
        return fileSystemInfMainEntity;
    }
}
