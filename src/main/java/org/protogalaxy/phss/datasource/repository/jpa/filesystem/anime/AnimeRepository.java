package org.protogalaxy.phss.datasource.repository.jpa.filesystem.anime;

import org.protogalaxy.phss.datasource.entity.filesystem.anime.AnimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnimeRepository extends JpaRepository<AnimeEntity, UUID> {
}
