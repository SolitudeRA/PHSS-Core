package org.protogalaxy.phss.datasource.repository.jpa.filesystem.album.photo;

import org.protogalaxy.phss.datasource.entity.filesystem.album.photo.PhotoAlbumInfEntity;
import org.springframework.data.repository.CrudRepository;

public interface PhotoAlbumInfRepository extends CrudRepository<PhotoAlbumInfEntity, Integer> {
}
