package model;

import controller.normal.TrivialMethods;
import view.Insertion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import org.apache.derby.shared.common.error.DerbySQLIntegrityConstraintViolationException;

//public class DBMethods implements classes.interfaces.advanced.DBMethods{
public class DBMethods {

    static PreparedStatement ps;
    static ResultSet rs;
    static Connection con = null;

    public DBMethods() {
        con = Connect.connect();
    }

    public static void selectData() {
        con = Connect.connect();
        try {
            StringBuilder query = new StringBuilder("SELECT * FROM  (APP.INFO   inner join   APP.SUBJECT on fatwaid_t1=fatwaid_t2)");
//            query.append("where fatwaid_t1 > 5");
            rs = con.prepareStatement(query.toString()).executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("fatwaid_t1"));
//                System.out.println(rs.getString("source"));
//                System.out.println(rs.getString("fatwapath"));
//                System.out.println(rs.getString("fatwatitle"));
//                System.out.println(rs.getString("fatwaname"));
//                System.out.println(rs.getString("fatwa"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * method is responsible for insert all fields on the GUI to DB<br>
     * Fatwa FatwaSrc etc.<br>
     */
    public static void insertData() {
        int handleCanOk;
        con = Connect.connect();
        try {
            String info = "insert into APP.INFO (fatwaid_t1,source,fatwapath,fatwatitle) values(?,?,?,?)";
            String subject = "insert into APP.subject (fatwaid_t2,fatwaname,fatwa) values(?,?,?)";
            String classification = "insert into APP.classification (fatwaid_t3,classification) values(?,?)";
            String base = "insert into APP.base (fatwaID) values(?)";
            
            ps = con.prepareStatement(info);
            ps.setInt(1, Integer.parseInt(Insertion.fatwaid.getText().trim()));
            ps.setString(2, Insertion.source.getText().trim());
            ps.setString(3, Insertion.fatwapath.getText().trim());
            ps.setString(4, Insertion.fatwatitle.getText().trim());
            ps.execute();

            ps = con.prepareStatement(subject);
            ps.setInt(1, Integer.parseInt(Insertion.fatwaid.getText().trim()));
            ps.setString(2, Insertion.fatwaname.getText().trim());
            ps.setString(3, Insertion.fatwa.getText().trim());
            ps.execute();

            ps = con.prepareStatement(classification);
            ps.setInt(1, Integer.parseInt(Insertion.fatwaid.getText().trim()));
            ps.setString(2, "فتوي");
            ps.execute();
            
            ps = con.prepareStatement(base);
            ps.setInt(1, Integer.parseInt(Insertion.fatwaid.getText().trim()));
            ps.execute();
            
            handleCanOk = JOptionPane.showConfirmDialog(null, "تم تخزين الفتوي بنجاح هل تريد حذف البيانات", "تاكيد", JOptionPane.OK_CANCEL_OPTION);
            if (handleCanOk == 0) {
                TrivialMethods.clearText();
            }
//            JOptionPane.showMessageDialog(null, "تم تخزين الفتوي بنجاح");
        } catch (DerbySQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "لا يسمح بتكرار رقم الفتوي");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * this methods is responsible for get the count of the fatwa from DB<br>
     * so that user can know number of fatwa use this subroutine<br>
     *
     * @return fataw count.<br>
     */
    public static int fatwaCount() {
        int total = 0;
        con = Connect.connect();
        try {
//            String query = "SELECT count(fatwaid_t1) as total FROM   APP.INFO";
            String query = "SELECT  id as total  FROM   APP.base";
            rs = con.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery();
            rs.next();
            rs.last();
            total = rs.getInt("total");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return total;
    }

    public static void testInsert() {
        con = Connect.connect();
        try {
            String query = "SELECT fatwaid_t1 FROM   APP.INFO";
            String query1 = "insert into APP.classification (fatwaid_t3,classification) values (?,?)";
            ps = con.prepareStatement(query1);
            rs = con.prepareStatement(query).executeQuery();
            while (rs.next()) {
                ps.setInt(1, rs.getInt("fatwaid_t1"));
                ps.setString(2, "فتوي");
                ps.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * this methods is responsible for test if fatwa id is repeated or<br>
     * not so that user can't repeated fatwa <br>
     * @param fatwaid number user want to test it<br>
     */
    public static void testFatwatID(String fatwaid) {
        con = Connect.connect();
        try {
            String query = "SELECT fatwaid_t1  from APP.INFO";
            rs = con.prepareStatement(query).executeQuery();
            while (rs.next()) {
                if (rs.getString("fatwaid_t1").equals(fatwaid)) {
                    Insertion.jLabel9.setText("Ok");
                    break;
                } else {
                    Insertion.jLabel9.setText("No");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
