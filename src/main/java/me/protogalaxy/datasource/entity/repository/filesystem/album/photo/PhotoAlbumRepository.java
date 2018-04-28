package me.protogalaxy.datasource.entity.repository.filesystem.album.photo;

import me.protogalaxy.datasource.entity.core.filesystem.album.photo.PhotoAlbumEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface PhotoAlbumRepository extends Repository<PhotoAlbumEntity, Integer>, CrudRepository<PhotoAlbumEntity, Integer> {
}
