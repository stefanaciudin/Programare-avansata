package repository;

import entity.Album;
import jakarta.persistence.*;

import java.util.List;

/**
 * Class AlbumRepository - has CRUD methods for album objects
 */
public class AlbumRepository {
    private final EntityManagerFactory emf;

    public AlbumRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void createAlbum(Album album) throws PersistenceException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(album);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new PersistenceException("Error creating album: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Album findAlbumById(int id) throws EntityNotFoundException {
        EntityManager em = emf.createEntityManager();
        Album album = em.find(Album.class, id);
        if (album == null) {
            throw new EntityNotFoundException("Album with id " + id + " not found");
        }
        em.close();
        return album;
    }

    public void updateAlbum(Album album) throws PersistenceException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(album);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new PersistenceException("Error updating album: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void deleteAlbum(int id) throws PersistenceException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Album album = em.find(Album.class, id);
            if (album != null) {
                em.remove(album);
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new PersistenceException("Error deleting album: " + e.getMessage());
        } finally {
            em.close();
        }
    }
    public List<Album> findAlbumsByName(String name) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Album> query = em.createNamedQuery("Album.findByName", Album.class);
        query.setParameter("name", "%" + name + "%");
        List<Album> albums = query.getResultList();
        em.close();
        return albums;
    }
}

