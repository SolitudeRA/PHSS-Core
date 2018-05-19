package me.protogalaxy.datasource.entity.repository.filesystem.album.music;

import me.protogalaxy.datasource.entity.core.filesystem.album.music.MusicTrackEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@PreAuthorize("hasRole('ROLE_USER')")
public interface MusicTrackRepository extends Repository<MusicTrackEntity, Integer>, CrudRepository<MusicTrackEntity, Integer>, PagingAndSortingRepository<MusicTrackEntity, Integer> {
    List<MusicTrackEntity> findByTitleAndOwner_UserEntity_Username(String title, String username);

    List<MusicTrackEntity> findByAlbumAndOwner_UserEntity_Username(String album, String username);

    List<MusicTrackEntity> findByArtistAndOwner_UserEntity_Username(String artist, String username);
}
