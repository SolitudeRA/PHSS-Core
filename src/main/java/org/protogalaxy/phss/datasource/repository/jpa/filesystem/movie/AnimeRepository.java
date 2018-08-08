package org.protogalaxy.phss.datasource.repository.jpa.filesystem.movie;

import org.protogalaxy.phss.datasource.entity.filesystem.movie.AnimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnimeRepository extends JpaRepository<AnimeEntity, UUID> {
}
