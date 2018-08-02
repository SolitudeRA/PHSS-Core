package org.protogalaxy.phss.datasource.entity.repository.jpa.filesystem.main;

import org.protogalaxy.phss.datasource.entity.core.filesystem.main.FileSystemSpaceEntity;
import org.springframework.data.repository.CrudRepository;


public interface FilesystemSpaceRepository extends CrudRepository<FileSystemSpaceEntity, Integer> {
}
