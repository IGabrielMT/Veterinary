package co.edu.uptc.views;

import javax.swing.*;

public class ThrowMessage {
    public static void throwMessageDialog(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(null, message, title, messageType);
    }
}
