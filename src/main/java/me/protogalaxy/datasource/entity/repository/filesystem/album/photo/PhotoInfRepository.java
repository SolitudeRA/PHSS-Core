package me.protogalaxy.datasource.entity.repository.filesystem.album.photo;

import me.protogalaxy.datasource.entity.core.filesystem.album.photo.PhotoInfEntity;
import org.springframework.data.repository.CrudRepository;

public interface PhotoInfRepository extends CrudRepository<PhotoInfEntity, Integer> {
}
