package org.protogalaxy.phss.controller.filesystem;

import org.protogalaxy.phss.service.impl.filesystem.io.StorageServiceImpl;
import org.protogalaxy.phss.service.impl.filesystem.database.MusicServiceImpl;
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

    @PostMapping("/upload")
    @PreAuthorize("isFullyAuthenticated() && (#username==principal.username)")
    public String handleMusicUpload(@PathVariable String username, @RequestParam("music") MultipartFile file) throws Exception {
        return storageService.storeTrack(username, file);
    }

    @PostMapping("/multiupload")
    @PreAuthorize("isFullyAuthenticated() && (#username==principal.username)")
    public String handleMusicMultiUpload(@PathVariable String username, MultipartFile[] files) throws Exception {
        return storageService.storeTracks(username, files);
    }

    @PostMapping("/album")
    @PreAuthorize("isFullyAuthenticated() && (#username==principal.username)")
    public String listUserAlbum(@PathVariable String username, Pageable pageable) throws Exception {
        return musicService.listUserAlbum(username, pageable);
    }

    @PostMapping("/album/{id}")
    @PreAuthorize("isFullyAuthenticated() && (#username==principal.username)")
    public String getUserAlbumById(@PathVariable String username, @PathVariable int id) throws Exception {
        return musicService.getAlbum(username, id);
    }

    @PostMapping("/album/{id}/track")
    @PreAuthorize("isFullyAuthenticated() && (#username==principal.username)")
    public String listUserTrackByAlbumId(@PathVariable String username, @PathVariable int id) throws Exception {
        return musicService.listTrackByAlbumId(username, id);
    }

    @PostMapping("/search/album")
    @PreAuthorize("isFullyAuthenticated() && (#username==principal.username)")
    public String listUserAlbumByTile(@PathVariable String username, String title) throws Exception {
        return musicService.listAlbumByTitle(username, title);
    }

    @PostMapping("/search/track")
    @PreAuthorize("isFullyAuthenticated() && (#username==principal.username)")
    public String listUserTrackByTitle(@PathVariable String username, String title) throws Exception {
        return musicService.listTrackByTitle(username, title);
    }
}
