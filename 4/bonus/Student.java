

package bonus;
/**
 * Class Student - each student has a name and methods to get and set it.
 * The objects of this class are comparable.
 */

public class Student implements Comparable<Student> {
    private String name;


    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student student) {
        return this.name.compareTo(student.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}