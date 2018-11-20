package org.protogalaxy.phss.controller.filesystem;

import org.protogalaxy.phss.service.main.filesystem.io.StorageServiceImpl;
import org.protogalaxy.phss.service.main.filesystem.database.MusicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.RequestEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/music")
public class MusicController {
    private final StorageServiceImpl storageService;
    private final MusicServiceImpl musicService;

    @Autowired
    public MusicController(StorageServiceImpl storageService, MusicServiceImpl musicService) {
        this.storageService = storageService;
        this.musicService = musicService;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String handleMusicUpload(@RequestParam("track") MultipartFile file) throws Exception {
        return storageService.storeTrack(SecurityContextHolder.getContext().getAuthentication().getName(), file);
    }

    @RequestMapping(value = "/multiupload", method = RequestMethod.POST)
    public String handleMusicMultiUpload(@RequestParam("tracks") MultipartFile[] files) throws Exception {
        return storageService.storeTracks(SecurityContextHolder.getContext().getAuthentication().getName(), files);
    }

    @RequestMapping(value = "/album", method = RequestMethod.GET)
    public String listUserAlbum(Pageable pageable) throws Exception {
        return musicService.listUserAlbum(SecurityContextHolder.getContext().getAuthentication().getName(), pageable);
    }

    @RequestMapping(value = "/album/{id}", method = RequestMethod.GET)
    public String getUserAlbumById(@PathVariable int id) throws Exception {
        return musicService.getAlbum(SecurityContextHolder.getContext().getAuthentication().getName(), id);
    }

    @RequestMapping(value = "/album/{uuid}/track", method = RequestMethod.GET)
    public String listUserTrackByAlbumId(@PathVariable String uuid) throws Exception {
        return musicService.listTrackByAlbumId(SecurityContextHolder.getContext().getAuthentication().getName(), id);
    }

    @RequestMapping(value = "/album/{uuid}/delete", method = RequestMethod.DELETE)
    public RequestEntity deleteAlbum(@PathVariable String uuid) {

    }

    @RequestMapping(value = "/search/album", method = RequestMethod.POST)
    public String listUserAlbumByTile(String title) throws Exception {
        return musicService.listAlbumByTitle(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString(), title);
    }

    @RequestMapping(value = "/search/track", method = RequestMethod.POST)
    public String listUserTrackByTitle(String title) throws Exception {
        return musicService.listTrackByTitle(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString(), title);
    }
}
