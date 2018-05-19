package me.protogalaxy.service.impl.filesystem.logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.protogalaxy.datasource.entity.repository.filesystem.album.music.MusicAlbumRepository;
import me.protogalaxy.datasource.entity.repository.filesystem.album.music.MusicTrackRepository;
import me.protogalaxy.service.main.filesystem.logic.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MusicServiceImpl implements MusicService {
    private MusicAlbumRepository musicAlbumRepository;
    private MusicTrackRepository musicTrackRepository;

    @Autowired
    public MusicServiceImpl(MusicAlbumRepository musicAlbumRepository, MusicTrackRepository musicTrackRepository) {
        this.musicAlbumRepository = musicAlbumRepository;
        this.musicTrackRepository = musicTrackRepository;
    }

    @Override
    public String getAlbum(int id) throws Exception {
        return null;
    }

    @Override
    public String updateAlbum(String album) throws Exception {
        return null;
    }

    @Override
    public String updateAlbumCounters(String counters) throws Exception {
        return null;
    }

    @Override
    public boolean removeAlbum(int id) {
        return false;
    }

    @Override
    public String listAlbum(String username, Pageable pageable) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(musicAlbumRepository.findAllByOwner_UserEntity_Username(username, pageable));
    }

    @Override
    public String listAlbumByName(int ownerId, String albumName) throws Exception {
        return null;
    }

    @Override
    public String listAlbumByArtist(int ownerId, String Artist) throws Exception {
        return null;
    }

    @Override
    public String getTrack(int id) throws Exception {
        return null;
    }

    @Override
    public String updateTrack(String track) throws Exception {
        return null;
    }

    @Override
    public String updateTrackCounters(String counters) throws Exception {
        return null;
    }

    @Override
    public boolean removeTrack(int id) {
        return false;
    }

    @Override
    public String listTrackByTitle(String username, String title) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(musicTrackRepository.findByTitleAndOwner_UserEntity_Username(title, username));
    }

    @Override
    public String listTrackByAlbum(String username, String album) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(musicTrackRepository.findByAlbumAndOwner_UserEntity_Username(album, username));
    }

    @Override
    public String listTracksByArtist(String username, String artist) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(musicTrackRepository.findByArtistAndOwner_UserEntity_Username(artist, username));
    }
}
