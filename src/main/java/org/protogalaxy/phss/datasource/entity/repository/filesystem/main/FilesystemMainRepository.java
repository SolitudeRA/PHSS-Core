package org.protogalaxy.phss.datasource.entity.repository.filesystem.main;

import org.protogalaxy.phss.datasource.entity.core.filesystem.main.FileSystemMainEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

public interface FilesystemMainRepository extends CrudRepository<FileSystemMainEntity, Integer> {
    @PreAuthorize("isFullyAuthenticated()&&(#username==principal.username)")
    FileSystemMainEntity findByUserEntity_Username(@Param("username") String username);
}