package org.protogalaxy.phss.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Folder location for storing files
 */
@ConfigurationProperties(prefix = "storage")
public class StorageServiceConfig {
    private String prefix = "phss_";

    private String rootLocation = "phss_storage";

    private String tempLocation = "phss_temp";

    private String musicLocation = "music";

    private String animeLocation = "anime";

    private String movieLocation = "movie";

    private String videoLocation = "video";

    private String bookLocation = "book";

    private String documentLocation = "document";

    private String illustrationLocation = "illustration";

    private String photoLocation = "photo";

    private String imagePoolLocation = "image_pool";

    public String getPrefix() {
        return prefix;
    }

    public Path getRootLocation() {
        return Paths.get(rootLocation);
    }

    public Path getTempLocation() {
        return Paths.get(tempLocation);
    }

    public Path getMusicLocation() {
        return Paths.get(rootLocation).resolve(musicLocation);
    }

    public Path getAnimeLocation() {
        return Paths.get(rootLocation).resolve(animeLocation);
    }

    public Path getMovieLocation() {
        return Paths.get(rootLocation).resolve(movieLocation);
    }

    public Path getVideoLocation() {
        return Paths.get(rootLocation).resolve(videoLocation);
    }

    public Path getBookLocation() {
        return Paths.get(rootLocation).resolve(bookLocation);
    }

    public Path getDocumentLocation() {
        return Paths.get(rootLocation).resolve(documentLocation);
    }

    public Path getIllustrationLocation() {
        return Paths.get(rootLocation).resolve(illustrationLocation);
    }

    public Path getPhotoLocation() {
        return Paths.get(rootLocation).resolve(photoLocation);
    }

    public Path getImagePoolLocation() {
        return Paths.get(rootLocation).resolve(imagePoolLocation);
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setRootLocation(String rootLocation) {
        this.rootLocation = rootLocation;
    }

    public void setTempLocation(String tempLocation) {
        this.tempLocation = tempLocation;
    }

    public void setMusicLocation(String musicLocation) {
        this.musicLocation = musicLocation;
    }

    public void setAnimeLocation(String animeLocation) {
        this.animeLocation = animeLocation;
    }

    public void setMovieLocation(String movieLocation) {
        this.movieLocation = movieLocation;
    }

    public void setVideoLocation(String videoLocation) {
        this.videoLocation = videoLocation;
    }

    public void setBookLocation(String bookLocation) {
        this.bookLocation = bookLocation;
    }

    public void setDocumentLocation(String documentLocation) {
        this.documentLocation = documentLocation;
    }

    public void setIllustrationLocation(String illustrationLocation) {
        this.illustrationLocation = illustrationLocation;
    }

    public void setPhotoLocation(String photoLocation) {
        this.photoLocation = photoLocation;
    }

    public void setImagePoolLocation(String imagePoolLocation) {
        this.imagePoolLocation = imagePoolLocation;
    }
}
