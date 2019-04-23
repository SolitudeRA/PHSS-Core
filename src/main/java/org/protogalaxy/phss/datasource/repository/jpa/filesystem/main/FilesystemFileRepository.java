package org.protogalaxy.phss.datasource.repository.jpa.filesystem.main;

import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemFileEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface FilesystemFileRepository extends CrudRepository<FileSystemFileEntity, UUID> {
}
