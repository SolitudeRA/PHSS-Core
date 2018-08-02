package org.protogalaxy.phss.datasource.entity.core.filesystem.document;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Document(collection = "document")
public class DocumentMicrosoftWordOldEntity {
    @Id
    @GeneratedValue
    private UUID uuid;

    @Field("title")
    private String title;

    @Field("author")
    private String author;

    @Field("keywords")
    private String keywords;

    @Field("comments")
    private String comments;

    @Field("last_author")
    private String lastAuthor;

    @Field("app_name")
    private String appName;

    @Field("edit_time")
    private long editTime;

    @Field("create_dtm")
    private Date createDtm;

    @Field("last_save_dtm")
    private Date lastSaveDtm;

    @Field("page_count")
    private int pageCount;

    @Field("word_count")
    private int wordCount;

    @Field("char_count")
    private int charCount;

    @Field("line_count")
    private int lineCount;

    @Field("par_count")
    private int parCount;

    @Temporal(TemporalType.TIMESTAMP)
    @Field("gmt_create")
    @CreatedDate
    private Date gmtCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Field("gmt_modified")
    @LastModifiedDate
    private Date gmtModified;

    @PersistenceConstructor
    public DocumentMicrosoftWordOldEntity(String title, String author, String keywords, String comments, String lastAuthor, String appName, long editTime, Date createDtm, Date lastSaveDtm, int pageCount, int wordCount, int charCount, int lineCount, int parCount) {
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
