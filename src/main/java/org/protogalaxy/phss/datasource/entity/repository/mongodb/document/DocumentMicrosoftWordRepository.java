package org.protogalaxy.phss.datasource.entity.repository.mongodb.document;

import org.protogalaxy.phss.datasource.entity.core.filesystem.document.DocumentMicrosoftWordEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DocumentMicrosoftWordRepository extends MongoRepository<DocumentMicrosoftWordEntity, UUID>, CrudRepository<DocumentMicrosoftWordEntity, UUID> {
}
