package co.edu.uptc.pojos;

import lombok.Getter;
import lombok.Setter;

import java.time.Period;

@Setter
@Getter
public class Vaccine implements Comparable<Vaccine> {
    private String name;
    private Period dueTime;
    private PetType petType;

    @Override
    public String toString() {
        return "Vaccine{" +
                "name='" + name + '\'' +
                ", dueDate=" + dueTime +
                ", petType=" + petType +
                '}';
    }

    @Override
    public int compareTo(Vaccine o) {
        return Integer.compare(this.dueTime.getDays(), o.dueTime.getDays());
    }
}
