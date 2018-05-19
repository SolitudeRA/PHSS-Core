package me.protogalaxy.controller.filesystem;

import me.protogalaxy.service.impl.filesystem.io.StorageServiceImpl;
import me.protogalaxy.service.impl.filesystem.logic.MusicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/{username}/music")
public class MusicController {
    private final StorageServiceImpl storageService;
    private final MusicServiceImpl musicService;

    @Autowired
    public MusicController(StorageServiceImpl storageService, MusicServiceImpl musicService) {
        this.storageService = storageService;
        this.musicService = musicService;
    }

    @PreAuthorize("isFullyAuthenticated() && (#username==principal.username)")
    @PostMapping("/upload")
    public String handleMusicUpload(@PathVariable String username, @RequestParam("music") MultipartFile file) throws Exception {
        return storageService.storeMusic(username, file);
    }

    @PreAuthorize("isFullyAuthenticated() && (#username==principal.username)")
    @PostMapping("/multiupload")
    public String handleMultiMusicUpload(@PathVariable String username, MultipartFile[] files) {
        return null;
    }

    @PreAuthorize("isFullyAuthenticated() && (#username==principal.username)")
    @PostMapping("/album")
    public String listAlbum(@PathVariable String username, Pageable pageable) throws Exception {
        return musicService.listAlbum(username, pageable);
    }

    @PreAuthorize("isFullyAuthenticated() && (#username==principal.username)")
    @PostMapping("/album/track")
    public String listTrackFromAlbum(@PathVariable String username, String album) throws Exception {
        return musicService.listTrackByAlbum(username, album);
    }
}
