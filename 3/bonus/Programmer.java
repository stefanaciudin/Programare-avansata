package bonus;

import java.time.LocalDate;
/**
 * Class Programmer - extends class Person
 * and adds an extra property - programmingLanguage
 */
public class Programmer extends Person{
    private String programmingLanguage; // extra property

    public Programmer(int index, String name, LocalDate birthday, String location, String programmingLanguage) {
        super(index, name, birthday, location);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public Programmer(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }
}
