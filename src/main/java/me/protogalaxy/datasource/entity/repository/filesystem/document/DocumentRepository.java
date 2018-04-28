package me.protogalaxy.datasource.entity.repository.filesystem.document;

import me.protogalaxy.datasource.entity.core.filesystem.document.DocumentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface DocumentRepository extends Repository<DocumentEntity, Integer>, CrudRepository<DocumentEntity, Integer> {
}
