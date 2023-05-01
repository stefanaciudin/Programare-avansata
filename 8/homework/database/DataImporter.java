package database;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import dao.AlbumDAO;
import dao.ArtistDAO;
import dao.GenreDAO;
import homework.Album;
import homework.Artist;
import homework.Genre;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

/**
 * DataImporter - class used to import from csv file
 */

public class DataImporter {
    public static void importAlbumsFromCSV(String filepath) throws IOException, SQLException, CsvValidationException {
        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {
            String[] line;
            int idValueArtists = 0;
            int idValueGenres = 0;
            int idValueAlbums = 0;
            while ((line = reader.readNext()) != null) {
                int releaseYear = Integer.parseInt(line[1]);
                String title = line[2];
                String artistName = line[3];
                String genreName = line[4];

                Artist artist = new Artist(artistName);
                artist.setId(++idValueArtists);
                Genre genre = new Genre(genreName);
                genre.setId(++idValueGenres);
                Album album = new Album(releaseYear, title, artist, genre);
                album.setId(++idValueAlbums);
                ArtistDAO artistDAO = new ArtistDAO();
                GenreDAO genreDAO = new GenreDAO();
                AlbumDAO albumDAO = new AlbumDAO();

                artistDAO.addArtist(artist);
                genreDAO.addGenre(genre);
                albumDAO.addAlbum(album);
            }
        }

    }
}
