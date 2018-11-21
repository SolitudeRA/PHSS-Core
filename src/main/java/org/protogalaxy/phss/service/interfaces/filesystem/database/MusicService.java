package org.protogalaxy.phss.service.interfaces.filesystem.database;

import org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music.MusicAlbumResource;
import org.protogalaxy.phss.datasource.resource.main.entity.filesystem.music.MusicTrackResource;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
    MusicAlbumResource getAlbum(String uuid);

    /**
     * Update an album
     *
     * @param musicAlbumResource Resource of the updated album
     * @return Resource of the updated album
     */
    MusicAlbumResource updateAlbum(MusicAlbumResource musicAlbumResource);

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
     * @return Resource List of the albums
     */
    List<MusicAlbumResource> listUserAlbum(Pageable pageable);

    /**
     * Search albums by name
     *
     * @param title Title of the albums
     * @return Resource list of the albums
     */
    List<MusicAlbumResource> searchAlbumByTitle(String title);

    /**
     * Search albums by artist
     *
     * @param artist Artist of the albums
     * @return Resource list of the albums
     */
    List<MusicAlbumResource> searchAlbumByArtist(String artist);


    /**
     * Get a track
     *
     * @param uuid UUID of the track
     * @return Resource of the track
     */
    MusicTrackResource getTrack(String uuid);

    /**
     * Update a track
     *
     * @param musicTrackResource Resource of the updated track
     * @return Resource of the updated track
     */
    MusicTrackResource updateTrack(MusicTrackResource musicTrackResource);

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
     * @return Resource list of the tracks
     */
    List<MusicTrackResource> searchTrackByTitle(String title);

    /**
     * Search track by artist
     *
     * @param artist Artist of the tracks
     * @return Resource list of the tracks
     */
    List<MusicTrackResource> searchTrackByArtist(String artist);
}
