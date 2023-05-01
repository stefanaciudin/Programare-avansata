package entity;

import jakarta.persistence.*;

/**
 * Class Genre - models a genre from the database
 */

@Entity
@NamedQuery(name = "Genre.findByName", query = "SELECT g FROM Genre g WHERE LOWER(g.name) LIKE LOWER(:name)")
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

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
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
