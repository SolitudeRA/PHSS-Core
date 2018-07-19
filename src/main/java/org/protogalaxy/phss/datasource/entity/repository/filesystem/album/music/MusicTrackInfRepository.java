package org.protogalaxy.phss.datasource.entity.repository.filesystem.album.music;

import org.protogalaxy.phss.datasource.entity.core.filesystem.album.music.MusicTrackInfEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MusicTrackInfRepository extends CrudRepository<MusicTrackInfEntity, UUID> {
}
