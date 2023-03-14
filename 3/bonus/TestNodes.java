package bonus;

import java.time.LocalDate;
import java.util.LinkedList;


/**
 * Class used to test Company, Person and Node.
 * Prints various objects of the classes and uses the methods implemented.
 */

public class TestNodes {

    public static void main(String[] args) {
        Person person1 = new Person(1, "Person1", LocalDate.of(1999, 12, 13), "Romania");
        Person person2 = new Person(2, "Person2", LocalDate.of(1964, 2, 4), "Italy");
        Person person3 = new Person(3, "Person3", LocalDate.of(1989, 7, 16), "Romania");
        Person person4 = new Person(4, "Person4", LocalDate.of(1970, 1, 1), "Spain");
        Programmer programmer1 = new Programmer(5, "Programmer1", LocalDate.of(2000, 2, 2), "Tenerife", "C++");
        Designer designer1 = new Designer(6, "Designer1", LocalDate.of(1989, 3, 4), "Italy", "web");

        Company c1 = new Company(7, "Company1");
        Company c2 = new Company(8, "Company2");

        //adding employees
        c1.addEmployee(person1, "Programmer");
        c1.addEmployee(programmer1, "Intern");
        c1.addEmployee(designer1, "Designer");
        c1.addEmployee(person3, "CEO entrepreneur");
        c2.addEmployee(person2, "CEO");
        c2.addEmployee(person4, "Manager");
        //and relationships
        person1.addRelationship(person3, "marriage");
        person1.addRelationship(person2, "friendship");
        person3.addRelationship(person1, "marriage");
        //creating the network
        Network network = new Network();
        network.addNode(person1);
        network.addNode(person2);
        network.addNode(person3);
        network.addNode(person4);
        network.addNode(programmer1);
        network.addNode(designer1);
        network.addNode(c1);
        network.addNode(c2);

        network.printNetwork(); // print network in order of importance

        //creating the adjacency list for the graph
        for (int idx = 0; idx <= network.nodes.size(); idx++) {
            network.adjList.add(new LinkedList<>());
        }

        //adding the nodes in the list
        network.adjList.get(1).add(2);
        network.adjList.get(1).add(3);
        network.adjList.get(1).add(7);

        network.adjList.get(2).add(8);

        network.adjList.get(3).add(7);

        network.adjList.get(4).add(8);

        network.adjList.get(5).add(7);
        network.adjList.get(6).add(7);

        network.adjList.get(7).add(1);
        network.adjList.get(7).add(3);
        network.adjList.get(7).add(5);
        network.adjList.get(7).add(6);

        network.adjList.get(8).add(4);
        network.isDisconnectingNetwork(); //checking to see the nodes that are disconnecting the network
        System.out.println("The cutpoints in the given network are: ");
        for (var cutpoint : network.cutPoints)
            System.out.println(cutpoint);


    }

}
