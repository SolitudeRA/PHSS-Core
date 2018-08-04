package org.protogalaxy.phss.datasource.entity.repository.mongodb.document;

import org.protogalaxy.phss.datasource.entity.core.filesystem.document.DocumentOpenPresentationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DocumentOpenPresentationRepository extends MongoRepository<DocumentOpenPresentationEntity, UUID>, CrudRepository<DocumentOpenPresentationEntity, UUID> {
}
