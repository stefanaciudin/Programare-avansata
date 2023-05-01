package repository;
import entity.Genre;
import jakarta.persistence.*;

import java.util.List;
/**
 * Class GenreRepository - has CRUD methods for genre objects
 */
public class GenreRepository {
    private final EntityManagerFactory emf;

    public GenreRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void createGenre(Genre genre) throws PersistenceException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(genre);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new PersistenceException("Error creating genre: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Genre findGenreById(int id) throws EntityNotFoundException {
        EntityManager em = emf.createEntityManager();
        Genre genre = em.find(Genre.class, id);
        if (genre == null) {
            throw new EntityNotFoundException("Genre with id " + id + " not found");
        }
        em.close();
        return genre;
    }

    public void updateGenre(Genre genre) throws PersistenceException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(genre);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new PersistenceException("Error updating genre: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void deleteGenre(int id) throws PersistenceException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Genre genre = em.find(Genre.class, id);
            if (genre != null) {
                em.remove(genre);
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new PersistenceException("Error deleting genre: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public List<Genre> findGenresByName(String name) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Genre> query = em.createNamedQuery("Genre.findByName", Genre.class);
        query.setParameter("name", "%" + name + "%");
        List<Genre> genres = query.getResultList();
        em.close();
        return genres;
    }
}
