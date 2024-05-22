package co.edu.uptc.view.mainpage;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MainPageFrame extends JFrame {
    private JPanel workPanel;
    private JPanel headerPanel;
    private static MainPageFrame instance;

    public MainPageFrame(){
        initComponents();
        createHeaderPanel();
        createWorkPanel();
    }
    private void initComponents(){
        this.setTitle("Veterinaria");
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.setSize(getMainSize());
        this.setLocationRelativeTo(null);
        setAppIcon();
    }
    private Dimension getMainSize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight() * 0.68;
        return new Dimension((int)width, (int)height);
    }
    private void createWorkPanel(){
        workPanel = new WorkPanel();
        this.add(workPanel, BorderLayout.CENTER);
    }
    private void createHeaderPanel(){
        headerPanel = new HeaderPanel();
        this.add(headerPanel, BorderLayout.NORTH);
    }
    private void setAppIcon(){
        URL iconURL = MainPageFrame.class.getResource("/icons/IconoPrograma.png");
        assert iconURL != null;
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
    }
    public static MainPageFrame getInstance() {
        if (instance == null) {
            instance = new MainPageFrame();
        }
        return instance;
    }

}
