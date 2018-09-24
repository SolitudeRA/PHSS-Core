package org.protogalaxy.phss.datasource.repository.jpa.filesystem.anime;

import org.protogalaxy.phss.datasource.entity.filesystem.anime.AnimeMovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AnimeMovieRepository extends JpaRepository<AnimeMovieEntity, UUID>, CrudRepository<AnimeMovieEntity, UUID> {
}
