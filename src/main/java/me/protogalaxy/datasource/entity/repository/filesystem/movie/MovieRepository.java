package me.protogalaxy.datasource.entity.repository.filesystem.movie;

import me.protogalaxy.datasource.entity.core.filesystem.movie.MovieEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface MovieRepository extends Repository<MovieEntity, Integer>, CrudRepository<MovieEntity, Integer> {
}
