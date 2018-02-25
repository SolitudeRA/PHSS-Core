package datasource.entity.fileSystemCore.booksLayer;

import datasource.entity.userManagementCore.UserEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_USER_ID"))
    private UserEntity userEntity;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    @OneToOne(mappedBy = "bookEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private BookInfEntity bookInfEntity;

    public BookEntity(){
    }

    public BookEntity(String bookName, Date gmtCreate, Date gmtModified){
        this.bookName = bookName;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
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

    public String getBookName(){
        return bookName;
    }

    public void setBookName(String bookName){
        this.bookName = bookName;
    }

    public Date getGmtCreate(){
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate){
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified(){
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified){
        this.gmtModified = gmtModified;
    }

    public BookInfEntity getBookInfEntity(){
        return bookInfEntity;
    }
}
