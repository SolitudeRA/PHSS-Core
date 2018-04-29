package me.protogalaxy.service.main.filesystem;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface PhssStorageService {
    /**
     * init the storage service
     */
    void init();

    /**
     * store the file
     *
     * @param file file
     */
    void store(MultipartFile file);

    Stream<Path> loadAll();

    /**
     * load file through name
     *
     * @param filename name of the file
     * @return file path
     */
    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();
}
