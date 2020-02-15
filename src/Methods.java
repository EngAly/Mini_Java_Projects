
import java.security.MessageDigest;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//import java.util.Arrays;
import javax.xml.bind.DatatypeConverter;

public class Methods {

    public static String md5(String fatwa) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] stream = fatwa.getBytes();
            md.update(stream);
            byte[] digest = md.digest(stream);
//            System.out.println(Arrays.toString(digest));
            return DatatypeConverter.printHexBinary(digest).toLowerCase();
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    public static boolean checker(String... arr) {
        boolean flag = true;
        for (String item : arr) {
//            flag = !item.equals("");
            if (item.equals("")) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static Runnable commiter() {
        return new Runnable() {
            public void run() {
                for (int i = 1; i <= 3; i++) {
                    Insertion.commit.setText("Successful");
                    try {
                        Thread.sleep(500);
                        Insertion.commit.setText("");
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                }
                Methods.eraser(Insertion.a, Insertion.q, Insertion.fatwa);
                Insertion.jLabel6.setText("");
            }
        };
    }

    public static void eraser(JComponent... arr) {
        for (JComponent item : arr) {
            try {
                ((JTextArea) item).setText("");
            } catch (Exception e) {
                ((JTextField) item).setText("");
            }
        }
    }
}
