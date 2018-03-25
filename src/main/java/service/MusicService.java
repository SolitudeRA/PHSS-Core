package service;

import java.util.UUID;

/**
 * Music management service
 *
 * @author Arthur.Lee
 * @since 1.9
 */

public abstract class MusicService {

    /**
     * Persist an album
     *
     * @param uuid  uuid of the user
     * @param album a JSON format string of the album
     * @return a JSON format string of the saved album
     */
    public abstract String saveAlbum(UUID uuid, String album);

    /**
     * Remove the album
     *
     * @param uuid uuid of the album
     * @return boolean
     */
    public abstract boolean removeAlbum(UUID uuid);

    /**
     * Get current album
     *
     * @param uuid uuid of the album
     * @return a JSON format string of the album
     */
    public abstract String getAlbum(UUID uuid);

    /**
     * List album by name
     *
     * @param albumName name of the album
     * @return a JSON format string of the album
     */
    public abstract String listAlbumByName(String albumName);

    /**
     * List album by artist
     *
     * @param Artist artist of the album
     * @return a JSON format string of the album
     */
    public abstract String listAlbumByArtist(String Artist);

    /**
     * Persist a track
     *
     * @param track a JSON format string of the track
     * @return a JSON format string of the saved track
     */
    public abstract String saveTrack(String track);

    /**
     * Remove the track
     *
     * @param uuid uuid of the track
     * @return boolean
     */

    public abstract boolean removeTrack(UUID uuid);

    /**
     * Get Current track
     *
     * @param uuid uuid of the track
     * @return a JSON format string of the track
     */
    public abstract String getTrack(UUID uuid);

    /**
     * List track by name
     *
     * @param trackName name of the track
     * @return a JSON format string of the track
     */
    public abstract String listTrackByName(String trackName);

    /**
     * List tracks by album name
     *
     * @param albumName name of the album
     * @return a JSON format string of the tracks
     */
    public abstract String listTrackByAlbum(String albumName);
}
