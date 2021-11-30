import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;

public class adminpanel extends JFrame implements ActionListener  {//extend jframe class and actionlistener interface
	
	JLabel usridLabel;
	JLabel passLabel;
	JButton loginBtn;
	JSeparator passSeparator;
	JSeparator usrSeparator;
	JTextField usridField;
	JPasswordField passwordField;
	authUser auth1;

	adminpanel(){
		frontEnd();
		auth1 = new authUser(this);
		auth1.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==loginBtn) {
			
			String usr = usridField.getText();//making string variable and store text field user input
			String passwd = passwordField.getText();
			
			if(usr.equals("admin") && passwd.equals("admin")) {//check user input equals with string
				this.dispose();//when press button first frame will dispose
				auth1.stop();
				auth1.t1.stop();
				new adminview();//if button triggers this join to our page
			}
//			else if(usr.equals("user") && passwd.equals("user")) {//check user input equals with string
//
//				this.dispose();//when press button first frame will dispose
//				auth1.stop();
//				auth1.t1.stop();
//				new userPanel();//if button triggers this join to our page
//			}
			else {
				JOptionPane.showMessageDialog(this, "Invalid Username or Password");
//				this.dispose();
//				t1.stop();
//				int result = JOptionPane.showConfirmDialog(this,"Sure? You want to enter?", "Testing Box",
//						JOptionPane.YES_NO_OPTION,
//						JOptionPane.QUESTION_MESSAGE);
//				if(result == JOptionPane.YES_OPTION){
//					new adminview();
//				}else if (result == JOptionPane.NO_OPTION){
//					new userPanel();
//				}else {
//					new adminpanel();
//				}
			}
		}
	}

	public void frontEnd(){
		ImageIcon image = new ImageIcon("line.png");
		ImageIcon frameIcon = new ImageIcon("bash.png");
		ImageIcon anim = new ImageIcon("tap.gif");
		ImageIcon usrIcon = new ImageIcon("user.png");
		ImageIcon pass = new ImageIcon("padlock1.png");

		this.getContentPane().setBackground(new Color(255, 255, 255));
		this.setFont(new Font("Jersey M54", Font.BOLD, 15));
		this.setIconImage(frameIcon.getImage());//set image to frame

		this.setBounds(100, 100, 1248, 784);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		this.getContentPane().setPreferredSize(new Dimension(1920, 1080));
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);//maximize both
		this.setUndecorated(true);//maximize both
		this.setLocationRelativeTo(null);
		//this.pack();
//		this.setVisible(true);

		//this.pack();
		this.getContentPane().setLayout(null);//set frame layout as absolute layout

		Border border = BorderFactory.createLineBorder(Color.green,3);//create border object
		//txtLabel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GREEN));

		JLabel gifLabel = new JLabel();
		gifLabel.setBackground(new Color(192, 192, 192));
		gifLabel.setIcon(anim);
		gifLabel.setBounds(504, -22, 960,1012 );
		this.getContentPane().add(gifLabel);

		JPanel loginPanel = new JPanel();
		loginPanel.setForeground(Color.LIGHT_GRAY);
		loginPanel.setBackground(Color.DARK_GRAY);
		loginPanel.setBounds(0, 0, 446, 1000);
		this.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);


		JLabel txtLabel = new JLabel();
		txtLabel.setBounds(10, 201, 408, 88);
		txtLabel.setBackground(Color.WHITE);
		loginPanel.add(txtLabel);
		txtLabel.setIcon(null);
		txtLabel.setHorizontalAlignment(SwingConstants.CENTER);
		txtLabel.setText("Manual Login Panel");
		txtLabel.setForeground(Color.WHITE);//font color
		txtLabel.setFont(new Font("Myanmar Text", Font.BOLD, 41));//set font style,font type and size
		//txtLabel.setBackground(Color.GRAY);//set background color of label as gray
		//txtLabel.setOpaque(true);//visible background colour of label
		txtLabel.setVerticalTextPosition(JLabel.TOP);//position text
		txtLabel.setHorizontalTextPosition(SwingConstants.LEADING);//position text

		JLabel iconLabel = new JLabel();
		iconLabel.setBounds(159, 61, 128, 128);
		iconLabel.setForeground(Color.WHITE);
		iconLabel.setIcon(usrIcon);//add user icon to label
		loginPanel.add(iconLabel);


		usridLabel = new JLabel("User ID");//user id label
		usridLabel.setForeground(Color.LIGHT_GRAY);
		usridLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		usridLabel.setBackground(Color.WHITE);
		usridLabel.setBounds(42, 346, 84, 23);
		loginPanel.add(usridLabel);

		passLabel = new JLabel("password");
		passLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 24));
		passLabel.setForeground(Color.LIGHT_GRAY);
		passLabel.setBounds(42, 491, 106, 30);
		loginPanel.add(passLabel);

		usrSeparator = new JSeparator();
		usrSeparator.setForeground(Color.WHITE);
		usrSeparator.setBounds(42, 421, 323, 7);
		loginPanel.add(usrSeparator);

		passSeparator = new JSeparator();
		passSeparator.setForeground(Color.WHITE);
		passSeparator.setBounds(46, 573, 323, 14);
		loginPanel.add(passSeparator);


		usridField = new JTextField();
		usridField.setForeground(Color.WHITE);
		usridField.setBounds(42, 380, 323, 39);
		usridField.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		usridField.setCaretColor(Color.WHITE);
		usridField.setBackground(Color.DARK_GRAY);
		usridField.setBorder(null);
		loginPanel.add(usridField);
		usridField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setCaretColor(Color.WHITE);
		passwordField.setBackground(Color.DARK_GRAY);
		passwordField.setBounds(46, 531, 323, 39);
		passwordField.setBorder(null);
		loginPanel.add(passwordField);


		loginBtn = new JButton("LOGIN");
		loginBtn.setBounds(234, 632, 131, 39);
		loginPanel.add(loginBtn);
		loginBtn.setForeground(new Color(255, 255, 255));
		loginBtn.addActionListener(this);//since this keyword for our actionlistner interface
		loginBtn.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		loginBtn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		loginBtn.setBackground(new Color(0, 151, 238));
		loginBtn.setFocusable(false);
		this.setVisible(true);
	}
}