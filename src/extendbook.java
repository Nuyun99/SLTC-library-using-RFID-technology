import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class extendbook extends JFrame implements ActionListener {


    private static book b1 = new book();
    private static book b2 = new book();
    private static JTextField bk01Text;
    private static JTextField bk01AuthText;
    private String userRfid;
    private static String bookRfid1 ;
    private static String bookRfid2 ;

    private static JTextField bk02Text;
    private static JTextField bk02AuthText;
    private JButton backBtn;
    private JButton extendButton;
    private Float penalty = 0f;
    authBook auth1;

    public static void setBkText01(String bookrfid1){
        b1.getInfo(bookrfid1);
        bk01Text.setText(b1.getBookName());
        bk01AuthText.setText(b1.getBookAuthor());
        bookRfid1 = bookrfid1;
    }
    public static void setBkText02(String bookrfid2){
        b2.getInfo(bookrfid2);
        bk02Text.setText(b2.getBookName());
        bk02AuthText.setText(b2.getBookAuthor());
        bookRfid2 = bookrfid2;
    }

    public extendbook(String usrRfid) {
        this.userRfid = usrRfid;
        initialize();
        System.out.println(" user RFID "+userRfid);
        this.setVisible(true);
        auth1 = new authBook(this, (short) 2);
        auth1.start();

    }

    private void initialize() {

        ImageIcon lendImg = libMethod.scaledImg("handover.png",135,135);
        ImageIcon cover01 = libMethod.scaledImg("icons\\InterNetworking.png",262,336);
        ImageIcon cover02 = libMethod.scaledImg("icons\\Coding Interview.jpg",262,336);
        ImageIcon back = libMethod.scaledImg("back.png",30,30);

        this.setBounds(100, 100, 1920, 1080);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);//maximize both
        this.setUndecorated(true);//maximize both
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(0x5B6C8B));//CONTENT PANE COLOR
        getContentPane().setPreferredSize(new Dimension(1920, 1080));

        JPanel upperPannel = new JPanel();
        upperPannel.setLayout(null);
        upperPannel.setForeground(Color.WHITE);
        upperPannel.setBackground(new Color(0, 151, 238));
        upperPannel.setBounds(0, 0, 1920, 252);
        getContentPane().add(upperPannel);

        JLabel upperLabel = new JLabel("Extend Book");
        upperLabel.setForeground(Color.WHITE);
        upperLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 99));
        upperLabel.setBounds(628, 72, 510, 100);
        upperPannel.add(upperLabel);

        JLabel logoLabel = new JLabel();
        logoLabel.setBounds(452, 59, 135, 135);
        logoLabel.setIcon(lendImg);
        upperPannel.add(logoLabel);

        backBtn = new JButton();
        backBtn.setFocusable(false);
        backBtn.setBorder(null);
        backBtn.setBackground(new Color(0xF50097EE));
        backBtn.setIcon(back);
        backBtn.setBounds(5, 5, 30, 30);
        backBtn.addActionListener(this);
        upperPannel.add(backBtn);


        JLabel txtLabel = new JLabel("Place Book or Books Here");
        txtLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 40));
        txtLabel.setForeground(Color.WHITE);
        txtLabel.setBounds(562, 278, 447, 38);
        getContentPane().add(txtLabel);

        JLabel bookCov01 = new JLabel();
        bookCov01.setBackground(new Color(0x5B6C8B));
        bookCov01.setBounds(62, 368, 263, 339);
        bookCov01.setBorder(new LineBorder(new Color(0, 0, 0), 4));
        bookCov01.setIcon(cover01);
        bookCov01.setOpaque(true);
        getContentPane().add(bookCov01);

        JLabel bkoneLabel = new JLabel("Cover of Book 01 ");
        bkoneLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        bkoneLabel.setForeground(new Color(255, 255, 255));
        bkoneLabel.setBounds(118, 338, 166, 20);
        getContentPane().add(bkoneLabel);

        JLabel bktwoLabel = new JLabel("Cover of Book 02 ");
        bktwoLabel.setForeground(Color.WHITE);
        bktwoLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        bktwoLabel.setBounds(888, 338, 175, 20);
        getContentPane().add(bktwoLabel);

        JLabel bookCov02 = new JLabel();
        bookCov02.setBorder(new LineBorder(new Color(0, 0, 0), 4));
        bookCov02.setBackground(new Color(91, 108, 139));
        bookCov02.setBounds(827, 368, 263, 339);
        bookCov02.setIcon(cover02);
        getContentPane().add(bookCov02);

        JSeparator bk01Titleline = new JSeparator();
        bk01Titleline.setBackground(new Color(255, 255, 255));
        bk01Titleline.setBounds(363, 424, 329, 27);
        getContentPane().add(bk01Titleline);

        bk01Text = new JTextField();
        bk01Text.setBackground(new Color(91, 108, 139));
        bk01Text.setForeground(new Color(0, 0, 0));
        bk01Text.setBounds(363, 398, 329, 27);
        bk01Text.setBorder(null);
        bk01Text.setFont(new Font("Tahoma", Font.BOLD, 16));
        getContentPane().add(bk01Text);
        bk01Text.setColumns(10);

        JLabel bk01BookTitle = new JLabel("Book 01 Title");
        bk01BookTitle.setForeground(Color.WHITE);
        bk01BookTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
        bk01BookTitle.setBounds(363, 368, 135, 20);
        getContentPane().add(bk01BookTitle);

        JSeparator separator_1 = new JSeparator();
        separator_1.setOrientation(SwingConstants.VERTICAL);
        separator_1.setBackground(Color.WHITE);
        separator_1.setBounds(782, 338, 24, 428);
        getContentPane().add(separator_1);

        JLabel bk01BookAuthor = new JLabel("Book 01 Author");
        bk01BookAuthor.setForeground(Color.WHITE);
        bk01BookAuthor.setFont(new Font("Tahoma", Font.BOLD, 16));
        bk01BookAuthor.setBounds(363, 472, 135, 20);
        getContentPane().add(bk01BookAuthor);

        bk01AuthText = new JTextField();
        bk01AuthText.setColumns(10);
        bk01AuthText.setBorder(null);
        bk01AuthText.setBackground(new Color(91, 108, 139));
        bk01AuthText.setForeground(new Color(0, 0, 0));
        bk01AuthText.setBounds(363, 502, 329, 27);
        //bk01AuthText.setText("Douglas Comer");
        bk01AuthText.setFont(new Font("Tahoma", Font.BOLD, 16));
        getContentPane().add(bk01AuthText);

        JSeparator bk01AuthLine = new JSeparator();
        bk01AuthLine.setBackground(Color.WHITE);
        bk01AuthLine.setBounds(363, 528, 329, 27);
        getContentPane().add(bk01AuthLine);

        JLabel bk02BookTitle = new JLabel("Book 02 Title");
        bk02BookTitle.setForeground(Color.WHITE);
        bk02BookTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
        bk02BookTitle.setBounds(1128, 368, 135, 20);
        getContentPane().add(bk02BookTitle);

        bk02Text = new JTextField();
        bk02Text.setColumns(10);
        bk02Text.setBorder(null);
        bk02Text.setBackground(new Color(91, 108, 139));
        bk02Text.setBounds(1128, 398, 406, 27);
        //bk02Text.setText("Cracking the Coding Interview");
        bk02Text.setFont(new Font("Tahoma", Font.BOLD, 16));
        bk02Text.setForeground(new Color(0, 0, 0));
        getContentPane().add(bk02Text);

        JSeparator bk02Titleline = new JSeparator();
        bk02Titleline.setBackground(Color.WHITE);
        bk02Titleline.setBounds(1128, 424, 329, 27);
        getContentPane().add(bk02Titleline);

        JLabel bk02BookAuthor = new JLabel("Book 02 Author");
        bk02BookAuthor.setForeground(Color.WHITE);
        bk02BookAuthor.setFont(new Font("Tahoma", Font.BOLD, 16));
        bk02BookAuthor.setBounds(1128, 472, 135, 20);
        getContentPane().add(bk02BookAuthor);

        bk02AuthText = new JTextField();
        bk02AuthText.setColumns(10);
        bk02AuthText.setBorder(null);
        bk02AuthText.setBackground(new Color(91, 108, 139));
        bk02AuthText.setBounds(1128, 502, 329, 27);
        //bk02AuthText.setText("Gayle Laakmann McDowell");
        bk02AuthText.setForeground(new Color(0, 0, 0));
        bk02AuthText.setFont(new Font("Tahoma", Font.BOLD, 16));
        getContentPane().add(bk02AuthText);

        JSeparator bk02AuthLine = new JSeparator();
        bk02AuthLine.setBackground(Color.WHITE);
        bk02AuthLine.setBounds(1128, 528, 329, 27);
        getContentPane().add(bk02AuthLine);

        extendButton = new JButton("Extend the Book");
        extendButton.addActionListener(this);
        extendButton.setBounds(686, 784, 203, 51);
        extendButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        extendButton.setBackground(new Color(0x3edad8));
        getContentPane().add(extendButton);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == backBtn) {
            auth1.t1.stop();
            auth1.t2.stop();
            auth1.stop();
            this.dispose();
            new userPanel(userRfid);
        }
        if (e.getSource() == extendButton) {
            boolean b1 = false,b2 = false;
            user u1 = new user(userRfid);
            u1.getInfo(userRfid);

            if (bookRfid1 != null && !b1){
                try{
                    Class.forName("java.sql.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbproject","harindu123","Zyco@123fuckinggood");
                    Statement stmt = con.createStatement();
                    java.util.Date date=new java.util.Date();
                    java.sql.Timestamp sqlTimeStamp =new java.sql.Timestamp(date.getTime());

                    String qry1 = "SELECT * FROM `activity_table` WHERE `bookRFIDno` = '"+ bookRfid1 +"' AND `status` = 'OPEN';";
                    ResultSet activityRS = stmt.executeQuery(qry1);
                    String lenduserRfid = "";
                    if (activityRS.next()){
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date lendDate = df.parse(activityRS.getString("TimeStamp"));
                        java.util.Date returnedDate=new java.util.Date();
                        penalty = libMethod.calculatePenalty(returnedDate.getTime() - lendDate.getTime());
                        lenduserRfid = activityRS.getString("userRFIDno");
                    }

                    String qry = "UPDATE `activity_table` SET `status`='CLOSE' WHERE `bookRFIDno` = '"+ bookRfid1 +"' AND `status` = 'OPEN';";
                    stmt.executeUpdate(qry);
                    System.out.println("Generated SQL query: " + qry);

                    qry ="INSERT INTO `activity_table`(`TimeStamp`, `userRFIDno`, `bookRFIDno`, `panalty`, `Type`, `status`) VALUES ('"+sqlTimeStamp+"','"+userRfid+"','"+bookRfid1+"','"+penalty+"','EXTENDED','OPEN')";
                    stmt.executeUpdate(qry);
                    System.out.println("Generated SQL query: " + qry);

                    qry ="UPDATE `user_table` SET `TotalPanalty` = `TotalPanalty` + "+penalty+" WHERE `RFID_NO` ='"+lenduserRfid+"'; ";
                    stmt.executeUpdate(qry);
                    System.out.println("Generated SQL query: " + qry);

                    JOptionPane.showMessageDialog(null, "Book 01 Extended successful! \n You can see activity on \n Web Page.");
                    penalty = 0f;
                    b1 = true;
                    bk01Text.setText("");
                    bk01AuthText.setText("");
                }
                catch(Exception exception){
                    JOptionPane.showMessageDialog(null, "The process could not be completed due to some error. Please contact Librarian.");
                    System.out.println(exception.getLocalizedMessage());
                }
            }
            if(bookRfid2 != null && !b2){
                try{
                    Class.forName("java.sql.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbproject","harindu123","Zyco@123fuckinggood");
                    Statement stmt = con.createStatement();
                    java.util.Date date=new java.util.Date();
                    java.sql.Timestamp sqlTimeStamp =new java.sql.Timestamp(date.getTime());

                    String qry1 = "SELECT * FROM `activity_table` WHERE `bookRFIDno` = '"+ bookRfid2 +"' AND `status` = 'OPEN';";
                    ResultSet activityRS = stmt.executeQuery(qry1);
                    String lenduserRfid = "";
                    if (activityRS.next()){
                        //System.out.println(activityRS.getString("TimeStamp"));
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date lendDate = df.parse(activityRS.getString("TimeStamp"));
                        java.util.Date returnedDate=new java.util.Date();
                        penalty = libMethod.calculatePenalty(returnedDate.getTime() - lendDate.getTime());
                        lenduserRfid = activityRS.getString("userRFIDno");
                    }

                    String qry = "UPDATE `activity_table` SET `status`='CLOSE' WHERE `bookRFIDno` = '"+ bookRfid2 +"' AND `status` = 'OPEN';";
                    stmt.executeUpdate(qry);
                    System.out.println("Generated SQL query: " + qry);

                    qry ="INSERT INTO `activity_table`(`TimeStamp`, `userRFIDno`, `bookRFIDno`, `panalty`, `Type`, `status`) VALUES ('"+sqlTimeStamp+"','"+userRfid+"','"+bookRfid2+"','"+penalty+"','EXTENDED','OPEN')";
                    stmt.executeUpdate(qry);
                    System.out.println("Generated SQL query: " + qry);

                    qry ="UPDATE `user_table` SET `TotalPanalty` = `TotalPanalty` + "+penalty+" WHERE `RFID_NO` ='"+lenduserRfid+"'; ";
                    stmt.executeUpdate(qry);
                    System.out.println("Generated SQL query: " + qry);

                    JOptionPane.showMessageDialog(null, "Book 02 Extended successful! \n You can see activity on \n Web Page.");

                    penalty = 0f;
                    b2 = true;
                    bk02Text.setText("");
                    bk02AuthText.setText("");
                }
                catch(Exception exception){
                    JOptionPane.showMessageDialog(null, "The process could not be completed due to some error. Please contact Librarian.");
                    System.out.println(exception.getLocalizedMessage());
                }

            }
            if (b1 && b2) {
                this.dispose();
                new userPanel(userRfid);
            }else{
                if(bookRfid1 == null && bookRfid2 == null )
                    JOptionPane.showMessageDialog(null, "checks that books place on the RFID sensor");
                else if(bookRfid1 != null || bookRfid2 != null){
                    //System.out.println("helicopter");
                }else{
                    JOptionPane.showMessageDialog(null, "Please contact the Librarian");
                }
            }
        }

    }
}
