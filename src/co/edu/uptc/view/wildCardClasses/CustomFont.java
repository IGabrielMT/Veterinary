package co.edu.uptc.view.wildCardClasses;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class CustomFont {
    public static Font createCustomFont(String path, float size) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(size);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
