package me.protogalaxy.test.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.protogalaxy.datasource.entity.core.filesystem.album.music.MusicAlbumEntity;
import me.protogalaxy.datasource.entity.core.filesystem.album.music.MusicAlbumInfEntity;
import me.protogalaxy.datasource.entity.core.filesystem.album.music.MusicAlbumInfStaticEntity;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import me.protogalaxy.service.impl.filesystem.MusicServiceImpl;

//TODO: test cases
@DisplayName("Music api test case")
public class MusicApiTest {
    @Test
    @DisplayName("Album save test")
    public void albumSaveTest() throws Exception {
        MusicServiceImpl musicService = new MusicServiceImpl();
        ObjectMapper mapper = new ObjectMapper();
        MusicAlbumEntity musicAlbumEntity = new MusicAlbumEntity("AlbumSaveTestName", "AlbumSaveTestArtist");
        musicAlbumEntity.setAlbumInformation(new MusicAlbumInfEntity(musicAlbumEntity));
        musicAlbumEntity.setAlbumInformationStatic(new MusicAlbumInfStaticEntity("AlbumSaveTestComposer", 2018, musicAlbumEntity));
        System.out.println(musicService.saveAlbum(mapper.writeValueAsString(musicAlbumEntity)));
    }

    @Test
    @DisplayName("Album get test")
    public void albumGetTest() throws Exception {
        MusicServiceImpl musicService = new MusicServiceImpl();
        System.out.println(musicService.getAlbum(1));
    }

    @Test
    @DisplayName("Album update test")
    public void albumUpdateTest() throws Exception {
        MusicServiceImpl musicService = new MusicServiceImpl();
        ObjectMapper mapper = new ObjectMapper();
    }
}
