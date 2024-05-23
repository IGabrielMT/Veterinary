package co.edu.uptc.view.appointments.allAppointments;

import co.edu.uptc.view.appointments.Table;
import co.edu.uptc.view.wildCardClasses.Global;
import lombok.Getter;

import javax.swing.*;
@Getter
public class WorkAllAppointments extends JPanel {
    private static Table tableAllAppointments;
    public WorkAllAppointments(){
        initWorkPanel();
    }
    private void initWorkPanel() {
        tableAllAppointments = new Table();
        setBackground(Global.WORK_BACKGROUND_COLOR);
        setForeground(Global.WORK_TEXT_COLOR);
        createTable();
    }
    private void createTable() {
        add(new JScrollPane(tableAllAppointments.getTable()));
    }
}
