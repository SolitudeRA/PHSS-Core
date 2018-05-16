package me.protogalaxy.datasource.entity.repository.filesystem.album.music;

import me.protogalaxy.datasource.entity.core.filesystem.album.music.MusicAlbumEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface MusicAlbumRepository extends Repository<MusicAlbumEntity, Integer>, CrudRepository<MusicAlbumEntity, Integer> {
    @PreAuthorize("isFullyAuthenticated()&&(#username==principal.username)")
    List<MusicAlbumEntity> findAllByOwner_UserEntity_Username(@Param("username") String username);

    @PreAuthorize("isFullyAuthenticated()&&(#username==principal.username)")
    Page<MusicAlbumEntity> findAllByOwner_UserEntity_Username(@Param("username") String username, Pageable pageable);
}
