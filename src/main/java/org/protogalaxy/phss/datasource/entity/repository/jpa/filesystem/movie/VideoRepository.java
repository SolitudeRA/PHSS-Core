package org.protogalaxy.phss.datasource.entity.repository.jpa.filesystem.movie;

import org.protogalaxy.phss.datasource.entity.core.filesystem.movie.VideoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface VideoRepository extends Repository<VideoEntity, UUID>, CrudRepository<VideoEntity, UUID> {
}
