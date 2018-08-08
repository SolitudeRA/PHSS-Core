package org.protogalaxy.phss.datasource.repository.jpa.filesystem.folder;

import org.protogalaxy.phss.datasource.entity.filesystem.folder.FolderExtEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface FolderExtRepository extends CrudRepository<FolderExtEntity, UUID> {
}
