package org.protogalaxy.phss.datasource.entity.repository.jpa.filesystem.illustration;

import org.protogalaxy.phss.datasource.entity.core.filesystem.illustration.IllustrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IllustrationRepository extends JpaRepository<IllustrationEntity, UUID> {
}
