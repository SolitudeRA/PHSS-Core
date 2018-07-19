package org.protogalaxy.phss.datasource.entity.repository.filesystem.album.music;

import org.protogalaxy.phss.datasource.entity.core.filesystem.album.music.MusicTrackEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.UUID;

@PreAuthorize("hasRole('ROLE_USER')")
public interface MusicTrackRepository extends Repository<MusicTrackEntity, UUID>, CrudRepository<MusicTrackEntity, UUID>, PagingAndSortingRepository<MusicTrackEntity, UUID> {
    List<MusicTrackEntity> findByTitleAndOwner_UserEntity_Username(String title, String username);

    List<MusicTrackEntity> findByAlbumAndOwner_UserEntity_Username(String album, String username);

    List<MusicTrackEntity> findByArtistAndOwner_UserEntity_Username(String artist, String username);

    List<MusicTrackEntity> findByMusicAlbumEntity_IdAndOwner_UserEntity_Username(int id, String username);
}
