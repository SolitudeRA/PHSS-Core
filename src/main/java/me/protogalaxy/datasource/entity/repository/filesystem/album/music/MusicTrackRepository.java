package me.protogalaxy.datasource.entity.repository.filesystem.album.music;

import me.protogalaxy.datasource.entity.core.filesystem.album.music.MusicTrackEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface MusicTrackRepository extends Repository<MusicTrackEntity, Integer>, CrudRepository<MusicTrackEntity, Integer> {
    List<MusicTrackEntity> findByName(String name);

    List<MusicTrackEntity> findByArtist(String artist);
}
