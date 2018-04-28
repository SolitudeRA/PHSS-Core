package me.protogalaxy.datasource.entity.repository.filesystem.album.photo;

import me.protogalaxy.datasource.entity.core.filesystem.album.photo.PhotoAlbumInfEntity;
import org.springframework.data.repository.CrudRepository;

public interface PhotoAlbumInfRepository extends CrudRepository<PhotoAlbumInfEntity, Integer> {
}
