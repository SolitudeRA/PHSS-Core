package org.protogalaxy.phss.service.main.filesystem.database;

import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicAlbumEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackEntity;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.music.MusicAlbumRepository;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.music.MusicTrackRepository;
import org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music.MusicAlbumResource;
import org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music.MusicTrackResource;
import org.protogalaxy.phss.service.interfaces.filesystem.database.MusicService;
import org.protogalaxy.phss.service.interfaces.filesystem.io.StorageService;
import org.protogalaxy.phss.service.main.filesystem.io.StorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MusicServiceImpl implements MusicService {
    private StorageService storageService;
    private MusicAlbumRepository musicAlbumRepository;
    private MusicTrackRepository musicTrackRepository;

    @Autowired
    public MusicServiceImpl(StorageServiceImpl storageService,
                            MusicAlbumRepository musicAlbumRepository,
                            MusicTrackRepository musicTrackRepository) {
        this.storageService = storageService;
        this.musicAlbumRepository = musicAlbumRepository;
        this.musicTrackRepository = musicTrackRepository;
    }


    /**
     * Get an album
     *
     * @param uuid UUID of the album
     * @return Resource of the album
     */
    @Override
    public MusicAlbumEntity getAlbum(String uuid) {
        return musicAlbumRepository.findByUuid(UUID.fromString(uuid));
    }

    /**
     * Update an album with UUID and resource
     *
     * @param uuid               UUID of the updated album
     * @param musicAlbumResource Resource of the updated album
     * @return Entity of the updated album
     */
    @Override
    public MusicAlbumEntity updateAlbumWithUuidAndResource(UUID uuid, MusicAlbumResource musicAlbumResource) {
        MusicAlbumEntity musicAlbumEntity = musicAlbumRepository.findByUuid(uuid);
        return musicAlbumRepository.save(musicAlbumEntity.updateFromResource(musicAlbumResource));
    }

    /**
     * Update an album with entity
     *
     * @param musicAlbumEntity Entity of the updated album
     * @return Entity of the updated album
     */
    @Override
    public MusicAlbumEntity updateAlbumWithEntity(MusicAlbumEntity musicAlbumEntity) {
        return musicAlbumRepository.save(musicAlbumEntity);
    }

    /**
     * Remove an album
     *
     * @param uuid UUID of the album
     */
    @Override
    public void removeAlbum(String uuid) {
        storageService.deleteMusicAlbum(UUID.fromString(uuid));
        musicAlbumRepository.deleteByUuid(UUID.fromString(uuid));
    }

    /**
     * List account albums
     *
     * @param pageable Data page
     * @return Resource List of the albums
     */
    @Override
    public Page<MusicAlbumEntity> listUserAlbum(Pageable pageable) {
        return musicAlbumRepository.findAllByFileSystemOwner_AccountEntity_Username(SecurityContextHolder.getContext().getAuthentication().getName(), pageable);
    }

    /**
     * Search albums by name
     *
     * @param title Title of the albums
     * @return Resource list of the albums
     */
    @Override
    public List<MusicAlbumEntity> searchAlbumByTitle(String title) {
        return musicAlbumRepository.findAllByFileSystemOwner_AccountEntity_UsernameAndTitle(SecurityContextHolder.getContext().getAuthentication().getName(), title);
    }

    /**
     * Search albums by artist
     *
     * @param artist Artist of the albums
     * @return Resource list of the albums
     */
    @Override
    public List<MusicAlbumEntity> searchAlbumByArtist(String artist) {
        return musicAlbumRepository.findAllByFileSystemOwner_AccountEntity_UsernameAndArtist(SecurityContextHolder.getContext().getAuthentication().getName(), artist);
    }

    /**
     * Get a track
     *
     * @param uuid UUID of the track
     * @return Resource of the track
     */
    @Override
    public MusicTrackEntity getTrack(String uuid) {
        return musicTrackRepository.findByUuid(UUID.fromString(uuid));
    }

    /**
     * Update a track with UUID and resource
     *
     * @param uuid               UUID of the updated track
     * @param musicTrackResource Resource of the updated track
     * @return Entity of the updated track
     */
    @Override
    public MusicTrackEntity updateTrackWithUuidAndResource(UUID uuid, MusicTrackResource musicTrackResource) {
        MusicTrackEntity musicTrackEntity = musicTrackRepository.findByUuid(uuid);
        return musicTrackRepository.save(musicTrackEntity.updateFromResource(musicTrackResource));
    }

    /**
     * Update a track with entity
     *
     * @param musicTrackEntity Entity of the updated track
     * @return Entity of the updated track
     */
    @Override
    public MusicTrackEntity updateTrackWithEntity(MusicTrackEntity musicTrackEntity) {
        return musicTrackRepository.save(musicTrackEntity);
    }

    /**
     * Remove a track
     *
     * @param uuid UUID of the track
     */
    @Override
    public void removeTrack(String uuid) {
        storageService.deleteTrack(UUID.fromString(uuid));
        musicTrackRepository.deleteByUuid(UUID.fromString(uuid));
    }

    /**
     * Search track by title
     *
     * @param title Name of the tracks
     * @return Resource list of the tracks
     */
    @Override
    public List<MusicTrackEntity> searchTrackByTitle(String title) {
        return musicTrackRepository.findAllByFileSystemOwner_AccountEntity_UsernameAndTitle(SecurityContextHolder.getContext().getAuthentication().getName(), title);
    }

    /**
     * Search track by artist
     *
     * @param artist Artist of the tracks
     * @return Resource list of the tracks
     */
    @Override
    public List<MusicTrackEntity> searchTrackByArtist(String artist) {
        return musicTrackRepository.findAllByFileSystemOwner_AccountEntity_UsernameAndArtist(SecurityContextHolder.getContext().getAuthentication().getName(), artist);
    }
}
