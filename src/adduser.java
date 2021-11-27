import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JComboBox;

public class adduser extends JFrame implements ActionListener{
	
	/*whenever extract text in text field make sure use below JTextField Variables*/
	
	JTextField nameText;
	JTextField emailText;
	JTextField addressText;
	JTextField rfidText;
	JTextField phoneText;
	JTextField yearText;
	JTextField nicText;
	JComboBox degreeBox;//drob down box
	JButton backBtn;
	JButton genarateBtn;

	
	JButton submitBtn;

	adduser(){
		
		getContentPane().setBackground(new Color(0x5b6c8b));
		
		ImageIcon usr = new ImageIcon("largenewuser.png");
		
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
		
		JLabel upperLabel = new JLabel("Add New User");
		upperLabel.setForeground(Color.WHITE);
		upperLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 53));
		upperLabel.setBounds(298, 29, 364, 64);
		panel.add(upperLabel);
		
		JLabel imgLabel = new JLabel();
		imgLabel.setBounds(173, 29, 64, 64);
		imgLabel.setIcon(usr);
		panel.add(imgLabel);
		
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
		nameLabel.setBounds(78, 176, 60, 13);
		getContentPane().add(nameLabel);
		
		nameText = new JTextField();
		nameText.setForeground(Color.WHITE);
		nameText.setColumns(10);
		nameText.setBorder(new LineBorder(Color.BLACK, 2));
		nameText.setBackground(new Color(0x5B6C8B));
		nameText.setBounds(78, 206, 290, 29);
		getContentPane().add(nameText);
		
		JLabel emailLabel = new JLabel("University Email");
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		emailLabel.setBounds(78, 268, 136, 13);
		getContentPane().add(emailLabel);
		
		emailText = new JTextField();
		emailText.setForeground(Color.WHITE);
		emailText.setColumns(10);
		emailText.setBorder(new LineBorder(Color.BLACK, 2));
		emailText.setBackground(new Color(0x5B6C8B));
		emailText.setBounds(78, 298, 290, 29);
		getContentPane().add(emailText);
		
		addressText = new JTextField();
		addressText.setForeground(Color.WHITE);
		addressText.setColumns(10);
		addressText.setBorder(new LineBorder(Color.BLACK, 2));
		addressText.setBackground(new Color(0x5B6C8B));
		addressText.setBounds(78, 385, 290, 29);
		getContentPane().add(addressText);
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setForeground(Color.WHITE);
		addressLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		addressLabel.setBounds(78, 355, 76, 13);
		getContentPane().add(addressLabel);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBounds(0, 548, 895, 75);
		getContentPane().add(bottomPanel);
		bottomPanel.setLayout(null);
		
		rfidText = new JTextField();
		rfidText.setForeground(Color.BLACK);
		rfidText.setColumns(10);
		rfidText.setBorder(new LineBorder(Color.BLACK, 2));
		rfidText.setBackground(Color.white);
		rfidText.setBounds(298, 22, 290, 29);
		bottomPanel.add(rfidText);
		
		JLabel rfidLabel = new JLabel("RFID NO");
		rfidLabel.setBackground(Color.WHITE);
		rfidLabel.setForeground(Color.BLACK);
		rfidLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		rfidLabel.setBounds(192, 28, 76, 13);
		bottomPanel.add(rfidLabel);
		
		genarateBtn = new JButton("GENARATE");
		genarateBtn.setForeground(Color.WHITE);
		genarateBtn.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		genarateBtn.setFocusable(false);
		genarateBtn.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		genarateBtn.setBackground(Color.DARK_GRAY);
		genarateBtn.setBounds(632, 21, 118, 29);
		genarateBtn.addActionListener(this);
		bottomPanel.add(genarateBtn);
		
		JLabel phoneLabel = new JLabel("Phone Number");
		phoneLabel.setForeground(Color.WHITE);
		phoneLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		phoneLabel.setBounds(469, 355, 122, 13);
		getContentPane().add(phoneLabel);
		
		phoneText = new JTextField();
		phoneText.setForeground(Color.WHITE);
		phoneText.setColumns(10);
		phoneText.setBorder(new LineBorder(Color.BLACK, 2));
		phoneText.setBackground(new Color(0x5B6C8B));
		phoneText.setBounds(469, 380, 290, 29);
		getContentPane().add(phoneText);
		
		JLabel yearLabel = new JLabel("Graduate Year");
		yearLabel.setForeground(Color.WHITE);
		yearLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		yearLabel.setBounds(469, 176, 122, 13);
		getContentPane().add(yearLabel);
		
		yearText = new JTextField();
		yearText.setForeground(Color.WHITE);
		yearText.setColumns(10);
		yearText.setBorder(new LineBorder(Color.BLACK, 2));
		yearText.setBackground(new Color(0x5B6C8B));
		yearText.setBounds(469, 206, 290, 29);
		getContentPane().add(yearText);
		
		JLabel nicLabel = new JLabel("NIC ");
		nicLabel.setForeground(Color.WHITE);
		nicLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		nicLabel.setBounds(78, 442, 60, 13);
		getContentPane().add(nicLabel);
		
		nicText = new JTextField();
		nicText.setForeground(Color.WHITE);
		nicText.setColumns(10);
		nicText.setBorder(new LineBorder(Color.BLACK, 2));
		nicText.setBackground(new Color(0x5B6C8B));
		nicText.setBounds(78, 472, 290, 29);
		getContentPane().add(nicText);

		JLabel degreeLabel = new JLabel("Degree Program");
		degreeLabel.setForeground(Color.WHITE);
		degreeLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		degreeLabel.setBounds(469, 263, 136, 22);
		getContentPane().add(degreeLabel);
		
		submitBtn = new JButton("SUBMIT");
		submitBtn.setForeground(Color.BLACK);
		submitBtn.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		submitBtn.setFocusable(false);
		submitBtn.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		submitBtn.setBackground(new Color(0x3edad8));
		submitBtn.addActionListener(this);
		submitBtn.setBounds(627, 435, 118, 29);
		getContentPane().add(submitBtn);

		String [] degrees = {"Engineering School","IT And Computing School","Technology School","Business School","Music School"};//drop down array make sure to use data type as warapper class

		degreeBox = new JComboBox(degrees);//drop down
		degreeBox.setForeground(Color.WHITE);//font color of drop down
		degreeBox.setBackground(new Color(0x5b6c8b));
		degreeBox.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		degreeBox.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		degreeBox.setFocusable(true);
		degreeBox.setBounds(469, 296, 290, 29);
		degreeBox.addActionListener(this);

		//degreeBox.addItem("name"); add item to drop down list
		getContentPane().add(degreeBox);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backBtn) {
			this.dispose();
			new adminview();
		}
		if(e.getSource()==degreeBox) {//drop down
			//System.out.println(degreeBox.getSelectedItem()); return selected item
			//System.out.println(degreeBox.getSelectedIndex()); return selected index
		}
		if(e.getSource() == genarateBtn){

			RFID_Reader t1 = new RFID_Reader();
			t1.run();
			if (!t1.getRFIDnumber().isEmpty()) {
				rfidText.setText(t1.getRFIDnumber());
				JOptionPane.showMessageDialog(this, "RFID Generated");

			}
//			else if (!t1.isAlive() && t1.getRFIDnumber().isEmpty()) {
//				JOptionPane.showMessageDialog(this, "RFID Generated failed!!\nTry again");
//			}
		}
		if(e.getSource() == submitBtn){
			try{
				Class.forName("java.sql.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbproject","harindu123","Zyco@123fuckinggood");
				Statement stmt = con.createStatement();
				String qry = "INSERT INTO `user_table`(`User Name`, `E-mail`, `Address`, `phone_Number`, `Graduate_Year`, `NIC`, `Dgree`, `RFID_NO`) VALUES ('" + nameText.getText() + "', '" + emailText.getText() + "', '" + addressText.getText() + "', '"  + phoneText.getText() + "', '" + yearText.getText() + "', '" + nicText.getText() + "', '"+degreeBox.getSelectedItem()+"', '"+ rfidText.getText()+ "');";
				System.out.println(qry);
				stmt.executeUpdate(qry);
				JOptionPane.showMessageDialog(null, "New record has been saved successfully! \n You may view your profile by clicking on \n Update or Delete User.");
				System.out.println("Generated SQL query: " + qry);

				nameText.setText("");
				emailText.setText("");
				addressText.setText("");
				rfidText.setText("");
				phoneText.setText("");
				yearText.setText("");
				nicText.setText("");
			}
			catch(Exception exception){
				JOptionPane.showMessageDialog(null, "The process could not be completed due to some error. Please check if all data entered are correct.");
				System.out.println(exception.getLocalizedMessage());
			}
		}
	}
	
}
