package co.edu.uptc.view.registerAppointmentVet;

import co.edu.uptc.view.mainpage.MainPageFrame;
import co.edu.uptc.view.wildCardClasses.CustomJComboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterAppointmentMainPage extends JDialog {
    public RegisterAppointmentMainPage(){
        super(MainPageFrame.getInstance(), true);
        initComponents();
        createHeaderPanel();
        createWorkPanel();
        this.setOpacity(0);
        fadeIn();
    }
    private void initComponents(){
        this.setTitle("Registrar Cita");
        this.setSize(obtainSize());
        this.setUndecorated(true);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    private Dimension obtainSize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight() * 0.9;
        return new Dimension((int)width, (int)height);
    }
    private void createHeaderPanel(){
        HeaderPanelAppointment headerPanel = new HeaderPanelAppointment(this);
        this.add(headerPanel, BorderLayout.NORTH);
    }
    private void createWorkPanel(){
        WorkPanelAppointmentVet workPanelAppointmentVet = new WorkPanelAppointmentVet(this);
        workPanelAppointmentVet.setPetType(new CustomJComboBox(new String[]{"Perro", "Gato"}));
        workPanelAppointmentVet.setVaccinesNum(new CustomJComboBox(new String[]{"1", "2", "3", "4"}));
        workPanelAppointmentVet.setVaccines(new CustomJComboBox(new String[]{"Rabia", "Moquillo", "Hepatitis", "Parvovirus"}));
        workPanelAppointmentVet.buildPanel();
        add(workPanelAppointmentVet, BorderLayout.CENTER);
    }
    private void fadeIn() {
        Timer timer = new Timer(10, new ActionListener() {
            private float opacity = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                opacity += 0.15f;
                setOpacity(Math.min(opacity, 1)); // Set the new opacity
                if (opacity >= 1) {
                    ((Timer)e.getSource()).stop(); // Stop the timer when the window is fully opaque
                }
            }
        });
        timer.start();
    }
}
