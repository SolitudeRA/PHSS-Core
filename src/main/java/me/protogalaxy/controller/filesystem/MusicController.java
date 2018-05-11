package me.protogalaxy.controller.filesystem;

import me.protogalaxy.service.main.filesystem.io.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


//TODO: Music controller implement
@PreAuthorize("hasRole('ROLE_USER')")
@RestController
@RequestMapping("/music")
public class MusicController {
    private final StorageService storageService;

    @Autowired
    public MusicController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PreAuthorize("isFullyAuthenticated() && (#username==principal.username)")
    @PostMapping("/upload")
    public String handleMusicUpload(@RequestParam("username") String username, @RequestParam("music") MultipartFile file) throws Exception {
        return storageService.storeMusic(username, file);
    }

    @PreAuthorize("isFullyAuthenticated() && (#username==principal.username)")
    @PostMapping("/multiupload")
    public String handleMultiMusicUpload(@RequestParam("username") String username, MultipartFile[] files) {
        return null;
    }
}
