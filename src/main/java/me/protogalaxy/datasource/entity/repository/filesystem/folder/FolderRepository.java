package me.protogalaxy.datasource.entity.repository.filesystem.folder;

import me.protogalaxy.datasource.entity.core.filesystem.folder.FolderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface FolderRepository extends Repository<FolderEntity, Integer>, CrudRepository<FolderEntity, Integer> {
}
