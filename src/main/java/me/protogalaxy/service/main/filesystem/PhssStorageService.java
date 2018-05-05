package me.protogalaxy.service.main.filesystem;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface PhssStorageService {
    void init();

    void storeMusic(String username, MultipartFile musicFile);

    void storeAnime(String username, MultipartFile animeFile);

    void storeMovie(String username, MultipartFile movieFile);

    void storeVideo(String username, MultipartFile videoFile);

    void storePhoto(String username, MultipartFile photoFile);

    void storeBook(String username, MultipartFile bookFile);

    void storeDocument(String username, MultipartFile documentFile);

    void storeIllustration(String username, MultipartFile illustrationFile);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();
}
