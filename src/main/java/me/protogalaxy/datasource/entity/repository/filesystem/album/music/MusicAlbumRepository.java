package me.protogalaxy.datasource.entity.repository.filesystem.album.music;

import me.protogalaxy.datasource.entity.core.filesystem.album.music.MusicAlbumEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import java.util.List;

public interface MusicAlbumRepository extends Repository<MusicAlbumEntity, Integer>, CrudRepository<MusicAlbumEntity, Integer> {
    List<MusicAlbumEntity> findAllByOwner_UserEntity_Username(String username);

    Page<MusicAlbumEntity> findAllByOwner_UserEntity_Username(String username, Pageable pageable);
}
