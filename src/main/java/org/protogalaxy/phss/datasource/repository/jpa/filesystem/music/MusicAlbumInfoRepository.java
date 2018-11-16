package org.protogalaxy.phss.datasource.repository.jpa.filesystem.music;

import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicAlbumInfoEntity;
import org.springframework.data.repository.CrudRepository;

public interface MusicAlbumInfoRepository extends CrudRepository<MusicAlbumInfoEntity, Integer> {
}
