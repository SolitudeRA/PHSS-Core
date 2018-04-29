package me.protogalaxy.test.datasource;

import me.protogalaxy.datasource.entity.core.filesystem.album.music.*;
import me.protogalaxy.datasource.entity.core.filesystem.book.BookEntity;
import me.protogalaxy.datasource.entity.core.filesystem.book.BookInfEntity;
import me.protogalaxy.datasource.entity.core.filesystem.main.FileSystemMainEntity;
import me.protogalaxy.datasource.entity.core.filesystem.main.FileSystemSpaceEntity;
import me.protogalaxy.datasource.entity.core.personaldata.PersonalDataEntity;
import me.protogalaxy.datasource.entity.core.setting.SettingMainEntity;
import me.protogalaxy.datasource.entity.core.user.UserEntity;
import me.protogalaxy.datasource.entity.repository.filesystem.album.music.*;
import me.protogalaxy.datasource.entity.repository.filesystem.book.BookInfRepository;
import me.protogalaxy.datasource.entity.repository.filesystem.book.BookRepository;
import me.protogalaxy.datasource.entity.repository.filesystem.main.FilesystemMainRepository;
import me.protogalaxy.datasource.entity.repository.filesystem.main.FilesystemSpaceRepository;
import me.protogalaxy.datasource.entity.repository.personaldata.PersonalDataRepository;
import me.protogalaxy.datasource.entity.repository.setting.SettingMainRepository;
import me.protogalaxy.datasource.entity.repository.user.UserRepository;
import me.protogalaxy.security.config.PhssGrantedAuthority;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

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
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
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

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookInfRepository bookInfRepository;

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
        Set<PhssGrantedAuthority> authorities = new HashSet<>();
        PhssGrantedAuthority authority1 = new PhssGrantedAuthority("ROLE_USER");
        PhssGrantedAuthority authority2 = new PhssGrantedAuthority("ROLE_ADMIN");
        authorities.add(authority1);
        authorities.add(authority2);
        UserEntity userEntity = new UserEntity(username, password, authorities);
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

    @DisplayName("Book filler")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/book.csv")
    public void bookTestCase(String bookName, String author) {
        BookEntity bookEntity = new BookEntity(bookName);
        bookRepository.save(bookEntity);
        bookInfRepository.save(new BookInfEntity(bookEntity));
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
