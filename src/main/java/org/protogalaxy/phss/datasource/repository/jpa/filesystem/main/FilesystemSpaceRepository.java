package org.protogalaxy.phss.datasource.repository.jpa.filesystem.main;

import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemSpaceEntity;
import org.springframework.data.repository.CrudRepository;


public interface FilesystemSpaceRepository extends CrudRepository<FileSystemSpaceEntity, Integer> {
}
