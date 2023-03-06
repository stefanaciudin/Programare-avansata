package homework;

import java.util.Objects;

/**
 * This file contains the classes City, Airport and GasStation that extend the class Location
 * each class has extra attributes
 * City has population, Airport terminals and GasStation has gasPrice
 */
class City extends Location {
    private int population;

    public City(int population) { // constructor for cities with only the population specified
        this.population = population;
    }

    public City(String name, float x, float y, int population) { // constructor for all the attributes
        super(name, x, y);
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        City city = (City) o;
        return population == city.population;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), population);
    }
}

class Airport extends Location {
    private int terminals;

    public Airport(int terminals) { // constructor for airports with only the number of terminals specified
        this.terminals = terminals;
    }

    public Airport(String name, float x, float y, int terminals) { // constructor for all the attributes
        super(name, x, y);
        this.terminals = terminals;
    }

    public int getTerminals() {
        return terminals;
    }

    public void setTerminals(int terminals) {
        this.terminals = terminals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Airport airport = (Airport) o;
        return terminals == airport.terminals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), terminals);
    }
}

class GasStation extends Location {
    private int gasPrice;

    public GasStation(int gasPrice) { // constructor for GasStations with only the gasPrice specified
        this.gasPrice = gasPrice;
    }

    public GasStation(String name, float x, float y, int gasPrice) { // constructor for GasStations with all the attributes specified
        super(name, x, y);
        this.gasPrice = gasPrice;
    }

    public int getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(int gasPrice) {
        this.gasPrice = gasPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GasStation that = (GasStation) o;
        return gasPrice == that.gasPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gasPrice);
    }
}