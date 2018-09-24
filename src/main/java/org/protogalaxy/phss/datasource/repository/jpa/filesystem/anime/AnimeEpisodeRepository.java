package org.protogalaxy.phss.datasource.repository.jpa.filesystem.anime;

import org.protogalaxy.phss.datasource.entity.filesystem.anime.AnimeEpisodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AnimeEpisodeRepository extends JpaRepository<AnimeEpisodeEntity, UUID>, CrudRepository<AnimeEpisodeEntity, UUID> {
}
