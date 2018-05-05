package me.protogalaxy.controller.filesystem;

import me.protogalaxy.service.main.filesystem.PhssStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


//TODO: Music controller implement
@PreAuthorize("hasRole('ROLE_USER')")
@RestController
@RequestMapping("/music")
public class MusicController {
    private final PhssStorageService storageService;

    @Autowired
    public MusicController(PhssStorageService storageService) {
        this.storageService = storageService;
    }

    @PreAuthorize("isFullyAuthenticated() && (#username==principal.username)")
    @PostMapping("/upload")
    public String handleMusicUpload(@RequestParam("username") String username, @RequestParam("music") MultipartFile file) {
        storageService.storeMusic(username, file);
        return null;
    }

    @PreAuthorize("isFullyAuthenticated() && (#username==principal.username)")
    @PostMapping("/multiupload")
    public String handleMultiMusicUpload(@RequestParam("username") String username, MultipartFile[] files) {
        return null;
    }
}
