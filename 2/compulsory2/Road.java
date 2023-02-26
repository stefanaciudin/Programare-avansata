package compulsory2;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Road {
    private Location start;
    private Location end;
    private RoadTypes type;
    private float length;
    private float speedLimit;

    public Road(RoadTypes type, float length, float speedLimit, Location startLocation, Location endLocation) {
        this.type = type;
        this.length = length;
        this.speedLimit = speedLimit;
        this.start = startLocation;
        this.end = endLocation;
    }

    public boolean isValid() {
        float startX = this.start.getX();
        float startY = this.start.getY();
        float endX = this.end.getX();
        float endY = this.end.getY();
        double euclideanDistance = sqrt(pow(endX - startX, 2) + pow(endY - startY, 2));
        return (this.length > euclideanDistance);
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(float speedLimit) {
        this.speedLimit = speedLimit;
    }

    public Location getEnd() {
        return end;
    }

    public void setEnd(Location end) {
        this.end = end;
    }

    public Location getStart() {
        return start;
    }

    public void setStart(Location start) {
        this.start = start;
    }

    public RoadTypes getType() {
        return type;
    }

    public void setType(RoadTypes type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
