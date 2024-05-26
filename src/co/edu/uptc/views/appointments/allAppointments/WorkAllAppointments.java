package co.edu.uptc.views.appointments.allAppointments;

import co.edu.uptc.interfaces.VetInterface;
import co.edu.uptc.presenters.PresenterVet;
import co.edu.uptc.views.appointments.Table;
import co.edu.uptc.views.wildCardClasses.Global;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class WorkAllAppointments extends JPanel implements VetInterface.View.Tables {
    private final PresenterVet presenterVet;
    private Table tableAllAppointments;
    public WorkAllAppointments(){
        presenterVet = new PresenterVet();
        initWorkPanel();
        setData();
    }
    private void initWorkPanel() {
        tableAllAppointments = new Table();
        setBackground(Global.WORK_BACKGROUND_COLOR);
        setForeground(Global.WORK_TEXT_COLOR);
        setLayout(new BorderLayout());
        createTitle();
        createTable();
    }
    private void createTable() {
        JScrollPane scrollPane = new JScrollPane(tableAllAppointments.getTable());
        scrollPane.setPreferredSize(obtainSize());
        add(scrollPane);
    }
    private Dimension obtainSize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth() * 0.95;
        double height = screenSize.getHeight() * 0.6;
        return new Dimension((int)width, (int)height);
    }
    private void createTitle(){
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Global.WORK_BACKGROUND_COLOR);
        titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel data = new JLabel("Datos");
        data.setFont(Global.FONT_TITLE_BIG);
        data.setForeground(Global.WORK_TEXT_COLOR);
        add(titlePanel, BorderLayout.NORTH);
        titlePanel.add(data);
    }
    @Override
    public void setData() {
        presenterVet.getDataAndSetData();
        Object[][] data = presenterVet.obtainVisits();
        for (Object[] datum : data) {
            tableAllAppointments.putData(datum);
        }

    }
}
