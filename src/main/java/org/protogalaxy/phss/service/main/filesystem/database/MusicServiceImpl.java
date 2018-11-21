package org.protogalaxy.phss.service.main.filesystem.database;

import org.protogalaxy.phss.datasource.repository.jpa.filesystem.music.MusicAlbumRepository;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.music.MusicTrackRepository;
import org.protogalaxy.phss.datasource.resource.assembler.filesystem.music.MusicAlbumResourceAssembler;
import org.protogalaxy.phss.datasource.resource.assembler.filesystem.music.MusicTrackResourceAssembler;
import org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music.MusicAlbumResource;
import org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music.MusicTrackResource;
import org.protogalaxy.phss.service.interfaces.filesystem.database.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MusicServiceImpl implements MusicService {
    private MusicAlbumRepository musicAlbumRepository;
    private MusicTrackRepository musicTrackRepository;
    private MusicAlbumResourceAssembler musicAlbumResourceAssembler = new MusicAlbumResourceAssembler();
    private MusicTrackResourceAssembler musicTrackResourceAssembler = new MusicTrackResourceAssembler();

    @Autowired
    public MusicServiceImpl(MusicAlbumRepository musicAlbumRepository,
                            MusicTrackRepository musicTrackRepository) {
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
    public MusicAlbumResource getAlbum(String uuid) {
        return musicAlbumResourceAssembler.toResource(musicAlbumRepository.findByUuid(UUID.fromString(uuid)));
    }

    /**
     * Update an album
     *
     * @param musicAlbumResource Resource of the updated album
     * @return Resource of the updated album
     */
    @Override
    public MusicAlbumResource updateAlbum(MusicAlbumResource musicAlbumResource) {
        return null;
    }

    /**
     * Remove an album
     *
     * @param uuid UUID of the album
     */
    @Override
    public void removeAlbum(String uuid) {
        musicAlbumRepository.deleteByUuid(UUID.fromString(uuid));
    }

    /**
     * List account albums
     *
     * @param pageable Data page
     * @return Resource List of the albums
     */
    @Override
    public List<MusicAlbumResource> listUserAlbum(Pageable pageable) {
        return musicAlbumResourceAssembler.toResources(musicAlbumRepository.findAllByFileSystemOwner_AccountEntity_Username(SecurityContextHolder.getContext().getAuthentication().getName(), pageable));
    }

    /**
     * Search albums by name
     *
     * @param title Title of the albums
     * @return Resource list of the albums
     */
    @Override
    public List<MusicAlbumResource> searchAlbumByTitle(String title) {
        return musicAlbumResourceAssembler.toResources(musicAlbumRepository.findAllByFileSystemOwner_AccountEntity_UsernameAndTitle(SecurityContextHolder.getContext().getAuthentication().getName(), title));
    }

    /**
     * Search albums by artist
     *
     * @param artist Artist of the albums
     * @return Resource list of the albums
     */
    @Override
    public List<MusicAlbumResource> searchAlbumByArtist(String artist) {
        return musicAlbumResourceAssembler.toResources(musicAlbumRepository.findAllByFileSystemOwner_AccountEntity_UsernameAndArtist(SecurityContextHolder.getContext().getAuthentication().getName(), artist));
    }

    /**
     * Get a track
     *
     * @param uuid UUID of the track
     * @return Resource of the track
     */
    @Override
    public MusicTrackResource getTrack(String uuid) {
        return musicTrackResourceAssembler.toResource(musicTrackRepository.findByUuid(UUID.fromString(uuid)));
    }

    /**
     * Update a track
     *
     * @param musicTrackResource Resource of the updated track
     * @return Resource of the updated track
     */
    @Override
    public MusicTrackResource updateTrack(MusicTrackResource musicTrackResource) {
        return null;
    }

    /**
     * Remove a track
     *
     * @param uuid UUID of the track
     */
    @Override
    public void removeTrack(String uuid) {
        musicTrackRepository.deleteByUuid(UUID.fromString(uuid));
    }

    /**
     * Search track by title
     *
     * @param title Name of the tracks
     * @return Resource list of the tracks
     */
    @Override
    public List<MusicTrackResource> searchTrackByTitle(String title) {
        return musicTrackResourceAssembler.toResources(musicTrackRepository.findAllByFileSystemOwner_AccountEntity_UsernameAndTitle(SecurityContextHolder.getContext().getAuthentication().getName(), title));
    }

    /**
     * Search track by artist
     *
     * @param artist Artist of the tracks
     * @return Resource list of the tracks
     */
    @Override
    public List<MusicTrackResource> searchTrackByArtist(String artist) {
        return musicTrackResourceAssembler.toResources(musicTrackRepository.findAllByFileSystemOwner_AccountEntity_UsernameAndArtist(SecurityContextHolder.getContext().getAuthentication().getName(), artist));
    }
}
