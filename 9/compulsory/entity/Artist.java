package entity;

import jakarta.persistence.*;

/**
 * Class Artist - model for an artist from the database
 */

@Entity
@NamedQuery(name = "Artist.findByName", query = "SELECT DISTINCT a FROM Artist a WHERE LOWER(a.name) LIKE LOWER(:name)")
@Table(name = "artists")

public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    public Artist() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Artist{" + "id=" + id + ", name='" + name + '\'' + '}';
    }

    public Artist(String name) {
        this.name = name;
    }
}
