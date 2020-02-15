
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class DB_Methods {

    static Connection con = null;
    static PreparedStatement pst = null;
    static ResultSet rst = null;

    public DB_Methods() {
        System.out.println("success connction");
        con = Connect.connect();
//        System.out.println(con);
    }

// not have connection
    public static void insert_fatwa(String fatwa, String q, String a) {
        boolean checker = Methods.checker(fatwa, q, a);
        if (checker) {
            try {
                String sqlCommand = "insert into fatwa (fatwa,question,answer,md5) values "
                        + "('" + fatwa + "','" + q + "','" + a + "','" + Methods.md5(fatwa) + "')";
                exec(sqlCommand);
            } catch (Exception handle) {
                JOptionPane.showMessageDialog(null, handle.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "complete all fielda");
        }
    }

    private static void exec(String sql) {
        try {
//            con = Connect.connect();
            pst = con.prepareStatement(sql);
            pst.execute();
            new Thread(Methods.commiter()).start();
        } catch (Exception handle) {
            JOptionPane.showMessageDialog(null, handle.getMessage());
        }
    }

    public static void select_fatwa() {
        try {
//            con = Connect.connect();
            String sqlCommand = "select * from fatwa";
            pst = con.prepareStatement(sqlCommand);
            rst = pst.executeQuery();
            while (rst.next()) {
                System.out.println(rst.getString("fatwa"));
            }
        } catch (Exception handle) {
            System.out.println(handle.getMessage());
        }
    }

    public static void select_All() {
        try {
//            con = Connect.connect();
            String sqlCommand = "select * from commands";
            pst = con.prepareStatement(sqlCommand);
            rst = pst.executeQuery();
            while (rst.next()) {
                GenPage.create_root(rst.getString("questions"), rst.getString("answer"));
            }
        } catch (Exception handle) {
            System.out.println(handle.getMessage());
        }
    }

    public static void count() {
        try {
            String sqlCommand = "select count(*) from fatwa";
            pst = con.prepareStatement(sqlCommand);
            rst = pst.executeQuery();
            System.out.println(rst.getInt(1));
        } catch (Exception handle) {
            System.out.println(handle.getMessage());
        }
    }

    public static void main(String[] args) {
        DB_Methods dbm = new DB_Methods();
////        System.out.println(foundation("من صلى ركعتين نافلة ثم قام ساهياً إلى ثالثة"));
//        count();
        select_All();
    }

    public static boolean foundation(String text) {
        boolean flag = false;
        try {
            String sqlCommand = "select fatwa from fatwa";
            rst = con.prepareStatement(sqlCommand).executeQuery();
            while (rst.next()) {
                if (text.equals(rst.getString("fatwa"))) {
                    flag = true;
                    break;
                }
            }
        } catch (Exception handle) {
            System.out.println(handle.getMessage());
        }
        return flag;

    }
}
