package org.protogalaxy.phss.service.interfaces.filesystem.io;

import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface StorageService {
    /**
     * Store single track
     *
     * @param musicFile uploaded track
     * @return JSON format string of the uploaded track
     */
    MusicTrackEntity storeTrack(MultipartFile musicFile) throws Exception;

    /**
     * Store tracks
     *
     * @param musicFiles uploaded tracks
     * @return JSON format string of the uploaded tracks
     */
    List<MusicTrackEntity> storeTracks(MultipartFile[] musicFiles) throws Exception;


    /**
     * Delete track
     *
     * @param uuid UUID of the file
     */
    void deleteTrack(String uuid);

    /**
     * Store single anime
     *
     * @param username  name of current account
     * @param animeFile uploaded anime
     * @return JSON format string of the uploaded anime
     */
    String storeAnime(String username, MultipartFile animeFile) throws Exception;

    /**
     * Delete Anime
     *
     * @param uuid UUID of the file
     */
    void deleteAnime(String uuid);

    /**
     * Store single movie
     *
     * @param username  name of current account
     * @param movieFile uploaded movie
     * @return JSON format string of the uploaded movie
     */
    String storeMovie(String username, MultipartFile movieFile) throws Exception;

    /**
     * Delete movie
     *
     * @param uuid UUID of the file
     */
    void deleteMovie(String uuid);

    /**
     * Store single video
     *
     * @param username  name of current account
     * @param videoFile uploaded video
     * @return JSON format string of the uploaded video
     */
    String storeVideo(String username, MultipartFile videoFile) throws Exception;

    /**
     * Delete video
     *
     * @param uuid UUID of the file
     */
    void deleteVideo(String uuid);

    /**
     * Store single photo
     *
     * @param username  name of current account
     * @param photoFile uploaded photo
     * @return JSON format string of the uploaded photo
     */
    String storePhoto(String username, MultipartFile photoFile) throws Exception;

    /**
     * Delete photo
     *
     * @param uuid UUID of the file
     */
    void deletePhoto(String uuid);

    /**
     * Store single book
     *
     * @param username name of current account
     * @param bookFile uploaded book
     * @return JSON format string of the uploaded book
     */
    String storeBook(String username, MultipartFile bookFile) throws Exception;

    /**
     * Delete book
     *
     * @param uuid UUID of the file
     */
    void deleteBook(String uuid);

    /**
     * Store single document
     *
     * @param username     name of current account
     * @param documentFile uploaded document
     * @return JSON format string of the uploaded document
     */
    String storeDocument(String username, MultipartFile documentFile) throws Exception;

    /**
     * Delete document
     *
     * @param uuid UUID of the file
     */
    void deleteDocument(String uuid);

    /**
     * Store single illustration
     *
     * @param username         name of current account
     * @param illustrationFile uploaded illustration
     * @return JSON format string of the uploaded illustration
     */
    String storeIllustration(String username, MultipartFile illustrationFile) throws Exception;

    /**
     * Delete illustration
     *
     * @param uuid UUID of the file
     */
    void deleteIllustration(String uuid);
}
