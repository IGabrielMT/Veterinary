package co.edu.uptc.views.mainpage;

import co.edu.uptc.interfaces.VetInterface;
import co.edu.uptc.views.addVaccines.MainAddVaccines;
import co.edu.uptc.views.appointments.allAppointments.MainAllAppointments;
import co.edu.uptc.views.wildCardClasses.CustomButton;
import co.edu.uptc.views.wildCardClasses.Global;
import co.edu.uptc.views.wildCardClasses.LabelHeader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HeaderPanel extends JPanel{
    private JPanel headerLabelsPanel;
    private JPanel titlePanel;
    private final MainPageFrame mainPageFrame;
    private final VetInterface.Presenter presenter;

    public HeaderPanel(MainPageFrame mainPageFrame, VetInterface.Presenter presenter) {
        this.mainPageFrame = mainPageFrame;
        this.presenter = presenter;
        initComponents();
        createPanelHeaderLabels();
        createLabelAddVaccines();
        createLabelViewDates();
        createTitlePanel();
        createLblTitle();
        createButtonExit();
    }
    private void initComponents(){
        this.setVisible(true);
        this.setBackground(Global.HEADER_BACKGROUND_COLOR);
        this.setLayout(new BorderLayout());
        setPreferredSize(new Dimension(0, getHeaderSize()));
    }
    private int getHeaderSize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double height = screenSize.getHeight();
        return (int)(height * 0.18);
    }
    private void createPanelHeaderLabels(){
        headerLabelsPanel = new JPanel();
        FlowLayout layout = new FlowLayout(FlowLayout.RIGHT, 90, 45);
        headerLabelsPanel.setLayout(layout);
        headerLabelsPanel.setBackground(Global.HEADER_BACKGROUND_COLOR);
        this.add(headerLabelsPanel, BorderLayout.CENTER);
    }
    private void createLabelViewDates(){
        JLabel label =  new LabelHeader("Ver Citas");
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addAppointments();
            }
        });
        headerLabelsPanel.add(label);
    }
    private void createLabelAddVaccines(){
        JLabel label =  new LabelHeader("Agregar Vacunas");
        label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addVaccine();
            }
        });
        headerLabelsPanel.add(label);
    }
    private void createTitlePanel(){
        titlePanel = new JPanel();
        titlePanel.setBackground(Global.HEADER_BACKGROUND_COLOR);
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
        this.add(titlePanel, BorderLayout.WEST);
    }
    private void createLblTitle(){
        JLabel label = new JLabel("Veterinaria");
        titlePanel.add(Box.createHorizontalStrut(50));
        label.setFont(Global.FONT_TITLE_NORMAL);
        label.setForeground(Global.HEADER_TEXT_COLOR);
        titlePanel.add(label);
    }
    private void createButtonExit(){
        CustomButton button = new CustomButton("Salir");
        button.addActionListener(e -> System.exit(0));
        headerLabelsPanel.add(button);
    }
    private void addVaccine(){
        MainAddVaccines mainAddVaccines = new MainAddVaccines(mainPageFrame, presenter);
        mainAddVaccines.setVisible(true);
    }
    private void addAppointments(){
        MainAllAppointments mainAllAppointments = new MainAllAppointments(mainPageFrame, presenter);
        mainAllAppointments.setVisible(true);
    }


}
