package org.protogalaxy.phss.controller.filesystem;

import org.protogalaxy.phss.service.main.filesystem.io.StorageServiceImpl;
import org.protogalaxy.phss.service.main.filesystem.database.MusicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity listUserAlbum(Pageable pageable) {
        return new ResponseEntity<>(musicService.listUserAlbum(pageable), HttpStatus.OK);
    }

    @RequestMapping(value = "/album/{uuid}", method = RequestMethod.GET)
    public ResponseEntity getAlbum(@PathVariable String uuid) {
        return new ResponseEntity<>(musicService.getAlbum(uuid), HttpStatus.OK);
    }

    @RequestMapping(value = "/album/{uuid}/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteAlbum(@PathVariable String uuid) {
        musicService.removeAlbum(uuid);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/album/search", method = RequestMethod.POST)
    public ResponseEntity searchAlbumByTitle(@RequestParam("title") String title) {
        return new ResponseEntity<>(musicService.searchAlbumByTitle(title), HttpStatus.OK);
    }

    @RequestMapping(value = "/album/search", method = RequestMethod.POST)
    public ResponseEntity searchAlbumByArtist(@RequestParam("artist") String artist) {
        return new ResponseEntity<>(musicService.searchAlbumByArtist(artist), HttpStatus.OK);
    }

    @RequestMapping(value = "/track/{uuid}", method = RequestMethod.GET)
    public ResponseEntity getTrack(@PathVariable String uuid) {
        return new ResponseEntity<>(musicService.getTrack(uuid), HttpStatus.OK);
    }

    @RequestMapping(value = "/track/{uuid}/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteTrack(@PathVariable String uuid) {
        musicService.removeTrack(uuid);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/track/search", method = RequestMethod.POST)
    public ResponseEntity searchTrackByTitle(@RequestParam("title") String title) {
        return new ResponseEntity<>(musicService.searchTrackByTitle(title), HttpStatus.OK);
    }

    @RequestMapping(value = "/track/search", method = RequestMethod.POST)
    public ResponseEntity searchTrackByArtist(@RequestParam("artist") String artist) {
        return new ResponseEntity<>(musicService.searchTrackByArtist(artist), HttpStatus.OK);
    }
}
