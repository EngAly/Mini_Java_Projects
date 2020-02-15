package controller.normal;

import view.Insertion;
import static view.Insertion.*;
import view.Showing;
import java.awt.ComponentOrientation;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.util.Stack;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

public class TrivialMethods {

    public static Stack<Object> previoue_repository = new Stack<>();
    public static int timer = 0;

    final static JTextComponent[] text = {fatwa, fatwaid, fatwaname, fatwapath, fatwatitle, source};

    public static void textDemension() {
        for (JTextComponent jTextComponent : text) {
            jTextComponent.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }

    }

    public static void clearText() {
        for (JTextComponent jTextComponent : text) {
            jTextComponent.setText("");
        }

    }

    public static void fillFields() {
        for (JTextComponent nextText : text) {
            if (nextText != fatwaid) {
                nextText.setText("1");
            }
        }

    }

    public static boolean checkFields() {
        boolean check = false;
        for (JTextComponent jTextComponent : text) {
            if (jTextComponent.getText().isEmpty()) {
                check = true;
                JOptionPane.showMessageDialog(jTextComponent, "بعض الحقول فارغه");
                break;
            }
        }
        return check;
    }

    public static void pasteText(int idx) {
        try {

            switch (idx) {
                case 3:
                    text[idx].setText(fatwapath.getText().trim().replace("  ", " >> "));
                    break;
                case 5:
                    text[idx].setText("إسلام ويب");
                    break;
                default:
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void getClipboard(int idx) {
        String clipboard;
        try {
            clipboard = Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor).toString();
            text[idx].setText(clipboard.trim());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void getSource(int count) {
//        System.out.println(count);
        switch (count) {
            case 1:
                source.setText("إسلام ويب");
                break;
            case 2:
                source.setText("الأسلام سؤال وجواب");
                break;
            case 3:
                source.setText("موضوع");
                break;
            case 4:
                source.setText("ابن باز رحمه الله");
                break;
            case 5:
                source.setText("نداء الإيمان");
                break;
            case 6:
                source.setText("طريق الإسلام");
                break;
            case 7:
                source.setText("ويكبيديا");
                Insertion.sourceFatwa = 0;
                break;
            default:

        }
    }

    public static void storePrevious(int fatwaid) {
        previoue_repository.add(fatwaid);
    }

    /**
     * method is used to pop() remove element from the <br>
     * stack and then get the last element and so on <br>
     * untill stack there only one element in the stack so that <br>
     * the previous button become disable
     */
    public static int previousValue() {
        int firstElement = 1;
        try {
            if (previoue_repository.size() > 1) {
                previoue_repository.pop();
                firstElement = Integer.parseInt(previoue_repository.peek() + "");
            } else {
                Showing.previous.setEnabled(false);
            }
        } catch (Exception e) {
        }
//        System.out.println(firstFatwa);
        return firstElement;

    }

}
