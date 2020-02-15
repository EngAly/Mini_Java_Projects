package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Connect {

    public static Connection connect() {
        try {
            Properties info = new Properties();
            info.put("user", "images");
            info.put("password", "images");
//            info.put("derby.language.sequence.preallocator", "1");
//            info.put("connectTimeout", "1000");
            String db_name = "images";
//            String db_url = "jdbc:derby:" + db_name+";shutdown=true";
            String db_url = "jdbc:derby:" + db_name;
            Connection con = DriverManager.getConnection(db_url, info);
//            con.setReadOnly(true);
//            System.out.println("success");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void shutdown_DB() {
        try {
            System.out.println("shutdown OK");
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }

}
