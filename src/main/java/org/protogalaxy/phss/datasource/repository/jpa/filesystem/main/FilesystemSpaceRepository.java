package org.protogalaxy.phss.datasource.repository.jpa.filesystem.main;

import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemSpaceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface FilesystemSpaceRepository extends CrudRepository<FileSystemSpaceEntity, UUID> {
}
