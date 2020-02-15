
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class test {

    static Connection con = null;
    static PreparedStatement pst = null;
    static ResultSet rst = null;

    public test() {
        con = connect();
    }

    public void exec(String sql) {
        try {
            pst = con.prepareStatement(sql);
            pst.execute();
        } catch (Exception handle) {
            System.out.println(handle.getMessage());
        }
    }

    public static Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:db\\dictionary");
//            JOptionPane.showMessageDialog(null, "sccussful connection with database");
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public void EN_AR_Words(JTextField arabic, JTextField english) {
        try {
            String sqlCommand = "insert into EN_AR (arabic,english) values ('" + arabic.getText() + "','" + english.getText() + "')";
            exec(sqlCommand);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void getLastId(JTextField id) {
        try {
            String sqlCommand = "select * from  EN_AR order by id desc";
            pst = con.prepareStatement(sqlCommand);
            rst = pst.executeQuery();
            id.setText(rst.getString("id"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void writeWorss2File() {
        File write2me = new File("words");
        if (!write2me.exists()) {
            write2me.mkdir();
        } else {
            try {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd  HH-mm-ss");
                Date date = new Date();
                File filePath = new File("words/" + dateFormat.format(date) + ".txt");
                BufferedWriter write2file = new BufferedWriter(new FileWriter(filePath));
                String wordsLine2line = "";
                String sqlCommand = "select * from  EN_AR";
                pst = con.prepareStatement(sqlCommand);
                rst = pst.executeQuery();
                while (rst.next()) {
                    wordsLine2line = rst.getString("id") + ") " + rst.getString("english") + "  ----------------  " + rst.getString("arabic");
                    write2file.write(wordsLine2line);
                    write2file.newLine();
                }
                write2file.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
