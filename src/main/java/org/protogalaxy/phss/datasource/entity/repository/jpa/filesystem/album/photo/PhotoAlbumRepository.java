package org.protogalaxy.phss.datasource.entity.repository.jpa.filesystem.album.photo;

import org.protogalaxy.phss.datasource.entity.core.filesystem.album.photo.PhotoAlbumEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface PhotoAlbumRepository extends Repository<PhotoAlbumEntity, Integer>, CrudRepository<PhotoAlbumEntity, Integer> {
}
