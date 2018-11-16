package org.protogalaxy.phss.datasource.repository.jpa.filesystem.music;

import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicAlbumInfoStaticEntity;
import org.springframework.data.repository.CrudRepository;

public interface MusicAlbumInfoStaticRepository extends CrudRepository<MusicAlbumInfoStaticEntity, Integer> {
}
