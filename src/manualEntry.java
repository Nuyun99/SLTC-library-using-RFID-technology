

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;

public class manualEntry extends JFrame implements ActionListener {
	
	JTextField nameText;
	JTextField emailText;
	JTextField addressText;
	JTextField searchText;
	JTextField phoneText;
	JTextField yearText;
	JTextField nicText;
	JTextField dgreeText;
	JButton backBtn;
	JButton srchBtn;
	JButton visitBtn;
	private JPasswordField rfidPassfield;
	JLabel usrImgLabel;

	ImageIcon usr = libMethod.scaledImg("user.png",100,100);

	manualEntry(){
		
		frontEnd();
	}
	
	/*all front end components and methods declared under this*/
	
	public void frontEnd(){
		
		getContentPane().setBackground(new Color(0x5b6c8b));

		ImageIcon visit = new ImageIcon("goto.png");
		ImageIcon src = new ImageIcon("src.png");
		ImageIcon back = libMethod.scaledImg("back.png",30,30);

		this.setBounds(100, 100, 895, 664);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);//this set center our frame
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 904, 124);
		panel.setBackground(new Color(0xF50097EE));
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel upperLabel = new JLabel("Manual User Entries");
		upperLabel.setForeground(Color.WHITE);
		upperLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 53));
		upperLabel.setBounds(240, 29, 449, 64);
		panel.add(upperLabel);

		usrImgLabel = new JLabel();
		usrImgLabel.setBounds(129, 13, 100, 100);
		usrImgLabel.setIcon(usr); //set icon method need to pass get icon
		panel.add(usrImgLabel);

		backBtn = new JButton();
		backBtn.setFocusable(false);
		backBtn.setBorder(null);
		backBtn.addActionListener(this);
		backBtn.setBackground(new Color(0xF50097EE));
		backBtn.setIcon(back);
		backBtn.setBounds(5, 5, 30, 30);
		panel.add(backBtn);

		JLabel nameLabel = new JLabel("Name");
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		nameLabel.setBounds(78, 251, 60, 13);
		getContentPane().add(nameLabel);

		nameText = new JTextField();
		nameText.setForeground(Color.WHITE);
		nameText.setColumns(10);
		nameText.setBorder(new LineBorder(Color.BLACK, 2));
		nameText.setBackground(new Color(0x5B6C8B));
		nameText.setBounds(78, 281, 290, 29);
		nameText.setEditable(false);//disable editing text field
		getContentPane().add(nameText);

		JLabel emailLabel = new JLabel("University Email");
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		emailLabel.setBounds(78, 343, 139, 13);
		getContentPane().add(emailLabel);

		emailText = new JTextField();
		emailText.setForeground(Color.WHITE);
		emailText.setColumns(10);
		emailText.setBorder(new LineBorder(Color.BLACK, 2));
		emailText.setBackground(new Color(0x5B6C8B));
		emailText.setBounds(78, 373, 290, 29);
		emailText.setEditable(false);//disable editing text field
		getContentPane().add(emailText);

		addressText = new JTextField();
		addressText.setForeground(Color.WHITE);
		addressText.setColumns(10);
		addressText.setBorder(new LineBorder(Color.BLACK, 2));
		addressText.setBackground(new Color(0x5B6C8B));
		addressText.setBounds(78, 460, 290, 29);
		addressText.setEditable(false);//disable editing text field
		getContentPane().add(addressText);

		JLabel addressLabel = new JLabel("Address");
		addressLabel.setForeground(Color.WHITE);
		addressLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		addressLabel.setBounds(78, 430, 76, 13);
		getContentPane().add(addressLabel);

		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.WHITE);
		bottomPanel.setBounds(0, 125, 895, 71);
		getContentPane().add(bottomPanel);
		bottomPanel.setLayout(null);

		searchText = new JTextField();
		searchText.setText("Enter NIC Number");

		searchText.addMouseListener(new MouseAdapter(){//from this method whenever user click on text field already set text will dissapear
			@Override
			public void mouseClicked(MouseEvent e){
				searchText.setText("");
			}
		});
		searchText.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		searchText.setForeground(Color.BLACK);
		searchText.setColumns(10);
		searchText.setBorder(null);
		searchText.setBackground(Color.WHITE);
		searchText.setBounds(343, 22, 171, 29);
		bottomPanel.add(searchText);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(343, 51, 171, 10);
		bottomPanel.add(separator);

		srchBtn = new JButton();
		srchBtn.setBackground(Color.WHITE);
		srchBtn.setBorder(null);
		srchBtn.setIcon(src);
		srchBtn.setFocusable(false);
		srchBtn.setBounds(529, 22, 32, 32);
		srchBtn.addActionListener(this);
		bottomPanel.add(srchBtn);

		JLabel phoneLabel = new JLabel("Phone Number");
		phoneLabel.setForeground(Color.WHITE);
		phoneLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		phoneLabel.setBounds(78, 517, 122, 13);
		getContentPane().add(phoneLabel);

		phoneText = new JTextField();
		phoneText.setForeground(Color.WHITE);
		phoneText.setColumns(10);
		phoneText.setBorder(new LineBorder(Color.BLACK, 2));
		phoneText.setBackground(new Color(0x5B6C8B));
		phoneText.setBounds(78, 542, 290, 29);
		phoneText.setEditable(false);//disable editing text field
		getContentPane().add(phoneText);

		JLabel yearLabel = new JLabel("Graduate Year");
		yearLabel.setForeground(Color.WHITE);
		yearLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		yearLabel.setBounds(469, 251, 122, 13);
		getContentPane().add(yearLabel);

		yearText = new JTextField();
		yearText.setForeground(Color.WHITE);
		yearText.setColumns(10);
		yearText.setBorder(new LineBorder(Color.BLACK, 2));
		yearText.setBackground(new Color(0x5B6C8B));
		yearText.setBounds(469, 281, 290, 29);
		yearText.setEditable(false);//disable editing text field
		getContentPane().add(yearText);

		JLabel nicLabel = new JLabel("NIC ");
		nicLabel.setForeground(Color.WHITE);
		nicLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		nicLabel.setBounds(469, 343, 60, 13);
		getContentPane().add(nicLabel);

		nicText = new JTextField();
		nicText.setForeground(Color.WHITE);
		nicText.setColumns(10);
		nicText.setBorder(new LineBorder(Color.BLACK, 2));
		nicText.setBackground(new Color(0x5B6C8B));
		nicText.setBounds(469, 373, 290, 29);
		nicText.setEditable(false);//disable editing text field
		getContentPane().add(nicText);

		JLabel rfidLabel = new JLabel("Rfid No");
		rfidLabel.setForeground(Color.WHITE);
		rfidLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		rfidLabel.setBounds(469, 519, 122, 13);
		getContentPane().add(rfidLabel);
		
		//get degree as text field since all boxes disabled
		dgreeText = new JTextField();
		dgreeText.setForeground(Color.WHITE);
		dgreeText.setColumns(10);
		dgreeText.setBorder(new LineBorder(Color.BLACK, 2));
		dgreeText.setBackground(new Color(91, 108, 139));
		dgreeText.setBounds(469, 460, 290, 29);
		dgreeText.setEditable(false);//disable editing text field
		getContentPane().add(dgreeText);

		visitBtn = new JButton("VISIT USER PANEL");
		visitBtn.setIcon(visit);
		visitBtn.setForeground(Color.WHITE);
		visitBtn.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		visitBtn.setFocusable(false);
		visitBtn.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		visitBtn.setBackground(new Color(0x3edad8));
		visitBtn.setBounds(346, 605, 183, 37);
		visitBtn.addActionListener(this);
		
		getContentPane().add(visitBtn);
		
		JLabel degreeLabel = new JLabel("Degree Program");
		degreeLabel.setForeground(Color.WHITE);
		degreeLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		degreeLabel.setBounds(469, 427, 136, 22);
		getContentPane().add(degreeLabel);
		
		//rfid text field as password field since librarian couldn't see it due to user privacy
		rfidPassfield = new JPasswordField();
		rfidPassfield.setBounds(469, 542, 290, 29);
		rfidPassfield.setBackground(new Color(91, 108, 139));
		rfidPassfield.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		rfidPassfield.setEditable(false);//disable editing text field
		getContentPane().add(rfidPassfield);
		
		//String [] degrees = {"Engineering School","IT And Computing School","Technology School","Business School","Music School"};

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backBtn) {
            this.dispose();
            new adminview();
        }
		if(e.getSource()==srchBtn) {
			if(((searchText.getText().contains("V") || searchText.getText().length() == 12) && searchText.getText().length() >= 10)){
				try{
					Class.forName("java.sql.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbproject","harindu123","Zyco@123fuckinggood");
					Statement stmt = con.createStatement();
					String qry = "SELECT * FROM `user_table` WHERE `NIC` = '" + searchText.getText() + "';";
					System.out.println("Searched SQL query: " + qry);
					ResultSet rs = stmt.executeQuery(qry);
					if (rs.next()) {
						nameText.setText(rs.getString("User Name"));
						emailText.setText(rs.getString("E-mail"));
						addressText.setText(rs.getString("Address"));
						phoneText.setText(rs.getString("phone_Number"));
						yearText.setText(rs.getString("Graduate_Year").substring(0,4));
						nicText.setText(rs.getString("NIC"));
						dgreeText.setText(rs.getString("Dgree"));
						rfidPassfield.setText(rs.getString("RFID_NO"));
//						String totalPanalty = rs.getString("TotalPanalty");
//						String lendedBooks = rs.getString("currentLendedBooks");
//						byte[] image = null;
//						image = rs.getBytes("userImg");
//						Image img = Toolkit.getDefaultToolkit().createImage(image);
//						usrImgLabel.setIcon(libMethod.scaledImg(img,100,100));
//						usrImgLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, null, null, null));
						//usrImgLabel.setIcon(libMethod.getRoundImg(libMethod.resize(ImageIO.read(rs.getBinaryStream("userImg")), 100, 100)));
						usrImgLabel.setIcon(libMethod.ScaleSmooth(libMethod.getRoundImg(libMethod.resize(ImageIO.read(rs.getBinaryStream("userImg")), 100, 100)),100,100));
						JOptionPane.showMessageDialog(null, "Generated SQL query: " + qry);
						this.setVisible(true);
					}else{
						nameText.setText("");
						emailText.setText("");
						addressText.setText("");
						phoneText.setText("");
						yearText.setText("");
						nicText.setText("");
						dgreeText.setText("");
						rfidPassfield.setText("");
						usrImgLabel.setIcon(usr);
						usrImgLabel.setBorder(null);
						JOptionPane.showMessageDialog(null, "No Matching Found");
					}
				}catch(Exception exception){
					JOptionPane.showMessageDialog(null, "Error in Connectivity");
					System.out.println(exception.getLocalizedMessage());
				}
			}else{
				nameText.setText("");
				emailText.setText("");
				addressText.setText("");
				phoneText.setText("");
				yearText.setText("");
				nicText.setText("");
				dgreeText.setText("");
				rfidPassfield.setText("");
				usrImgLabel.setIcon(usr);
				usrImgLabel.setBorder(null);
				JOptionPane.showMessageDialog(null, "Enter Valid Email or NIC Number");
			}
		}

		if(e.getSource()==visitBtn) {
            this.dispose();
            new userPanel(rfidPassfield.getText());
        }
	}
}
