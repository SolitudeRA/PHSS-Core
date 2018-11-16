package org.protogalaxy.phss.datasource.repository.jpa.filesystem.music;

import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackInfoStaticEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MusicTrackInfoStaticRepository extends CrudRepository<MusicTrackInfoStaticEntity, UUID> {
}
