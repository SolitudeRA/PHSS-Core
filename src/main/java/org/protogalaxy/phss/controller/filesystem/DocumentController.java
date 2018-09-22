package org.protogalaxy.phss.controller.filesystem;

import org.protogalaxy.phss.service.impl.filesystem.io.StorageServiceImpl;
import org.protogalaxy.phss.service.impl.filesystem.database.DocumentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Pageable;

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
    public String documentUpload(@PathVariable String username, @RequestParam("document") MultipartFile file) throws Exception {
        return storageService.storeDocument(username, file);
    }

    @PostMapping("/")
    @PreAuthorize("isFullyAuthenticated() && (#username==principal.username)")
    public String listDocument(@PathVariable String username, Pageable pageable) {
        return null;
    }

    @PostMapping("/search")
    @PreAuthorize("isFullyAuthenticated() && (#username==principal.username)")
    public String searchDocument(@PathVariable String username, String title) {
        return null;
    }
}
