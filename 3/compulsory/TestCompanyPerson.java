package compulsory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class used to test Company, Person and Node.
 * Prints various objects of the classes and uses the methods implemented.
 */

public class TestCompanyPerson {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        Person one = new Person("one");
        Person two = new Person("two");
        Person three = new Person("three");
        Person four = new Person("four");

        Company c1 = new Company("Company one");
        Company c2 = new Company("Company two");

        one.addFriend(two);
        one.addFriend(two);
        two.addFriend(four);

        c1.addEmployee(one, "Programmer");
        c1.addEmployee(one, "Designer");
        c1.addEmployee(two, "Designer");
        c2.addEmployee(three, "Programmer");
        c2.addEmployee(four, "Manager");

        nodes.add(one);
        nodes.add(two);
        nodes.add(three);
        nodes.add(four);
        nodes.add(c1);
        nodes.add(c2);

        nodes.sort(new Comparator<Node>() { //sort the nodes lists
            @Override
            public int compare(Node node, Node t1) {
                return node.getName().compareTo(t1.getName());
            }
        });

        for (Node node : nodes) {
            System.out.println("Node name:" + node.getName() + ", node class: " + node.getClass());
        }


    }
}
