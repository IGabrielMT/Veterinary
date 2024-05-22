import co.edu.uptc.view.mainpage.MainPageFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainPageFrame::getInstance);
    }
}