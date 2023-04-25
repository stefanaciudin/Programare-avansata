package compulsory;

import java.sql.SQLException;

/**
 * Class Test - used to test all the methods
 */
public class Test {
    public static void main(String[] args) {
        try {
            int idValueArtists = 0;
            Artist artist1 = new Artist("The Beatles");
            artist1.setId(++idValueArtists);
            Artist artist2 = new Artist("Led Zeppelin");
            artist2.setId(++idValueArtists);
            ArtistDAO artistDAO = new ArtistDAO();
            artistDAO.addArtist(artist1);
            artistDAO.addArtist(artist2);

            int idValueGenres = 0;
            Genre genre1 = new Genre("Rock");
            genre1.setId(++idValueGenres);
            Genre genre2 = new Genre("Pop");
            genre2.setId(++idValueGenres);
            GenreDAO genreDAO = new GenreDAO();
            genreDAO.addGenre(genre1);
            genreDAO.addGenre(genre2);

            int idValueAlbums = 0;
            Album album1 = new Album(1967, "Sgt. Pepper's Lonely Hearts Club Band", artist1);
            album1.setId(++idValueAlbums);
            album1.addGenre(genre1);

            Album album2 = new Album(1971, "Led Zeppelin IV", artist2);
            album2.setId(++idValueAlbums);
            album2.addGenre(genre1);
            album2.addGenre(genre2);

            AlbumDAO albumDAO = new AlbumDAO();
            //albumDAO.addAlbum(album1);
            //albumDAO.addAlbum(album2);

            // test ArtistDAO
            System.out.println("All artists " + artistDAO.getAllArtists());
            System.out.println("The artist with id = 1 is " + artistDAO.findById(1));
            System.out.println("Find by name the second artist " + artistDAO.findByName(artist2.getName()));

            // test GenreDAO
            System.out.println("All genres " + genreDAO.getAllGenres());
            System.out.println("The genre with id = 2 is " + genreDAO.findById(2));
            System.out.println("Find by name the second genre " + genreDAO.findByName(genre2.getName()));

            // test AlbumDAO
            System.out.println("All albums " + albumDAO.getAllAlbums());
            System.out.println("Albums by The Beatles: " + albumDAO.getAlbumsByArtist(artist1));
            System.out.println("Rock albums: " + albumDAO.getAlbumsByGenre(genre1));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
