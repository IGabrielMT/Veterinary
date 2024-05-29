package co.edu.uptc.models;

import co.edu.uptc.interfaces.VetInterface;
import co.edu.uptc.pojos.Vaccine;
import co.edu.uptc.pojos.VetVisit;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Getter
@Setter
public class VetModel implements VetInterface.Model {
    private ArrayList<VetVisit> visits;
    private TreeSet<Vaccine> vaccines;
    private VetInterface.Presenter presenter;

    public VetModel(){
        visits = new ArrayList<>();
        vaccines = new TreeSet<>();
    }


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
    copyVisitsOrdered.sort(Comparator.comparing(v -> {
        long daysSinceVisit = ChronoUnit.DAYS.between(v.getDay(), LocalDate.now());
        long vaccineDueTime = v.getVaccineUsed().getDueTime().get(ChronoUnit.DAYS);
        return Math.abs(daysSinceVisit - vaccineDueTime);
    }));
    return copyVisitsOrdered;
}

@Override
public ArrayList<VetVisit> obtainVisitByLaterDueDate() {
    ArrayList<VetVisit> copyVisitsOrdered = new ArrayList<>(visits);
    copyVisitsOrdered.sort(Comparator.comparing(v -> {
        long daysSinceVisit = ChronoUnit.DAYS.between(v.getDay(), LocalDate.now());
        long vaccineDueTime = v.getVaccineUsed().getDueTime().get(ChronoUnit.DAYS);
        return Math.abs(daysSinceVisit - vaccineDueTime);
    }));
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

    @Override
    public void setPresenter(VetInterface.Presenter presenter) {
        this.presenter = presenter;
    }


}
