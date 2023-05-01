package homework;

/**
 * Class Genre - has an id and a name, getters and setters
 */

public class Genre {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Genre{" +
                "name='" + name + '\'' +
                '}';
    }

    public Genre(){}

    public Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }


    public void setId(int id) {
        this.id = id;
    }
}
