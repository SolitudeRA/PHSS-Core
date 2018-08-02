package org.protogalaxy.phss.datasource.entity.repository.jpa.filesystem.book;

import org.protogalaxy.phss.datasource.entity.core.filesystem.book.BookInfEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BookInfRepository extends CrudRepository<BookInfEntity, UUID> {
}
