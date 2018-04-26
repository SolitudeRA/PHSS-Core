package datasource.entity;

import me.protogalaxy.datasource.JPAUtil;
import me.protogalaxy.datasource.entity.core.filesystem.album.music.*;
import me.protogalaxy.datasource.entity.core.filesystem.book.BookEntity;
import me.protogalaxy.datasource.entity.core.filesystem.book.BookInfEntity;
import me.protogalaxy.datasource.entity.core.filesystem.document.DocumentEntity;
import me.protogalaxy.datasource.entity.core.filesystem.main.FileSystemMainEntity;
import me.protogalaxy.datasource.entity.core.filesystem.main.FileSystemSpaceEntity;
import me.protogalaxy.datasource.entity.core.filesystem.folder.FolderEntity;
import me.protogalaxy.datasource.entity.core.filesystem.illustration.IllustrationEntity;
import me.protogalaxy.datasource.entity.core.filesystem.album.photo.PhotoEntity;
import me.protogalaxy.datasource.entity.core.filesystem.movie.AnimeEntity;
import me.protogalaxy.datasource.entity.core.filesystem.movie.MovieEntity;
import me.protogalaxy.datasource.entity.core.filesystem.movie.VideoEntity;
import me.protogalaxy.datasource.entity.core.personaldata.PersonalDataInfEntity;
import me.protogalaxy.datasource.entity.core.personaldata.calender.CalenderEntity;
import me.protogalaxy.datasource.entity.core.setting.SettingMainEntity;
import me.protogalaxy.datasource.entity.core.user.UserEntity;
import me.protogalaxy.service.security.config.PhssGrantedAuthority;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 * TODO: Entity test bench design
 */

@DisplayName("Entity test bench")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EntityTestBench {
    private EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    @BeforeAll
    void initAll() {

    }

    @BeforeEach
    void init() {
        entityManager.getTransaction().begin();
    }

    @DisplayName("User test case")
    @ParameterizedTest
    @CsvSource({"Alpha,sol123456", "Beta,#$%&!@#", "Charlie,test", "Delta,test"})
    void userTestCase(String username, String password) {
        Set<PhssGrantedAuthority> authorities = new HashSet<>();
        PhssGrantedAuthority authority1 = new PhssGrantedAuthority("ROLE_USER");
        PhssGrantedAuthority authority2 = new PhssGrantedAuthority("ROLE_ADMIN");
        authorities.add(authority1);
        authorities.add(authority2);
        UserEntity userEntity = new UserEntity(username, password, authorities);
        entityManager.persist(userEntity);
        FileSystemMainEntity fileSystemMainEntity = new FileSystemMainEntity(userEntity);
        entityManager.persist(fileSystemMainEntity);
        entityManager.persist(new FileSystemSpaceEntity(fileSystemMainEntity));
        entityManager.persist(new PersonalDataInfEntity(userEntity));
        entityManager.persist(new SettingMainEntity(userEntity));
    }

    @DisplayName("user select test case")
    @ParameterizedTest
    @CsvSource({"Alpha", "Beta", "Charlie", "Delta"})
    void userSelectTestCase(String username) {
        UserEntity userEntity = entityManager.createQuery("select user from UserEntity user where user.username=:username", UserEntity.class).setParameter("username", username).getSingleResult();
        System.out.println(userEntity.getPassword());
    }


    @DisplayName("Music_Album test case")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/music-album.csv")
    void musicAlbumTestCase(String albumName, String artist, String albumArtist, String composer) {
        MusicAlbumEntity musicAlbumEntity = new MusicAlbumEntity(albumName, artist);
        entityManager.persist(musicAlbumEntity);
        entityManager.persist(new MusicAlbumInfEntity(musicAlbumEntity));
        entityManager.persist(new MusicAlbumInfStaticEntity(musicAlbumEntity));
    }

    @DisplayName("Music_Track test case")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/music-track.csv")
    void musicTrackTestCase(String trackName, String totalTime, String artist, String albumName, String genre, int playbackCount) {
        MusicTrackEntity musicTrackEntity = new MusicTrackEntity(trackName, albumName, artist, artist);
        entityManager.persist(musicTrackEntity);
        entityManager.persist(new MusicTrackInfEntity(playbackCount, null, 0, null, musicTrackEntity));
        entityManager.persist(new MusicTrackInfStaticEntity("music track test", musicTrackEntity));
    }

    @DisplayName("Book test case")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/book.csv")
    void bookTestCase(String bookName, String author) {
        BookEntity bookEntity = new BookEntity(bookName);
        entityManager.persist(bookEntity);
        BookInfEntity bookInfEntity = new BookInfEntity(author, null, null);
        bookInfEntity.setBookEntity(bookEntity);
        entityManager.persist(bookInfEntity);
    }

    @DisplayName("Document test case")
    @ParameterizedTest
    @ValueSource(strings = {"doc1", "doc2", "doc3"})
    void documentTestCase(String documentName) {
        entityManager.persist(new DocumentEntity(documentName));
    }

    @DisplayName("Movie test case")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/movie.csv")
    void movieTestCase(String movieName, String director) {
        entityManager.persist(new MovieEntity(movieName));
    }

    @Disabled
    @DisplayName("Video test case")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/video.csv")
    void videoTestCase() {
        entityManager.persist(new VideoEntity());
    }

    @Disabled
    @DisplayName("Anime test case")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/anime.csv")
    void animeTestCase() {
        entityManager.persist(new AnimeEntity());
    }

    @Disabled
    @DisplayName("Illustration test case")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/illustration.csv")
    void illustrationTestCase() {
        entityManager.persist(new IllustrationEntity());
    }

    @Disabled
    @DisplayName("Photo test case")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/photo.csv")
    void photoTestCase() {
        entityManager.persist(new PhotoEntity());
    }

    @Disabled
    @DisplayName("Folder test case")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/folder.csv")
    void folderTestCase() {
        entityManager.persist(new FolderEntity());
    }

    @Disabled
    @DisplayName("Calender test case")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/calender.csv")
    void calenderEventTestCase() {
        entityManager.persist(new CalenderEntity());
    }

    @AfterEach
    void tearDown() {
        entityManager.getTransaction().commit();
    }

    @AfterAll
    void tearDownAll() {
        JPAUtil.close();
    }
}
