package org.protogalaxy.phss.datasource.repository.jpa.filesystem.music;

import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicAlbumInfStaticEntity;
import org.springframework.data.repository.CrudRepository;

public interface MusicAlbumInfStaticRepository extends CrudRepository<MusicAlbumInfStaticEntity, Integer> {
}
