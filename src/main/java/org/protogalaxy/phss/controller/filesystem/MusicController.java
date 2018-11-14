package org.protogalaxy.phss.controller.filesystem;

import org.protogalaxy.phss.service.main.filesystem.io.StorageServiceImpl;
import org.protogalaxy.phss.service.main.filesystem.database.MusicServiceImpl;
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

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @PreAuthorize("isFullyAuthenticated() && (#username==principal.username)")
    public String handleMusicUpload(@PathVariable String username, @RequestParam("music") MultipartFile file) throws Exception {
        return storageService.storeTrack(username, file);
    }

    @RequestMapping(value = "/multiupload", method = RequestMethod.POST)
    @PreAuthorize("isFullyAuthenticated() && (#username==principal.username)")
    public String handleMusicMultiUpload(@PathVariable String username, MultipartFile[] files) throws Exception {
        return storageService.storeTracks(username, files);
    }

    @RequestMapping(value = "/album", method = RequestMethod.GET)
    @PreAuthorize("isFullyAuthenticated() && (#username==principal.username)")
    public String listUserAlbum(@PathVariable String username, Pageable pageable) throws Exception {
        return musicService.listUserAlbum(username, pageable);
    }

    @RequestMapping(value = "/album/{id}", method = RequestMethod.GET)
    @PreAuthorize("isFullyAuthenticated() && (#username==principal.username)")
    public String getUserAlbumById(@PathVariable String username, @PathVariable int id) throws Exception {
        return musicService.getAlbum(username, id);
    }

    @RequestMapping(value = "/album/{id}/track", method = RequestMethod.GET)
    @PreAuthorize("isFullyAuthenticated() && (#username==principal.username)")
    public String listUserTrackByAlbumId(@PathVariable String username, @PathVariable int id) throws Exception {
        return musicService.listTrackByAlbumId(username, id);
    }

    @RequestMapping(value = "/search/album", method = RequestMethod.POST)
    @PreAuthorize("isFullyAuthenticated() && (#username==principal.username)")
    public String listUserAlbumByTile(@PathVariable String username, String title) throws Exception {
        return musicService.listAlbumByTitle(username, title);
    }

    @RequestMapping(value = "/search/track", method = RequestMethod.POST)
    @PreAuthorize("isFullyAuthenticated() && (#username==principal.username)")
    public String listUserTrackByTitle(@PathVariable String username, String title) throws Exception {
        return musicService.listTrackByTitle(username, title);
    }
}
