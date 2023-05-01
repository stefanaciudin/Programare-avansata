package dao;

import database.DatabaseManager;
import homework.Genre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Class GenreDAO - has methods for operations on the Genre table
 * of the given database
 */
public class GenreDAO {
    private final Connection connection;

    public GenreDAO() throws SQLException {
        connection = DatabaseManager.getConnection();
    }
    public List<Genre> getAllGenres() throws SQLException { //get all existent genres
        List<Genre> genres = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT DISTINCT name FROM genres");

        while (resultSet.next()) {
            Genre genre = new Genre();
            genre.setName(resultSet.getString("name"));
            genres.add(genre);
        }

        return genres;
    }

    public void addGenre(Genre genre) throws SQLException { //add a new genre
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO genres (name) VALUES (?)");
        preparedStatement.setString(1, genre.getName());
        preparedStatement.executeUpdate();
    }

    public void updateGenre(Genre genre) throws SQLException { //update an existent genre
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE genres SET name = ? WHERE id = ?");
        preparedStatement.setString(1, genre.getName());
        preparedStatement.setInt(2, genre.getId());
        preparedStatement.executeUpdate();
    }

    public void deleteGenre(Genre genre) throws SQLException { //delete an existent genre
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM genres WHERE id = ?");
        preparedStatement.setInt(1, genre.getId());
        preparedStatement.executeUpdate();
    }

    public Genre findByName(String name) throws SQLException { //find a genre by its name
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM genres WHERE name = ?");
        preparedStatement.setString(1, name);
        return getGenre(preparedStatement);
    }

    public Genre findById(int id) throws SQLException { //find a genre by its id
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM genres WHERE id = ?");
        preparedStatement.setInt(1, id);
        return getGenre(preparedStatement);
    }

    private Genre getGenre(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            Genre genre = new Genre();
            genre.setId(resultSet.getInt("id"));
            genre.setName(resultSet.getString("name"));
            return genre;
        }

        return null;
    }

}

