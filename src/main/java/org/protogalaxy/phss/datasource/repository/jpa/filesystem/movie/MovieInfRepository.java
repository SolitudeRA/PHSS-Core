package org.protogalaxy.phss.datasource.repository.jpa.filesystem.movie;

import org.protogalaxy.phss.datasource.entity.filesystem.movie.MovieInfEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MovieInfRepository extends CrudRepository<MovieInfEntity, UUID> {
}
