package datasource.entity;

import datasource.DataSource;
import datasource.entity.core.filesystem.album.music.*;
import datasource.entity.core.filesystem.book.BookEntity;
import datasource.entity.core.filesystem.book.BookInfEntity;
import datasource.entity.core.filesystem.document.DocumentEntity;
import datasource.entity.core.filesystem.main.FileSystemMainEntity;
import datasource.entity.core.filesystem.main.FileSystemSpaceEntity;
import datasource.entity.core.filesystem.folder.FolderEntity;
import datasource.entity.core.filesystem.illustration.IllustrationEntity;
import datasource.entity.core.filesystem.movie.*;
import datasource.entity.core.filesystem.album.photo.PhotoEntity;
import datasource.entity.core.personaldata.PersonalDataInfEntity;
import datasource.entity.core.personaldata.calender.CalenderEntity;
import datasource.entity.core.setting.SettingMainEntity;
import datasource.entity.core.user.UserEntity;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.persistence.*;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 * TODO: Entity test bench design
 */

@DisplayName("Entity test bench")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class entityTestBench {
    private DataSource dataSource = new DataSource();
    private EntityManager entityManager = dataSource.getEntityManagerFactory().createEntityManager();

    @BeforeAll
    void initAll() {
        entityManager.getTransaction().begin();
    }

    @DisplayName("User test case")
    @ParameterizedTest
    @CsvSource({"Alpha,sol123456", "Beta,#$%&!@#", "Charlie,test", "Delta,test"})
    void userTestCase(String username, String password) {
        UserEntity userEntity = new UserEntity(username, password);
        entityManager.persist(userEntity);
        FileSystemMainEntity fileSystemMainEntity = new FileSystemMainEntity(userEntity);
        entityManager.persist(fileSystemMainEntity);
        entityManager.persist(new FileSystemSpaceEntity(fileSystemMainEntity));
        entityManager.persist(new PersonalDataInfEntity(userEntity));
        entityManager.persist(new SettingMainEntity(userEntity));
    }

    @DisplayName("Music_Album test case")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/music-album.csv")
    void musicAlbumTestCase(String albumName, String artist, String albumArtist, String composer) {
        MusicAlbumEntity musicAlbumEntity = new MusicAlbumEntity(albumName, artist);
        entityManager.persist(musicAlbumEntity);
        MusicAlbumInfEntity musicAlbumInfEntity = new MusicAlbumInfEntity(musicAlbumEntity);
        MusicAlbumInfStaticEntity musicAlbumInfStaticEntity = new MusicAlbumInfStaticEntity(musicAlbumEntity);
        entityManager.persist(musicAlbumInfEntity);
        entityManager.persist(musicAlbumInfStaticEntity);
    }

    @Disabled
    @DisplayName("Music_Track test case")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/music-track.csv")
    void musicTrackTestCase(String trackName, String totalTime, String artist, String albumName, String genre, int playbackCount) {
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

    @AfterAll
    void tearDownAll() {
        entityManager.getTransaction().commit();
        dataSource.close();
    }
}
