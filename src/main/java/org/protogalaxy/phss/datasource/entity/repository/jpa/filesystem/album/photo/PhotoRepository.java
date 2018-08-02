package org.protogalaxy.phss.datasource.entity.repository.jpa.filesystem.album.photo;

import org.protogalaxy.phss.datasource.entity.core.filesystem.album.photo.PhotoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface PhotoRepository extends Repository<PhotoEntity, UUID>, CrudRepository<PhotoEntity, UUID> {
}
