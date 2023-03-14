package homework;

import java.time.LocalDate;
import java.util.Objects;

/**
 * class Designer - inherits from class Person and adds
 * a String for specialization
 */
public class Designer extends Person{
    private String specialization; // extra property

    public Designer(String specialization) {
        this.specialization = specialization;
    }

    public Designer(String name, LocalDate birthday, String location, String specialization) {
        super(name, birthday, location);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Designer designer = (Designer) o;
        return Objects.equals(specialization, designer.specialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), specialization);
    }
}
