package org.protogalaxy.phss.controller.filesystem;

import org.protogalaxy.phss.service.impl.filesystem.io.StorageServiceImpl;
import org.protogalaxy.phss.service.impl.filesystem.logic.DocumentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/{username}/document")
public class DocumentController {
    private final StorageServiceImpl storageService;
    private final DocumentServiceImpl documentService;

    @Autowired
    public DocumentController(StorageServiceImpl storageService, DocumentServiceImpl documentService) {
        this.storageService = storageService;
        this.documentService = documentService;
    }

    @PostMapping("/upload")
    @PreAuthorize("isFullyAuthenticated() && (#username==principal.username)")
    public String documentUpload(@PathVariable String username, MultipartFile file, String type) {
        return storageService.storeDocument(username, file, type);
    }
}
