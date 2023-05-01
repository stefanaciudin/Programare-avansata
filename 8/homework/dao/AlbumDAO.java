package dao;

import database.DatabaseManager;
import homework.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class AlbumDAO - has methods for operations on the Album table
 * of the given database
 */

public class AlbumDAO {
    private final Connection connection;

    public AlbumDAO() throws SQLException {
        connection = DatabaseManager.getConnection();
    }

    public List<Album> getAllAlbums() throws SQLException { // getting all the albums
        List<Album> albums = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM albums");

        while (resultSet.next()) {
            Album album = new Album();
            album.setId(resultSet.getInt("id"));
            album.setReleaseYear(resultSet.getInt("release_year"));
            album.setTitle(resultSet.getString("title"));
            int artistId = resultSet.getInt("artist_id");
            ArtistDAO artistDAO = new ArtistDAO();
            Artist artist = artistDAO.findById(artistId);
            album.setArtist(artist);
            int albumId = resultSet.getInt("id");
            List<Genre> genres = getGenresForAlbum(albumId);
            album.setGenres(genres);

            albums.add(album);
        }

        return albums;
    }

    public void addAlbum(Album album) throws SQLException { // adding a new album
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO albums (release_year, title, artist_id) VALUES (?, ?, ?)");
        preparedStatement.setInt(1, album.getReleaseYear());
        preparedStatement.setString(2, album.getTitle());
        preparedStatement.setInt(3, album.getArtist().getId());
        preparedStatement.executeUpdate();

        int albumId = getAlbumIdByTitle(album.getTitle());
        for (Genre genre : album.getGenres()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO album_genres (album_id, genre_id) VALUES (?, ?)");
            statement.setInt(1, albumId);
            statement.setInt(2, genre.getId());
            statement.executeUpdate();
        }
    }

    public void updateAlbum(Album album) throws SQLException { //update an existent album
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE albums SET release_year = ?, title = ?, artist_id = ? WHERE id = ?");
        preparedStatement.setInt(1, album.getReleaseYear());
        preparedStatement.setString(2, album.getTitle());
        preparedStatement.setInt(3, album.getArtist().getId());
        preparedStatement.setInt(4, album.getId());
        preparedStatement.executeUpdate();

        // delete old genre associations
        PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM album_genres WHERE album_id = ?");
        deleteStatement.setInt(1, album.getId());
        deleteStatement.executeUpdate();

        // insert new genre associations
        for (Genre genre : album.getGenres()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO album_genres (album_id, genre_id) VALUES (?, ?)");
            statement.setInt(1, album.getId());
            statement.setInt(2, genre.getId());
            statement.executeUpdate();
        }
    }

    public void deleteAlbum(Album album) throws SQLException { //delete an existent album
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM albums WHERE id = ?");
        preparedStatement.setInt(1, album.getId());
        preparedStatement.executeUpdate();

        PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM album_genres WHERE album_id = ?");
        deleteStatement.setInt(1, album.getId());
        deleteStatement.executeUpdate();
    }

    public List<Album> getAlbumsByArtist(Artist artist) throws SQLException { //get all albums by a given artist
        List<Album> albums = new ArrayList<>();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM albums WHERE artist_id = ?");
        preparedStatement.setInt(1, artist.getId());
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Album album = new Album();
            album.setId(resultSet.getInt("id"));
            album.setReleaseYear(resultSet.getInt("release_year"));
            album.setTitle(resultSet.getString("title"));
            album.setArtist(artist);
            int albumId = resultSet.getInt("id");
            List<Genre> genres = getGenresForAlbum(albumId);
            album.setGenres(genres);
            albums.add(album);
        }
        return albums;
    }

    public List<Album> getAlbumsByGenre(Genre genre) throws SQLException { //get all albums of a given genre
        List<Album> albums = new ArrayList<>();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM albums INNER JOIN album_genres ON albums.id = album_genres.album_id WHERE album_genres.genre_id = ?");
        preparedStatement.setInt(1, genre.getId());
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Album album = new Album();
            album.setId(resultSet.getInt("id"));
            album.setReleaseYear(resultSet.getInt("release_year"));
            album.setTitle(resultSet.getString("title"));

            int artistId = resultSet.getInt("artist_id");
            ArtistDAO artistDAO = new ArtistDAO();
            Artist artist = artistDAO.findById(artistId);
            album.setArtist(artist);

            album.setGenres(List.of(genre));

            albums.add(album);
        }

        return albums;
    }

    private int getAlbumIdByTitle(String title) throws SQLException { //get an album's id using its title
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM albums WHERE title = ?");
        preparedStatement.setString(1, title);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt("id");
        } else {
            throw new SQLException("Could not find album with title: " + title);
        }
    }

    private List<Genre> getGenresForAlbum(int albumId) throws SQLException { //get the list of genres of a given album
        List<Genre> genres = new ArrayList<>();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT genres.* FROM genres INNER JOIN album_genres ON genres.id = album_genres.genre_id WHERE album_genres.album_id = ?");
        preparedStatement.setInt(1, albumId);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Genre genre = new Genre();
            genre.setId(resultSet.getInt("id"));
            genre.setName(resultSet.getString("name"));
            genres.add(genre);
        }

        return genres;
    }
}

