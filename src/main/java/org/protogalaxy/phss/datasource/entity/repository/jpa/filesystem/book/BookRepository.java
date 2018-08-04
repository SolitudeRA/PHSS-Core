package org.protogalaxy.phss.datasource.entity.repository.jpa.filesystem.book;

import org.protogalaxy.phss.datasource.entity.core.filesystem.book.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<BookEntity, UUID>, CrudRepository<BookEntity, UUID> {
}
