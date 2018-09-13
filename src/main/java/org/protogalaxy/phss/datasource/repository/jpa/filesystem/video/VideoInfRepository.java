package org.protogalaxy.phss.datasource.repository.jpa.filesystem.video;

import org.protogalaxy.phss.datasource.entity.filesystem.video.VideoInfEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface VideoInfRepository extends CrudRepository<VideoInfEntity, UUID> {
}
