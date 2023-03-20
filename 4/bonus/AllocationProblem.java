package bonus;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.github.javafaker.Faker;

/**
 * Class used to solve the allocation problem - each student has to get
 * a project from their preferences list, or not if it isn't possible
 */

public class AllocationProblem {
    private static Map<Student, Set<Project>> preferences;
    private static List<Student> students;

    public AllocationProblem(Map<Student, Set<Project>> preferences,List<Student> students) { //non-default constructor I used for the solution
        AllocationProblem.preferences =preferences;
        AllocationProblem.students =students;

    }

    public AllocationProblem() {
    }

    public static void main(String[] args) {

        AllocationProblem pb = new AllocationProblem();
        students = pb.generateStudents(80);
        preferences = pb.generatePreferences(students);
        System.out.println("Student preferences: " + preferences);
        pb.printStudents();// print students that have a number of preferences lower than the average number of preferences
        pb.findMatchGreedy(preferences);
    }

     void findMatchGreedy(Map<Student, Set<Project>> preferences) {
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
         System.out.println("Project matching: " + matches);
    }

    public static List<Student> getStudents() {
        return students;
    }

    public static Map<Student, Set<Project>> getPreferences() {
        return preferences;
    }

    private void printStudents() {
        double avgNumPreferences = students.stream().mapToInt(student -> preferences.get(student).size()).average().orElse(0.0);
        List<Student> studentsWithFewerPreferences = students.stream().filter(student -> preferences.get(student).size() < avgNumPreferences).toList();
        System.out.println("\nStudents with Fewer Preferences than Average:");
        for (Student studentFewerPrefs : studentsWithFewerPreferences)
            System.out.println(studentFewerPrefs);

    }

    List<Student> generateStudents(int nrStudents) {
        Faker faker = new Faker();
        var studs = IntStream.range(0, nrStudents).mapToObj(i -> new Student(faker.name().fullName())).toArray(Student[]::new);
        return Arrays.asList(studs);
    }

    Map<Student, Set<Project>> generatePreferences(List<Student> students) {
        List<Project> projects = new ArrayList<>();
        Map<Student, Set<Project>> preferences = new HashMap<>();
        int requiredSize = students.size() * 2; //the total size of projects generated
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

    //Another method I found for generating projects for students - didn't use this one in the example because it's a bit unrealistic
    // but still gives interesting results, so I kept it for future reference :)

//    Map<Student, Set<Project>> generatePreferences(List<Student> students) {
//        Map<Student, Set<Project>> preferences = new HashMap<>();
//
//        // first generating a set of common projects
//        Set<Project> commonProjects = new HashSet<>();
//        Random firstRandom = new Random();
//        int projectSize = students.size() / 4 * firstRandom.nextInt(2, 5);
//        Set<Integer> chosenIndices = new HashSet<>();
//        while (commonProjects.size() != projectSize) {
//            Random random = new Random();
//            int index = random.nextInt(1, projectSize);
//            if (!chosenIndices.contains(index)) { // we check to see if the index was already added
//                commonProjects.add(new Project("P" + index)); // if it wasn't, we add it to prefs
//                chosenIndices.add(index); // and to the index set
//            } else { //if one of the common indexes was added, we add new values to complete
//                int newValueOfIndex = students.size() / 2 * random.nextInt(10, 20);
//                if (!chosenIndices.contains(newValueOfIndex)) {// of course, we don't add any of the values twice :)
//                    commonProjects.add(new Project("P" + newValueOfIndex));
//                    chosenIndices.add(newValueOfIndex);
//                }
//            }
//        }
//
//        //assign common projects to half of the students
//        List<Student> commonStudents = students.subList(0, students.size() / 2);
//        for (Student student : commonStudents) {
//            preferences.put(student, new HashSet<>(commonProjects));
//        }
//        //assign random project to the other half of the students
//        List<Student> remainingStudents = students.subList(students.size() / 2, students.size());
//        for (Student student : remainingStudents) {
//            int numPrefs = (int) (Math.random() * 3) + 1;
//            Set<Project> prefs = new HashSet<>();
//            chosenIndices = new HashSet<>();
//            while (prefs.size() < numPrefs) {
//                Random random = new Random();
//                int index = students.size() / 2 * random.nextInt(20, 30); //new values for the index, that we can't find in the first half
//                if (!chosenIndices.contains(index)) { // we check to see if the index was already added
//                    prefs.add(new Project("P" + index)); // if it wasn't, we add it to prefs
//                    chosenIndices.add(index); // and to the index vector
//                }
//            }
//            preferences.put(student, prefs);
//        }
//
//        return preferences;
//    }
}
