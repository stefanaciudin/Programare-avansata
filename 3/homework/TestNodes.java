package homework;

import java.time.LocalDate;

/**
 * Class used to test Company, Person and Node.
 * Prints various objects of the classes and uses the methods implemented.
 */

public class TestNodes {
    public static void main(String[] args) {
        // creating persons
        Person person1 = new Person("Person1", LocalDate.of(1999, 12, 13), "Romania");
        Person person2 = new Person("Person2", LocalDate.of(1964, 2, 4), "Italy");
        Person person3 = new Person("Person3", LocalDate.of(1989, 7, 16), "Romania");
        Person person4 = new Person("Person4", LocalDate.of(1970, 1, 1), "Spain");
        // creating programmer and designers
        Programmer programmer1 = new Programmer("Programmer1", LocalDate.of(2000, 2, 2), "Tenerife", "C++");
        Designer designer1 = new Designer("Designer1", LocalDate.of(1989, 3, 4), "Italy", "web");
        // creating companies
        Company c1 = new Company("Company1");
        Company c2 = new Company("Company2");
        // adding employees - company1 has 4
        c1.addEmployee(person1, "Programmer");
        c1.addEmployee(programmer1, "Intern");
        c1.addEmployee(designer1, "Designer");
        c1.addEmployee(person3, "CEO entrepreneur");
        //company2 has only 2 employees
        c2.addEmployee(person2, "CEO");
        c2.addEmployee(person4, "Manager");
        // adding relationships - person1 has 3: one with company1 and 2 with other people.
        person1.addRelationship(person3, "marriage");
        person1.addRelationship(person2, "friendship");
        // adding nodes to the network
        Network network = new Network();
        network.addNode(person1);
        network.addNode(person2);
        network.addNode(person3);
        network.addNode(person4);
        network.addNode(c1);
        network.addNode(c2);
        // print nodes in the network in order of their importance
        network.printNetwork();
    }
}
