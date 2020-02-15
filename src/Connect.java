
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Connect {

    static Connection con = null;

    public static Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:attaches/ubuntu");
//            con = DriverManager.getConnection("jdbc:sqlite:/media/engali/26G/islam-web/attaches/islam-web");
//            JOptionPane.showMessageDialog(null, "sccussful connection with database");
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
//finally {
//            try {
//                con.close();
//                System.out.println("closed");
//            } catch (Exception e) {
//            }
//        }
    }
//    
//    public static void main(String[] args) {
//        System.out.println(Connect.connect());
//    }
//    

}
