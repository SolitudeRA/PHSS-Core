package org.protogalaxy.phss.datasource.repository.jpa.filesystem.music;

import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MusicTrackRepository extends JpaRepository<MusicTrackEntity, UUID>, CrudRepository<MusicTrackEntity, UUID>, PagingAndSortingRepository<MusicTrackEntity, UUID> {
    MusicTrackEntity findByUuid(UUID uuid);

    void deleteByUuid(UUID uuid);

    Optional<MusicTrackEntity> findByFileSystemOwner_AccountEntity_UsernameAndTrackInformationStatic_Md5(String username, String md5);

    List<MusicTrackEntity> findAllByFileSystemOwner_AccountEntity_UsernameAndTitle(String username, String title);

    List<MusicTrackEntity> findAllByFileSystemOwner_AccountEntity_UsernameAndArtist(String username, String artist);
}
