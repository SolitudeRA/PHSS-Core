package org.protogalaxy.phss.datasource.entity.repository.filesystem.album.photo;

import org.protogalaxy.phss.datasource.entity.core.filesystem.album.photo.PhotoInfEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PhotoInfRepository extends CrudRepository<PhotoInfEntity, UUID> {
}
