package org.protogalaxy.phss.service.interfaces.filesystem.database;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
     * @param username name of the account
     * @param id       id of the album
     * @return JSON format string of the album
     */
    String getAlbum(String username, int id) throws Exception;

    /**
     * Update an album
     *
     * @param album JSON format string of the updated album
     * @return JSON format string of the updated album
     */
    String updateAlbum(String album) throws Exception;

    /**
     * Update counters of the album
     *
     * @param counters JSON format string of the updated counters
     * @return JSON format string of the updated album counters
     */
    String updateAlbumCounters(String counters) throws Exception;

    /**
     * Remove an album
     *
     * @param id id of the album
     * @return boolean
     */
    boolean removeAlbum(int id);

    /**
     * List account albums
     *
     * @param username name of the account
     * @param pageable data page
     * @return JSON format string of albums
     */
    String listUserAlbum(String username, Pageable pageable) throws Exception;

    /**
     * List albums by name
     *
     * @param username name of the account
     * @param title    title of the albums
     * @return JSON format string of the album
     */
    String listAlbumByTitle(String username, String title) throws Exception;

    /**
     * List albums by artist
     *
     * @param ownerId id of the owner
     * @param Artist  artist of the albums
     * @return JSON format string of the album
     */
    String listAlbumByArtist(int ownerId, String Artist) throws Exception;


    /**
     * Get a track
     *
     * @param id id of the track
     * @return JSON format string of the track
     */
    String getTrack(int id) throws Exception;

    /**
     * Update a track
     *
     * @param track JSON format string of the updated track
     * @return JSON format string of the updated track
     */
    String updateTrack(String track) throws Exception;

    /**
     * Update counters of the track
     *
     * @param counters JSON format string of the updated track counters
     * @return JSON format string of the updated counters
     */
    String updateTrackCounters(String counters) throws Exception;

    /**
     * Remove a track
     *
     * @param id uuid of the track
     * @return boolean
     */

    boolean removeTrack(int id);

    /**
     * List tracks by title
     *
     * @param username name of the account
     * @param title    name of the tracks
     * @return JSON format string of the track
     */
    String listTrackByTitle(String username, String title) throws Exception;

    /**
     * List tracks by album name
     *
     * @param username name of the account
     * @param title    title of the album
     * @return JSON format string of the tracks
     */
    String listTrackByAlbum(String username, String title) throws Exception;

    /**
     * List tracks by album id
     *
     * @param username name of the account
     * @param id       is of the album
     * @return JSON format string of tracks
     */
    String listTrackByAlbumId(String username, int id) throws Exception;

    /**
     * List tracks by artist
     *
     * @param username name of the account
     * @param artist   artist of the tracks
     * @return JSON format string of the tracks
     */
    String listTracksByArtist(String username, String artist) throws Exception;
}
