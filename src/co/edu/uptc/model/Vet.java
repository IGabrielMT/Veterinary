package co.edu.uptc.model;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Vet {
    private ArrayList<VetVisit> visits;
    private TreeSet<Vaccine> vaccines;

    public void addVaccine(Vaccine vaccine){
        vaccines.add(vaccine);
    }
    public ArrayList<VetVisit> obtainVisitByCloseDueDate(){
        ArrayList<VetVisit> visitsOrdered = new ArrayList<>(List.of(Arrays.copyOf(visits.toArray(), visits.size(), VetVisit[].class)));
        visitsOrdered.sort(Comparator.comparing(o -> o.getVaccineUsed().getDueDate()));
        return visitsOrdered;
    }
}
