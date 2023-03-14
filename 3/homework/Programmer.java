package homework;

import java.time.LocalDate;
import java.util.Objects;

/**
 * class Programmer - inherits from class Person
 * and has an extra property
 */
public class Programmer extends Person{
    private String programmingLanguage; // specific property of the class

    public Programmer(String name, LocalDate birthday, String location, String programmingLanguage) {
        super(name, birthday, location);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public Programmer(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Programmer that = (Programmer) o;
        return Objects.equals(programmingLanguage, that.programmingLanguage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), programmingLanguage);
    }
}
