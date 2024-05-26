package co.edu.uptc.pojos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Vaccine implements Comparable<Vaccine> {
    private String name;
    private LocalDate dueDate;
    private PetType petType;

    @Override
    public String toString() {
        return "Vaccine{" +
                "name='" + name + '\'' +
                ", dueDate=" + dueDate +
                ", petType=" + petType +
                '}';
    }

    @Override
    public int compareTo(Vaccine o) {
        return this.dueDate.compareTo(o.dueDate);
    }
}
