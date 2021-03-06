package org.protogalaxy.phss.datasource.repository.jpa.filesystem.photo;

import org.protogalaxy.phss.datasource.entity.filesystem.photo.PhotoAlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PhotoAlbumRepository extends JpaRepository<PhotoAlbumEntity, Integer>, CrudRepository<PhotoAlbumEntity, Integer> {
}
