package org.protogalaxy.phss.datasource.entity.repository.filesystem.document;

import org.protogalaxy.phss.datasource.entity.core.filesystem.document.DocumentInfEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DocumentInfRepository extends CrudRepository<DocumentInfEntity, UUID> {
}
