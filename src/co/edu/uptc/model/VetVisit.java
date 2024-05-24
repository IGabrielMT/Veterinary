package co.edu.uptc.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VetVisit {
    private PetParent petParent;
    private Pet pet;
    private Vaccine vaccineUsed;
    private LocalDate day;
}
