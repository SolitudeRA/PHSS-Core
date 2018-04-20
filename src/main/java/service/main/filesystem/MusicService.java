package service.main.filesystem;

import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Music management service
 *
 * @author Arthur.Lee
 * @since 1.9
 */

//TODO:Music service interfaces design
@Service
public interface MusicService {
    /**
     * Persist an album
     *
     * @param album a JSON format string of the album
     * @return JSON format string of the saved album
     */
    String saveAlbum(String album) throws Exception;

    /**
     * Get an album
     *
     * @param id id of the album
     * @return JSON format string of the album
     */
    String getAlbum(int id) throws Exception;

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
     * List albums by name
     *
     * @param ownerId   id of the owner
     * @param albumName name of the albums
     * @return JSON format string of the album
     */
    String listAlbumByName(int ownerId, String albumName) throws Exception;

    /**
     * List albums by artist
     *
     * @param ownerId id of the owner
     * @param Artist  artist of the albums
     * @return JSON format string of the album
     */
    String listAlbumByArtist(int ownerId, String Artist) throws Exception;


    /**
     * Persist a track
     *
     * @param track a JSON format string of the track
     * @return JSON format string of the saved track
     */
    String saveTrack(String track) throws Exception;


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
     * List tracks by name
     *
     * @param ownerId   id of the owner
     * @param trackName name of the tracks
     * @return JSON format string of the track
     */
    String listTrackByName(int ownerId, String trackName) throws Exception;

    /**
     * List tracks by album name
     *
     * @param albumName name of the albums
     * @return JSON format string of the tracks
     */
    String listTrackByAlbum(int ownerId, String albumName) throws Exception;

    /**
     * List tracks by artist
     *
     * @param ownerId id of the owner
     * @param artist  artist of the tracks
     * @return JSON format string of the tracks
     */
    String listTracksByArtist(int ownerId, String artist) throws Exception;
}
