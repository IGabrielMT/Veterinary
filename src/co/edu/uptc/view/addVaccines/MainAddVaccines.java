package co.edu.uptc.view.addVaccines;

import co.edu.uptc.view.mainpage.MainPageFrame;
import co.edu.uptc.view.wildCardClasses.CustomJComboBox;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainAddVaccines extends JDialog {
    public MainAddVaccines() {
        super(MainPageFrame.getInstance(), true);
        initComponents();
        createHeaderPanel();
        createWorkPanel();
    }
    private void initComponents(){
        this.setSize(obtainSize());
        this.setUndecorated(true);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        fadeIn();
    }
    private Dimension obtainSize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight() * 0.9;
        return new Dimension((int)width, (int)height);
    }
    private void createHeaderPanel(){
        HeaderPanelAddVaccines headerPanel = new HeaderPanelAddVaccines(this);
        this.add(headerPanel, BorderLayout.NORTH);
    }
    private void createWorkPanel(){
        WorkPanelAddVaccines workPanel = new WorkPanelAddVaccines();
        workPanel.setDueDate(new JDateChooser());
        CustomJComboBox petType = new CustomJComboBox(new String[]{"Perro", "Gato"});
        workPanel.setPetType(petType);
        workPanel.build();
        this.add(workPanel, BorderLayout.CENTER);
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
