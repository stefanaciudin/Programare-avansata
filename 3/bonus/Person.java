package bonus;

import java.time.LocalDate;
import java.util.*;

/**
 * Class Person - implements class Node. Has a field for a person's name,
 * a person's birthday, a person's location and a map to store relationships
 * between nodes.
 * Has a method to add a relationship between two people.
 */

public class Person implements Node, Comparable<Person> {
    private int index;
    private String name;
    private LocalDate birthday;
    private String location;
    private Map<Node, String> relationships = new HashMap<>();

    public Person() {

    }

    public Person(int index, String name, LocalDate birthday, String location) {
        this.name = name;
        this.location = location;
        this.birthday = birthday;
        this.index = index;
    }

    public Person(String s) { //used for testing
        this.name = s;
    }

    public void addRelationship(Node node, String value) {
        if (!relationships.containsKey(node)) {
            relationships.put(node, value);
        }
    }

    //getters and setters

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Node, String> getRelationships() {
        return relationships;
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

    public int getIndex() {
        return this.index;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(location, person.location) && Objects.equals(relationships, person.relationships);
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
