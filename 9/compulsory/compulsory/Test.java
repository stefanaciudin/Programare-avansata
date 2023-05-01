package compulsory;

import entity.Album;
import entity.Artist;
import entity.Genre;
import jakarta.persistence.EntityManagerFactory;
import repository.AlbumRepository;
import repository.ArtistRepository;
import repository.GenreRepository;

import java.util.List;

/**
 * Class Test - used to test all the methods implemented
 */

public class Test {
    public static void main(String[] args) {
        // get EntityManagerFactory instance from the singleton
        EntityManagerFactory emf = EntityManagerFactorySingleton.getEntityManagerFactory();

        // create repository instances
        ArtistRepository artistRepo = new ArtistRepository(emf);
        AlbumRepository albumRepo = new AlbumRepository(emf);
        GenreRepository genreRepo = new GenreRepository(emf);

        // create new Artist entity
        Artist artist = new Artist();
        artist.setName("Ghost");

        // create new Album entity
        Album album = new Album();
        album.setReleaseYear(2015);
        album.setTitle("Meliora");
        //album.setArtist(artist);

        // create new Genre entity
        Genre genre = new Genre();
        genre.setName("Rock");


        // persist entities to database
        artistRepo.createArtist(artist);
        //albumRepo.createAlbum(album);
        genreRepo.createGenre(genre);

        // retrieve entities from database
        System.out.println("Before updates: ");
        Artist retrievedArtist = artistRepo.findArtistById(1);
        System.out.println(retrievedArtist);
        Album retrievedAlbum = albumRepo.findAlbumById(2);
        System.out.println(retrievedAlbum);
        Genre retrievedGenre = genreRepo.findGenreById(3);
        System.out.println(retrievedGenre);

        // update entities in database
        System.out.println("After updates: ");
        retrievedArtist.setName("The Rolling Stones");
        artistRepo.updateArtist(retrievedArtist);
        System.out.println(retrievedArtist);
        retrievedAlbum.setTitle("Abbey Road");
        albumRepo.updateAlbum(retrievedAlbum);
        System.out.println(retrievedAlbum);
        retrievedGenre.setName("Blues");
        genreRepo.updateGenre(retrievedGenre);
        System.out.println(retrievedGenre);

        List<Artist> artists = artistRepo.findArtistsByName("The Beatles");
        int entries = 0; // entries having as an artist The Beatles
        // print the results
        for (Artist a : artists) {
            entries++;
        }
        System.out.println("There are " + entries + " albums by The Beatles in the database");

        // close EntityManagerFactory
        emf.close();
    }

}
