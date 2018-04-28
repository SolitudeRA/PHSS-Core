package me.protogalaxy.datasource.entity.repository.filesystem.book;

import me.protogalaxy.datasource.entity.core.filesystem.book.BookInfEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookInfRepository extends CrudRepository<BookInfEntity, Integer> {
}
