package me.protogalaxy.datasource.entity.repository.filesystem.album.music;

import me.protogalaxy.datasource.entity.core.filesystem.album.music.MusicPlaylistEntity;
import org.springframework.data.repository.CrudRepository;

public interface MusicPlaylistRepository extends CrudRepository<MusicPlaylistEntity, Integer> {
}
