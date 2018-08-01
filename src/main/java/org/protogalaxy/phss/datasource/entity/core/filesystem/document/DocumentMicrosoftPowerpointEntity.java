package org.protogalaxy.phss.datasource.entity.core.filesystem.document;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.protogalaxy.phss.datasource.entity.core.filesystem.main.FileSystemMainEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "document_microsoft_powerpoint")
public class DocumentMicrosoftPowerpointEntity {
    @Id
    @GeneratedValue
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "FK_OWNER_ID_DOCUMENT_MICROSOFT_POWERPOINT"))
    private FileSystemMainEntity fileSystemMainEntity;

    @Column(name = "title")
    private String title;

    @Column(name = "application")
    private String application;

    @Column(name = "app_version")
    private String appVersion;

    @Column(name = "creator")
    private String creator;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Column(name = "created")
    private Date created;

    @Column(name = "modified")
    private Date modified;

    @Column(name = "characters")
    private int characters;

    @Column(name = "characters_with_spaces")
    private int charactersWithSpaces;

    @Column(name = "lines")
    private int lines;

    @Column(name = "pages")
    private int pages;

    @Column(name = "paragraphs")
    private int paragraphs;

    @Column(name = "presentation_format")
    private String presentationFormat;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_create")
    @CreationTimestamp
    private Date gmtCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified")
    @UpdateTimestamp
    private Date gmtModified;

    public DocumentMicrosoftPowerpointEntity() {
    }

    public DocumentMicrosoftPowerpointEntity(FileSystemMainEntity fileSystemMainEntity, String title, String application, String appVersion, String creator, String lastModifiedBy, Date created, Date modified, int characters, int charactersWithSpaces, int lines, int pages, int paragraphs, String presentationFormat) {
        this.fileSystemMainEntity = fileSystemMainEntity;
        this.title = title;
        this.application = application;
        this.appVersion = appVersion;
        this.creator = creator;
        this.lastModifiedBy = lastModifiedBy;
        this.created = created;
        this.modified = modified;
        this.characters = characters;
        this.charactersWithSpaces = charactersWithSpaces;
        this.lines = lines;
        this.pages = pages;
        this.paragraphs = paragraphs;
        this.presentationFormat = presentationFormat;
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

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
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

    public int getCharacters() {
        return characters;
    }

    public void setCharacters(int characters) {
        this.characters = characters;
    }

    public int getCharactersWithSpaces() {
        return charactersWithSpaces;
    }

    public void setCharactersWithSpaces(int charactersWithSpaces) {
        this.charactersWithSpaces = charactersWithSpaces;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(int paragraphs) {
        this.paragraphs = paragraphs;
    }

    public String getPresentationFormat() {
        return presentationFormat;
    }

    public void setPresentationFormat(String presentationFormat) {
        this.presentationFormat = presentationFormat;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }
}
