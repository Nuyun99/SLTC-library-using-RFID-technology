import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class authBook extends Thread {
    JFrame frame ;
    short test;
    String bk01rfid="";

    public authBook(JFrame frame, short test) {
        this.frame = frame;
        this.test = test;
    }

    RFID_Reader t1,t2;
    @Override
    public void run() {
        try {
            String rfidKey = "";
            t1 = new RFID_Reader(false);
            t2 = new RFID_Reader(false);
            t1.start();
            int count=0;
            while (true) {
                sleep(1000);

                if(t1.isAlive())
                    rfidKey = t1.getRFIDnumber();
                else
                    rfidKey = t2.getRFIDnumber();
                if(count > 1){
                    t1.stop();
                    t2.stop();
                    stop();
                    break;
                }
                if (!rfidKey.equals("")) {
                    Class.forName("java.sql.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbproject", "harindu123", "Zyco@123fuckinggood");
                    Statement stmt = con.createStatement();
                    String qry = "SELECT * FROM `book_table` WHERE `RFID_NO` LIKE '" + rfidKey + "';";
                    System.out.println("Searched SQL query: " + qry);
                    ResultSet rs = stmt.executeQuery(qry);
                    if (rs.next()) {
                        if (bk01rfid.equals(rfidKey)){
                            JOptionPane.showMessageDialog(frame, "You Cannot Lend Same Book twice");
                            continue;
                        }
                        byte[] image = null;
                        image = rs.getBytes("bookImg");
                        Image img = Toolkit.getDefaultToolkit().createImage(image);
                        ImageIcon bkcover = libMethod.scaledImg(img,263,339);
                        if (rs.getString("Availability").equals("1") && test == 0) {
                            JOptionPane.showMessageDialog(frame, "book Authenticated");
                            count++;

                            if (count == 1) {
                                // for book 01
                                bk01rfid=rfidKey;
                                lendBook.setBook01(rfidKey,bkcover);
                                t1.stop();
                                t2.start();
                            } else {
                                //for book 2
                                lendBook.setBook02(rfidKey,bkcover);
                                t2.stop();
                                stop();
                            }
                        }
                        else if (rs.getString("Availability").equals("0") && test == 1) {
                            JOptionPane.showMessageDialog(frame, "book Authenticated");
                            count++;
                            if (count == 1) {
                                // for book 01
                                bk01rfid=rfidKey;
                                returnBook.setBook01(rfidKey,bkcover);
                                t1.stop();
                                t2.start();
                            } else {
                                //for book 2
                                returnBook.setBook02(rfidKey,bkcover);
                                t2.stop();
                                stop();
                            }
                        }else if (rs.getString("Availability").equals("0") && test == 2){
                            JOptionPane.showMessageDialog(frame, "book Authenticated");
                            count++;
                            if (count == 1) {
                                // for book 01
                                bk01rfid=rfidKey;
                                extendbook.setBook01(rfidKey,bkcover);
                                t1.stop();
                                t2.start();
                            } else {
                                //for book 2
                                extendbook.setBook02(rfidKey,bkcover);
                                t2.stop();
                                stop();
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(frame, "Enter Valid Book");
                        }
                    }
                }


            }
        } catch (SQLException | ClassNotFoundException | InterruptedException throwable) {
            throwable.printStackTrace();
        }
    }
}
