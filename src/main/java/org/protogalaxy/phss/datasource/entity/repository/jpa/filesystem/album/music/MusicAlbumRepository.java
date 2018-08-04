package org.protogalaxy.phss.datasource.entity.repository.jpa.filesystem.album.music;

import org.protogalaxy.phss.datasource.entity.core.filesystem.album.music.MusicAlbumEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MusicAlbumRepository extends JpaRepository<MusicAlbumEntity, Integer>, CrudRepository<MusicAlbumEntity, Integer> {
    List<MusicAlbumEntity> findByOwner_UserEntity_Username(String username);

    Page<MusicAlbumEntity> findAllByOwner_UserEntity_Username(String username, Pageable pageable);

    List<MusicAlbumEntity> findByOwner_UserEntity_UsernameAndTitle(String username, String title);

    MusicAlbumEntity findByOwner_UserEntity_UsernameAndId(String username, int id);
}
