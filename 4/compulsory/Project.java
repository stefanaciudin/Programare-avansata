package compulsory;

/**
 * Class Project - each project has a name and functions to set and get its name.
 * The objects of this class are comparable.
 */
public class Project implements Comparable<Project> {

    private String name;

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Project project) {
        return this.name.compareTo(project.name);
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                '}';
    }
}
