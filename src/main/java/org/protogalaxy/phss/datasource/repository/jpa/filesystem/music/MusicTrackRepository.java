package org.protogalaxy.phss.datasource.repository.jpa.filesystem.music;

import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

public interface MusicTrackRepository extends JpaRepository<MusicTrackEntity, UUID>, CrudRepository<MusicTrackEntity, UUID>, PagingAndSortingRepository<MusicTrackEntity, UUID> {
    List<MusicTrackEntity> findByTitleAndFileSystemOwner_UserEntity_Username(String title, String username);

    List<MusicTrackEntity> findByAlbumAndFileSystemOwner_UserEntity_Username(String album, String username);

    List<MusicTrackEntity> findByArtistAndFileSystemOwner_UserEntity_Username(String artist, String username);
}
