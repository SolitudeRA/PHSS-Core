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
public class DocumentMicrosoftWordEntity {
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

    @Field("application")
    private String application;

    @Field("app_version")
    private String appVersion;

    @Field("characters")
    private int characters;

    @Field("characters_with_spaces")
    private int charactersWithSpaces;

    @Field("lines")
    private int lines;

    @Field("pages")
    private int pages;

    @Field("paragraphs")
    private int paragraphs;

    @Temporal(TemporalType.TIMESTAMP)
    @Field("gmt_create")
    @CreatedDate
    private Date gmtCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @Field("gmt_modified")
    @LastModifiedDate
    private Date gmtModified;

    @PersistenceConstructor
    public DocumentMicrosoftWordEntity(String title, String creator, String application, String appVersion, Date created, Date modified, String lastModifiedBy, int characters, int charactersWithSpaces, int lines, int pages, int paragraphs) {
        this.title = title;
        this.creator = creator;
        this.application = application;
        this.appVersion = appVersion;
        this.created = created;
        this.modified = modified;
        this.lastModifiedBy = lastModifiedBy;
        this.characters = characters;
        this.charactersWithSpaces = charactersWithSpaces;
        this.lines = lines;
        this.pages = pages;
        this.paragraphs = paragraphs;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
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

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }
}
