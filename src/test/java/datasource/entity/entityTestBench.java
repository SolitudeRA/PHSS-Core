package datasource.entity;

import datasource.DataSource;
import datasource.entity.fileSystemCore.booksLayer.BookEntity;
import datasource.entity.fileSystemCore.booksLayer.BookInfEntity;
import datasource.entity.fileSystemCore.documentsLayer.DocumentEntity;
import datasource.entity.fileSystemCore.floderLayer.FolderEntity;
import datasource.entity.fileSystemCore.illustrationLayer.IllustrationEntity;
import datasource.entity.fileSystemCore.moviesLayer.*;
import datasource.entity.fileSystemCore.musicAlbumsLayer.MusicAlbumEntity;
import datasource.entity.fileSystemCore.musicAlbumsLayer.MusicAlbumInfEntity;
import datasource.entity.fileSystemCore.musicAlbumsLayer.MusicTrackEntity;
import datasource.entity.fileSystemCore.musicAlbumsLayer.MusicTrackInfEntity;
import datasource.entity.fileSystemCore.photoAlbumsLayer.PhotoAlbumEntity;
import datasource.entity.fileSystemCore.photoAlbumsLayer.PhotoEntity;
import datasource.entity.personalDataCore.calenderLayer.CalenderEntity;
import datasource.entity.userManagementCore.UserEntity;
import org.junit.Test;
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
        entityManager.persist(new UserEntity(username, password));
    }

    @DisplayName("Music_Album test case")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/music-album.csv")
    void musicAlbumTestCase(String albumName, String artist, String albumArtist, String composer) {
        MusicAlbumEntity musicAlbumEntity = new MusicAlbumEntity(albumName);
        entityManager.persist(musicAlbumEntity);
    }

    @DisplayName("Music_Track test case")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/music-track.csv")
    void musicTrackTestCase(String trackName, String totalTime, String artist, String albumName, String genre, int playbackCount) {
        entityManager.persist(new MusicTrackEntity(trackName, albumName));
    }

    @DisplayName("Book test case")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/book.csv")
    void bookTestCase(String bookName, String author) {
        entityManager.persist(new BookEntity(bookName));
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

    @DisplayName("Video test case")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/video.csv")
    void videoTestCase() {
        entityManager.persist(new VideoEntity());
    }

    @DisplayName("Anime test case")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/anime.csv")
    void animeTestCase() {
        entityManager.persist(new AnimeEntity());
    }

    @DisplayName("Illustration test case")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/illustration.csv")
    void illustrationTestCase() {
        entityManager.persist(new IllustrationEntity());
    }

    @DisplayName("Photo test case")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/photo.csv")
    void photoTestCase() {
        entityManager.persist(new PhotoEntity());
    }

    @DisplayName("Folder test case")
    @ParameterizedTest
    @CsvFileSource(resources = "/valuesources/folder.csv")
    void folderTestCase() {
        entityManager.persist(new FolderEntity());
    }

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
