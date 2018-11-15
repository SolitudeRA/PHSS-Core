package org.protogalaxy.phss.datasource.repository.jpa.filesystem.music;

import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackInfStaticEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MusicTrackInfStaticRepository extends CrudRepository<MusicTrackInfStaticEntity, UUID> {
}
