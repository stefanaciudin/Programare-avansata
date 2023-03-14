package bonus;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for the cut-point algorithm implemented in the Network class
 * Implements the same test from TestNodes.java
 */
class NetworkTest {

    @Test
    void isDisconnectingNetwork() {
        List<LinkedList<Integer>> graph = new ArrayList<>(); //creating the graph
        for (int idx = 0; idx <= 8; idx++) {
            graph.add(new LinkedList<>());
        }
        //adding the adjacency list
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(7);

        graph.get(2).add(8);

        graph.get(3).add(7);

        graph.get(4).add(8);

        graph.get(5).add(7);
        graph.get(6).add(7);

        graph.get(7).add(1);
        graph.get(7).add(3);
        graph.get(7).add(5);
        graph.get(7).add(6);

        graph.get(8).add(4);
        var nodes = IntStream.rangeClosed(0, 7).mapToObj(i -> new Person("P" + i)).toArray(Person[]::new); //create nodes
        Network dn = new Network(graph);
        dn.nodes.addAll(Arrays.asList(nodes)); //add the nodes to the dn network
        dn.isDisconnectingNetwork();

        // cut-points: 1, 2 7 and 8
        assertTrue(dn.isCutPoint(1));
        assertTrue(dn.isCutPoint(2));
        assertTrue(dn.isCutPoint(7));
        assertTrue(dn.isCutPoint(8));
        assertFalse(dn.isCutPoint(3));
        assertFalse(dn.isCutPoint(4));
        assertFalse(dn.isCutPoint(5));
        assertFalse(dn.isCutPoint(6));

    }
}