package org.protogalaxy.phss.service.interfaces.filesystem.database;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public interface DocumentService {
    /**
     * Get a document
     *
     * @param username name of the account
     * @param uuid     uuid of the document
     * @return JSON format string of the document
     */
    String getDocument(String username, UUID uuid);

    /**
     * List all of the account's document
     *
     * @param username name of the account
     * @return JSON format string of the documents
     */
    String listUserDocument(String username);

    /**
     * List account's documents by tag
     *
     * @param username name of the account
     * @param tag      tag of documents
     * @return JSON format string of the documents
     */
    String listUserDocumentByTag(String username, String tag);

    /**
     * List account's documents by categories
     *
     * @param username name of the account
     * @param category category of documents
     * @return JSON format string of the documents
     */
    String listUserDocumentByCategories(String username, String category);

    /**
     * Search account's documents by name
     *
     * @param username     name of the account
     * @param documentName name of documents
     * @return JSON format string of the documents
     */
    String searchUserDocumentByName(String username, String documentName);

    /**
     * Search account's documents by tags
     *
     * @param username name of the account
     * @param tags     tags of documents
     * @return JSON format string of the documents
     */
    String searchUserDocumentByTags(String username, List<String> tags);

    /**
     * Search account's documents by modified date
     *
     * @param username name os the account
     * @param fromDate date where begins
     * @param toDate   date where ends
     * @return JSON format string of the documents
     */
    String searchUserDocumentByModifiedDate(String username, Date fromDate, Date toDate);

    /**
     * Search account's documents by last access date
     *
     * @param username name of the account
     * @param fromDate date where begins
     * @param toDate   date where ends
     * @return JSON format string of the documents
     */
    String searchUserDocumentByLastAccessDate(String username, Date fromDate, Date toDate);
}
