package org.protogalaxy.phss.controller.filesystem;

import org.protogalaxy.phss.datasource.resource.assembler.filesystem.music.MusicAlbumResourceAssembler;
import org.protogalaxy.phss.datasource.resource.assembler.filesystem.music.MusicTrackResourceAssembler;
import org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music.MusicAlbumResource;
import org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music.MusicTrackResource;
import org.protogalaxy.phss.exception.application.filesystem.real.storage.StorageServiceException;
import org.protogalaxy.phss.service.interfaces.filesystem.database.MusicService;
import org.protogalaxy.phss.service.interfaces.filesystem.io.StorageService;
import org.protogalaxy.phss.service.main.filesystem.io.StorageServiceImpl;
import org.protogalaxy.phss.service.main.filesystem.database.MusicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/music")
public class MusicController {
    private final MusicService musicService;
    private final StorageService storageService;
    private final MusicAlbumResourceAssembler musicAlbumResourceAssembler = new MusicAlbumResourceAssembler();
    private final MusicTrackResourceAssembler musicTrackResourceAssembler = new MusicTrackResourceAssembler();

    @Autowired
    public MusicController(StorageService storageService, MusicService musicService) {
        this.storageService = storageService;
        this.musicService = musicService;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity handleMusicUpload(@RequestParam("track") MultipartFile file) throws Exception {
        try {
            return new ResponseEntity<>(musicTrackResourceAssembler.toResource(storageService.storeTrack(file)), HttpStatus.CREATED);
        } catch (StorageServiceException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/multiupload", method = RequestMethod.POST)
    public ResponseEntity handleMusicMultiUpload(@RequestParam("tracks") MultipartFile[] files) throws Exception {
        return new ResponseEntity<>(musicTrackResourceAssembler.toResources(storageService.storeTracks(files)), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/album", method = RequestMethod.GET)
    public ResponseEntity listUserAlbum(Pageable pageable) {
        return new ResponseEntity<>(musicAlbumResourceAssembler.toResources(musicService.listUserAlbum(pageable)), HttpStatus.OK);
    }

    @RequestMapping(value = "/album/{uuid}", method = RequestMethod.GET)
    public ResponseEntity getAlbum(@PathVariable String uuid) {
        return new ResponseEntity<>(musicAlbumResourceAssembler.toResource(musicService.getAlbum(uuid)), HttpStatus.OK);
    }

    @RequestMapping(value = "/album/{uuid}/update", method = RequestMethod.PATCH)
    public ResponseEntity updateAlbum(@PathVariable String uuid, MusicAlbumResource musicAlbumResource) {
        return new ResponseEntity<>(musicAlbumResourceAssembler.toResource(musicService.updateAlbumWithUuidAndResource(UUID.fromString(uuid), musicAlbumResource)), HttpStatus.OK);
    }

    @RequestMapping(value = "/album/{uuid}/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteAlbum(@PathVariable String uuid) {
        musicService.removeAlbum(uuid);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/album/search/title", method = RequestMethod.POST)
    public ResponseEntity searchAlbumByTitle(@RequestParam("title") String title) {
        return new ResponseEntity<>(musicAlbumResourceAssembler.toResources(musicService.searchAlbumByTitle(title)), HttpStatus.OK);
    }

    @RequestMapping(value = "/album/search/artist", method = RequestMethod.POST)
    public ResponseEntity searchAlbumByArtist(@RequestParam("artist") String artist) {
        return new ResponseEntity<>(musicAlbumResourceAssembler.toResources(musicService.searchAlbumByArtist(artist)), HttpStatus.OK);
    }

    @RequestMapping(value = "/track/{uuid}", method = RequestMethod.GET)
    public ResponseEntity getTrack(@PathVariable String uuid) {
        return new ResponseEntity<>(musicTrackResourceAssembler.toResource(musicService.getTrack(uuid)), HttpStatus.OK);
    }

    @RequestMapping(value = "/track/{uuid}/update", method = RequestMethod.PATCH)
    public ResponseEntity updateTrack(@PathVariable String uuid, MusicTrackResource musicTrackResource) {
        return new ResponseEntity<>(musicTrackResourceAssembler.toResource(musicService.updateTrackWithUuidAndResource(UUID.fromString(uuid), musicTrackResource)), HttpStatus.OK);
    }

    @RequestMapping(value = "/track/{uuid}/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteTrack(@PathVariable String uuid) {
        musicService.removeTrack(uuid);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/track/search/title", method = RequestMethod.POST)
    public ResponseEntity searchTrackByTitle(@RequestParam("title") String title) {
        return new ResponseEntity<>(musicTrackResourceAssembler.toResources(musicService.searchTrackByTitle(title)), HttpStatus.OK);
    }

    @RequestMapping(value = "/track/search/artist", method = RequestMethod.POST)
    public ResponseEntity searchTrackByArtist(@RequestParam("artist") String artist) {
        return new ResponseEntity<>(musicTrackResourceAssembler.toResources(musicService.searchTrackByArtist(artist)), HttpStatus.OK);
    }
}
