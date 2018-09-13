package org.protogalaxy.phss.datasource.repository.jpa.filesystem.anime;

import org.protogalaxy.phss.datasource.entity.filesystem.anime.AnimeInfEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AnimeInfRepository extends CrudRepository<AnimeInfEntity, UUID> {
}
