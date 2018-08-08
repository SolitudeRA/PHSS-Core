package org.protogalaxy.phss.datasource.repository.jpa.filesystem.folder;

import org.protogalaxy.phss.datasource.entity.filesystem.folder.FolderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface FolderRepository extends JpaRepository<FolderEntity, UUID>, CrudRepository<FolderEntity, UUID> {
}
