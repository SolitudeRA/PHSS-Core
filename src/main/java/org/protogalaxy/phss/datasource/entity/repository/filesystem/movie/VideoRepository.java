package org.protogalaxy.phss.datasource.entity.repository.filesystem.movie;

import org.protogalaxy.phss.datasource.entity.core.filesystem.movie.VideoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface VideoRepository extends Repository<VideoEntity, Integer>, CrudRepository<VideoEntity, Integer> {
}
