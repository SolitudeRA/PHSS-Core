package org.protogalaxy.phss.datasource.entity.core.filesystem.document;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.protogalaxy.phss.datasource.entity.core.filesystem.main.FileSystemMainEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "document_microsoft_word_old")
public class DocumentMicrosoftWordOldEntity {
    @Id
    @GeneratedValue
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_OWNER_ID_DOCUMENT_MICROSOFT_WORD_OLD"))
    private FileSystemMainEntity fileSystemMainEntity;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "keywords")
    private String keywords;

    @Column(name = "comments")
    private String comments;

    @Column(name = "last_author")
    private String lastAuthor;

    @Column(name = "app_name")
    private String appName;

    @Column(name = "edit_time")
    private long editTime;

    @Column(name = "create_dtm")
    private Date createDtm;

    @Column(name = "last_save_dtm")
    private Date lastSaveDtm;

    @Column(name = "page_count")
    private int pageCount;

    @Column(name = "word_count")
    private int wordCount;

    @Column(name = "char_count")
    private int charCount;

    @Column(name = "line_count")
    private int lineCount;

    @Column(name = "par_count")
    private int parCount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified")
    @UpdateTimestamp
    private Date gmtModified;

    public DocumentMicrosoftWordOldEntity() {
    }

    public DocumentMicrosoftWordOldEntity(FileSystemMainEntity fileSystemMainEntity, String title, String author, String keywords, String comments, String lastAuthor, String appName, long editTime, Date createDtm, Date lastSaveDtm, int pageCount, int wordCount, int charCount, int lineCount, int parCount) {
        this.fileSystemMainEntity = fileSystemMainEntity;
        this.title = title;
        this.author = author;
        this.keywords = keywords;
        this.comments = comments;
        this.lastAuthor = lastAuthor;
        this.appName = appName;
        this.editTime = editTime;
        this.createDtm = createDtm;
        this.lastSaveDtm = lastSaveDtm;
        this.pageCount = pageCount;
        this.wordCount = wordCount;
        this.charCount = charCount;
        this.lineCount = lineCount;
        this.parCount = parCount;
    }

    public UUID getUuid() {
        return uuid;
    }

    public FileSystemMainEntity getFileSystemMainEntity() {
        return fileSystemMainEntity;
    }

    public void setFileSystemMainEntity(FileSystemMainEntity fileSystemMainEntity) {
        this.fileSystemMainEntity = fileSystemMainEntity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getLastAuthor() {
        return lastAuthor;
    }

    public void setLastAuthor(String lastAuthor) {
        this.lastAuthor = lastAuthor;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public long getEditTime() {
        return editTime;
    }

    public void setEditTime(long editTime) {
        this.editTime = editTime;
    }

    public Date getCreateDtm() {
        return createDtm;
    }

    public void setCreateDtm(Date createDtm) {
        this.createDtm = createDtm;
    }

    public Date getLastSaveDtm() {
        return lastSaveDtm;
    }

    public void setLastSaveDtm(Date lastSaveDtm) {
        this.lastSaveDtm = lastSaveDtm;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getCharCount() {
        return charCount;
    }

    public void setCharCount(int charCount) {
        this.charCount = charCount;
    }

    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }

    public int getParCount() {
        return parCount;
    }

    public void setParCount(int parCount) {
        this.parCount = parCount;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }
}
