package co.edu.uptc.view.mainpage;

import co.edu.uptc.view.registerAppointmentVet.RegisterAppointmentMainPage;
import co.edu.uptc.view.wildCardClasses.CustomButton;
import co.edu.uptc.view.wildCardClasses.Global;

import javax.swing.*;
import java.awt.*;

public class WorkPanel extends JPanel {
    public WorkPanel(){
        initWorkPanel();
        createLabelAndButton();
    }

    private void initWorkPanel() {
        setBackground(Global.WORK_BACKGROUND_COLOR);
        setForeground(Global.WORK_TEXT_COLOR);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    private void createLabelAndButton(){
        add(Box.createVerticalGlue());
        JLabel label = new JLabel("Registrar Cita");
        label.setFont(Global.FONT_TITLE_BIG);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(label);
        add(Box.createVerticalStrut(50));
        CustomButton button = new CustomButton("Registrar");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(e -> registerAppointment());
        add(button);
        add(Box.createVerticalGlue());
    }
    private void registerAppointment(){
        RegisterAppointmentMainPage registerAppointmentMainPage = new RegisterAppointmentMainPage();
        registerAppointmentMainPage.setVisible(true);
    }
}
