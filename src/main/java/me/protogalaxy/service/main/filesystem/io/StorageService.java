package me.protogalaxy.service.main.filesystem.io;

import org.springframework.web.multipart.MultipartFile;


public interface StorageService {
    void storeMusic(String username, MultipartFile musicFile) throws Exception;

    void storeAnime(String username, MultipartFile animeFile);

    void storeMovie(String username, MultipartFile movieFile);

    void storeVideo(String username, MultipartFile videoFile);

    void storePhoto(String username, MultipartFile photoFile);

    void storeBook(String username, MultipartFile bookFile);

    void storeDocument(String username, MultipartFile documentFile);

    void storeIllustration(String username, MultipartFile illustrationFile);
}
