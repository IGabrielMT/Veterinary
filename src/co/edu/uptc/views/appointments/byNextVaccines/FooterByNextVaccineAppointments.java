package co.edu.uptc.views.appointments.byNextVaccines;

import co.edu.uptc.interfaces.VetInterface;
import co.edu.uptc.views.appointments.allAppointments.MainAllAppointments;
import co.edu.uptc.views.appointments.byDate.MainByDateAppointments;
import co.edu.uptc.views.appointments.byParent.MainByParentAppointments;
import co.edu.uptc.views.mainpage.MainPageFrame;
import co.edu.uptc.views.wildCardClasses.Global;
import co.edu.uptc.views.wildCardClasses.LabelHeader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FooterByNextVaccineAppointments extends JPanel {
    private final MainPageFrame mainPageFrame;
    private final JDialog parent;
    private final VetInterface.Presenter presenter;

    public FooterByNextVaccineAppointments(JDialog parent, MainPageFrame mainPageFrame, VetInterface.Presenter presenter) {
        this.mainPageFrame = mainPageFrame;
        this.parent = parent;
        this.presenter = presenter;
        initPanel();
    }
    private void initPanel() {
        this.setBackground(Global.FOOTER_BACKGROUND_COLOR);
        this.setLayout(new BorderLayout());
        createWorkPanel();
    }
    private void createWorkPanel() {
        JPanel gridPanel = new JPanel(new GridLayout(1, 4, 40, 40));
        gridPanel.setBackground(Global.FOOTER_BACKGROUND_COLOR);
        int marginSize = 60;
        JPanel marginPanel = new JPanel(new BorderLayout());
        marginPanel.add(gridPanel, BorderLayout.CENTER);
        marginPanel.setBorder(BorderFactory.createEmptyBorder(marginSize, marginSize, marginSize, marginSize));
        marginPanel.setBackground(Global.FOOTER_BACKGROUND_COLOR);
        addContent(gridPanel);
        add(marginPanel);
    }
    private void addContent(JPanel gridPanel){
        createTitle1(gridPanel);
        createTitle2(gridPanel);
        createTitle3(gridPanel);
        createTitle4(gridPanel);
    }
    private void createTitle1(JPanel gridPanel){
        JLabel orderBy = new LabelHeader("Ordernar por: ");
        orderBy.setFont(Global.FONT_TITLE_NORMAL);
        orderBy.setForeground(Global.FOOTER_TEXT_COLOR);
        gridPanel.add(orderBy);
    }
    private void createTitle2(JPanel gridPanel){
        JLabel all = new LabelHeader("Todos");
        all.setFont(Global.FONT_TEXTS);
        all.setForeground(Global.FOOTER_TEXT_COLOR);
        all.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parent.dispose();
                createAllAppointments();
            }
        });
        gridPanel.add(all);
    }
    private void createTitle3(JPanel gridPanel){
        JLabel date = new LabelHeader("Fecha");
        date.setFont(Global.FONT_TEXTS);
        date.setForeground(Global.FOOTER_TEXT_COLOR);
        date.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parent.dispose();
                createByDateAppointments();
            }
        });
        gridPanel.add(date);
    }
    private void createTitle4(JPanel gridPanel) {
        JLabel responsible = new LabelHeader("Responsable");
        responsible.setFont(Global.FONT_TEXTS);
        responsible.setForeground(Global.FOOTER_TEXT_COLOR);
        responsible.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parent.dispose();
                createByResponsible();
            }
        });
        gridPanel.add(responsible);
    }
    private void createAllAppointments(){
        MainAllAppointments mainAllAppointments = new MainAllAppointments(mainPageFrame, presenter);
        mainAllAppointments.setVisible(true);
    }
    private void createByDateAppointments(){
        MainByDateAppointments mainByDateAppointments = new MainByDateAppointments(mainPageFrame, presenter);
        mainByDateAppointments.setVisible(true);
    }
    private void createByResponsible(){
        MainByParentAppointments mainByResponsibleAppointments = new MainByParentAppointments(mainPageFrame, presenter);
        mainByResponsibleAppointments.setVisible(true);
    }
}
