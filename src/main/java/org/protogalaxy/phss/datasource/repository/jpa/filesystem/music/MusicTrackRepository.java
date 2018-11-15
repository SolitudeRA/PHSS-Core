package org.protogalaxy.phss.datasource.repository.jpa.filesystem.music;

import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.UUID;

@PreAuthorize("hasRole('ROLE_USER')")
public interface MusicTrackRepository extends JpaRepository<MusicTrackEntity, UUID>, CrudRepository<MusicTrackEntity, UUID>, PagingAndSortingRepository<MusicTrackEntity, UUID> {
    List<MusicTrackEntity> findByTitleAndOwner_UserEntity_Username(String title, String username);

    List<MusicTrackEntity> findByAlbumAndOwner_UserEntity_Username(String album, String username);

    List<MusicTrackEntity> findByArtistAndOwner_UserEntity_Username(String artist, String username);

    List<MusicTrackEntity> findByMusicAlbumEntity_IdAndOwner_UserEntity_Username(int id, String username);
}
