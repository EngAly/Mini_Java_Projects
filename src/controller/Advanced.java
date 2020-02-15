package controller;

import java.awt.ComponentOrientation;
import java.awt.event.MouseWheelEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.xml.bind.DatatypeConverter;
import model.Connect;

public class Advanced {

    public static String checkSum(String path) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(Files.readAllBytes(Paths.get(path)));
            byte[] hash = messageDigest.digest();
            return DatatypeConverter.printHexBinary(hash).toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String checkSum(File file) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(Files.readAllBytes(file.toPath()));
            byte[] hash = messageDigest.digest();
            return DatatypeConverter.printHexBinary(hash);
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int generateInteger() {
        return ThreadLocalRandom.current().nextInt(100000, 999999);
    }

    public static void closeWindow(JFrame s) {
        try {
            s.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent event) {
                    System.out.println("closed");
                    Connect.shutdown_DB();
                }
            });
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }

    public static void switchLang(MouseWheelEvent evt, JTextField keyWord) {
        if (evt.getWheelRotation() == 1) {
            keyWord.getInputContext().selectInputMethod(new Locale("ar", "eg"));
            keyWord.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        } else {
            keyWord.getInputContext().selectInputMethod(new Locale("en", "us"));
            keyWord.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        }

    }
}
