package homework;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.github.javafaker.Faker;

/**
 * Class AllocationProblem - used to solve the problem of allocating
 * each student a project from their list of preferences.
 */

public class AllocationProblem {
    private static Map<Student, Set<Project>> preferences;
    private static List<Student> students;

    public static void main(String[] args) {

        AllocationProblem pb = new AllocationProblem();
        students = pb.generateStudents(80);
        preferences = pb.generatePreferences(students);
        System.out.println("Student preferences: " + preferences);
        pb.printStudents();// print students that have a number of preferences lower than the average number of preferences
        Map<Student, Project> algorithmResult;
        algorithmResult = findMatchGreedy();
        System.out.println("Project matching: " + algorithmResult);
    }

    private static Map<Student, Project> findMatchGreedy() {
        Map<Student, Project> matches = new HashMap<>();
        Set<Project> assignedProjects = new HashSet<>(); // used to keep track of the projects we already assigned
        for (Map.Entry<Student, Set<Project>> entry : preferences.entrySet()) {
            Student student = entry.getKey(); // for each student in the map
            for (Project project : entry.getValue()) { // we get its projects in order
                if (!assignedProjects.contains(project)) { // and assign the first one that wasn't already assigned to someone else
                    matches.put(student, project);
                    assignedProjects.add(project);
                    break;
                }
            }

        }
        if (matches.size() != preferences.size()) //there wasn't a matching found
            matches.clear();
        return matches;
    }

    private void printStudents() {
        double avgNumPreferences = students.stream()
                .mapToInt(student -> preferences.get(student).size())
                .average()
                .orElse(0.0);
        List<Student> studentsWithFewerPreferences = students.stream()
                .filter(student -> preferences.get(student).size() < avgNumPreferences)
                .toList();
        System.out.println("\nStudents with Fewer Preferences than Average:");
        for (Student studentFewerPrefs : studentsWithFewerPreferences)
            System.out.println(studentFewerPrefs);

    }

    private List<Student> generateStudents(int nrStudents) {
        Faker faker = new Faker();
        var studs = IntStream.range(0, nrStudents)
                .mapToObj(i -> new Student(faker.name().fullName()))
                .toArray(Student[]::new);
        return Arrays.asList(studs);
    }

    Map<Student, Set<Project>> generatePreferences(List<Student> students) {
        List<Project> projects = new ArrayList<>();
        Map<Student, Set<Project>> preferences = new HashMap<>();
        int requiredSize = students.size() * 3; //the total size of projects generated
        var projs = IntStream.rangeClosed(0, requiredSize).mapToObj(i -> new Project("P" + i)).toArray(Project[]::new); //create projects
        projects.addAll(Arrays.asList(projs));
        for (Student stud : students) { //for each student
            Random rand = new Random();
            int rValue = rand.nextInt(students.size());
            //we assign a random number of projects, and we pick randomly which ones they would prefer to pick from
            Set<Project> preferencesList = IntStream.rangeClosed(0, rValue)
                    .mapToObj(i -> projects.get(rand.nextInt(requiredSize)))
                    .collect(Collectors.toSet());

            preferences.put(stud, preferencesList);
        }
        return preferences;
    }
}
