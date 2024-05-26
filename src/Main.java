import co.edu.uptc.views.mainpage.MainPageFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(MainPageFrame::getInstance);
//        ArrayList<VetVisit> vetVisits = new ArrayList<>();
//        VetVisit vetVisit = new VetVisit();
//        Vaccine vaccine = new Vaccine();
//        vaccine.setName("Rabia");
//        vaccine.setDueDate(LocalDate.now());
//        vaccine.setPetType(PetType.DOG);
//        vetVisit.setVaccineUsed(vaccine);
//        Pet pet = new Pet();
//        pet.setName("Firulais");
//        pet.setPetType(PetType.DOG);
//        vetVisit.setPet(pet);
//        PetParent petParent = new PetParent();
//        petParent.setName("Juan");
//        petParent.setLastName("Perez");
//        petParent.setEmailAdress("juanperez@pok.com");
//        petParent.setPhoneNumber(1234567890);
//        vetVisit.setPetParent(petParent);
//        LocalDate date = LocalDate.of(2021, 10, 10);
//        vetVisit.setDay(date);
//        vetVisits.add(vetVisit);
//        JSONManager.createJSONFileByCollection("files/vetVisits.json", vetVisits);
//        String fileName = "files/vetVisits.json";
//        Class<?> clazz = VetVisit.class; // Reemplaza "TuClase" con el nombre de la clase de los objetos que están en el archivo JSON
//        Collection<?> collection = JSONManager.createCollectionByJSONFile(fileName, clazz);
//        assert collection != null;
//        for (Object object : collection) {
//            System.out.println(object);
//        }
//        Vaccine vaccine = new Vaccine();
//        vaccine.setName("Rabia");
//        vaccine.setDueDate(LocalDate.now());
//        vaccine.setPetType(PetType.DOG);
//        Vet vet = new Vet();
//        vet.addVaccine(vaccine);
//        JSONManager.createJSONFileByCollection("files/vaccines.json", vet.getVaccines());
    }
}
