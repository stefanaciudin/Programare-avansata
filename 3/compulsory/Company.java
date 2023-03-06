package compulsory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Class company - has a field name and a map named employees, which stores the employees that work
 * for that company and their position.
 * The function addEmployee adds an employee and its position for a given company.
 * getPosition, getName - return the position of a person and its name.
 */

public class Company implements Node, Comparable<Company> {
    private String name;
    private Map<Person, String> employees; // if a person works for that company, what is their position?

    public Company(String name) {
        this.name = name;
        this.employees = new HashMap<>();
    }

    public void addEmployee(Person person, String position) {
        if (!employees.containsKey(person))// if the person isn't already employed at the company
            employees.put(person, position);
        else
            System.out.println("Can't add " + person.getName() + "; it's already an employer of " + name);

    }

    public String getPosition(Person person) {
        return employees.get(person);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name) && Objects.equals(employees, company.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, employees);
    }

    @Override
    public int compareTo(Company company) {
        return name.compareTo(company.name);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
