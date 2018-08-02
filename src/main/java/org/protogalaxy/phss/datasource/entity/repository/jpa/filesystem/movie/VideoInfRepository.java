package org.protogalaxy.phss.datasource.entity.repository.jpa.filesystem.movie;

import org.protogalaxy.phss.datasource.entity.core.filesystem.movie.VideoInfEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface VideoInfRepository extends CrudRepository<VideoInfEntity, UUID> {
}
