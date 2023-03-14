package homework;

import java.time.LocalDate;
import java.util.*;

/**
 * Class Person - implements class Node. Has a field for a person's name,
 * a person's birthday, a person's location and a map to store relationships
 * between nodes.
 * Has a method to add a relationship between two people.
 */

public class Person implements Node, Comparable<Person> {
    private String name; // name of the person
    private LocalDate birthday; // person's birthday
    private String location; // person's location
    private Map<Node, String> relationships = new HashMap<>(); // relationships map

    public Person() {

    }

    public Person(String name, LocalDate birthday, String location) {
        this.name = name;
        this.location = location;
        this.birthday = birthday;
    }

    public void addRelationship(Node node, String value) {
        if (!relationships.containsKey(node)) {
            relationships.put(node, value);
        }
    }

    // setters and getters
    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getImportance() {
        return relationships.size();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", relationships=" + relationships +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(location, person.location)
                && Objects.equals(relationships, person.relationships);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int compareTo(Person person) {
        return Integer.compare(person.getImportance(), this.getImportance());
    }
}
