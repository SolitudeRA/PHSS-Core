package org.protogalaxy.phss.datasource.repository.mongodb.document;

import org.protogalaxy.phss.datasource.entity.filesystem.document.DocumentOpenTextEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DocumentOpenTextRepository extends MongoRepository<DocumentOpenTextEntity, UUID>, CrudRepository<DocumentOpenTextEntity, UUID> {
}
