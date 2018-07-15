package org.protogalaxy.phss.datasource.entity.repository.filesystem.album.photo;

import org.protogalaxy.phss.datasource.entity.core.filesystem.album.photo.PhotoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface PhotoRepository extends Repository<PhotoEntity, Integer>, CrudRepository<PhotoEntity, Integer> {
}
