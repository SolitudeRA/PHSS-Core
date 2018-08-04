package org.protogalaxy.phss.datasource.entity.repository.jpa.filesystem.album.photo;

import org.protogalaxy.phss.datasource.entity.core.filesystem.album.photo.PhotoAlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PhotoAlbumRepository extends JpaRepository<PhotoAlbumEntity, Integer>, CrudRepository<PhotoAlbumEntity, Integer> {
}
