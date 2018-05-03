package me.protogalaxy.service.impl.filesystem;

import me.protogalaxy.service.config.PhssStorageServiceConfig;
import me.protogalaxy.service.main.filesystem.PhssStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        }catch (IOException e){
            throw
        }
    }

    @Override
    public void store(MultipartFile file) {

    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    @Override
    public Path load(String filename) {
        return null;
    }

    @Override
    public Resource loadAsResource(String filename) {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
