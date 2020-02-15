package controller.normal;

import java.awt.event.KeyEvent;
import model.ShowingDBMethods;
import static view.Showing.jEditorPane1;

public class Subroutines {

    public static void searchWithKeyEvent(KeyEvent evt, ShowingDBMethods sdbm) {
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            try {
                int getSelected = Integer.parseInt(jEditorPane1.getSelectedText() + "");
//                System.out.println(getSelected);
                sdbm.searchWithFatwaID((long) getSelected);
                TrivialMethods.storePrevious(sdbm.getID(getSelected));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
