package org.protogalaxy.phss.datasource.repository.jpa.filesystem.photo;

import org.protogalaxy.phss.datasource.entity.filesystem.photo.PhotoInfEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PhotoInfRepository extends CrudRepository<PhotoInfEntity, UUID> {
}
