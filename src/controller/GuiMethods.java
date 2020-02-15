package controller;

import java.awt.FileDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GuiMethods {

    public static void getPath(JFrame frame, JTextField pathFile) {
        try {
            FileDialog fd = new FileDialog(frame);
            fd.setFile("*.jpg;*jpeg;*png;*gif");
            fd.setVisible(true);
            StringBuilder path = new StringBuilder(fd.getDirectory());
            pathFile.setText(path + "");
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }

}
