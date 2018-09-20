package org.protogalaxy.phss.datasource.entity.filesystem.anime;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "anime_bluray")
public class AnimeBluRayEntity {
    @Id
    @GeneratedValue
    private UUID uuid;

    @Column(name = "bangumi_id")
    private Integer bangumiId;

    @Column(name = "title")
    private String title;

    @Column(name = "title_translated")
    private String titleTranslated;

    @Column(name = "poster")
    private String poster;
}
