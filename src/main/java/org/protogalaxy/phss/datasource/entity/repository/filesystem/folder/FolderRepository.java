package org.protogalaxy.phss.datasource.entity.repository.filesystem.folder;

import org.protogalaxy.phss.datasource.entity.core.filesystem.folder.FolderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface FolderRepository extends Repository<FolderEntity, UUID>, CrudRepository<FolderEntity, UUID> {
}
