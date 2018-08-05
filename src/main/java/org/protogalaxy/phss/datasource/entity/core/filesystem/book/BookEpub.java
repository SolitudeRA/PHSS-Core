package org.protogalaxy.phss.datasource.entity.core.filesystem.book;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Document(collection = "e_book")
public class BookEpub {
    @Id
    @GeneratedValue
    private UUID uuid;
}
