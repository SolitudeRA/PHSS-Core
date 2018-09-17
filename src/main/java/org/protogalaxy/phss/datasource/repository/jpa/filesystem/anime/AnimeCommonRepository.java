package org.protogalaxy.phss.datasource.repository.jpa.filesystem.anime;

import org.protogalaxy.phss.datasource.entity.filesystem.anime.AnimeCommonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnimeCommonRepository extends JpaRepository<AnimeCommonEntity, UUID> {
}
