package org.protogalaxy.phss.datasource.entity.repository.filesystem.main;

import org.protogalaxy.phss.datasource.entity.core.filesystem.main.FileSystemFileEntity;
import org.springframework.data.repository.CrudRepository;

public interface FilesystemFileRepository extends CrudRepository<FileSystemFileEntity, Integer> {
}
