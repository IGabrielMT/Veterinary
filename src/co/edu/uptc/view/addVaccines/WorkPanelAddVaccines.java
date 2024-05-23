package co.edu.uptc.view.addVaccines;

import co.edu.uptc.view.wildCardClasses.CustomButton;
import co.edu.uptc.view.wildCardClasses.CustomJComboBox;
import co.edu.uptc.view.wildCardClasses.Global;
import co.edu.uptc.view.wildCardClasses.LimitedTextField;
import com.toedter.calendar.JDateChooser;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class WorkPanelAddVaccines extends JPanel {
    private LimitedTextField nameVaccine;
    private JDateChooser dueDate;
    private CustomJComboBox petType;
    public WorkPanelAddVaccines(){
        initWorkPanel();
    }
    public void build(){
        createWorkPanel();
    }
    private void initWorkPanel() {
        setBackground(Global.WORK_BACKGROUND_COLOR);
        setForeground(Global.WORK_TEXT_COLOR);
        setLayout(new BorderLayout());
    }
    private void createWorkPanel(){
        JPanel gridPanel = new JPanel(new GridLayout(7, 3, 20, 20));
        int marginSize = 50;
        JPanel marginPanel = new JPanel(new BorderLayout());
        marginPanel.add(gridPanel, BorderLayout.CENTER);
        marginPanel.setBorder(BorderFactory.createEmptyBorder(marginSize, marginSize, marginSize, marginSize));
        addContent(gridPanel);
        add(marginPanel);
    }
    private void addContent(JPanel gridPanel){
        addFirstAndSecondRow(gridPanel);
        addEmptySpace(gridPanel);
        addButton(gridPanel);
    }
    private void addButton(JPanel gridPanel){
        gridPanel.add(new JLabel(""));
        CustomButton button = new CustomButton("Agregar Vacuna");
        gridPanel.add(button);
        gridPanel.add(new JLabel(""));
    }
    private void addEmptySpace(JPanel gridPanel) {
        for (int i = 0; i < 4; i++) {
            createEmptySpaceInARow(gridPanel);
        }
    }
    private void createEmptySpaceInARow(JPanel gridPanel){
        for (int i = 0; i < 3; i++) {
            JLabel label = new JLabel("");
            gridPanel.add(label);
        }
    }

    private void addFirstAndSecondRow(JPanel gridPanel){
        JLabel label = new JLabel("Nombre de la vacuna:");
        label.setFont(Global.FONT_TEXTS);
        gridPanel.add(label);
        label = new JLabel("Fecha de vencimiento:");
        label.setFont(Global.FONT_TEXTS);
        gridPanel.add(label);
        label = new JLabel("Tipo de mascota:");
        label.setFont(Global.FONT_TEXTS);
        gridPanel.add(label);
        nameVaccine = new LimitedTextField(20, "");
        gridPanel.add(nameVaccine);
        gridPanel.add(dueDate);
        gridPanel.add(petType);
    }


}
