package co.edu.uptc.view.registerAppointmentVet;

import co.edu.uptc.view.wildCardClasses.CustomButton;
import co.edu.uptc.view.wildCardClasses.Global;
import co.edu.uptc.view.wildCardClasses.LabelHeader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HeaderPanelAppointment extends JPanel{
    private JPanel headerLabelsPanel;
    private JPanel titlePanel;
    private final JDialog parentDialog;
    public HeaderPanelAppointment(JDialog parentDialog){
        this.parentDialog = parentDialog;
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
        JLabel label =  new LabelHeader("Inicio");
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parentDialog.dispose();
            }
        });
        headerLabelsPanel.add(label);
    }
    private void createLabelAddVaccines(){
        JLabel label =  new LabelHeader("Ver Citas");
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
}
