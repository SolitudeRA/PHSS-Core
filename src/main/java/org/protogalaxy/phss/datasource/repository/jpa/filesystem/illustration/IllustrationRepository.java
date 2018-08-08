package org.protogalaxy.phss.datasource.repository.jpa.filesystem.illustration;

import org.protogalaxy.phss.datasource.entity.filesystem.illustration.IllustrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IllustrationRepository extends JpaRepository<IllustrationEntity, UUID> {
}
