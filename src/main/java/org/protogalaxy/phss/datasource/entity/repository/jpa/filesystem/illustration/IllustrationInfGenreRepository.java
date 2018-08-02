package org.protogalaxy.phss.datasource.entity.repository.jpa.filesystem.illustration;

import org.protogalaxy.phss.datasource.entity.core.filesystem.illustration.IllustrationInfGenreEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IllustrationInfGenreRepository extends CrudRepository<IllustrationInfGenreEntity, UUID> {
}
