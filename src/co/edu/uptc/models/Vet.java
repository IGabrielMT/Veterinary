package co.edu.uptc.models;

import co.edu.uptc.interfaces.VetInterface;
import co.edu.uptc.pojos.Vaccine;
import co.edu.uptc.pojos.VetVisit;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
public class Vet implements VetInterface.Model {
    private ArrayList<VetVisit> visits;
    private TreeSet<Vaccine> vaccines;


    @Override
    public void addVaccine(Vaccine vaccine) {
        if (vaccine != null) {
            vaccines.add(vaccine);
        }
    }

    @Override
    public void addVisit(VetVisit visit) {
        if (visit != null) {
            visits.add(visit);
        }
    }

    @Override
    public ArrayList<VetVisit> obtainVisitByCloseDueDate() {
    ArrayList<VetVisit> copyVisitsOrdered = new ArrayList<>(List.of(Arrays.copyOf(visits.toArray(), visits.size(), VetVisit[].class)));
    copyVisitsOrdered.sort(Comparator.comparing(v -> v.getVaccineUsed().getDueDate()));
    return copyVisitsOrdered;
    }

    @Override
    public ArrayList<VetVisit> obtainVisitByLaterDueDate() {
        ArrayList<VetVisit> copyVisitsOrdered = new ArrayList<>(visits);
        copyVisitsOrdered.sort(Comparator.comparing(v -> v.getVaccineUsed().getDueDate()));
        Collections.reverse(copyVisitsOrdered);
        return copyVisitsOrdered;
    }

    @Override
    public ArrayList<VetVisit> obtainVisitByPetParentPhoneNumber(Long phoneNumber) {
        ArrayList<VetVisit> visitsByPhoneNumber = new ArrayList<>();
        for (VetVisit visit : visits) {
            if (visit.getPetParent().getPhoneNumber().equals(phoneNumber)) {
                visitsByPhoneNumber.add(visit);
            }
        }
        return visitsByPhoneNumber;
    }

    @Override
    public ArrayList<VetVisit> obtainVisitByDate(LocalDate date) {
        ArrayList<VetVisit> visitsByDate = new ArrayList<>();
        for (VetVisit visit : visits) {
            if (visit.getDay().equals(date)) {
                visitsByDate.add(visit);
            }
        }
        return visitsByDate;
    }


}
