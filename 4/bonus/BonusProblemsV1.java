package bonus;

import org.jgrapht.Graph;
import org.jgrapht.alg.interfaces.MatchingAlgorithm;
import org.jgrapht.alg.matching.DenseEdmondsMaximumCardinalityMatching;
import org.jgrapht.alg.vertexcover.GreedyVCImpl;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.*;

/**
 * Class used to solve the matching problem, minimumVertexCover and maximumIndependentSet
 * using algorithms from JGraphT
 */
public class BonusProblemsV1 {
    private static Runtime runtime;
    private static long usedMemoryBefore;
    private static long initialTime;

    public static void main(String[] args) {
        AllocationProblem pb = new AllocationProblem();
        List<Student> students;
        students = pb.generateStudents(50); //generating an instance of 5000 students
        Map<Student, Set<Project>> preferences;
        preferences = pb.generatePreferences(students);
        setInitialInfo();
        pb.findMatchGreedy(preferences);
        System.out.println("Greedy algorithm: ");
        getAfterInfo();

        Graph<Object, DefaultEdge> graph = buildGraph(students, preferences);
        setInitialInfo();
        getMatching(graph);
        System.out.println("Fancy JGraphT algorithm: ");
        getAfterInfo(); //works slower than the greedy algorithm implemented
        detVertexCoverIndependentSet(graph);
    }

    private static Graph<Object, DefaultEdge> buildGraph(List<Student> students, Map<Student, Set<Project>> preferences) {
        Graph<Object, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
        //building the graph
        for (Student student : students)
            graph.addVertex(student); // adding the students as vertices
        List<Project> preferencesList = new ArrayList<>();
        for (Set<Project> projectSet : preferences.values()) {
            preferencesList.addAll(projectSet);
        }
        for (Project project : preferencesList)
            graph.addVertex(project); // adding the projects as vertices

        for (Student student : students) { //adding the edges
            for (Project project : preferences.get(student)) {
                graph.addEdge(student, project);
            }
        }
        return graph;

    }

    private static void getMatching(Graph<Object, DefaultEdge> graph) { // implements the matching problem
        MatchingAlgorithm<Object, DefaultEdge> matcher = new DenseEdmondsMaximumCardinalityMatching<>(graph);
        MatchingAlgorithm.Matching<Object, DefaultEdge> matching = matcher.getMatching();
        System.out.println("Matching: " + matching);

    }

    private static void detVertexCoverIndependentSet(Graph<Object, DefaultEdge> graph) { //method used to solve the last two requirements
        //we determine the minimum vertex cover first
        GreedyVCImpl<Object, DefaultEdge> vc = new GreedyVCImpl<>(graph);
        Set<Object> cover = vc.getVertexCover();
        System.out.println("Minimum vertex cover: " + cover);
        //then the maximum independent set - this is represented by the maximum vertex cover from the compliment graph
        Set<Object> vertices = graph.vertexSet();
        Set<Object> difference = new HashSet<>(vertices);
        difference.removeAll(cover);
        System.out.println("Maximum independent set: " + difference);

    }

    // methods used to measure the performance of the matching algorithms
    private static void setInitialInfo() {
        runtime = Runtime.getRuntime();
        usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        initialTime = System.currentTimeMillis();
    }

    private static void getAfterInfo() {
        long runningTime;
        long usedMemoryAfter;
        long memoryIncrease;
        runningTime = System.currentTimeMillis() - initialTime;
        usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        memoryIncrease = usedMemoryAfter - usedMemoryBefore;
        System.out.println("Running time: " + runningTime + ", memory increase: " + memoryIncrease);
    }
}
