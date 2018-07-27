package org.protogalaxy.phss.datasource.entity.core.filesystem.document;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "document_inf")
public class DocumentInfEntity {
    @Id
    private UUID documentId;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "keywords")
    private String keyWords;

    @Column(name = "comments")
    private String comments;

    @Column(name = "last_author")
    private String lastAuthor;

    @Column(name = "edit_time")
    private String editTime;

    @Column(name = "create_dtm")
    private String createDtm;

    @Column(name = "last_save_dtm")
    private String lastSaveDtm;

    @Column(name = "page_count")
    private int pageCount;

    @Column(name = "word_count")
    private int wordCount;

    @Column(name = "char_count")
    private int charCount;

    @Column(name = "category")
    private String category;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    @OneToOne
    @MapsId
    @JoinColumn(name = "document_id")
    @JsonBackReference
    private DocumentEntity documentEntity;

    public DocumentInfEntity() {
    }

    public DocumentInfEntity(DocumentEntity documentEntity) {
        this.documentEntity = documentEntity;
    }

    public DocumentInfEntity(String title, String author, String keyWords, String comments, String lastAuthor, String editTime, String createDtm, String lastSaveDtm, int pageCount, int wordCount, int charCount, String category, DocumentEntity documentEntity) {
        this.title = title;
        this.author = author;
        this.keyWords = keyWords;
        this.comments = comments;
        this.lastAuthor = lastAuthor;
        this.editTime = editTime;
        this.createDtm = createDtm;
        this.lastSaveDtm = lastSaveDtm;
        this.pageCount = pageCount;
        this.wordCount = wordCount;
        this.charCount = charCount;
        this.category = category;
        this.documentEntity = documentEntity;
    }

    public UUID getDocumentId() {
        return documentId;
    }

    public void setDocumentId(UUID documentId) {
        this.documentId = documentId;
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

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
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

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public String getCreateDtm() {
        return createDtm;
    }

    public void setCreateDtm(String createDtm) {
        this.createDtm = createDtm;
    }

    public String getLastSaveDtm() {
        return lastSaveDtm;
    }

    public void setLastSaveDtm(String lastSaveDtm) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public DocumentEntity getDocumentEntity() {
        return documentEntity;
    }

    public void setDocumentEntity(DocumentEntity documentEntity) {
        this.documentEntity = documentEntity;
    }
}
