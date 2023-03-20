package bonus;

import org.graph4j.*;
import org.graph4j.alg.matching.HopcroftKarpMaximumMatching;
import org.graph4j.util.EdgeSet;
import org.graph4j.util.Matching;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BonusProblemsV2 {
    public static void main(String[] args) {
        AllocationProblem pb = new AllocationProblem();
        List<Student> students;
        students = pb.generateStudents(5000);
        Map<Student, Set<Project>> preferences;
        preferences = pb.generatePreferences(students);
        getMatching(students, preferences);

    }

    private static void getMatching(List<Student> students, Map<Student, Set<Project>> preferences) { //can't get this to work :c
        Graph<Object, EdgeSet> g = GraphBuilder.numVertices(23456)
                .buildGraph();
        for (Student student : students)
            g.addVertex(student);
        List<Project> preferencesList = new ArrayList<>();
        for (Set<Project> projectSet : preferences.values()) {
            preferencesList.addAll(projectSet);
        }
        for (Project project : preferencesList)
            g.addVertex(project);

        for (Student student : students) { //adding the edges
            for (Project project : preferences.get(student)) {
                g.addEdge(student, project);
            }

        }
        HopcroftKarpMaximumMatching matcher = new HopcroftKarpMaximumMatching(g);
        Matching matching = matcher.getMatching();
        System.out.println(matching);
    }
}
