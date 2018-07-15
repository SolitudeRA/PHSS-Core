package org.protogalaxy.phss.datasource.entity.repository.filesystem.book;

import org.protogalaxy.phss.datasource.entity.core.filesystem.book.BookEntity;
import org.protogalaxy.phss.datasource.entity.core.filesystem.book.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface BookRepository extends Repository<BookEntity, Integer>, CrudRepository<BookEntity, Integer> {
}
