package model;

import java.awt.Image;
import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.NavigableSet;
import java.util.TreeSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import view.Showing;

public class SelectDB {

    private static final SelectDB sdb = new SelectDB();
    private Connection con = null;
    private ResultSet rs;
    public final int labCounts = 12;
    int reminderIDS;
    int counter = 0;
    boolean flagReminder = false;
    ArrayList ids = new ArrayList();
    TreeSet temp = new TreeSet();

    private SelectDB() {
        con = Connect.connect();
    }

    public static SelectDB getInstance() {
        return sdb;
    }

    private ArrayList getIDS(String iclass) {
        String pattern;
        try {
            pattern = String.format("select imgid from app.imgs where imgclass='" + iclass + "'");
            rs = con.prepareStatement(pattern).executeQuery();
            while (rs.next()) {
                ids.add(rs.getInt(1));
            }
            return ids;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void getImages(JLabel[] labs) {
        String pattern;
        int counter = 0;
        try {
            pattern = "select img,imgid from app.imgs where imgid in (674720,757601,569253)";
            rs = con.prepareStatement(pattern).executeQuery();
            while (rs.next()) {
                Image original = new ImageIcon(rs.getBytes(1)).getImage();
                Image modified = original.getScaledInstance(labs[0].getWidth(), labs[0].getHeight(), 0);
                labs[counter].setIcon(new ImageIcon(modified));
                labs[counter].setText(rs.getInt(2) + "");
                counter++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getImage(JLabel icon,JLabel lab) {
        System.out.println(icon.getText());
        String pattern;
        Image modified;
        try {
            pattern = "select img from app.imgs where imgid =" + Integer.parseInt(icon.getText());
            rs = con.prepareStatement(pattern).executeQuery();
            rs.next();
            ImageIcon imgIcon = new ImageIcon(rs.getBytes(1));
            if (imgIcon.getIconWidth() > lab.getWidth()) {
                modified = imgIcon.getImage().getScaledInstance(lab.getWidth(), imgIcon.getIconHeight(), 0);
            } else if (imgIcon.getIconHeight() > lab.getHeight()) {
                modified = imgIcon.getImage().getScaledInstance(imgIcon.getIconWidth(), lab.getHeight(), 0);
            } else {
                modified = imgIcon.getImage().getScaledInstance(imgIcon.getIconWidth(), imgIcon.getIconHeight(), 0);
            }
            lab.setIcon(new ImageIcon(modified));
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }

    public void getALLKeyWords(String keyWord, List list) {
        temp.clear();
        list.clear();
        StringBuilder pattern = new StringBuilder();
        try {
            pattern.append("select imgclass from app.imgs where imgclass like ").append("'%").append(keyWord).append("%'");
            rs = con.prepareStatement(pattern.toString()).executeQuery();
            while (rs.next()) {
                temp.add(rs.getString(1));
            }
            temp.stream().forEach((t) -> {
                list.add(t.toString());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void nextImgSection() {               //JLabel[] labCounts) {
        try {
            if (reminderIDS > labCounts) {
                Showing.previous.setEnabled(true);
                System.out.println(ids.subList(counter, counter + labCounts));
                reminderIDS -= labCounts;
                counter += labCounts;
            } else {
                System.out.println(counter);
                System.out.println(ids.subList(counter, counter + reminderIDS));
                counter += reminderIDS;
                flagReminder = true;

                Showing.next.setEnabled(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void previousImgSection() {
        try {
            if (flagReminder) {
                counter = (counter - reminderIDS);
                flagReminder = false;
            }
            System.out.println(counter);
            if (counter > labCounts) {
                System.out.println(ids.subList(counter - (labCounts * 2), counter - labCounts));
                reminderIDS += labCounts;
                counter -= labCounts;
                Showing.next.setEnabled(true);
            } else {
//                System.out.println(ids.subList(0, counter));
                Showing.previous.setEnabled(false);

            }
        } catch (Exception e) {
        }
    }

    class features {

        private int getImgCounts() {
            con = Connect.connect();
            try {
                String query1 = "select count(imgid) from app.imgs";
                rs = con.prepareStatement(query1).executeQuery();
                rs.next();
                return rs.getInt(1);
            } catch (Exception e) {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("select imgclass from app.imgs where imgclass like ").append("'%").append(123).append("%'");
        System.out.println(sb);
    }

}
