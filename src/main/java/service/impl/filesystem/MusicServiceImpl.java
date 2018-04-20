package service.impl.filesystem;

import com.fasterxml.jackson.databind.ObjectMapper;
import datasource.JPAUtil;
import datasource.entity.core.filesystem.album.music.MusicAlbumEntity;
import datasource.entity.core.filesystem.album.music.MusicAlbumInfEntity;
import datasource.entity.core.filesystem.album.music.MusicTrackEntity;
import datasource.entity.core.filesystem.album.music.MusicTrackInfEntity;
import org.springframework.stereotype.Service;
import service.main.filesystem.MusicService;

import javax.persistence.EntityManager;

//TODO: Music service implement(Counts)
@Service
public class MusicServiceImpl implements MusicService {
    @Override
    public String saveAlbum(String album) throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        entityManager.getTransaction().begin();
        MusicAlbumEntity musicAlbumEntity = mapper.readValue(album, MusicAlbumEntity.class);
        entityManager.persist(musicAlbumEntity);
        entityManager.getTransaction().commit();
        entityManager.refresh(musicAlbumEntity);
        return mapper.writeValueAsString(musicAlbumEntity);
    }

    @Override
    public String getAlbum(int id) throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(entityManager.find(MusicAlbumEntity.class, id));
    }

    @Override
    public String updateAlbum(String album) throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        MusicAlbumEntity updatedAlbum = mapper.readValue(album, MusicAlbumEntity.class);
        MusicAlbumEntity handledAlbum = entityManager.find(MusicAlbumEntity.class, updatedAlbum.getId());
        handledAlbum.setName(updatedAlbum.getName());
        handledAlbum.setArtist(updatedAlbum.getArtist());
        handledAlbum.setLocation(updatedAlbum.getLocation());
        handledAlbum.getAlbumInformationStatic().setArtwork(updatedAlbum.getAlbumInformationStatic().getArtwork());
        handledAlbum.getAlbumInformationStatic().setComposer(updatedAlbum.getAlbumInformationStatic().getComposer());
        handledAlbum.getAlbumInformationStatic().setYear(updatedAlbum.getAlbumInformationStatic().getYear());
        handledAlbum.getAlbumInformationStatic().setTotalTime(updatedAlbum.getAlbumInformationStatic().getTotalTime());
        handledAlbum.getAlbumInformationStatic().setTrackCount(updatedAlbum.getAlbumInformationStatic().getTrackCount());
        handledAlbum.getAlbumInformationStatic().setAlbumNumber(updatedAlbum.getAlbumInformationStatic().getAlbumNumber());
        handledAlbum.getAlbumInformationStatic().setAlbumCount(updatedAlbum.getAlbumInformationStatic().getAlbumCount());
        handledAlbum.getAlbumInformationStatic().setGenreSummary(updatedAlbum.getAlbumInformationStatic().getGenreSummary());
        handledAlbum.getAlbumInformationStatic().setGenreSub1(updatedAlbum.getAlbumInformationStatic().getGenreSub1());
        handledAlbum.getAlbumInformationStatic().setGenreSub2(updatedAlbum.getAlbumInformationStatic().getGenreSub2());
        handledAlbum.getAlbumInformationStatic().setGenreSub3(updatedAlbum.getAlbumInformationStatic().getGenreSub3());
        handledAlbum.getAlbumInformationStatic().setStar(updatedAlbum.getAlbumInformationStatic().getStar());
        handledAlbum.getAlbumInformationStatic().setIsFavorite(updatedAlbum.getAlbumInformationStatic().getIsFavorite());
        handledAlbum.getAlbumInformationStatic().setComment(updatedAlbum.getAlbumInformationStatic().getComment());
        handledAlbum.getAlbumInformationStatic().setSize(updatedAlbum.getAlbumInformationStatic().getSize());
        entityManager.persist(handledAlbum);
        entityManager.refresh(handledAlbum);
        return mapper.writeValueAsString(handledAlbum);
    }

    @Override
    public String updateAlbumCounters(String counters) throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        MusicAlbumInfEntity updatedMusicAlbumInfEntity = mapper.readValue(counters, MusicAlbumInfEntity.class);
        MusicAlbumInfEntity handledMusicAlbumInfEntity = entityManager.find(MusicAlbumInfEntity.class, updatedMusicAlbumInfEntity.getAlbumId());
        handledMusicAlbumInfEntity.setPlaybackCount(updatedMusicAlbumInfEntity.getPlaybackCount());
        entityManager.persist(handledMusicAlbumInfEntity);
        entityManager.refresh(handledMusicAlbumInfEntity);
        return mapper.writeValueAsString(handledMusicAlbumInfEntity);
    }

    @Override
    public boolean removeAlbum(int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.remove(entityManager.find(MusicAlbumEntity.class, id));
        return entityManager.find(MusicAlbumEntity.class, id) == null;
    }

    @Override
    public String listAlbumByName(int ownerId, String albumName) throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(entityManager.createQuery("select albums from MusicAlbumEntity albums where albums.owner=:owner and albums.name=:name", MusicAlbumEntity.class).setParameter("owner", ownerId).setParameter("name", albumName).getResultList());
    }

    @Override
    public String listAlbumByArtist(int ownerId, String artist) throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(entityManager.createQuery("select albums from MusicAlbumEntity albums where albums.owner=:owner and albums.artist=:artist", MusicAlbumEntity.class).setParameter("owner", ownerId).setParameter("artist", artist).getResultList());
    }

    @Override
    public String saveTrack(String track) throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        entityManager.getTransaction().begin();
        MusicTrackEntity musicTrackEntity = mapper.readValue(track, MusicTrackEntity.class);
        entityManager.persist(musicTrackEntity);
        entityManager.getTransaction().commit();
        entityManager.refresh(musicTrackEntity);
        return mapper.writeValueAsString(musicTrackEntity);
    }

    @Override
    public String getTrack(int id) throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(entityManager.find(MusicTrackEntity.class, id));
    }

    @Override
    public String updateTrack(String track) throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        MusicTrackEntity updatedMusicTrackEntity = mapper.readValue(track, MusicTrackEntity.class);
        MusicTrackEntity handledMusicTrackEntity = entityManager.find(MusicTrackEntity.class, updatedMusicTrackEntity.getId());
        handledMusicTrackEntity.setName(updatedMusicTrackEntity.getName());
        handledMusicTrackEntity.setAlbum(updatedMusicTrackEntity.getAlbum());
        handledMusicTrackEntity.setArtist(updatedMusicTrackEntity.getArtist());
        handledMusicTrackEntity.setAlbumArtist(updatedMusicTrackEntity.getAlbumArtist());
        handledMusicTrackEntity.getTrackInformationStatic().setSize(updatedMusicTrackEntity.getTrackInformationStatic().getSize());
        handledMusicTrackEntity.getTrackInformationStatic().setTotalTime(updatedMusicTrackEntity.getTrackInformationStatic().getTotalTime());
        handledMusicTrackEntity.getTrackInformationStatic().setTrackNumber(updatedMusicTrackEntity.getTrackInformationStatic().getTrackNumber());
        handledMusicTrackEntity.getTrackInformationStatic().setTrackCount(updatedMusicTrackEntity.getTrackInformationStatic().getTrackCount());
        handledMusicTrackEntity.getTrackInformationStatic().setYear(updatedMusicTrackEntity.getTrackInformationStatic().getYear());
        handledMusicTrackEntity.getTrackInformationStatic().setBitRate(updatedMusicTrackEntity.getTrackInformationStatic().getBitRate());
        handledMusicTrackEntity.getTrackInformationStatic().setSampleRate(updatedMusicTrackEntity.getTrackInformationStatic().getSampleRate());
        handledMusicTrackEntity.getTrackInformationStatic().setArtwork(updatedMusicTrackEntity.getTrackInformationStatic().getArtwork());
        handledMusicTrackEntity.getTrackInformationStatic().setGenre(updatedMusicTrackEntity.getTrackInformationStatic().getGenre());
        handledMusicTrackEntity.getTrackInformationStatic().setKind(updatedMusicTrackEntity.getTrackInformationStatic().getKind());
        handledMusicTrackEntity.getTrackInformationStatic().setLocation(updatedMusicTrackEntity.getTrackInformationStatic().getLocation());
        entityManager.persist(handledMusicTrackEntity);
        entityManager.refresh(handledMusicTrackEntity);
        return mapper.writeValueAsString(handledMusicTrackEntity);
    }

    @Override
    public String updateTrackCounters(String counters) throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        MusicTrackInfEntity updatedMusicTrackInfEntity = mapper.readValue(counters, MusicTrackInfEntity.class);
        MusicTrackInfEntity handledMusicTrackInfEntity = entityManager.find(MusicTrackInfEntity.class, updatedMusicTrackInfEntity.getTrackId());
        handledMusicTrackInfEntity.setPlaybackCount(updatedMusicTrackInfEntity.getPlaybackCount());
        handledMusicTrackInfEntity.setPlaybackDate(updatedMusicTrackInfEntity.getPlaybackDate());
        handledMusicTrackInfEntity.setSkipCount(updatedMusicTrackInfEntity.getSkipCount());
        handledMusicTrackInfEntity.setSkipDate(updatedMusicTrackInfEntity.getSkipDate());
        entityManager.persist(handledMusicTrackInfEntity);
        entityManager.refresh(handledMusicTrackInfEntity);
        return mapper.writeValueAsString(handledMusicTrackInfEntity);
    }

    @Override
    public boolean removeTrack(int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.remove(entityManager.find(MusicTrackEntity.class, id));
        return entityManager.find(MusicTrackEntity.class, id) == null;
    }

    @Override
    public String listTrackByName(int ownerId, String trackName) throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(entityManager.createQuery("select tracks from MusicTrackEntity tracks where tracks.owner=:owner and tracks.name=:name", MusicTrackEntity.class).setParameter("owner", ownerId).setParameter("name", trackName).getResultList());
    }

    @Override
    public String listTrackByAlbum(int ownerId, String albumName) throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(entityManager.createQuery("select tracks from MusicTrackEntity tracks where tracks.owner=:owner and tracks.album=:album", MusicTrackEntity.class).setParameter("owner", ownerId).setParameter("album", albumName).getResultList());
    }

    @Override
    public String listTracksByArtist(int ownerId, String artist) throws Exception {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(entityManager.createQuery("select tracks from MusicTrackEntity tracks where tracks.owner=:owner and tracks.artist=:artist", MusicTrackEntity.class).setParameter("owner", ownerId).setParameter("artist", artist).getResultList());
    }
}
