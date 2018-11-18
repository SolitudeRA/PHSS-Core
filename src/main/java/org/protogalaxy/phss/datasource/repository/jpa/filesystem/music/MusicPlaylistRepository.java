package org.protogalaxy.phss.datasource.repository.jpa.filesystem.music;

import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicPlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
import java.util.UUID;

public interface MusicPlaylistRepository extends JpaRepository<MusicPlaylistEntity, UUID>, CrudRepository<MusicPlaylistEntity, UUID> {
    List<MusicPlaylistEntity> findAllByFileSystemOwner_UserEntity_Username(String username);
}
