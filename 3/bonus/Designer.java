package bonus;

import java.time.LocalDate;

/**
 * Class Designer - extends class Person
 * and adds an extra property - specialization
 */
public class Designer extends Person{
    private String specialization; // extra property

    public Designer(String specialization) {
        this.specialization = specialization;
    }

    public Designer(int index, String name, LocalDate birthday, String location, String specialization) {
        super(index, name, birthday, location);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }
}
