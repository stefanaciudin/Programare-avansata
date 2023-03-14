package homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * class Network - has a List of nodes
 * and methods to compute a node's importance, print the network and add a node
 * to a specific network
 */
public class Network {
    private List<Node> nodes = new ArrayList<>();

    public int computeImportance(Node n) {
        return n.getImportance();
    }

    public void addNode(Node node) {
        this.nodes.add(node);
    }

    public void printNetwork() { //sorts the nodes, then prints them by importance
        nodes.sort(Comparator.comparing(Node::getImportance).reversed());
        for (Node node : nodes) {
            System.out.println(node.getName() + " - " + node.getImportance());
        }
    }

    @Override
    public String toString() {
        return "Network{" +
                "nodes=" + nodes +
                '}';
    }

}
