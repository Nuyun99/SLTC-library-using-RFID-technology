import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class userPanel extends JFrame implements ActionListener{


	JPanel upperPannel; 
	JButton lendbookbtn;
	JButton returnbookbtn;
	JButton logoutbtn;
	private JLabel logoLabel;
	JLabel textArea;

	public userPanel() {

		initialize();

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {// button functionalities
		if(e.getSource()== logoutbtn) {//logout button functionality
			this.dispose();
			new adminpanel();

		}
		if(e.getSource()== lendbookbtn) {//logout button functionality
			this.dispose();
			new lendBook();

		}
		if(e.getSource()== returnbookbtn) {//logout button functionality
			this.dispose();
			new returnBook();

		}

	}
	private void initialize() {
		//frame.setBounds(100, 100, 1248, 784);
		this.setBounds(100, 100, 1920, 1080);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		getContentPane().setPreferredSize(new Dimension(1920, 1080));

		ImageIcon userImg = libMethod.scaledImg("userpro.png",64,64);
		ImageIcon logoImg = libMethod.scaledImg("book1.png",135,135);
		ImageIcon lendImg = libMethod.scaledImg("handover.png",100,100);
		ImageIcon rtnImg  = libMethod.scaledImg("return.png",100,100);
		ImageIcon logoutImg  = libMethod.scaledImg("usrlogout.png",100,100);

		getContentPane().setBackground(new Color(0x5B6C8B));
		getContentPane().setLayout(null);
		upperPannel = new JPanel();
		upperPannel.setBackground(new Color(0, 151, 238));
		upperPannel.setForeground(Color.WHITE);
		getContentPane().setPreferredSize(new Dimension(1920, 1080));
		upperPannel.setBounds(0, 0, 1920, 252);
		getContentPane().add(upperPannel);
		upperPannel.setLayout(null);

		JLabel upperLabel = new JLabel("Library Management System");
		upperLabel.setForeground(Color.WHITE);
		upperLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 70));
		upperLabel.setBounds(389, 76, 855, 100);
		upperPannel.add(upperLabel);

		JLabel usrLabel = new JLabel();
		usrLabel.setBounds(1151, 10, 64, 64);
		usrLabel.setIcon(userImg);
		//usrLabel.setOpaque(true);

		upperPannel.add(usrLabel);
		textArea = new JLabel();
		textArea.setBounds(1225, 10, 295, 64);
		textArea.setBackground(new Color(0xF50097EE));
		textArea.setText("<html>Wellcome<br>K. Nuyun Pabasara<html>");
		textArea.setFont(new Font("Verdana", Font.BOLD, 15));
		textArea.setAlignmentX(1000);
		upperPannel.add(textArea);

		logoLabel = new JLabel("");
		logoLabel.setBounds(221, 60, 135, 135);
		logoLabel.setIcon(logoImg);
		upperPannel.add(logoLabel);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);//maximize both
		this.setUndecorated(true);//maximize both
		this.setLocationRelativeTo(null);


		JPanel lendbkPanel = new JPanel();//add book JPanel
		lendbkPanel.setBackground(new Color(0xF50097EE));
		lendbkPanel.setBounds(172, 418, 254, 269);
		getContentPane().add(lendbkPanel);
		lendbkPanel.setLayout(null);

		lendbookbtn = new JButton("<html><br>Lend Book</html>",lendImg);
		lendbookbtn.setBounds(0, 0, 254, 269);
		lendbkPanel.add(lendbookbtn);
		lendbookbtn.setForeground(Color.WHITE);
		lendbookbtn.setFont(new Font("Verdana", Font.BOLD, 20));
		lendbookbtn.setFocusable(false);
		lendbookbtn.addActionListener(this);//since this keyword for our action listner interface
		lendbookbtn.setBackground(new Color(0xF50097EE));
		lendbookbtn.setVerticalTextPosition(SwingConstants.BOTTOM);
		lendbookbtn.setHorizontalTextPosition(SwingConstants.CENTER);

		JPanel returnbkkPanel = new JPanel();//add book JPanel
		returnbkkPanel.setBackground(new Color(0xF50097EE));
		returnbkkPanel.setBounds(641, 418, 254, 269);
		getContentPane().add(returnbkkPanel);
		returnbkkPanel.setLayout(null);

		returnbookbtn = new JButton("<html><br>Return Book</html>",rtnImg);
		returnbookbtn.setBounds(0, 0, 254, 269);
		returnbkkPanel.add(returnbookbtn);
		returnbookbtn.setForeground(Color.WHITE);
		returnbookbtn.setFont(new Font("Verdana", Font.BOLD, 20));
		returnbookbtn.setFocusable(false);
		returnbookbtn.addActionListener(this);//since this keyword for our action listner interface
		returnbookbtn.setBackground(new Color(0xF50097EE));
		returnbookbtn.setVerticalTextPosition(SwingConstants.BOTTOM);
		returnbookbtn.setHorizontalTextPosition(SwingConstants.CENTER);

		JPanel logoutPanel = new JPanel();
		logoutPanel.setBounds(1101, 418, 254, 269);
		getContentPane().add(logoutPanel);
		logoutPanel.setBackground(new Color(0xF50097EE));
		logoutPanel.setLayout(null);

		logoutbtn = new JButton("<html><br>Log Out</html>",logoutImg);

		logoutbtn.setBounds(0, 0, 254, 269);
		logoutPanel.add(logoutbtn);
		logoutbtn.setForeground(Color.WHITE);
		logoutbtn.setFont(new Font("Verdana", Font.BOLD, 20));
		logoutbtn.setFocusable(false);

		logoutbtn.setBackground(new Color(0xF50097EE));
		logoutbtn.setVerticalTextPosition(SwingConstants.BOTTOM);
		logoutbtn.setHorizontalTextPosition(SwingConstants.CENTER);
		//since this keyword for our action listner interface
		logoutbtn.addActionListener(this);
	}
}
