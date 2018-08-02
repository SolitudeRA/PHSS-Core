package org.protogalaxy.phss.datasource.entity.repository.jpa.filesystem.main;

import org.protogalaxy.phss.datasource.entity.core.filesystem.main.FileSystemFileEntity;
import org.springframework.data.repository.CrudRepository;

public interface FilesystemFileRepository extends CrudRepository<FileSystemFileEntity, Integer> {
}
