package org.protogalaxy.phss.datasource.repository.jpa.filesystem.main;

import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemMainEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

public interface FilesystemMainRepository extends CrudRepository<FileSystemMainEntity, Integer> {
    @PreAuthorize("isFullyAuthenticated()&&(#username==principal.username)")
    FileSystemMainEntity findByAccountEntity_Username(@Param("username") String username);
}
