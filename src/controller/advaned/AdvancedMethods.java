package controller.advaned;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.concurrent.ThreadLocalRandom;

public class AdvancedMethods {

    public static void typeNumberOnly(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c))) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }

    public static int generateInteger() {
        return ThreadLocalRandom.current().nextInt(19931993, 20202020);
    }
}
