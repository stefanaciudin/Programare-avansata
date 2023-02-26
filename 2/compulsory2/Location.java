package compulsory2;

public class Location {
    private String name;
    private LocationTypes type;
    private float x;
    private float y;

    public Location(String name, LocationTypes type, float x, float y) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(LocationTypes type) {
        this.type = type;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public LocationTypes getType() {
        return type;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}