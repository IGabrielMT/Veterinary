package co.edu.uptc.presenters;

import co.edu.uptc.interfaces.VetInterface;
import co.edu.uptc.models.Vet;
import co.edu.uptc.models.assets.JSONManager;
import co.edu.uptc.pojos.*;
import co.edu.uptc.views.ThrowMessage;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PresenterVet implements VetInterface.Presenter {
    private final Vet vet;

    public PresenterVet() {
        vet = new Vet();
        getDataAndSetData();
    }

    @Override
    public void addVaccine(String[] vaccine) {
        Vaccine vaccine1 = new Vaccine();
        vaccine1.setName(vaccine[0]);
        vaccine1.setDueDate(LocalDate.parse(vaccine[1]));
        vaccine1.setPetType(PetType.fromDisplayName(vaccine[2]));
        vet.addVaccine(vaccine1);
        saveData();
    }

    @Override
    public void addVisit(String[] visit) {
        VetVisit vetVisit = createVetVisit(visit);
        vet.addVisit(vetVisit);
        saveData();
    }

    private VetVisit createVetVisit(String[] visit) {
        VetVisit vetVisit = new VetVisit();
        Pet pet = createPet(visit);
        PetParent petParent = createPetParent(visit);
        Vaccine vaccine = obtainVaccineByName(visit[4]);
        if (!pet.getPetType().equals(vaccine.getPetType())) {
            ThrowMessage.throwMessageDialog(
                    "El tipo de vacuna debe ser el mismo que el tipo de mascota\n" +
                            "Tipo de vacuna: " + vaccine.getPetType().getDisplayName() +
                            "\nTipo de mascota: " + pet.getPetType().getDisplayName(),
                    "Error", JOptionPane.ERROR_MESSAGE
            );
            throw new IllegalArgumentException("El tipo de vacuna debe ser el mismo que el tipo de mascota");
        }
        vetVisit.setNumVaccinesUsed(Integer.parseInt(visit[1]));
        vetVisit.setDay(parseVisitDate(visit[5], vaccine));
        vetVisit.setPet(pet);
        vetVisit.setPetParent(petParent);
        vetVisit.setVaccineUsed(vaccine);
        return vetVisit;
    }

    private Pet createPet(String[] visit) {
        Pet pet = new Pet();
        pet.setName(visit[0]);
        pet.setPetType(PetType.fromDisplayName(visit[2]));
        return pet;
    }

    private PetParent createPetParent(String[] visit) {
        PetParent petParent = new PetParent();
        petParent.setName(visit[3]);
        petParent.setPhoneNumber(Long.parseLong(visit[6]));
        petParent.setEmailAdress(visit[7]);
        petParent.setLastName(visit[8]);
        return petParent;
    }

    private LocalDate parseVisitDate(String visitDateStr, Vaccine vaccine) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        LocalDate visitDate = LocalDate.parse(visitDateStr, formatter);
        if (visitDate.isAfter(vaccine.getDueDate())) {
            ThrowMessage.throwMessageDialog(
                    "La fecha de la visita no puede ser después de la fecha de vencimiento de la vacuna\n"
                            + "Fecha de la cita: " + visitDate +
                            "\nFecha de vencimiento de la vacuna: " +
                            vaccine.getDueDate().toString(), "Error", JOptionPane.ERROR_MESSAGE
            );
            throw new IllegalArgumentException(
                    "La fecha de la visita no puede ser después de la fecha de vencimiento de la vacuna"
            );
        }
        return visitDate;
    }

    @Override
    public String[] obtainVaccinesName(){
        TreeSet<Vaccine> vaccines = vet.getVaccines();
        String[] vaccinesArray = new String[vaccines.size()];
        int i = 0;
        for (Vaccine vaccine : vaccines) {
            vaccinesArray[i] = vaccine.getName();
            i++;
        }
        return vaccinesArray;
    }

    @Override
    public Vaccine obtainVaccineByName(String vaccineName){
        TreeSet<Vaccine> vaccines = vet.getVaccines();
        for (Vaccine vaccine : vaccines) {
            if (vaccine.getName().equals(vaccineName)) {
                return vaccine;
            }
        }
        return null;
    }

    @Override
    public Object[][] obtainVisits() {
        return transformToMatrix(vet.getVisits());
    }

    @Override
    public Object[][] obtainVisitsByCloseDueDate() {
        return transformToMatrix(vet.obtainVisitByCloseDueDate());
    }

    @Override
    public Object[][] obtainVisitsByPetParentPhoneNumber(Long phoneNumber) {
        return transformToMatrix(vet.obtainVisitByPetParentPhoneNumber(phoneNumber));
    }

    @Override
    public Object[][] obtainVisitsByDate(Date date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        return transformToMatrix(vet.obtainVisitByDate(LocalDate.parse(date.toString(), formatter)));
    }

    @Override
    public Object[][] obtainVisitsByLaterDueDate(){
        return transformToMatrix(vet.obtainVisitByLaterDueDate());
    }

    @Override
    public void saveData() {
        JSONManager.createJSONFileByCollection("files/vetVisits.json", vet.getVisits());
        JSONManager.createJSONFileByCollection("files/vaccines.json", vet.getVaccines());
    }

    @Override
    public String[] obtainPetTypes(){
        return new String[]{PetType.DOG.getDisplayName(), PetType.CAT.getDisplayName()};
    }

    @Override
    public void getDataAndSetData() {
        Collection<?> collection = JSONManager.createCollectionByJSONFile("files/vetVisits.json", VetVisit.class);
        assert collection != null;
        vet.setVisits(new ArrayList<>(List.of(Arrays.copyOf(collection.toArray(), collection.size(), VetVisit[].class))));
        Collection<?> collectionVaccines = JSONManager.createCollectionByJSONFile("files/vaccines.json", Vaccine.class);
        assert collectionVaccines != null;
        vet.setVaccines(new TreeSet<>(List.of(Arrays.copyOf(collectionVaccines.toArray(), collectionVaccines.size(), Vaccine[].class))));
    }

    private Object[][] transformToMatrix(ArrayList<VetVisit> visits) {
        Object[][] data = new Object[visits.size()][10];
        for (int i = 0; i < visits.size(); i++) {
            data[i] = fillRow(visits.get(i));
        }
        return data;
    }

    private Object[] fillRow(VetVisit visit) {
        Object[] row = new Object[10];
        row[0] = visit.getPetParent().getName();
        row[1] = visit.getPetParent().getLastName();
        row[2] = visit.getPetParent().getEmailAdress();
        row[3] = visit.getPetParent().getPhoneNumber();
        row[4] = visit.getPet().getName();
        row[5] = visit.getPet().getPetType().getDisplayName();
        row[6] = visit.getNumVaccinesUsed();
        row[7] = getVaccineName(visit);
        row[8] = visit.getDay();
        row[9] = getVaccineDueDate(visit);
        return row;
    }

    private String getVaccineName(VetVisit visit) {
        return visit.getVaccineUsed() != null ? visit.getVaccineUsed().getName() : "No vaccine";
    }

    private Object getVaccineDueDate(VetVisit visit) {
        return visit.getVaccineUsed() != null ? visit.getVaccineUsed().getDueDate() : "No vaccine";
    }
}
