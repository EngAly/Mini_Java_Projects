
import java.util.ArrayList;

public class Methods {

      static ArrayList<Long> uncompleteAnalyizer(long number) {
        ArrayList<Long> analyizedNoStore = new ArrayList();
        long counter = 2;
        boolean flag = false;
        while (flag == false) {
            if (number % counter == 0) {
                analyizedNoStore.add(counter);
                number = number / counter;
            } else {
                counter++;
            }
            if (number == counter) {
                analyizedNoStore.add(counter);
                flag = true;
            }
        }
        return analyizedNoStore;
    }

     
}
