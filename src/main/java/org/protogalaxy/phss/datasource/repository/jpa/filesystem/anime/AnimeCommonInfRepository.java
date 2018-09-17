package org.protogalaxy.phss.datasource.repository.jpa.filesystem.anime;

import org.protogalaxy.phss.datasource.entity.filesystem.anime.AnimeCommonInfEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AnimeCommonInfRepository extends CrudRepository<AnimeCommonInfEntity, UUID> {
}
