package controller.normal;

import model.Connect;
import javax.swing.JFrame;

public class OverrideMethods {

    public static void closeWindow(JFrame s) {
        try {
            s.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent event) {
                    Connect.shutdown_DB();
                    System.out.println("closed");
                }
            });
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }
}
