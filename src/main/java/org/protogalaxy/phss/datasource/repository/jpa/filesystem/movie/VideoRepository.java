package org.protogalaxy.phss.datasource.repository.jpa.filesystem.movie;

import org.protogalaxy.phss.datasource.entity.filesystem.movie.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface VideoRepository extends JpaRepository<VideoEntity, UUID>, CrudRepository<VideoEntity, UUID> {
}
