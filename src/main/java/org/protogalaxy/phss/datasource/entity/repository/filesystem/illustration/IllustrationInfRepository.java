package org.protogalaxy.phss.datasource.entity.repository.filesystem.illustration;

import org.protogalaxy.phss.datasource.entity.core.filesystem.illustration.IllustrationInfEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IllustrationInfRepository extends CrudRepository<IllustrationInfEntity, UUID> {
}
