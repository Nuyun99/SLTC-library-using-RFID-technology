import javax.swing.*;
import java.sql.*;

public class user {
    private String userName;
    private String userRfid;
    private String email;
    private String phoneNo;
    private String graduateYear;
    private String address;
    private String nic;
    private String dgree;
    private String totalpanalty;
    private String curtLendedBooks;

    public user(String userRfid) {
        this.userRfid = userRfid;
    }

    protected void getInfo(String RFID){
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
                System.out.println("User Current Lended Books : "+curtLendedBooks);
            }
            else{
                JOptionPane.showMessageDialog(null, "No Matching Found");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public String getUserName() {
        return userName;
    }

    public String getUserRfid() {
        return userRfid;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getGraduateYear() {
        return graduateYear;
    }

    public String getAddress() {
        return address;
    }

    public String getNic() {
        return nic;
    }

    public String getDgree() {
        return dgree;
    }

    public String getTotalpanalty() {
        return totalpanalty;
    }

    public String getCurtLendedBooks() {
        return curtLendedBooks;
    }
}
