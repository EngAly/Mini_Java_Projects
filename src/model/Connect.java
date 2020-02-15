package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Connect {

    public static Connection connect() {
        try {
            Properties info = new Properties();
            info.put("user", "fatwa");
            info.put("password", "fatwa");
//            info.put("derby.language.sequence.preallocator", "1");
//            info.put("connectTimeout", "1000");
            String db_name = "subjects";
//            String db_url = "jdbc:derby:" + db_name+";shutdown=true";
            String db_url = "jdbc:derby:" + db_name;
            Connection con = DriverManager.getConnection(db_url, info);
//            con.setReadOnly(true);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void shutdown_DB() {
        try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
            System.out.println("sssssssssss");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
