package org.protogalaxy.phss.datasource.entity.core.filesystem.document;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Document(collection = "document")
public class DocumentMicrosoftPowerpointOldEntity {
    @Id
    @GeneratedValue
    private UUID uuid;

    @Field("title")
    private String title;

    @Field("author")
    private String author;

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

    @Field("word_count")
    private int wordCount;

    @Field("present_count")
    private int presentCount;

    @Field("byte_count")
    private int byteCount;

    @Field("part_count")
    private int partCount;

    @Field("slide_count")
    private int slideCount;

    @Field("note_count")
    private int noteCount;

    @Field("hidden_count")
    private int hiddenCount;

    @Field("mmclip_count")
    private int mmclipCount;

    @Temporal(TemporalType.TIMESTAMP)
    @Field("gmt_create")
    @CreatedDate
    private Date gmtCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Field("gmt_modified")
    @LastModifiedDate
    private Date gmtModified;

    public DocumentMicrosoftPowerpointOldEntity(String title, String author, String lastAuthor, String appName, long editTime, Date createDtm, Date lastSaveDtm, int wordCount, int presentCount, int byteCount, int partCount, int slideCount, int noteCount, int hiddenCount, int mmclipCount) {
        this.title = title;
        this.author = author;
        this.lastAuthor = lastAuthor;
        this.appName = appName;
        this.editTime = editTime;
        this.createDtm = createDtm;
        this.lastSaveDtm = lastSaveDtm;
        this.wordCount = wordCount;
        this.presentCount = presentCount;
        this.byteCount = byteCount;
        this.partCount = partCount;
        this.slideCount = slideCount;
        this.noteCount = noteCount;
        this.hiddenCount = hiddenCount;
        this.mmclipCount = mmclipCount;
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

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getPresentCount() {
        return presentCount;
    }

    public void setPresentCount(int presentCount) {
        this.presentCount = presentCount;
    }

    public int getByteCount() {
        return byteCount;
    }

    public void setByteCount(int byteCount) {
        this.byteCount = byteCount;
    }

    public int getPartCount() {
        return partCount;
    }

    public void setPartCount(int partCount) {
        this.partCount = partCount;
    }

    public int getSlideCount() {
        return slideCount;
    }

    public void setSlideCount(int slideCount) {
        this.slideCount = slideCount;
    }

    public int getNoteCount() {
        return noteCount;
    }

    public void setNoteCount(int noteCount) {
        this.noteCount = noteCount;
    }

    public int getHiddenCount() {
        return hiddenCount;
    }

    public void setHiddenCount(int hiddenCount) {
        this.hiddenCount = hiddenCount;
    }

    public int getMmclipCount() {
        return mmclipCount;
    }

    public void setMmclipCount(int mmclipCount) {
        this.mmclipCount = mmclipCount;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }
}
