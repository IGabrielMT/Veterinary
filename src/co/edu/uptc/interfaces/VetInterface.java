package co.edu.uptc.interfaces;

import co.edu.uptc.pojos.Vaccine;
import co.edu.uptc.pojos.VetVisit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;

public interface VetInterface {
    interface Model {
        void addVaccine(Vaccine vaccine);
        void addVisit(VetVisit visit);
        ArrayList<VetVisit> obtainVisitByCloseDueDate();
        ArrayList<VetVisit> obtainVisitByLaterDueDate();
        ArrayList<VetVisit> obtainVisitByPetParentPhoneNumber(Long phoneNumber);
        ArrayList<VetVisit> obtainVisitByDate(LocalDate date);
        ArrayList<VetVisit> getVisits();
        TreeSet<Vaccine> getVaccines();
    }

    interface View {
        interface Tables{
            void setData();
        }
        String[] returnData();
    }


    interface Presenter {
        void addVaccine(String[] vaccine);
        void addVisit(String[] visit);
        String[] obtainVaccinesName();
        Vaccine obtainVaccineByName(String vaccineName);
        Object[][] obtainVisits();
        Object[][] obtainVisitsByCloseDueDate();
        Object[][] obtainVisitsByPetParentPhoneNumber(Long phoneNumber);
        Object[][] obtainVisitsByDate(Date date);
        Object[][] obtainVisitsByLaterDueDate();
        void saveData();
        String[] obtainPetTypes();
        void getDataAndSetData();
    }
}