package service;

import java.util.UUID;

/**
 * Music management service
 *
 * @author Arthur.Lee
 * @since 1.9
 */

//TODO:Music service interfaces design
public interface MusicService {

    /**
     * Persist an album
     *
     * @param uuid  uuid of the user
     * @param album a JSON format string of the album
     * @return JSON format string of the saved album
     */
    String saveAlbum(UUID uuid, String album);

    /**
     * Remove an album
     *
     * @param uuid uuid of the album
     * @return boolean
     */
    boolean removeAlbum(UUID uuid);

    /**
     * Get an album
     *
     * @param uuid uuid of the album
     * @return JSON format string of the album
     */
    String getAlbum(UUID uuid);

    /**
     * List albums by name
     *
     * @param albumName name of the albums
     * @return JSON format string of the album
     */
    String listAlbumByName(String albumName);

    /**
     * List albums by artist
     *
     * @param Artist artist of the albums
     * @return JSON format string of the album
     */
    String listAlbumByArtist(String Artist);

    /**
     * Update an album
     *
     * @param album JSON format string of the updated album
     * @return JSON format string of the updated album
     */
    String updateAlbum(String album);

    /**
     * Persist a track
     *
     * @param track a JSON format string of the track
     * @return JSON format string of the saved track
     */
    String saveTrack(String track);

    /**
     * Remove a track
     *
     * @param uuid uuid of the track
     * @return boolean
     */

    boolean removeTrack(UUID uuid);

    /**
     * Get a track
     *
     * @param uuid uuid of the track
     * @return JSON format string of the track
     */
    String getTrack(UUID uuid);

    /**
     * List tracks by name
     *
     * @param trackName name of the tracks
     * @return JSON format string of the track
     */
    String listTrackByName(String trackName);

    /**
     * List tracks by album name
     *
     * @param albumName name of the albums
     * @return JSON format string of the tracks
     */
    String listTrackByAlbum(String albumName);

    /**
     * List tracks by artist
     *
     * @param artist artist of the tracks
     * @return JSON format string of the tracks
     */
    String listTracksByArtist(String artist);

    /**
     * Update a track
     *
     * @param track JSON format string of the updated track
     * @return JSON format string of the updated track
     */
    String updateTrack(String track);
}
