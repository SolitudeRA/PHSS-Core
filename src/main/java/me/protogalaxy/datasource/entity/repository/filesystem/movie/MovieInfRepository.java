package me.protogalaxy.datasource.entity.repository.filesystem.movie;

import me.protogalaxy.datasource.entity.core.filesystem.movie.MovieInfEntity;
import org.springframework.data.repository.CrudRepository;

public interface MovieInfRepository extends CrudRepository<MovieInfEntity, Integer> {
}
