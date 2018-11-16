package org.protogalaxy.phss.datasource.repository.jpa.filesystem.music;

import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicAlbumEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface MusicAlbumRepository extends JpaRepository<MusicAlbumEntity, UUID>, CrudRepository<MusicAlbumEntity, UUID> {
    Page<MusicAlbumEntity> findAllByFileSystemOwner_UserEntity_Username(String username, Pageable pageable);

    List<MusicAlbumEntity> findByFileSystemOwner_UserEntity_UsernameAndTitle(String username, String title);
}
