package dao;

import homework.Artist;
import database.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class AristDAO - has methods for operations on the Artist table
 * of the given database
 */

public class ArtistDAO {
    private final Connection connection;

    public ArtistDAO() throws SQLException {
        connection = DatabaseManager.getConnection();
    }

    public List<Artist> getAllArtists() throws SQLException { //get all artists
        List<Artist> artists = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT DISTINCT name FROM artists");

        while (resultSet.next()) {
            Artist artist = new Artist();
            artist.setName(resultSet.getString("name"));
            artists.add(artist);
        }
        return artists;

    }

    public void addArtist(Artist artist) throws SQLException { //add a new artist
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO artists (name) VALUES (?)");
        preparedStatement.setString(1, artist.getName());
        preparedStatement.executeUpdate();
    }

    public void updateArtist(Artist artist) throws SQLException { //update an existent artist
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE artists SET name = ? WHERE id = ?");
        preparedStatement.setString(1, artist.getName());
        preparedStatement.setInt(2, artist.getId());
        preparedStatement.executeUpdate();
    }

    public void deleteArtist(Artist artist) throws SQLException { //delete an existent artist
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM artists WHERE id = ?");
        preparedStatement.setInt(1, artist.getId());
        preparedStatement.executeUpdate();
    }

    public Artist findByName(String name) throws SQLException { //find an artist by its name
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM artists WHERE name = ?");
        preparedStatement.setString(1, name);
        return getArtist(preparedStatement);
    }

    private Artist getArtist(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Artist artist = new Artist();
            artist.setId(resultSet.getInt("id"));
            artist.setName(resultSet.getString("name"));
            return artist;
        }
        return null;
    }

    public Artist findById(int id) throws SQLException { //find an artist by its id
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM artists WHERE id = ?");
        preparedStatement.setInt(1, id);
        return getArtist(preparedStatement);
    }

    public int getArtistIdByName(String name) { //get an artist's id by its name
        int artistId = -1;
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT id FROM artists WHERE name = ?")) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                artistId = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artistId;
    }
}
