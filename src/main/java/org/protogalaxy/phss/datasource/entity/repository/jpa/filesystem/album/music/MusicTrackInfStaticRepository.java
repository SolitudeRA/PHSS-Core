package org.protogalaxy.phss.datasource.entity.repository.jpa.filesystem.album.music;

import org.protogalaxy.phss.datasource.entity.core.filesystem.album.music.MusicTrackInfStaticEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MusicTrackInfStaticRepository extends CrudRepository<MusicTrackInfStaticEntity, UUID> {
}
