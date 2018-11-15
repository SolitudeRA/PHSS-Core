package org.protogalaxy.phss.datasource.repository.jpa.filesystem.photo;

import org.protogalaxy.phss.datasource.entity.filesystem.photo.PhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PhotoRepository extends JpaRepository<PhotoEntity, UUID>, CrudRepository<PhotoEntity, UUID> {
}
