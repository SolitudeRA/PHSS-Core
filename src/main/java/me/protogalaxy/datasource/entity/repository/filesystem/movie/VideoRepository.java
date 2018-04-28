package me.protogalaxy.datasource.entity.repository.filesystem.movie;

import me.protogalaxy.datasource.entity.core.filesystem.movie.VideoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface VideoRepository extends Repository<VideoEntity, Integer>, CrudRepository<VideoEntity, Integer> {
}
