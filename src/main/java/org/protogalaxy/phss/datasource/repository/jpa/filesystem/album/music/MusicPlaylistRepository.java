package org.protogalaxy.phss.datasource.repository.jpa.filesystem.album.music;

import org.protogalaxy.phss.datasource.entity.filesystem.album.music.MusicPlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface MusicPlaylistRepository extends JpaRepository<MusicPlaylistEntity, Integer>, CrudRepository<MusicPlaylistEntity, Integer> {
    @PreAuthorize("isFullyAuthenticated()&&(#username==principal.username)")
    List<MusicPlaylistEntity> findAllByFileSystemMainEntity_UserEntity_Username(@Param("username") String username);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    List<MusicPlaylistEntity> findAll();

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteAll();
}
