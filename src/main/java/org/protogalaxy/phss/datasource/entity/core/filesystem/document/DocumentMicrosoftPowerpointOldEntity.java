package org.protogalaxy.phss.datasource.entity.core.filesystem.document;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.protogalaxy.phss.datasource.entity.core.filesystem.main.FileSystemMainEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "document_microsoft_powerpoint_old")
public class DocumentMicrosoftPowerpointOldEntity {
    @Id
    @GeneratedValue
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_OWNER_ID_DOCUMENT_MICROSOFT_POWERPOINT_OLD"))
    private FileSystemMainEntity fileSystemMainEntity;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

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

    @Column(name = "word_count")
    private int wordCount;

    @Column(name = "present_count")
    private int presentCount;

    @Column(name = "byte_count")
    private int byteCount;

    @Column(name = "part_count")
    private int partCount;

    @Column(name = "slide_count")
    private int slideCount;

    @Column(name = "note_count")
    private int noteCount;

    @Column(name = "hidden_count")
    private int hiddenCount;

    @Column(name = "mmclip_count")
    private int mmclipCount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified")
    @UpdateTimestamp
    private Date gmtModified;

    public DocumentMicrosoftPowerpointOldEntity() {
    }

    public DocumentMicrosoftPowerpointOldEntity(FileSystemMainEntity fileSystemMainEntity, String title, String author, String lastAuthor, String appName, long editTime, Date createDtm, Date lastSaveDtm, int wordCount, int presentCount, int byteCount, int partCount, int slideCount, int noteCount, int hiddenCount, int mmclipCount) {
        this.fileSystemMainEntity = fileSystemMainEntity;
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
