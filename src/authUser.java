import javax.swing.*;
import java.sql.*;

public class authUser extends Thread {
    JFrame frame;

    public authUser(JFrame frame) {
        this.frame = frame;
    }

    RFID_Reader t1;
    @Override
    public void run() {
        try {
            String rfidKey = "";
            t1 = new RFID_Reader();
            t1.start();
            while (true) {
                sleep(1000);
                rfidKey = t1.getRFIDnumber();
                if (!rfidKey.equals("")) {
                    Class.forName("java.sql.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbproject", "harindu123", "Zyco@123fuckinggood");
                    Statement stmt = con.createStatement();
                    String qry = "SELECT * FROM `user_table` WHERE `RFID_NO` LIKE '" + rfidKey + "';";
                    System.out.println("Searched SQL query: " + qry);
                    ResultSet rs = stmt.executeQuery(qry);
                    if (rs.next()) {
                        if (rs.getString("RFID_NO").equals(rfidKey)) {
                            JOptionPane.showMessageDialog(frame, "User Authenticated");
                            frame.dispose();
                            t1.stop();
                            new userPanel();
                            stop();
                            break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Access Denied");
                        frame.dispose();
                        t1.stop();
                        new adminpanel();
                        stop();
                        break;
                    }
                }
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
