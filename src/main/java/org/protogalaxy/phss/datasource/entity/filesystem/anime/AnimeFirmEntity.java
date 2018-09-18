package org.protogalaxy.phss.datasource.entity.filesystem.anime;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "anime_firm")
public class AnimeFirmEntity {
    @Id
    @GeneratedValue
    private UUID uuid;

    @Column(name = "bangumi_id")
    private Integer bangumiId;

    @Column(name = "name")
    private String name;

    @Column(name = "name_translated")
    private String nameTranslated;

    public AnimeFirmEntity() {
    }

    public AnimeFirmEntity(Integer bangumiId, String name, String nameTranslated) {
        this.bangumiId = bangumiId;
        this.name = name;
        this.nameTranslated = nameTranslated;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Integer getBangumiId() {
        return bangumiId;
    }

    public void setBangumiId(Integer bangumiId) {
        this.bangumiId = bangumiId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameTranslated() {
        return nameTranslated;
    }

    public void setNameTranslated(String nameTranslated) {
        this.nameTranslated = nameTranslated;
    }
}
