package co.edu.uptc.view.registerAppointmentVet;

import co.edu.uptc.view.wildCardClasses.CustomButton;
import co.edu.uptc.view.wildCardClasses.Global;
import co.edu.uptc.view.wildCardClasses.LimitedTextField;
import com.toedter.calendar.JDateChooser;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
@Getter
@Setter
public class WorkPanelAppointmentVet extends JPanel {
    private JComboBox<String> petType;
    private JComboBox<String> vaccinesNum;
    private JComboBox<String> vaccines;
    private LimitedTextField ownerName;
    private LimitedTextField petName;
    private JDateChooser dateChooser;
    private JDialog parent;
    public WorkPanelAppointmentVet(JDialog parent){
        this.parent = parent;
        this.parent = getParent();
    }

    public void buildPanel() {
        initWorkPanel();
        createLabelAndText();
        requestFocusInWindow();
        addButtons();
    }

    private void initWorkPanel() {
        setBackground(Global.WORK_BACKGROUND_COLOR);
        setForeground(Global.WORK_TEXT_COLOR);
        setLayout(new BorderLayout()); // Change to BorderLayout
    }
    private void createLabelAndText(){
        JPanel gridPanel = new JPanel(new GridLayout(9, 3, 20, 20)); // Create a new JPanel with GridLayout
        addFirstAndSecondRow(gridPanel);
        createEmptySpace(gridPanel);
        addFourthRowAndFifth(gridPanel);
        for (int i = 0; i < 4; i++) {
            createEmptySpace(gridPanel);
        }
        int marginSize = 50; // Create a margin size
        JPanel marginPanel = new JPanel(new BorderLayout());
        marginPanel.add(gridPanel, BorderLayout.CENTER);
        marginPanel.setBorder(BorderFactory.createEmptyBorder(marginSize, marginSize, marginSize, marginSize));
        add(marginPanel); // Add the marginPanel to the main panel
    }
    private void addFirstAndSecondRow(JPanel gridPanel){
        JLabel label = new JLabel("Nombre de la mascota:");
        label.setFont(Global.FONT_TEXTS);
        gridPanel.add(label);
        label = new JLabel("Numero de Vacunas a Colorcar:");
        label.setFont(Global.FONT_TEXTS);
        gridPanel.add(label);
        label = new JLabel("Tipo de Mascota:");
        label.setFont(Global.FONT_TEXTS);
        gridPanel.add(label);
        petName = new LimitedTextField(10, "");
        gridPanel.add(petName);
        gridPanel.add(vaccinesNum);
        gridPanel.add(petType);
    }
    private void createEmptySpace(JPanel gridPanel){
        for (int i = 0; i < 3; i++) {
            gridPanel.add(new JLabel(""));
        }
    }
    private void addFourthRowAndFifth(JPanel gridPanel){
        JLabel label = new JLabel("Nombre del Responsable:");
        label.setFont(Global.FONT_TEXTS);
        gridPanel.add(label);
        label = new JLabel("Vacunas:");
        label.setFont(Global.FONT_TEXTS);
        gridPanel.add(label);
        label = new JLabel("Fecha de la Cita:");
        label.setFont(Global.FONT_TEXTS);
        gridPanel.add(label);
        ownerName = new LimitedTextField(10, "");
        gridPanel.add(ownerName);
        gridPanel.add(vaccines);
        dateChooser = new JDateChooser();
        gridPanel.add(dateChooser);
    }
    private void addButtons(){
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.add(createButtonRegister());
        buttonPanel.add(createButtonReturn());
        add(buttonPanel, BorderLayout.SOUTH);
    }
    private JButton createButtonRegister(){
        CustomButton button = new CustomButton("Registrar Cita");
        button.addActionListener(e -> {
            // Add the logic to register the appointment
        });
        return button;
    }
    private JButton createButtonReturn() {
        CustomButton button = new CustomButton("Volver");
        button.addActionListener(e -> parent.dispose());
        return button;
    }

}