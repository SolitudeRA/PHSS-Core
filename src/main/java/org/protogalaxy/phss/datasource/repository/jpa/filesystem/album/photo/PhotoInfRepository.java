package org.protogalaxy.phss.datasource.repository.jpa.filesystem.album.photo;

import org.protogalaxy.phss.datasource.entity.filesystem.album.photo.PhotoInfEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PhotoInfRepository extends CrudRepository<PhotoInfEntity, UUID> {
}
