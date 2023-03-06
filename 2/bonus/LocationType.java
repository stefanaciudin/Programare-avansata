package bonus;

import java.util.Objects;

class City extends Location {
    private int population;

    public City(int population) {
        this.population = population;
    }

    public City(String name, float x, float y, int population) {
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

    public Airport(int terminals) {
        this.terminals = terminals;
    }

    public Airport(String name, float x, float y, int terminals) {
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

class GasStation extends Location{
    private int gasPrice;

    public GasStation(int gasPrice) {
        this.gasPrice = gasPrice;
    }

    public GasStation(String name, float x, float y, int gasPrice) {
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