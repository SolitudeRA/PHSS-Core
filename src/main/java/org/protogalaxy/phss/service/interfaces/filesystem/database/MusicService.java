package org.protogalaxy.phss.service.interfaces.filesystem.database;

import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicAlbumEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackEntity;
import org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music.MusicAlbumResource;
import org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music.MusicTrackResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Music management service
 *
 * @author Arthur.Lee
 * @since 1.0
 */

@Service
public interface MusicService {
    /**
     * Get an album
     *
     * @param uuid UUID of the album
     * @return Resource of the album
     */
    MusicAlbumEntity getAlbum(String uuid);

    /**
     * Update an album with UUID and resource
     *
     * @param uuid               UUID of the updated album
     * @param musicAlbumResource Resource of the updated album
     * @return Entity of the updated album
     */
    MusicAlbumEntity updateAlbumWithUuidAndResource(UUID uuid, MusicAlbumResource musicAlbumResource);

    /**
     * Update an album with entity
     *
     * @param musicAlbumEntity Entity of the updated album
     * @return Entity of the updated album
     */
    MusicAlbumEntity updateAlbumWithEntity(MusicAlbumEntity musicAlbumEntity);

    /**
     * Remove an album
     *
     * @param uuid UUID of the album
     */
    void removeAlbum(String uuid);

    /**
     * List account albums
     *
     * @param pageable Data page
     * @return Entity List of the albums
     */
    Page<MusicAlbumEntity> listUserAlbum(Pageable pageable);

    /**
     * Search albums by name
     *
     * @param title Title of the albums
     * @return Entity list of the albums
     */
    List<MusicAlbumEntity> searchAlbumByTitle(String title);

    /**
     * Search albums by artist
     *
     * @param artist Artist of the albums
     * @return Entity list of the albums
     */
    List<MusicAlbumEntity> searchAlbumByArtist(String artist);


    /**
     * Get a track
     *
     * @param uuid UUID of the track
     * @return Entity of the track
     */
    MusicTrackEntity getTrack(String uuid);

    /**
     * Update a track with UUID and resource
     *
     * @param uuid               UUID of the updated track
     * @param musicTrackResource Resource of the updated track
     * @return Entity of the updated track
     */
    MusicTrackEntity updateTrackWithUuidAndResource(UUID uuid, MusicTrackResource musicTrackResource);

    /**
     * Update a track with entity
     *
     * @param musicTrackEntity Entity of the updated track
     * @return Entity of the updated track
     */
    MusicTrackEntity updateTrackWithEntity(MusicTrackEntity musicTrackEntity);

    /**
     * Remove a track
     *
     * @param uuid UUID of the track
     */

    void removeTrack(String uuid);

    /**
     * Search track by title
     *
     * @param title Name of the tracks
     * @return Entity list of the tracks
     */
    List<MusicTrackEntity> searchTrackByTitle(String title);

    /**
     * Search track by artist
     *
     * @param artist Artist of the tracks
     * @return Entity list of the tracks
     */
    List<MusicTrackEntity> searchTrackByArtist(String artist);
}
