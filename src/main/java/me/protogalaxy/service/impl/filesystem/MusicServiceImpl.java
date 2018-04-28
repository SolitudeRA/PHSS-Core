package me.protogalaxy.service.impl.filesystem;

import me.protogalaxy.service.main.filesystem.MusicService;
import org.springframework.stereotype.Service;


//TODO: Music service implement(Counts)
@Service
public class MusicServiceImpl implements MusicService {
    @Override
    public String saveAlbum(String album) throws Exception {
        return null;
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
    public String listAlbumByName(int ownerId, String albumName) throws Exception {
        return null;
    }

    @Override
    public String listAlbumByArtist(int ownerId, String Artist) throws Exception {
        return null;
    }

    @Override
    public String saveTrack(String track) throws Exception {
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
    public String listTrackByName(int ownerId, String trackName) throws Exception {
        return null;
    }

    @Override
    public String listTrackByAlbum(int ownerId, String albumName) throws Exception {
        return null;
    }

    @Override
    public String listTracksByArtist(int ownerId, String artist) throws Exception {
        return null;
    }
}
