package compulsory;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * class Road - has a length, speed limit, a start and end of type location and a type of RoadType
 */
public class Road {
    private Location start;
    private Location end;
    private RoadType type;
    private float length;
    private float speedLimit;

    public Road(RoadType type, float length, float speedLimit, Location startLocation, Location endLocation) {
        this.type = type;
        this.length = length;
        this.speedLimit = speedLimit;
        this.start = startLocation;
        this.end = endLocation;
    }

    public boolean isValid() { // checks if the road length given is valid - the road length has to be bigger
        // than the euclidean distance between the start and end locations
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

    public RoadType getType() {
        return type;
    }

    public void setType(RoadType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
