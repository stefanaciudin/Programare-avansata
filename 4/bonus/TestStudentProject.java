package bonus;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Class to test objects of classes Project and Student
 */

public class TestStudentProject {
    public static void main(String[] args) {
        List<Student> listOfStudents = new ArrayList<>();
        var students = IntStream.rangeClosed(0, 2).mapToObj(i -> new Student("S" + i)).toArray(Student[]::new); //create students
        listOfStudents.addAll(Arrays.asList(students)); //add them to the students list

        TreeSet<Project> treeOfProjects = new TreeSet<>();
        var projects = IntStream.rangeClosed(0, 2).mapToObj(i -> new Project("P" + i)).toArray(Project[]::new); //create projects
        treeOfProjects.addAll(Arrays.asList(projects));//add them to the projects list

        Collections.sort(listOfStudents, Comparator.comparing(Student::getName)); //sort the students
        System.out.println("Sorted students: " + listOfStudents);
        System.out.println("Sorted projects: " + treeOfProjects); //projects are already sorted


    }
}