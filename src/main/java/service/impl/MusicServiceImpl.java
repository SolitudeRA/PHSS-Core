package service.impl;

import service.MusicService;

import java.util.UUID;

//TODO: Music service implement
public class MusicServiceImpl implements MusicService {
    @Override
    public String saveAlbum(UUID uuid, String album) {
        return null;
    }

    @Override
    public boolean removeAlbum(UUID uuid) {
        return false;
    }

    @Override
    public String getAlbum(UUID uuid) {
        return null;
    }

    @Override
    public String listAlbumByName(String albumName) {
        return null;
    }

    @Override
    public String listAlbumByArtist(String Artist) {
        return null;
    }

    @Override
    public String updateAlbum(String album) {
        return null;
    }

    @Override
    public String saveTrack(String track) {
        return null;
    }

    @Override
    public boolean removeTrack(UUID uuid) {
        return false;
    }

    @Override
    public String getTrack(UUID uuid) {
        return null;
    }

    @Override
    public String listTrackByName(String trackName) {
        return null;
    }

    @Override
    public String listTrackByAlbum(String albumName) {
        return null;
    }

    @Override
    public String listTracksByArtist(String artist) {
        return null;
    }

    @Override
    public String updateTrack(String track) {
        return null;
    }
}
