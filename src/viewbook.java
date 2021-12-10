import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class viewbook extends JFrame implements ActionListener{
    JTextField booktitleText;
    JTextField authorText;
    JTextField bookgnrText;
    JTextField editionText;
    JButton closeBtn;
    JTextArea aboutTextArea;
    JLabel bkImgCover;
    private JTextField textField;
    private JTextField textField_1;
    private String bookRFID;

    public viewbook(String bkRfid) {
        this.bookRFID = bkRfid;
        initialize();
        setData();
        this.setVisible(true);
    }
    private void setData(){
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbproject", "harindu123", "Zyco@123fuckinggood");
            Statement stmt = con.createStatement();
            String qry = "SELECT * FROM `book_table` WHERE `RFID_NO` LIKE '%" + bookRFID + "%';";
            System.out.println("Searched SQL query: " + qry);
            ResultSet rs = stmt.executeQuery(qry);
            byte[] image = null;
            boolean matchingFound = false;
            int i=0;
            while (rs.next()) {
                //have to get byte image from data_base.
                image = rs.getBytes("bookImg");
                Image img = Toolkit.getDefaultToolkit().createImage(image);
                ImageIcon test = libMethod.scaledImg(img,330,439);
                bkImgCover.setIcon(test);
                booktitleText.setText("  "+rs.getString("Book Title"));
                authorText.setText("  "+rs.getString("Book Author"));
                bookgnrText.setText("  "+rs.getString("Genre"));
                editionText.setText("  "+rs.getString("Edition"));
                textField.setText("  "+rs.getString("Rack Number"));
                textField_1.setText("  "+rs.getString("Section"));
                aboutTextArea.setText("  "+rs.getString("About"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void initialize() {
        ImageIcon closeImg = libMethod.scaledImg("cancel.png",40,40);
        ImageIcon usr = new ImageIcon("search.png");
        this.setBounds(100, 100, 895, 664);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        //this.setResizable(true);
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0x5B6C8B));
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 904, 124);
        panel.setBackground(new Color(0xF50097EE));
        getContentPane().add(panel);
        panel.setLayout(null);

        closeBtn = new JButton();//close button
        closeBtn.setBounds(849, 9, 40, 40);
        closeBtn.setFocusable(false);
        closeBtn.setBackground(new Color(0xF50097EE));
        closeBtn.setBorder(null);
        closeBtn.addActionListener(this);
        closeBtn.setIcon(closeImg);
        closeBtn.setOpaque(true);
        panel.add(closeBtn);

        JLabel imgLabel = new JLabel();
        imgLabel.setBounds(223, 29, 64, 64);
        imgLabel.setIcon(usr);
        panel.add(imgLabel);

        JLabel upperLabel = new JLabel("View Book");
        upperLabel.setBounds(0, 2, 894, 122);
        panel.add(upperLabel);
        upperLabel.setHorizontalAlignment(SwingConstants.CENTER);
        upperLabel.setForeground(Color.WHITE);
        upperLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 56));

        bkImgCover = new JLabel("");
        bkImgCover.setBounds(36, 143, 330, 439);
        bkImgCover.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(100, 149, 237), new Color(100, 149, 237), new Color(100, 149, 237), new Color(100, 149, 237)));
        getContentPane().add(bkImgCover);

        booktitleText = new JTextField();
        booktitleText.setBounds(534, 142, 319, 29);
        booktitleText.setForeground(Color.WHITE);
        booktitleText.setColumns(10);
        booktitleText.setBorder(new LineBorder(Color.BLACK, 2));
        booktitleText.setBackground(new Color(0x5B6C8B));
        getContentPane().add(booktitleText);

        JLabel bookTitleLabel = new JLabel("Book Title");
        bookTitleLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        bookTitleLabel.setBounds(401, 142, 95, 29);
        bookTitleLabel.setForeground(Color.WHITE);
        bookTitleLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        getContentPane().add(bookTitleLabel);

        authorText = new JTextField();
        authorText.setBounds(534, 194, 319, 29);
        authorText.setForeground(Color.WHITE);
        authorText.setColumns(10);
        authorText.setBorder(new LineBorder(Color.BLACK, 2));
        authorText.setBackground(new Color(0x5B6C8B));
        getContentPane().add(authorText);

        JLabel authorLabel = new JLabel("Book Author");
        authorLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        authorLabel.setBounds(401, 194, 110, 29);
        authorLabel.setForeground(Color.WHITE);
        authorLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        getContentPane().add(authorLabel);

        bookgnrText = new JTextField();
        bookgnrText.setBounds(534, 249, 319, 29);
        bookgnrText.setForeground(Color.WHITE);
        bookgnrText.setColumns(10);
        bookgnrText.setBorder(new LineBorder(Color.BLACK, 2));
        bookgnrText.setBackground(new Color(91, 108, 139));
        getContentPane().add(bookgnrText);

        JLabel bookgnrLabel = new JLabel("Book Genre");
        bookgnrLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        bookgnrLabel.setBounds(401, 249, 95, 29);
        bookgnrLabel.setForeground(Color.WHITE);
        bookgnrLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        getContentPane().add(bookgnrLabel);

        JLabel editionLabel = new JLabel("Edition");
        editionLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        editionLabel.setBounds(401, 303, 82, 29);
        editionLabel.setForeground(Color.WHITE);
        editionLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        getContentPane().add(editionLabel);

        editionText = new JTextField();
        editionText.setBounds(534, 303, 319, 29);
        editionText.setForeground(Color.WHITE);
        editionText.setColumns(10);
        editionText.setBorder(new LineBorder(Color.BLACK, 2));
        editionText.setBackground(new Color(0x5B6C8B));
        getContentPane().add(editionText);

        textField = new JTextField();
        textField.setForeground(Color.WHITE);
        textField.setColumns(10);
        textField.setBorder(new LineBorder(Color.BLACK, 2));
        textField.setBackground(new Color(91, 108, 139));
        textField.setBounds(534, 360, 319, 29);
        getContentPane().add(textField);

        JLabel rackLabel = new JLabel("Rack Number");
        rackLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        rackLabel.setForeground(Color.WHITE);
        rackLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        rackLabel.setBounds(401, 360, 110, 29);
        getContentPane().add(rackLabel);

        JLabel sectionLabel = new JLabel("Section");
        sectionLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        sectionLabel.setForeground(Color.WHITE);
        sectionLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        sectionLabel.setBounds(401, 427, 60, 29);
        getContentPane().add(sectionLabel);

        textField_1 = new JTextField();
        textField_1.setForeground(Color.WHITE);
        textField_1.setColumns(10);
        textField_1.setBorder(new LineBorder(Color.BLACK, 2));
        textField_1.setBackground(new Color(91, 108, 139));
        textField_1.setBounds(534, 427, 319, 29);
        getContentPane().add(textField_1);

        JLabel aboutLabel = new JLabel("About");
        aboutLabel.setForeground(Color.WHITE);
        aboutLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        aboutLabel.setBounds(401, 495, 82, 29);
        getContentPane().add(aboutLabel);

        aboutTextArea = new JTextArea();
        aboutTextArea.setBorder(new LineBorder(Color.BLACK, 2));
        aboutTextArea.setBackground(new Color(91, 108, 139));
        aboutTextArea.setForeground(new Color(229, 229, 229));
        aboutTextArea.setBounds(534, 495, 319, 142);
        getContentPane().add(aboutTextArea);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == closeBtn){
            this.dispose();
        }

    }

}

