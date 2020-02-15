package model;

import controller.Advanced;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.apache.derby.shared.common.error.DerbySQLIntegrityConstraintViolationException;

public class InsertDB {

    private static final InsertDB idbObj = new InsertDB();
    private PreparedStatement ps;
    private Icon imgProp;
    private Connection con = null;
    static String iname, iclass, iext, query;
    static int insertedImg = 0;

    private InsertDB() {
        con = Connect.connect();
    }

    public static InsertDB getInstance() {
        return idbObj;
    }

    public void insertImage(String folderPath) {  // for end user
        initProperties(folderPath);
    }

    /**
     * method is used to init the method params it take path then it get image
     * name and get image class the it<br>
     * get image extension and then it throw them to another method  <br>
     *
     * @param folderPath the path of the folder that the image found inner it.
     */
    private void initProperties(String folderPath) {  //middle between user and exact insertion
        try {
            File[] files = new File(folderPath).listFiles();    //Files.list(Paths.get(folderPath));;
            Arrays.stream(files).forEach(pathFile -> {
                if (pathFile.isDirectory()) {
                    initProperties(pathFile.toString());
                } else {
                    iname = pathFile.getName().substring(0, pathFile.getName().lastIndexOf("."));
                    iclass = pathFile.getParent().substring(pathFile.getParent().lastIndexOf("\\") + 1);
                    iext = pathFile.getName().substring(pathFile.getName().lastIndexOf(".") + 1);
                    insertImage(pathFile.toString(), iname.toLowerCase(), iclass.toLowerCase(), iext.toLowerCase());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * this method is the real insertion to DB so that it take some Params
     * attached to the image <br>
     *
     * @param path the path of the image that image stored it it.
     * @param iname name of the image.
     * @param iclass the class (classification) of the image.
     * @param iext extension of the image.
     */
    private void insertImage(String path, String iname, String iclass, String iext) {
        try {
            query = "insert into app.imgs (imgid,img,imgname,imgclass,checksum,width,height,ext) values (?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            byte[] image = Files.readAllBytes(Paths.get(path));
            ps.setInt(1, Advanced.generateInteger());
            ps.setBytes(2, image);
            ps.setString(3, iname);
            ps.setString(4, iclass);
            ps.setString(5, Advanced.checkSum(path));
            imgProp = new ImageIcon(path);
            ps.setInt(6, imgProp.getIconWidth());
            ps.setInt(7, imgProp.getIconHeight());
            ps.setString(8, iext);
            ps.execute();
            System.out.println("Complete insertion=" + ++insertedImg);
        } catch (DerbySQLIntegrityConstraintViolationException e) {
            System.out.println("prevent dupication=" + iname);
        } catch (SQLException | IOException | HeadlessException e) {
            e.printStackTrace();
        }

    }

     

}
