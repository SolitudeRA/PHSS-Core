package org.protogalaxy.phss.datasource.entity.repository.jpa.filesystem.album.music;

import org.protogalaxy.phss.datasource.entity.core.filesystem.album.music.MusicPlaylistEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface MusicPlaylistRepository extends Repository<MusicPlaylistEntity, Integer>, CrudRepository<MusicPlaylistEntity, Integer> {
    @PreAuthorize("isFullyAuthenticated()&&(#username==principal.username)")
    List<MusicPlaylistEntity> findAllByFileSystemMainEntity_UserEntity_Username(@Param("username") String username);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Iterable<MusicPlaylistEntity> findAll();

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteAll();
}
