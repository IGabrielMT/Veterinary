package co.edu.uptc.view.appointments.allAppointments;

import co.edu.uptc.view.mainpage.MainPageFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainAllAppointments extends JDialog {
    public MainAllAppointments(){
        super(MainPageFrame.getInstance(), true);
        initComponents();
        createHeader();
        createWork();
        createFooter();
    }
    private void initComponents() {
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
        double height = screenSize.getHeight();
        return new Dimension((int)width, (int)height);
    }
    private void createFooter() {
        FooterAllAppointments footerAllAppointments = new FooterAllAppointments();
        add(footerAllAppointments, BorderLayout.SOUTH);
    }
    private void createWork() {
        WorkAllAppointments workAllApointments = new WorkAllAppointments();
        add(workAllApointments, BorderLayout.CENTER);
    }
    private void createHeader() {
        HeaderAllAppointments headerAllAppointments = new HeaderAllAppointments(this);
        add(headerAllAppointments, BorderLayout.NORTH);
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
