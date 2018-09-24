package org.protogalaxy.phss.datasource.repository.jpa.filesystem.anime;

import org.protogalaxy.phss.datasource.entity.filesystem.anime.AnimeFirmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AnimeFirmRepository extends JpaRepository<AnimeFirmEntity, UUID>, CrudRepository<AnimeFirmEntity, UUID> {
}
