package org.protogalaxy.phss.service.main.filesystem.io;

import org.protogalaxy.phss.datasource.entity.core.filesystem.album.music.MusicTrackEntity;
import org.protogalaxy.phss.datasource.entity.core.filesystem.album.photo.PhotoEntity;
import org.protogalaxy.phss.datasource.entity.core.filesystem.book.BookEntity;
import org.protogalaxy.phss.datasource.entity.core.filesystem.document.DocumentEntity;
import org.protogalaxy.phss.datasource.entity.core.filesystem.illustration.IllustrationEntity;
import org.protogalaxy.phss.datasource.entity.core.filesystem.movie.AnimeEntity;
import org.protogalaxy.phss.datasource.entity.core.filesystem.movie.MovieEntity;
import org.protogalaxy.phss.datasource.entity.core.filesystem.movie.VideoEntity;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.Map;

@Service
public interface FileRegisteringService {
    /**
     * Register track in database
     *
     * @param username name of the user
     * @param metadata metadata of the music
     * @param path     path of the file
     */
    MusicTrackEntity registerTrack(String username, Map<String, Object> metadata, byte[] artwork, Path path) throws Exception;

    /**
     * Register anime in database
     *
     * @param username name of the user
     * @param metadata metadata of the anime
     * @param path     path of the file
     */
    AnimeEntity registerAnime(String username, Map<String, String> metadata, Path path) throws Exception;

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
    BookEntity registerBook(String username, Map<String, String> metadata, Path path) throws Exception;

    /**
     * Register document in database
     *
     * @param username name of the user
     * @param title    title of the document
     * @param type     type of the document
     * @param path     path of the file
     */
    DocumentEntity registerDocument(String username, String title, String type, Path path) throws Exception;

    /**
     * Register illustration in database
     *
     * @param username name of the user
     * @param metadata metadata of the illustration
     * @param path     path of the file
     */
    IllustrationEntity registerIllustration(String username, Map<String, String> metadata, Path path) throws Exception;
}
