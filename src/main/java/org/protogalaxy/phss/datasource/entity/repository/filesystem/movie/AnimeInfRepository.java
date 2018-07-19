package org.protogalaxy.phss.datasource.entity.repository.filesystem.movie;

import org.protogalaxy.phss.datasource.entity.core.filesystem.movie.AnimeInfEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AnimeInfRepository extends CrudRepository<AnimeInfEntity, UUID> {
}
