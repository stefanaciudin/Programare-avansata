package homework;

/**
 * Class Arist - has an id and a name
 */
public class Artist {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Artist{" +
                "Name='" + name + '\'' +
                '}';
    }

    public Artist() {
    }

    public Artist(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
