package bonus;

import java.util.Objects;

class Highway extends Road {
    private int lanes;

    public Highway(int lanes) {
        this.lanes = lanes;
    }

    public Highway(float length, float speedLimit, Location startLocation, Location endLocation, int lanes) {
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

    public Express(int carsPassing) {
        this.carsPassing = carsPassing;
    }

    public Express(float length, float speedLimit, Location startLocation, Location endLocation, int carsPassing) {
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

    public CountryRoad(String place) {
        this.place = place;
    }

    public CountryRoad(float length, float speedLimit, Location startLocation, Location endLocation, String place) {
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

