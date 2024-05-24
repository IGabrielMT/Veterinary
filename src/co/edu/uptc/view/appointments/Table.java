package co.edu.uptc.view.appointments;

import lombok.Getter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

@Getter
public class Table {
    private JTable table;

    public Table() {
        createTable();
    }
    private void createTable() {
        String[] columnNames = {"Responsable", "Nombre de la Mascota", "Vacunas Usadas", "Dia de la Cita"};
        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        table = new JTable(model);
    }

}
