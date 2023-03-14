package bonus;

import java.util.*;

import static java.lang.Math.min;

/**
 * Class Network - represents People and Companies as nodes.
 * Has methods to check for a node's importance, to add a node
 * and to print a network in order of importance.
 */
public class Network {
    List<Node> nodes = new ArrayList<>(); //list of nodes in a network
    List<LinkedList<Integer>> adjList = new ArrayList<>(); //adjacency list of the network
    Set<Integer> cutPoints = new HashSet<>(); //used to store and print the cut-points
    //attributes used to check the nodes that are disconnecting the network
    private ArrayList<Boolean> visited = new ArrayList<>();
    private List<Integer> tin = new ArrayList<>();
    private List<Integer> low = new ArrayList<>();
    private int timer;

    public Network() {
    }

    public Network(List<LinkedList<Integer>> adjList) {
        this.adjList = adjList;
    }

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

    void dfs(int v, Integer p) { //dfs method used to check if a node is a cut-point or not
        //used the method provided in the lab slides
        if (p == null) {
            p = -1;
        }
        visited.set(v, true);
        timer++;
        tin.set(v, timer);
        low.set(v, timer);
        int children = 0;
        for (int to : adjList.get(v)) {
            if (to == p) continue;
            if (Boolean.TRUE.equals(visited.get(to))) {
                low.set(v, min(low.get(v), tin.get(to)));
            } else {
                dfs(to, v);
                low.set(v, min(low.get(v), low.get(to)));
                if (low.get(to) >= tin.get(v) && p != -1) {
                    cutPoints.add(v);
                }
                ++children;
            }
        }
        if (p == -1 && children > 1) {
            cutPoints.add(v);
        }
    }

    public void isDisconnectingNetwork() { //main method to check if a node is a cut-point or not
        timer = 0;
        tin = new ArrayList<>(Collections.nCopies(nodes.size() + 1, -1));
        low = new ArrayList<>(Collections.nCopies(nodes.size() + 1, -1));
        visited = new ArrayList<>(Collections.nCopies(nodes.size() + 1, false));
        for (int idx = 0; idx < nodes.size(); ++idx) {
            if (Boolean.FALSE.equals(visited.get(idx))) {
                dfs(idx, null);
            }
        }
    }

    public boolean isCutPoint(int v) {
        return cutPoints.contains(v);
    }

    @Override
    public String toString() {
        return "Network{" + "nodes=" + nodes + '}';
    }

}
