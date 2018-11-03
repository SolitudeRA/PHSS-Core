package org.protogalaxy.phss.test.datasource;

import org.protogalaxy.phss.datasource.entity.filesystem.album.music.*;
import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemMainEntity;
import org.protogalaxy.phss.datasource.entity.filesystem.main.FileSystemSpaceEntity;
import org.protogalaxy.phss.datasource.entity.personaldata.PersonalDataEntity;
import org.protogalaxy.phss.datasource.entity.setting.SettingMainEntity;
import org.protogalaxy.phss.datasource.entity.user.UserEntity;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.album.music.*;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.main.FilesystemMainRepository;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.main.FilesystemSpaceRepository;
import org.protogalaxy.phss.datasource.repository.jpa.personaldata.PersonalDataRepository;
import org.protogalaxy.phss.datasource.repository.jpa.setting.SettingMainRepository;
import org.protogalaxy.phss.datasource.repository.jpa.user.UserRepository;
import org.protogalaxy.phss.security.config.GrantedAuthority;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.Set;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 * TODO: Entity test bench design
 */

@DisplayName("Entity test bench")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DataJpaTest
@Rollback(false)
@ExtendWith({SpringExtension.class})
public class TestDataFiller {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FilesystemMainRepository filesystemMainRepository;

    @Autowired
    private FilesystemSpaceRepository filesystemSpaceRepository;

    @Autowired
    private PersonalDataRepository personalDataRepository;

    @Autowired
    private SettingMainRepository settingMainRepository;

    @Autowired
    private MusicAlbumRepository musicAlbumRepository;

    @Autowired
    private MusicAlbumInfRepository musicAlbumInfRepository;

    @Autowired
    private MusicAlbumInfStaticRepository musicAlbumInfStaticRepository;

    @Autowired
    private MusicTrackRepository musicTrackRepository;

    @Autowired
    private MusicTrackInfRepository musicTrackInfRepository;

    @Autowired
    private MusicTrackInfStaticRepository musicTrackInfStaticRepository;

    @BeforeAll
    public void initAll() {
    }

    @BeforeEach
    public void init() {
    }

    @DisplayName("User filler")
    @ParameterizedTest
    @CsvSource({"Alpha,sol123456", "Beta,#$%&!@#", "Charlie,test", "Delta,test"})
    public void userTestCase(String username, String password) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        GrantedAuthority authority1 = new GrantedAuthority("ROLE_USER");
        GrantedAuthority authority2 = new GrantedAuthority("ROLE_ADMIN");
        authorities.add(authority1);
        authorities.add(authority2);
        UserEntity userEntity = new UserEntity(username, password, authorities, true, true, true);
        userRepository.save(userEntity);
        FileSystemMainEntity fileSystemMainEntity = new FileSystemMainEntity(userEntity);
        filesystemMainRepository.save(fileSystemMainEntity);
        filesystemSpaceRepository.save(new FileSystemSpaceEntity(fileSystemMainEntity));
        personalDataRepository.save(new PersonalDataEntity(userEntity));
        settingMainRepository.save(new SettingMainEntity(userEntity));
    }

    @DisplayName("Music_Album filler")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/music-album.csv")
    public void musicAlbumTestCase(String albumName, String artist, String albumArtist, String composer) {
        MusicAlbumEntity musicAlbumEntity = new MusicAlbumEntity(userRepository.findByUsername("Alpha").getFileSystemMainEntity(), albumName, artist, "");
        musicAlbumRepository.save(musicAlbumEntity);
        musicAlbumInfRepository.save(new MusicAlbumInfEntity(musicAlbumEntity));
        musicAlbumInfStaticRepository.save(new MusicAlbumInfStaticEntity(musicAlbumEntity));
    }

    @DisplayName("Music_Track filler")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/music-track.csv")
    public void musicTrackTestCase(String trackName, String totalTime, String artist, String albumName, String genre, int playbackCount) {
        MusicTrackEntity musicTrackEntity = new MusicTrackEntity(userRepository.findByUsername("Alpha").getFileSystemMainEntity(), trackName, albumName, artist, "", "");
        musicTrackRepository.save(musicTrackEntity);
        musicTrackInfRepository.save(new MusicTrackInfEntity(musicTrackEntity));
        musicTrackInfStaticRepository.save(new MusicTrackInfStaticEntity("music track test", musicTrackEntity));
    }

    @DisplayName("Document filler")
    @ParameterizedTest
    @ValueSource(strings = {"doc1", "doc2", "doc3"})
    public void documentTestCase(String documentName) {

    }

    @DisplayName("Movie filler")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/movie.csv")
    public void movieTestCase(String movieName, String director) {

    }

    @Disabled
    @DisplayName("Video filler")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/video.csv")
    public void videoTestCase() {

    }

    @Disabled
    @DisplayName("Anime filler")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/anime.csv")
    public void animeTestCase() {

    }

    @Disabled
    @DisplayName("Illustration filler")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/illustration.csv")
    public void illustrationTestCase() {

    }

    @Disabled
    @DisplayName("Photo filler")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/photo.csv")
    public void photoTestCase() {

    }

    @Disabled
    @DisplayName("Folder filler")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/folder.csv")
    public void folderTestCase() {
    }

    @Disabled
    @DisplayName("Calender filler")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/calender.csv")
    public void calenderEventTestCase() {

    }

    @AfterEach
    public void tearDown() {

    }

    @AfterAll
    public void tearDownAll() {

    }
}
