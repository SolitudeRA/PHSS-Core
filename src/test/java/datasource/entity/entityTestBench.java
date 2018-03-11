package datasource.entity;

import datasource.DataSource;
import datasource.entity.fileSystemCore.booksLayer.BookEntity;
import datasource.entity.fileSystemCore.illustrationLayer.IllustrationEntity;
import datasource.entity.fileSystemCore.moviesLayer.AnimeEntity;
import datasource.entity.fileSystemCore.moviesLayer.MovieEntity;
import datasource.entity.fileSystemCore.musicAlbumsLayer.MusicAlbumEntity;
import datasource.entity.fileSystemCore.musicAlbumsLayer.MusicTrackEntity;
import datasource.entity.fileSystemCore.photoAlbumsLayer.PhotoAlbumEntity;
import datasource.entity.fileSystemCore.photoAlbumsLayer.PhotoEntity;
import datasource.entity.userManagementCore.UserEntity;
import org.junit.Test;
import org.junit.jupiter.api.*;

import javax.persistence.*;

/**
 * @author SolitudeRA
 * @version 1.0.0 SNAPSHOT
 * TODO: Entity test bench design
 */

@DisplayName("Entity test bench")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class entityTestBench {
    private DataSource dataSource = new DataSource();
    private EntityManager entityManager = dataSource.getEntityManagerFactory().createEntityManager();

    @Test
    public void userTestCase(){
        entityManager.getTransaction().begin();
        entityManager.persist(new UserEntity());
        entityManager.getTransaction().commit();
    }

    @Test
    public void musicAlbumTestCase(){
        entityManager.getTransaction().begin();
        entityManager.persist(new MusicAlbumEntity());
        entityManager.getTransaction().commit();
    }

    @Test
    public void musicTrackTestCase(){
        entityManager.getTransaction().begin();
        entityManager.persist(new MusicTrackEntity());
        entityManager.getTransaction().commit();
    }

    @Test
    public void bookTestCase(){
        entityManager.getTransaction().begin();
        entityManager.persist(new BookEntity());
        entityManager.getTransaction().commit();
    }

    @Test
    public void movieTestCase(){
        entityManager.getTransaction().begin();
        entityManager.persist(new MovieEntity());
        entityManager.getTransaction().commit();
    }

    @Test
    public void animeTestCase(){
        entityManager.getTransaction().begin();
        entityManager.persist(new AnimeEntity());
        entityManager.getTransaction().commit();
    }

    @Test
    public void illustrationTestCase(){
        entityManager.getTransaction().begin();
        entityManager.persist(new IllustrationEntity());
        entityManager.getTransaction().commit();
    }

    @Test
    public void photoAlbumTestCase(){
        entityManager.getTransaction().begin();
        entityManager.persist(new PhotoAlbumEntity());
        entityManager.getTransaction().commit();
    }

    @Test
    public void photoTestCase(){
        entityManager.getTransaction().begin();
        entityManager.persist(new PhotoEntity());
        entityManager.getTransaction().commit();
    }

    @AfterAll
    public void tearDownAll(){
        dataSource.close();
    }
}
