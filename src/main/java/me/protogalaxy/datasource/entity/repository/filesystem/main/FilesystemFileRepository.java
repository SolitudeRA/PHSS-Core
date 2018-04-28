package me.protogalaxy.datasource.entity.repository.filesystem.main;

import me.protogalaxy.datasource.entity.core.filesystem.main.FileSystemFileEntity;
import org.springframework.data.repository.CrudRepository;

public interface FilesystemFileRepository extends CrudRepository<FileSystemFileEntity, Integer> {
}
