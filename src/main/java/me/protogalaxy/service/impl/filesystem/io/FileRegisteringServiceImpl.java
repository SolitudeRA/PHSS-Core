package me.protogalaxy.service.impl.filesystem.io;

import me.protogalaxy.datasource.entity.core.filesystem.album.music.MusicTrackEntity;
import me.protogalaxy.datasource.entity.core.filesystem.album.music.MusicTrackInfEntity;
import me.protogalaxy.datasource.entity.core.filesystem.album.music.MusicTrackInfStaticEntity;
import me.protogalaxy.datasource.entity.repository.filesystem.album.music.MusicTrackRepository;
import me.protogalaxy.datasource.entity.repository.filesystem.main.FilesystemMainRepository;
import me.protogalaxy.service.main.filesystem.io.FileRegisteringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Path;
import java.util.Map;

@Service
@Transactional
public class FileRegisteringServiceImpl implements FileRegisteringService {
    private final FilesystemMainRepository filesystemMainRepository;
    private final MusicTrackRepository musicTrackRepository;

    @Autowired
    public FileRegisteringServiceImpl(FilesystemMainRepository filesystemMainRepository, MusicTrackRepository musicTrackRepository) {
        this.filesystemMainRepository = filesystemMainRepository;
        this.musicTrackRepository = musicTrackRepository;
    }

    @Override
    public MusicTrackEntity registerMusic(String username, Map<String, Object> metadata, byte[] artwork, Path path) throws Exception {
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
}
