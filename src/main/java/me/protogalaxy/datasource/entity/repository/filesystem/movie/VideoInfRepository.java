package me.protogalaxy.datasource.entity.repository.filesystem.movie;

import me.protogalaxy.datasource.entity.core.filesystem.movie.VideoInfEntity;
import org.springframework.data.repository.CrudRepository;

public interface VideoInfRepository extends CrudRepository<VideoInfEntity, Integer> {
}
