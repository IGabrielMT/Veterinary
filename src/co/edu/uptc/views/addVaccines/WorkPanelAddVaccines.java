package co.edu.uptc.views.addVaccines;

import co.edu.uptc.interfaces.VetInterface;
import co.edu.uptc.presenters.PresenterVet;
import co.edu.uptc.views.wildCardClasses.CustomButton;
import co.edu.uptc.views.wildCardClasses.CustomJComboBox;
import co.edu.uptc.views.wildCardClasses.Global;
import co.edu.uptc.views.wildCardClasses.LimitedTextField;
import com.toedter.calendar.JDateChooser;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Objects;

@Getter
@Setter
public class WorkPanelAddVaccines extends JPanel implements VetInterface.View{
    private PresenterVet presenterVet;
    private LimitedTextField nameVaccine;
    private JDateChooser dueDate;
    private CustomJComboBox petType;
    private JDialog parent;

    public WorkPanelAddVaccines(JDialog parent){
        this.parent = parent;
        presenterVet = new PresenterVet();
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
        button.addActionListener(e -> {
            presenterVet.addVaccine(returnData());
            JOptionPane.showMessageDialog(null, "Vacuna agregada correctamente");
            parent.dispose();
        });
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
        label = new JLabel("Fecha de vencimiento: (dd/mm/yyyy)");
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

@SneakyThrows
@Override
public String[] returnData() {
    String[] data = new String[3];
    data[0] = nameVaccine.getText();
    LocalDate dueDateLocal = dueDate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    LocalDate oneYearLater = LocalDate.now().plusYears(1);
    if (dueDateLocal.isAfter(oneYearLater)) {
        System.out.println(dueDateLocal);
        data[1] = dueDateLocal.toString();
    } else {
        JOptionPane.showMessageDialog(null, "La fecha de vencimiento no puede ser menor a la fecha actual");
        throw new Exception("La fecha de vencimiento no puede ser menor a la fecha actual más un año");
    }

    data[2] = Objects.requireNonNull(petType.getSelectedItem()).toString();
    return data;
    }
}
