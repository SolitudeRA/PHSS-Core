package org.protogalaxy.phss.service.main.filesystem.database;

import org.protogalaxy.phss.service.interfaces.filesystem.database.DocumentService;

import java.util.*;

public class DocumentServiceImpl implements DocumentService {

    @Override
    public String getDocument(String username, UUID uuid){
        return null;
    }

    @Override
    public String listUserDocument(String username){
        return null;
    }

    @Override
    public String listUserDocumentByTag(String username, String tag){
        return null;
    }

    @Override
    public String listUserDocumentByCategories(String username, String category){
        return null;
    }

    @Override
    public String searchUserDocumentByName(String username, String documentName){
        return null;
    }

    @Override
    public String searchUserDocumentByTags(String username, List<String> tags){
        return null;
    }

    @Override
    public String searchUserDocumentByModifiedDate(String username, Date fromDate, Date toDate){
        return null;
    }

    @Override
    public String searchUserDocumentByLastAccessDate(String username, Date fromDate, Date toDate){
        return null;
    }
}
