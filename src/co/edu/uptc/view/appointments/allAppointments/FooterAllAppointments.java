package co.edu.uptc.view.appointments.allAppointments;

import co.edu.uptc.view.wildCardClasses.Global;
import co.edu.uptc.view.wildCardClasses.LabelHeader;

import javax.swing.*;
import java.awt.*;

public class FooterAllAppointments extends JPanel {
    public FooterAllAppointments() {
        initPanel();
    }
    private void initPanel() {
        this.setBackground(Global.FOOTER_BACKGROUND_COLOR);
        this.setLayout(new BorderLayout());
        createWorkPanel();
    }
    private void createWorkPanel() {
        JPanel gridPanel = new JPanel(new GridLayout(1, 3, 40, 40));
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
    }
    private void createTitle1(JPanel gridPanel){
        JLabel orderBy = new LabelHeader("Ordernar por: ");
        orderBy.setFont(Global.FONT_TITLE_NORMAL);
        orderBy.setForeground(Global.FOOTER_TEXT_COLOR);
        gridPanel.add(orderBy);
    }
    private void createTitle2(JPanel gridPanel){
        JLabel date = new LabelHeader("Fecha");
        date.setFont(Global.FONT_TEXTS);
        date.setForeground(Global.FOOTER_TEXT_COLOR);
        gridPanel.add(date);
    }
    private void createTitle3(JPanel gridPanel){
        JLabel petsNextTo = new LabelHeader("Mascotas proximas a vacuna");
        petsNextTo.setFont(Global.FONT_TEXTS);
        petsNextTo.setForeground(Global.FOOTER_TEXT_COLOR);
        gridPanel.add(petsNextTo);
    }
}
