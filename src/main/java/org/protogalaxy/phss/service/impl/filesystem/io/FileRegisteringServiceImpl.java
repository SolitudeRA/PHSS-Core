package org.protogalaxy.phss.service.impl.filesystem.io;

import org.protogalaxy.phss.datasource.entity.core.filesystem.album.music.MusicTrackEntity;
import org.protogalaxy.phss.datasource.entity.core.filesystem.album.music.MusicTrackInfEntity;
import org.protogalaxy.phss.datasource.entity.core.filesystem.album.music.MusicTrackInfStaticEntity;
import org.protogalaxy.phss.datasource.entity.core.filesystem.album.photo.PhotoEntity;
import org.protogalaxy.phss.datasource.entity.core.filesystem.book.BookEntity;
import org.protogalaxy.phss.datasource.entity.core.filesystem.document.DocumentEntity;
import org.protogalaxy.phss.datasource.entity.core.filesystem.document.DocumentInfEntity;
import org.protogalaxy.phss.datasource.entity.core.filesystem.illustration.IllustrationEntity;
import org.protogalaxy.phss.datasource.entity.core.filesystem.movie.AnimeEntity;
import org.protogalaxy.phss.datasource.entity.core.filesystem.movie.MovieEntity;
import org.protogalaxy.phss.datasource.entity.core.filesystem.movie.VideoEntity;
import org.protogalaxy.phss.datasource.entity.repository.filesystem.album.music.MusicTrackRepository;
import org.protogalaxy.phss.datasource.entity.repository.filesystem.document.DocumentRepository;
import org.protogalaxy.phss.datasource.entity.repository.filesystem.main.FilesystemMainRepository;
import org.protogalaxy.phss.service.main.filesystem.io.FileRegisteringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.Map;

@Service
public class FileRegisteringServiceImpl implements FileRegisteringService {
    private final FilesystemMainRepository filesystemMainRepository;
    private final MusicTrackRepository musicTrackRepository;
    private final DocumentRepository documentRepository;

    @Autowired
    public FileRegisteringServiceImpl(FilesystemMainRepository filesystemMainRepository,
                                      MusicTrackRepository musicTrackRepository,
                                      DocumentRepository documentRepository) {
        this.filesystemMainRepository = filesystemMainRepository;
        this.musicTrackRepository = musicTrackRepository;
        this.documentRepository = documentRepository;
    }

    @Override
    public MusicTrackEntity registerTrack(String username, Map<String, Object> metadata, byte[] artwork, Path path) throws Exception {
        MusicTrackEntity trackEntity = new MusicTrackEntity(
                filesystemMainRepository.findByUserEntity_Username(username),
                metadata.get("title").toString(),
                metadata.get("album").toString(),
                metadata.get("artist").toString(),
                metadata.get("album_artist").toString(),
                path.toString());
        trackEntity.setTrackInformation(new MusicTrackInfEntity(trackEntity));
        trackEntity.setTrackInformationStatic(new MusicTrackInfStaticEntity(
                metadata.get("size").toString(),
                metadata.get("duration").toString(),
                metadata.get("track").toString(),
                metadata.get("disc").toString(),
                metadata.get("date").toString(),
                artwork,
                metadata.get("genre").toString(),
                metadata.get("bitrate").toString(),
                metadata.get("sample_rate").toString(),
                metadata.get("bit_depth").toString(),
                trackEntity));
        musicTrackRepository.save(trackEntity);
        return trackEntity;
    }

    @Override
    public AnimeEntity registerAnime(String username, Map<String, String> metadata, Path path) throws Exception {
        return null;
    }

    @Override
    public MovieEntity registerMovie(String username, Map<String, String> metadata, Path path) throws Exception {
        return null;
    }

    @Override
    public VideoEntity registerVideo(String username, Map<String, String> metadata, Path path) throws Exception {
        return null;
    }

    @Override
    public PhotoEntity registerPhoto(String username, Map<String, String> metadata, Path path) throws Exception {
        return null;
    }

    @Override
    public BookEntity registerBook(String username, Map<String, String> metadata, Path path) throws Exception {
        return null;
    }

    @Override
    public DocumentEntity registerDocument(String username, String title, String type, Path path) {
        DocumentEntity documentEntity = new DocumentEntity(filesystemMainRepository.findByUserEntity_Username(username), title, type);
        documentEntity.setDocumentInfEntity(new DocumentInfEntity(documentEntity));
        documentRepository.save(documentEntity);
        return documentEntity;
    }

    @Override
    public IllustrationEntity registerIllustration(String username, Map<String, String> metadata, Path path) throws Exception {
        return null;
    }
}
