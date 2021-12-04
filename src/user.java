import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.*;

public class user {
    private static String userName;
    private static String userRfid;
    private static String email;
    private static String phoneNo;
    private static String graduateYear;
    private static String address;
    private static String nic;
    private static String dgree;
    private static String totalpanalty;
    private static String curtLendedBooks;
    private static BufferedImage userImage;


    public user(String userRfid) {
        this.userRfid = userRfid;
    }
    protected static void getInfo(String RFID){
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbproject", "harindu123", "Zyco@123fuckinggood");
            Statement stmt = con.createStatement();
            String qry = "SELECT * FROM `user_table` WHERE `RFID_NO` LIKE '%" + RFID + "%';";
            System.out.println("Searched SQL query: " + qry);
            ResultSet rs = stmt.executeQuery(qry);
            if (rs.next()) {
                userName= rs.getString("User Name");
                email= rs.getString("E-mail");
                phoneNo = rs.getString("phone_Number");
                graduateYear = rs.getString("Graduate_Year");
                userRfid = rs.getString("RFID_NO");
                address = rs.getString("Address");
                nic = rs.getString("NIC");
                dgree = rs.getString("Dgree");
                totalpanalty = rs.getString("TotalPanalty");
                curtLendedBooks = rs.getString("currentLendedBooks");
                userImage = libMethod.resize(ImageIO.read(rs.getBinaryStream("userImg")),64,64);
            }
            else{
                JOptionPane.showMessageDialog(null, "No Matching Found");
                userName= "";
                email= "";
                phoneNo = "";
                graduateYear = "";
                userRfid = "";
                address = "";
                nic = "";
                dgree = "";
                totalpanalty = "";
                curtLendedBooks = "";
            }
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUserName() {
        return userName;
    }

    public static String getUserRfid() {
        return userRfid;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPhoneNo() {
        return phoneNo;
    }

    public static String getGraduateYear() {
        return graduateYear;
    }

    public static String getAddress() {
        return address;
    }

    public static String getNic() {
        return nic;
    }

    public static String getDgree() {
        return dgree;
    }

    public static String getTotalpanalty() {
        return totalpanalty;
    }

    public static String getCurtLendedBooks() {
        return curtLendedBooks;
    }

    public static BufferedImage getUserImage() {return userImage; }
}
