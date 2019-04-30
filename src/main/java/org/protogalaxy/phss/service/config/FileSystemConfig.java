package org.protogalaxy.phss.service.config;

import org.protogalaxy.phss.service.interfaces.filesystem.api.BangumiAPIService;
import org.protogalaxy.phss.service.interfaces.filesystem.database.*;
import org.protogalaxy.phss.service.interfaces.filesystem.io.CacheService;
import org.protogalaxy.phss.service.interfaces.filesystem.io.PathService;
import org.protogalaxy.phss.service.interfaces.filesystem.io.StorageService;
import org.protogalaxy.phss.service.interfaces.filesystem.logic.FileRegisteringService;
import org.protogalaxy.phss.service.main.filesystem.api.BangumiAPIServiceImpl;
import org.protogalaxy.phss.service.main.filesystem.database.*;
import org.protogalaxy.phss.service.main.filesystem.io.CacheServiceImpl;
import org.protogalaxy.phss.service.main.filesystem.io.PathServiceImpl;
import org.protogalaxy.phss.service.main.filesystem.io.StorageServiceImpl;
import org.protogalaxy.phss.service.main.filesystem.logic.FileRegisteringServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileSystemConfig {
    @Bean
    public MusicService musicService() {
        return new MusicServiceImpl();
    }

    @Bean
    public MovieService movieService() {
        return new MovieServiceImpl();
    }

    @Bean
    public BookService bookService() {
        return new BookServiceImpl();
    }

    @Bean
    public DocumentService documentService() {
        return new DocumentServiceImpl();
    }

    @Bean
    public IllustrationService illustrationService() {
        return new IllustrationServiceImpl();
    }

    @Bean
    public StorageService storageService() {
        return new StorageServiceImpl();
    }

    @Bean
    public PathService pathService() {
        return new PathServiceImpl();
    }

    @Bean
    public CacheService cacheService() {
        return new CacheServiceImpl();
    }

    @Bean
    public FileRegisteringService fileRegisteringService() {
        return new FileRegisteringServiceImpl();
    }

    @Bean
    public BangumiAPIService bangumiAPIService() {
        return new BangumiAPIServiceImpl();
    }
}
