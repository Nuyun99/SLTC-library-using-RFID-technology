import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.sql.*;

public class authBook extends Thread {
    JFrame frame ;
    short test;
    String bk01rfid="";
    String rfidKey = "";
    JTextField rfidField01 , rfidField02;

    public authBook(JFrame frame, short test, String userRfid) {
        this.frame = frame;
        this.test = test;
        rfidField01 = new JTextField();
        rfidField01.setForeground(new Color(0x5B6C8B));
        rfidField01.setBounds(42, 300, 323, 39);
        rfidField01.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
        rfidField01.setCaretColor(new Color(0x5B6C8B));
        rfidField01.setBackground(new Color(0x5B6C8B));
        rfidField01.setSelectedTextColor(new Color(0x5B6C8B));
        rfidField01.setSelectionColor(new Color(0x5B6C8B));
        rfidField01.setBorder(null);
        rfidField01.setDocument(new libMethod.JTextFieldLimitFun(10));

        frame.add(rfidField01);
        rfidField01.setColumns(10);
        rfidField01.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                if (rfidField01.getText().length() == 10) {
                    rfidKey = rfidField01.getText();
                }
//                frame.dispose();
//                new userPanel(userRfid);
            }
            public void removeUpdate(DocumentEvent e) {
//                frame.dispose();
//                new userPanel(userRfid);
            }
            public void insertUpdate(DocumentEvent e) {
                if (rfidField01.getText().length() == 10) {
                    rfidKey = rfidField01.getText();
                }
            }
        });

        rfidField02 = new JTextField();
        rfidField02.setForeground(new Color(0x5B6C8B));
        rfidField02.setBounds(1000, 300, 323, 39);
        rfidField02.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
        rfidField02.setCaretColor(new Color(0x5B6C8B));
        rfidField02.setBackground(new Color(0x5B6C8B));
        rfidField02.setSelectedTextColor(new Color(0x5B6C8B));
        rfidField02.setSelectionColor(new Color(0x5B6C8B));
        rfidField02.setBorder(null);
        rfidField02.setDocument(new libMethod.JTextFieldLimitFun(10));
        frame.add(rfidField02);
        rfidField02.setColumns(10);
        rfidField02.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                if (rfidField02.getText().length() == 10) {
                    rfidKey = rfidField02.getText();
                }
//                frame.dispose();
//                new userPanel(userRfid);
            }
            public void removeUpdate(DocumentEvent e) {
//                frame.dispose();
//                new userPanel(userRfid);
            }
            public void insertUpdate(DocumentEvent e) {
                if (rfidField02.getText().length() == 10) {
                    rfidKey = rfidField02.getText();
                }
            }
        });
        frame.setVisible(true);
    }
    @Override
    public void run() {
        try {
            boolean bk01Done = false;
            boolean bk02Done= false;
            rfidKey = "";
            rfidField01.requestFocus();
            while (true) {
                sleep(1000);
                System.out.println("running");
                if (bk01Done && bk02Done)
                    stop();

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
                            rfidKey = "";
                            rfidField02.selectAll();
                            continue;
                        }
                        byte[] image = null;
                        image = rs.getBytes("bookImg");
                        Image img = Toolkit.getDefaultToolkit().createImage(image);
                        ImageIcon bkcover = libMethod.scaledImg(img,263,339);
                        if (rs.getString("Availability").equals("1") && test == 0) {
                            //JOptionPane.showMessageDialog(frame, "book Authenticated");
                            if (!bk01Done) {
                                // for book 01
                                bk01rfid=rfidKey;
                                lendBook.setBook01(rfidKey,bkcover);
                                bk01Done =true;
                                rfidKey = "";
                                rfidField02.requestFocus();
                            } else {
                                //for book 2
                                lendBook.setBook02(rfidKey,bkcover);
                                bk02Done =true;
                            }
                        }
                        else if (rs.getString("Availability").equals("0") && test == 1) {
                            //JOptionPane.showMessageDialog(frame, "book Authenticated");

                            if (!bk01Done) {
                                // for book 01
                                bk01rfid=rfidKey;
                                returnBook.setBook01(rfidKey,bkcover);
                                bk01Done =true;
                                rfidKey = "";
                                rfidField02.requestFocus();
                            } else {
                                //for book 2
                                returnBook.setBook02(rfidKey,bkcover);
                                bk02Done =true;

                            }
                        }else if (rs.getString("Availability").equals("0") && test == 2){
                            //JOptionPane.showMessageDialog(frame, "book Authenticated");
                            if (!bk01Done) {
                                // for book 01
                                bk01rfid=rfidKey;
                                extendbook.setBook01(rfidKey,bkcover);
                                bk01Done =true;
                                rfidKey = "";
                                rfidField02.requestFocus();
                            } else {
                                //for book 2
                                extendbook.setBook02(rfidKey,bkcover);
                                bk02Done =true;

                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(frame, "Enter Valid Book");
                            rfidKey = "";
                            if (!bk01Done){
                                rfidField01.selectAll();
                            }else
                                rfidField02.selectAll();

                        }
                    }
                    else if (!rfidKey.equals("")){
                        JOptionPane.showMessageDialog(frame, "Enter Valid Bookssss");
                        rfidKey = "";
                        if (!bk01Done){
                            rfidField01.selectAll();
                        }else
                            rfidField02.selectAll();

                    }
                }


            }
        } catch (SQLException | ClassNotFoundException | InterruptedException throwable) {
            throwable.printStackTrace();
        }
    }
}
