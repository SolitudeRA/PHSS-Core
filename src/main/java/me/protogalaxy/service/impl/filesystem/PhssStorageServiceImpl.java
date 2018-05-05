package me.protogalaxy.service.impl.filesystem;

import org.bytedeco.javacpp.*;

import static org.bytedeco.javacpp.avcodec.*;
import static org.bytedeco.javacpp.avformat.*;
import static org.bytedeco.javacpp.avutil.*;
import static org.bytedeco.javacpp.swscale.*;

import me.protogalaxy.exception.storage.StorageException;
import me.protogalaxy.exception.storage.StorageFileNotFoundException;
import me.protogalaxy.service.config.PhssStorageServiceConfig;
import me.protogalaxy.service.main.filesystem.PhssStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.stream.Stream;

@Service
public class PhssStorageServiceImpl implements PhssStorageService {
    private final Path rootLocation;

    @Autowired
    public PhssStorageServiceImpl(PhssStorageServiceConfig config) {
        this.rootLocation = Paths.get(config.getLocation());
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }

    @Override
    public void storeMusic(String username, MultipartFile musicFile) {
        String filename = StringUtils.cleanPath(musicFile.getOriginalFilename());
        try {
            av_register_all();
            BytePointer pointer = new BytePointer(musicFile.getBytes());
            AVFormatContext context = new AVFormatContext(null);
            avformat_open_input(context, pointer, null, null);
            System.out.println(context);
            System.out.println("test");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (musicFile.isEmpty()) {
                throw new StorageException("Failed to store empty file " + filename);
            }
            if (filename.contains("..")) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + filename);
            }
            try (InputStream inputStream = musicFile.getInputStream()) {
                Files.copy(inputStream, this.rootLocation.resolve(username).resolve(filename),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + filename, e);
        }
    }

    @Override
    public void storeAnime(String username, MultipartFile animeFile) {

    }

    @Override
    public void storeMovie(String username, MultipartFile movieFile) {

    }

    @Override
    public void storeVideo(String username, MultipartFile videoFile) {

    }

    @Override
    public void storePhoto(String username, MultipartFile photoFile) {

    }

    @Override
    public void storeBook(String username, MultipartFile bookFile) {

    }

    @Override
    public void storeDocument(String username, MultipartFile documentFile) {

    }

    @Override
    public void storeIllustration(String username, MultipartFile illustrationFile) {

    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(this.rootLocation::relativize);
        } catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }

    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new StorageFileNotFoundException(
                        "Could not read file: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }
}
