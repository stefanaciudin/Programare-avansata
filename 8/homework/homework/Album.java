package homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Album - has an id, a releaseYear, a title, an artist
 * that wrote the album and a list of genres
 */

public class Album {
    private int id;
    private int releaseYear;
    private String title;
    private Artist artist;
    private Genre genre;
    private List<Genre> genres = new ArrayList<>();

    public Album() {
    }

    public Album(int id, int releaseYear, String title, Artist artist, List<Genre> genres) {
        this.id = id;
        this.releaseYear = releaseYear;
        this.title = title;
        this.artist = artist;
        this.genres = genres;
    }

    public Album(int releaseYear, String title, Artist artist) {
        this.releaseYear = releaseYear;
        this.title = title;
        this.artist = artist;
    }

    public Album(int releaseYear, String title, Artist artist, Genre genre) {
        this.releaseYear = releaseYear;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public void addGenre(Genre genre) {
        genres.add(genre);
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", releaseYear=" + releaseYear +
                ", title='" + title + '\'' +
                ", artist=" + artist +
                '}';
    }
}
