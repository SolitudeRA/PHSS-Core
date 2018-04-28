package me.protogalaxy.datasource.entity.repository.filesystem.main;

import me.protogalaxy.datasource.entity.core.filesystem.main.FileSystemSpaceEntity;
import org.springframework.data.repository.CrudRepository;

public interface FilesystemSpaceRepository extends CrudRepository<FileSystemSpaceEntity, Integer> {
}
