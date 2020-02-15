package model;

import java.awt.List;
import view.Showing;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import static view.Showing.time;

public class ShowingDB {

    static PreparedStatement ps;
    static ResultSet rs;
    static Connection con = null;
    public static boolean flagFatwaID = false;
    private static final ShowingDB sdbm = new ShowingDB();

    private ShowingDB() {
        con = Connect.connect();
    }

    public static ShowingDB getInstance() {
        return sdbm;
    }

    public void nextFatwa(int id) {
        try {
            int threadCount=0;
            StringBuilder query = new StringBuilder("SELECT * FROM  (APP.INFO   inner join   APP.SUBJECT on fatwaid_t1=fatwaid_t2)");
            query.append("inner join   APP.base on fatwaid_t1=fatwaid");
            query.append(" where id=").append(id);
            rs = con.prepareStatement(query.toString()).executeQuery();
            rs.next();
            Showing.jLabel4.setText(rs.getString("fatwaid"));
            Showing.jLabel4.setText(rs.getString("fatwaid_t1"));
            Showing.jLabel3.setText(rs.getString("fatwapath"));
            Showing.jLabel8.setText(rs.getString("source"));
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Showing.jEditorPane1.setText(rs.getString("fatwa"));
                        Thread.sleep(0);
 //                        Showing.jEditorPane1.setText(methodName(rs.getString("fatwa")));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            t2.start();
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Showing.jTextArea1.setText(rs.getString("fatwaname"));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            t1.start();
            
            
            
            
//                System.out.println(rs.getString("fatwatitle"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
         
              
        
    }

    public static String colorFatwaID(String string) {
        StringTokenizer st = new StringTokenizer(string);
        StringBuilder sb = new StringBuilder();
        long token_number = 0;
        String String = "";
        while (st.hasMoreTokens()) {
            try {
                String = st.nextToken();
                token_number = Long.parseLong(String);
                sb.append("<html><a href=\"\">").append(String).append("</a>").append(" ");
            } catch (Exception e) {
//                e.printStackTrace();
                sb.append(String).append(" ");
            }
        }
        return sb.toString();
    }

    public void streamInsert() {
        String select = "select fatwaid_t1 FROM   APP.INFO";
        String insert = "insert into APP.base (fatwaID) values (?)";
        try {
            con.setAutoCommit(false);
            rs = con.prepareStatement(select).executeQuery();
            ps = con.prepareStatement(insert);
            while (rs.next()) {
                ps.setInt(1, rs.getInt("fatwaid_t1"));
                ps.addBatch();
            }
            ps.executeBatch();
            con.commit();
            con.close();
            Connect.shutdown_DB();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public int getLastID() {
        String query = "select count(id) from app.base";
        int id_count = 0;
        try {
            rs = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
            rs.next();
            rs.last();
            id_count = rs.getInt(1);
//            con.close();
//            Connect.shutdown_DB();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id_count;

    }

    public void searchWithFatwaID(long fatwaID) {
        try {
            StringBuilder query = new StringBuilder("SELECT * FROM  (APP.INFO   inner join   APP.SUBJECT on fatwaid_t1=fatwaid_t2)");
            query.append("inner join   APP.base on fatwaid_t1=fatwaid");
            query.append(" where fatwaid=").append(fatwaID);
            rs = con.prepareStatement(query.toString()).executeQuery();
            if (rs.next()) {
                Showing.jLabel4.setText(rs.getString("fatwaid"));
                Showing.jLabel4.setText(rs.getString("fatwaid_t1"));
                Showing.jLabel3.setText(rs.getString("fatwapath"));
                Showing.jLabel8.setText(rs.getString("source"));
                Thread t2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Showing.jEditorPane1.setText(rs.getString("fatwa"));
                            Thread.sleep(0);
//                        Showing.jEditorPane1.setText(methodName(rs.getString("fatwa")));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                t2.start();
                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Showing.jTextArea1.setText(rs.getString("fatwaname"));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                t1.start();
                    flagFatwaID = true;
//                System.out.println(rs.getString("fatwatitle"));
            } else {
                JOptionPane.showMessageDialog(null, "عفوا الفتوي غير موجوده");
            }

        } catch (Exception e) {
            flagFatwaID = false;
            e.printStackTrace();
        }
    }

    public int getID(int fatawID) {
        StringBuilder query = new StringBuilder("select  id  from app.base where fatwaid=").append(fatawID);
        int id = 0;
        try {
            rs = con.prepareStatement(query.toString()).executeQuery();
            rs.next();
            id = rs.getInt("id");
//            System.out.println(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;

    }

//    public static void main(String[] args) {
//        ShowingDBMethods s = new ShowingDBMethods();
//        s.streamInsert();
//        System.out.println(s.getLastID());
//    }
}
