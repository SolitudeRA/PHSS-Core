package org.protogalaxy.phss.datasource.entity.repository.filesystem.document;

import org.protogalaxy.phss.datasource.entity.core.filesystem.document.DocumentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface DocumentRepository extends Repository<DocumentEntity, Integer>, CrudRepository<DocumentEntity, Integer> {
}
