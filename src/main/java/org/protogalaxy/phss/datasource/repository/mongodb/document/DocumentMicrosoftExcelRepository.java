package org.protogalaxy.phss.datasource.repository.mongodb.document;

import org.protogalaxy.phss.datasource.entity.filesystem.document.DocumentMicrosoftExcelEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DocumentMicrosoftExcelRepository extends MongoRepository<DocumentMicrosoftExcelEntity, UUID>, CrudRepository<DocumentMicrosoftExcelEntity, UUID> {
}
