package org.protogalaxy.phss.datasource.repository.jpa.filesystem.book;

import org.protogalaxy.phss.datasource.entity.filesystem.book.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<BookEntity, UUID> {
}
