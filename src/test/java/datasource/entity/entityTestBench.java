package datasource.entity;

import datasource.DataSource;
import datasource.entity.subjects.*;
import org.junit.Test;
import org.junit.jupiter.api.*;

import javax.persistence.*;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 * TODO: Entity test bench design
 */

@DisplayName("Entity test bench")
public class entityTestBench {
    private DataSource dataSource = new DataSource();

    @Test
    public void userTestCase(){
        EntityManager entityManager = dataSource.getEntityManagerFactory().createEntityManager();
        UserTest userTest = new UserTest();
        userTest.beginTest(entityManager);
    }

    @Test
    public void fileSystemInfMainTeatCase(){
        EntityManager entityManager = dataSource.getEntityManagerFactory().createEntityManager();
        FilesystemInfMainTest filesystemInfMainTest = new FilesystemInfMainTest();
        filesystemInfMainTest.beginTest(entityManager);
    }

    @Test
    public void musicAlbumTestCase(){
        EntityManager entityManager = dataSource.getEntityManagerFactory().createEntityManager();
        MusicAlbumTest musicAlbumTest = new MusicAlbumTest();
        musicAlbumTest.beginTest(entityManager);
    }

    @Test
    public void musicTrackTestCase(){
        EntityManager entityManager = dataSource.getEntityManagerFactory().createEntityManager();
        MusicTrackTest musicTrackTest = new MusicTrackTest();
        musicTrackTest.beginTest(entityManager);
    }

    @Test
    public void bookTestCase(){
        EntityManager entityManager = dataSource.getEntityManagerFactory().createEntityManager();
        BookTest bookTest = new BookTest();
        bookTest.beginTest(entityManager);
    }

    @Test
    public void movieTestCase(){
        EntityManager entityManager = dataSource.getEntityManagerFactory().createEntityManager();
        MovieTest movieTest = new MovieTest();
        movieTest.beginTest(entityManager);
    }

    @Test
    public void animeTestCate(){
        EntityManager entityManager = dataSource.getEntityManagerFactory().createEntityManager();
        AnimeTest animeTest = new AnimeTest();
        animeTest.beginTest(entityManager);
    }

    @Test
    public void illustrationTestCase(){
        EntityManager entityManager = dataSource.getEntityManagerFactory().createEntityManager();
        IllustrationTest illustrationTest = new IllustrationTest();
        illustrationTest.beginTest(entityManager);
    }

    @Test
    public void photoAlbumTestCase(){
        EntityManager entityManager = dataSource.getEntityManagerFactory().createEntityManager();
        PhotoAlbumTest photoAlbumTest = new PhotoAlbumTest();
        photoAlbumTest.beginTest(entityManager);
    }

    @Test
    public void photoTestCase(){
        EntityManager entityManager = dataSource.getEntityManagerFactory().createEntityManager();
        PhotoTest photoTest = new PhotoTest();
        photoTest.beginTest(entityManager);
    }

    @AfterAll
    public void tearDownAll(){
        dataSource.close();
    }
}
