package org.protogalaxy.phss.datasource.entity.repository.jpa.filesystem.movie;

import org.protogalaxy.phss.datasource.entity.core.filesystem.movie.AnimeEntity;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface AnimeRepository extends Repository<AnimeEntity, UUID> {
}
