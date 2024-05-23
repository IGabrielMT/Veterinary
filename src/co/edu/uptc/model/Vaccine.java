package co.edu.uptc.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
public class Vaccine {
    private String name;
    private LocalDate dueDate;
    private PetType petType;
}
