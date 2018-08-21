package org.protogalaxy.phss.service.main.filesystem.logic;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public interface DocumentService {
    /**
     * Get a document
     *
     * @param username name of the user
     * @param uuid     uuid of the document
     * @return JSON format string of the document
     */
    String getDocument(String username, UUID uuid);

    /**
     * List all of the user's document
     *
     * @param username name of the user
     * @return JSON format string of the documents
     */
    String listUserDocument(String username);

    /**
     * List user's documents by tag
     *
     * @param username name of the user
     * @param tag      tag of documents
     * @return JSON format string of the documents
     */
    String listUserDocumentByTag(String username, String tag);

    /**
     * List user's documents by categories
     *
     * @param username name of the user
     * @param category category of documents
     * @return JSON format string of the documents
     */
    String listUserDocumentByCategories(String username, String category);

    /**
     * Search user's documents by name
     *
     * @param username     name of the user
     * @param documentName name of documents
     * @return JSON format string of the documents
     */
    String searchUserDocumentByName(String username, String documentName);

    /**
     * Search user's documents by tags
     *
     * @param username name of the user
     * @param tags     tags of documents
     * @return JSON format string of the documents
     */
    String searchUserDocumentByTags(String username, List<String> tags);

    /**
     * Search user's documents by modified date
     *
     * @param username name os the user
     * @param fromDate date where begins
     * @param toDate   date where ends
     * @return JSON format string of the documents
     */
    String searchUserDocumentByModifiedDate(String username, Date fromDate, Date toDate);

    /**
     * Search user's documents by last access date
     *
     * @param username name of the user
     * @param fromDate date where begins
     * @param toDate   date where ends
     * @return JSON format string of the documents
     */
    String searchUserDocumentByLastAccessDate(String username, Date fromDate, Date toDate);
}
