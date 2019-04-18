package org.protogalaxy.phss.service.config;

import org.protogalaxy.phss.datasource.repository.jpa.filesystem.book.BookRepository;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.main.FilesystemMainRepository;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.music.MusicAlbumRepository;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.music.MusicTrackRepository;
import org.protogalaxy.phss.datasource.repository.mongodb.document.*;
import org.protogalaxy.phss.service.interfaces.filesystem.api.BangumiAPIService;
import org.protogalaxy.phss.service.interfaces.filesystem.database.*;
import org.protogalaxy.phss.service.interfaces.filesystem.io.CacheService;
import org.protogalaxy.phss.service.interfaces.filesystem.io.PathService;
import org.protogalaxy.phss.service.interfaces.filesystem.io.StorageService;
import org.protogalaxy.phss.service.interfaces.filesystem.logic.FileRegisteringService;
import org.protogalaxy.phss.service.interfaces.filesystem.multimedia.MetadataService;
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
    public MusicService musicService(StorageService storageService,
                                     MusicAlbumRepository musicAlbumRepository,
                                     MusicTrackRepository musicTrackRepository) {
        return new MusicServiceImpl(storageService, musicAlbumRepository, musicTrackRepository);
    }

    @Bean
    public MovieService movieService() {
        return new MovieServiceImpl();
    }

    @Bean
    public BangumiAPIService bangumiAPIService() {
        return new BangumiAPIServiceImpl();
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
    public StorageService storageService(StorageServiceConfig storageServiceConfig,
                                         PathService pathService,
                                         CacheService cacheService,
                                         MetadataService metadataService,
                                         FileRegisteringService fileRegisteringService,
                                         MusicTrackRepository musicTrackRepository,
                                         MusicAlbumRepository musicAlbumRepository) {
        return new StorageServiceImpl(storageServiceConfig, pathService, cacheService, metadataService, fileRegisteringService, musicTrackRepository, musicAlbumRepository);
    }

    @Bean
    public PathService pathService(StorageServiceConfig storageServiceConfig) {
        return new PathServiceImpl(storageServiceConfig);
    }

    @Bean
    public CacheService cacheService(StorageServiceConfig storageServiceConfig) {
        return new CacheServiceImpl(storageServiceConfig);
    }

    @Bean
    public FileRegisteringService fileRegisteringService(CacheService cacheService,
                                                         FilesystemMainRepository filesystemMainRepository,
                                                         MusicTrackRepository musicTrackRepository,
                                                         BookRepository bookRepository,
                                                         DocumentAdobePdfRepository documentAdobePdfRepository,
                                                         DocumentAdobePhotoshopRepository documentAdobePhotoshopRepository,
                                                         DocumentMicrosoftWordOldRepository documentMicrosoftWordOldRepository,
                                                         DocumentMicrosoftExcelOldRepository documentMicrosoftExcelOldRepository,
                                                         DocumentMicrosoftPowerpointOldRepository documentMicrosoftPowerpointOldRepository,
                                                         DocumentMicrosoftWordRepository documentMicrosoftWordRepository,
                                                         DocumentMicrosoftExcelRepository documentMicrosoftExcelRepository,
                                                         DocumentMicrosoftPowerpointRepository documentMicrosoftPowerpointRepository,
                                                         DocumentOpenTextRepository documentOpenTextRepository,
                                                         DocumentOpenSpreadsheetRepository documentOpenSpreadsheetRepository,
                                                         DocumentOpenPresentationRepository documentOpenPresentationRepository) {
        return new FileRegisteringServiceImpl(cacheService,
                filesystemMainRepository,
                musicTrackRepository,
                bookRepository,
                documentAdobePdfRepository,
                documentAdobePhotoshopRepository,
                documentMicrosoftWordRepository,
                documentMicrosoftWordOldRepository,
                documentMicrosoftExcelRepository,
                documentMicrosoftExcelOldRepository,
                documentMicrosoftPowerpointRepository,
                documentMicrosoftPowerpointOldRepository,
                documentOpenTextRepository,
                documentOpenSpreadsheetRepository,
                documentOpenPresentationRepository);
    }
}
