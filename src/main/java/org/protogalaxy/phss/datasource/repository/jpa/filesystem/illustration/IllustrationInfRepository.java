package org.protogalaxy.phss.datasource.repository.jpa.filesystem.illustration;

import org.protogalaxy.phss.datasource.entity.filesystem.illustration.IllustrationInfEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IllustrationInfRepository extends CrudRepository<IllustrationInfEntity, UUID> {
}
