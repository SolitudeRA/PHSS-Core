package me.protogalaxy.datasource.entity.repository.filesystem.main;

import me.protogalaxy.datasource.entity.core.filesystem.main.FileSystemMainEntity;
import org.springframework.data.repository.CrudRepository;

public interface FilesystemMainRepository extends CrudRepository<FileSystemMainEntity, Integer> {
}
