package org.protogalaxy.phss.service.main.filesystem.observer;

import org.protogalaxy.phss.datasource.entity.filesystem.album.music.MusicTrackEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.album.photo.PhotoEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.book.BookEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.illustration.IllustrationEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.anime.AnimeCommonEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.movie.MovieEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.video.VideoEntity;

import java.nio.file.Path;
import java.util.Map;

public interface FileRegisteringService {
    /**
     * Register track in database
     *
     * @param username name of the user
     * @param metadata metadata of the music
     * @param path     path of the file
     */
    MusicTrackEntity registerTrack(String username, Map<String, Object> metadata, Path path) throws Exception;

    /**
     * Register anime in database
     *
     * @param username name of the user
     * @param metadata metadata of the anime
     * @param path     path of the file
     */
    AnimeCommonEntity registerAnime(String username, Map<String, String> metadata, Path path) throws Exception;

    /**
     * Register movie in database
     *
     * @param username name of the user
     * @param metadata metadata of the movie
     * @param path     path of the file
     */
    MovieEntity registerMovie(String username, Map<String, String> metadata, Path path) throws Exception;

    /**
     * Register video in database
     *
     * @param username name of the user
     * @param metadata metadata of the video
     * @param path     path of the file
     */
    VideoEntity registerVideo(String username, Map<String, String> metadata, Path path) throws Exception;

    /**
     * Register photo in database
     *
     * @param username name of the user
     * @param metadata metadata of the photo
     * @param path     path of the file
     */
    PhotoEntity registerPhoto(String username, Map<String, String> metadata, Path path) throws Exception;

    /**
     * Register book in database
     *
     * @param username name of the user
     * @param metadata metadata of the book
     * @param path     path of the file
     */
    BookEntity registerBook(String username, Map<String, Object> metadata, Path path) throws Exception;

    /**
     * Register document in database
     *
     * @param username name of the user
     * @param metadata metadata of the document
     * @param path     path of the file
     * @param mimeType MIME type of the document
     */
    String registerDocument(String username, Map<String, Object> metadata, Path path, String mimeType) throws Exception;

    /**
     * Register illustration in database
     *
     * @param username name of the user
     * @param metadata metadata of the illustration
     * @param path     path of the file
     */
    IllustrationEntity registerIllustration(String username, Map<String, String> metadata, Path path) throws Exception;
}
