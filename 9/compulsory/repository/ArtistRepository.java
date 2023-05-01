package repository;
import entity.Artist;
import jakarta.persistence.*;

import java.util.List;
/**
 * Class ArtistRepository - has CRUD methods for artist objects
 */
public class ArtistRepository {
    private final EntityManagerFactory emf;

    public ArtistRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void createArtist(Artist artist) throws PersistenceException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(artist);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new PersistenceException("Error creating artist: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Artist findArtistById(int id) throws EntityNotFoundException {
        EntityManager em = emf.createEntityManager();
        Artist artist = em.find(Artist.class, id);
        if (artist == null) {
            throw new EntityNotFoundException("Artist with id " + id + " not found");
        }
        em.close();
        return artist;
    }

    public void updateArtist(Artist artist) throws PersistenceException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(artist);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new PersistenceException("Error updating artist: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void deleteArtist(int id) throws PersistenceException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Artist artist = em.find(Artist.class, id);
            if (artist != null) {
                em.remove(artist);
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new PersistenceException("Error deleting artist: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public List<Artist> findArtistsByName(String name) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Artist> query = em.createNamedQuery("Artist.findByName", Artist.class);
        query.setParameter("name", "%" + name + "%");
        List<Artist> artists = query.getResultList();
        em.close();
        return artists;
    }
}
