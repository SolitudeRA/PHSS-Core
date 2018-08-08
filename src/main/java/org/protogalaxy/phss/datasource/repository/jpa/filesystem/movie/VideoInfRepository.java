package org.protogalaxy.phss.datasource.repository.jpa.filesystem.movie;

import org.protogalaxy.phss.datasource.entity.filesystem.movie.VideoInfEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface VideoInfRepository extends CrudRepository<VideoInfEntity, UUID> {
}
