package org.protogalaxy.phss.service.interfaces.filesystem.logic;

import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.photo.PhotoEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.book.BookEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.illustration.IllustrationEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.anime.AnimeEpisodeEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.movie.MovieEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.video.VideoEntity;

import java.nio.file.Path;
import java.util.Map;

public interface FileRegisteringService {
    /**
     * Register track in database
     *
     * @param metadata metadata of the music
     * @param path     path of the file
     */
    MusicTrackEntity registerTrack(Map<String, Object> metadata, Path path);

    /**
     * Register anime in database
     *
     * @param metadata metadata of the anime
     * @param path     path of the file
     */
    AnimeEpisodeEntity registerAnime(Map<String, String> metadata, Path path);

    /**
     * Register movie in database
     *
     * @param metadata metadata of the movie
     * @param path     path of the file
     */
    MovieEntity registerMovie(Map<String, String> metadata, Path path);

    /**
     * Register video in database
     *
     * @param metadata metadata of the video
     * @param path     path of the file
     */
    VideoEntity registerVideo(Map<String, String> metadata, Path path);

    /**
     * Register photo in database
     *
     * @param metadata metadata of the photo
     * @param path     path of the file
     */
    PhotoEntity registerPhoto(Map<String, String> metadata, Path path);

    /**
     * Register book in database
     *
     * @param metadata metadata of the book
     * @param path     path of the file
     */
    BookEntity registerBook(Map<String, Object> metadata, Path path) throws Exception;

    /**
     * Register document in database
     *
     * @param metadata metadata of the document
     * @param path     path of the file
     * @param mimeType MIME type of the document
     */
    String registerDocument(Map<String, Object> metadata, Path path, String mimeType) throws Exception;

    /**
     * Register illustration in database
     *
     * @param metadata metadata of the illustration
     * @param path     path of the file
     */
    IllustrationEntity registerIllustration(Map<String, String> metadata, Path path);
}
