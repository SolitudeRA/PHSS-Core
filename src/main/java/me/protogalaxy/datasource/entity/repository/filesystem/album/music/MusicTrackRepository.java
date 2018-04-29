package me.protogalaxy.datasource.entity.repository.filesystem.album.music;

import me.protogalaxy.datasource.entity.core.filesystem.album.music.MusicTrackEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface MusicTrackRepository extends Repository<MusicTrackEntity, Integer>, CrudRepository<MusicTrackEntity, Integer> {
    @PreAuthorize("isFullyAuthenticated()&&(#username==principal.username)")
    List<MusicTrackEntity> findAllByOwner_UserEntity_Username(@Param("username") String username);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Iterable<MusicTrackEntity> findAll();

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteAll();
}
