package org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music;

import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicPlaylistEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackEntity;
import org.springframework.hateoas.ResourceSupport;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

public class MusicPlaylistResource extends ResourceSupport {
    private UUID uuid;

    private String name;

    private String description;

    private List<MusicTrackEntity> list;

    private Integer trackTotal;

    private Duration durationTotal;

    private Integer playbackCount;

    public MusicPlaylistResource() {
    }

    public MusicPlaylistResource(MusicPlaylistEntity musicPlaylistEntity) {
        this.uuid = musicPlaylistEntity.getUuid();
        this.name = musicPlaylistEntity.getName();
        this.description = musicPlaylistEntity.getDescription();
        this.list = musicPlaylistEntity.getList();
        this.trackTotal = musicPlaylistEntity.getTrackTotal();
        this.durationTotal = musicPlaylistEntity.getDurationTotal();
        this.playbackCount = musicPlaylistEntity.getPlaybackCount();
    }

    public MusicPlaylistResource(UUID uuid, String name, String description, List<MusicTrackEntity> list, Integer trackTotal, Duration durationTotal, Integer playbackCount) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.list = list;
        this.trackTotal = trackTotal;
        this.durationTotal = durationTotal;
        this.playbackCount = playbackCount;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<MusicTrackEntity> getList() {
        return list;
    }

    public Integer getTrackTotal() {
        return trackTotal;
    }

    public Duration getDurationTotal() {
        return durationTotal;
    }

    public Integer getPlaybackCount() {
        return playbackCount;
    }
}
