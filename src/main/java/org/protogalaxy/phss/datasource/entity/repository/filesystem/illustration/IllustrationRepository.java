package org.protogalaxy.phss.datasource.entity.repository.filesystem.illustration;

import org.protogalaxy.phss.datasource.entity.core.filesystem.illustration.IllustrationEntity;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface IllustrationRepository extends Repository<IllustrationEntity, UUID> {
}
