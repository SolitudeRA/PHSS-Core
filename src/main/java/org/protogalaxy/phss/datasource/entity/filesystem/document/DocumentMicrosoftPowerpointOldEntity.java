package org.protogalaxy.phss.datasource.entity.filesystem.document;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.PersistenceConstructor;
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

    @Field("created")
    private Date created;

    @Field("modified")
    private Date modified;

    @Field("creator")
    private String creator;

    @Field("last_modified_by")
    private String lastModifiedBy;

    @Field("app_name")
    private String appName;

    @Field("edit_time")
    private long editTime;

    @Field("word_count")
    private int wordCount;

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

    @Field("present_format")
    private String presentFormat;

    @Temporal(TemporalType.TIMESTAMP)
    @Field("gmt_create")
    @CreatedDate
    private Date gmtCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Field("gmt_modified")
    @LastModifiedDate
    private Date gmtModified;

    @PersistenceConstructor
    public DocumentMicrosoftPowerpointOldEntity(String title, Date created, Date modified, String creator, String lastModifiedBy, String appName, long editTime, int wordCount, int byteCount, int partCount, int slideCount, int noteCount, int hiddenCount, int mmclipCount, String presentFormat) {
        this.title = title;
        this.created = created;
        this.modified = modified;
        this.creator = creator;
        this.lastModifiedBy = lastModifiedBy;
        this.appName = appName;
        this.editTime = editTime;
        this.wordCount = wordCount;
        this.byteCount = byteCount;
        this.partCount = partCount;
        this.slideCount = slideCount;
        this.noteCount = noteCount;
        this.hiddenCount = hiddenCount;
        this.mmclipCount = mmclipCount;
        this.presentFormat = presentFormat;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
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

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
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

    public String getPresentFormat() {
        return presentFormat;
    }

    public void setPresentFormat(String presentFormat) {
        this.presentFormat = presentFormat;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }
}
