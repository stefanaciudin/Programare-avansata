package homework;

import java.util.Objects;

/**
 * This file contains the classes Highway, Express and CountryRoad that extend the class Road
 * each class has extra attributes
 * Highway has lanes, Express has carsPassing and CountryRoad has a String place
 */

class Highway extends Road {
    private int lanes;

    public Highway(int lanes) { // constructor for highways with only the number of lanes specified
        this.lanes = lanes;
    }

    public Highway(float length, float speedLimit, Location startLocation, Location endLocation, int lanes) { // constructor for all the attributes
        super(length, speedLimit, startLocation, endLocation);
        this.lanes = lanes;
    }

    public int getLanes() {
        return lanes;
    }

    public void setLanes(int lanes) {
        this.lanes = lanes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Highway highway = (Highway) o;
        return lanes == highway.lanes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), lanes);
    }
}

class Express extends Road {
    private int carsPassing;

    public Express(int carsPassing) {  // constructor for express roads with only carsPassing specified
        this.carsPassing = carsPassing;
    }

    public Express(float length, float speedLimit, Location startLocation, Location endLocation, int carsPassing) { // constructor for all the attributes
        super(length, speedLimit, startLocation, endLocation);
        this.carsPassing = carsPassing;
    }

    public int getCarsPassing() {
        return carsPassing;
    }

    public void setCarsPassing(int carsPassing) {
        this.carsPassing = carsPassing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Express express = (Express) o;
        return carsPassing == express.carsPassing;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), carsPassing);
    }
}

class CountryRoad extends Road {
    private String place;

    public CountryRoad(String place) { // constructor for country roads with only the place specified
        this.place = place;
    }

    public CountryRoad(float length, float speedLimit, Location startLocation, Location endLocation, String place) { // constructor for all the attributes
        super(length, speedLimit, startLocation, endLocation);
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CountryRoad that = (CountryRoad) o;
        return Objects.equals(place, that.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), place);
    }
}

