package org.protogalaxy.phss.datasource.repository.jpa.filesystem.music;

import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicAlbumEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface MusicAlbumRepository extends JpaRepository<MusicAlbumEntity, UUID>, CrudRepository<MusicAlbumEntity, UUID> {
    MusicAlbumEntity findByUuid(UUID uuid);

    void deleteByUuid(UUID uuid);

    Page<MusicAlbumEntity> findAllByFileSystemOwner_AccountEntity_Username(String username, Pageable pageable);

    List<MusicAlbumEntity> findAllByFileSystemOwner_AccountEntity_UsernameAndTitle(String username, String title);

    List<MusicAlbumEntity> findAllByFileSystemOwner_AccountEntity_UsernameAndArtist(String username, String artist);
}
