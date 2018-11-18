package org.protogalaxy.phss.service.main.filesystem.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.music.MusicAlbumRepository;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.music.MusicTrackRepository;
import org.protogalaxy.phss.service.interfaces.filesystem.database.MusicService;
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
    public String getAlbum(String username, int id) throws Exception {
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
    public String listUserAlbum(String username, Pageable pageable) throws Exception {
        return null;
    }

    @Override
    public String listAlbumByTitle(String username, String title) throws Exception {
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
        return null;
    }

    @Override
    public String listTrackByAlbum(String username, String album) throws Exception {
        return null;
    }

    @Override
    public String listTrackByAlbumId(String username, int id) throws Exception {
        return null;
    }

    @Override
    public String listTracksByArtist(String username, String artist) throws Exception {
        return null;
    }
}
