package compulsory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person implements Node, Comparable<Person> {
    private String name;
    private List<Person> friends; //if two people know each-other, we suppose they are friends

    public Person(String name) {
        this.name = name;
        this.friends = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void addFriend(Person person) {
        if (!friends.contains(person)) {
            friends.add(person);
            person.friends.add(this); // they are each-other's friends
        }
        else
            System.out.println("Can't add " + person.getName() + "; it's already a friend of " + this.name);
    }

    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Person person) {
        return name.compareTo(person.name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", friends=" + friends +
                '}';
    }
}
