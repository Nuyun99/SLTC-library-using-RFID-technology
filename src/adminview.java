import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adminview extends JFrame implements ActionListener {
	
	/*add button names as local variable since action perform is out of our constructor*/
	JButton logoutBtn;
	JButton srchBtn;
	JButton addbkBtn;
	JButton delusrBtn;
	JButton lendbkBtn;
	JButton addusrBtn;
	JButton exitBtn; 
	
	adminview(){
		setResizable(false);
		getContentPane().setBackground(new Color(0x5B6C8B));
		
		ImageIcon bookImg = new ImageIcon("book1.png");
		Image image = bookImg.getImage();
		Image newimg = image.getScaledInstance(135, 135,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		bookImg = new ImageIcon(newimg);
		ImageIcon srchImg = new ImageIcon("search.png");
		ImageIcon adbkImg = new ImageIcon("adbk.png");
		ImageIcon dltImg  = new ImageIcon("delete.png");
		ImageIcon lendImg = new ImageIcon("handover.png");
		ImageIcon infoImg = new ImageIcon("aboutus.png");
		ImageIcon exitImg = new ImageIcon("exit.png");
		ImageIcon logoutImg = new ImageIcon("logout.png");
		image = logoutImg.getImage();
		newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		logoutImg = new ImageIcon(newimg);

		
		this.setBounds(100, 100, 972, 699);//this key word replace Frame name
		this.setUndecorated(true);//title bar disappear
		this.setLocationRelativeTo(null);//this set center our frame
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();//upper jPannel
		panel.setBackground(new Color(0xF50097EE));
		panel.setBounds(0, 0, 972, 205);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel upLabel = new JLabel();//upper JLabel contains Text
		upLabel.setBackground(Color.WHITE);
		upLabel.setForeground(new Color(232, 235, 243));
		upLabel.setBounds(235, 48, 635, 94);
		panel.add(upLabel);
		upLabel.setText("Library Management System");
		upLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 53));
		
		JLabel upImgLabel = new JLabel();//upper JLabel contains Image
		upImgLabel.setBounds(83, 35, 135, 135);
		upImgLabel.setIcon(bookImg);
		panel.add(upImgLabel);


		logoutBtn = new JButton();
		logoutBtn.addActionListener(this);
		logoutBtn.setBounds(5, 2, 30, 30);
		logoutBtn.setBorder(null);
		logoutBtn.setBackground(new Color(0xF50097EE));
		logoutBtn.setIcon(logoutImg);
		panel.add(logoutBtn);


		JPanel srchPanel = new JPanel();//search book panel
		srchPanel.setBounds(398, 454, 175, 183);
		srchPanel.setBackground(new Color(0xF50097EE));
		getContentPane().add(srchPanel);
		srchPanel.setLayout(null);
		
		srchBtn = new JButton("<html><br><br>Search Book</html>",srchImg);//search book panel button
		srchBtn.setForeground(Color.WHITE);
		srchBtn.setFont(new Font("Verdana", Font.BOLD, 12));
		srchBtn.setBounds(0, 0, 175, 183);
		srchBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
		srchBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		srchBtn.setBackground(new Color(0xF50097EE));
		srchBtn.setFocusable(false);
		srchPanel.add(srchBtn);


		JPanel addbkPanel = new JPanel();//add book JPanel
		addbkPanel.setBackground(new Color(0xF50097EE));
		addbkPanel.setBounds(398, 244, 175, 183);
		getContentPane().add(addbkPanel);
		addbkPanel.setLayout(null);
		
		addbkBtn = new JButton("<html><br><br>Add Book</html>",adbkImg);//add book button
		addbkBtn.setForeground(Color.WHITE);
		addbkBtn.setFont(new Font("Verdana", Font.BOLD, 12));
		addbkBtn.setFocusable(false);
		addbkBtn.addActionListener(this);//since this keyword for our actionlistner interface
		addbkBtn.setBackground(new Color(0xF50097EE));
		addbkBtn.setBounds(0, 0, 175, 183);
		addbkBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
		addbkBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		addbkPanel.add(addbkBtn);

		
		JPanel delusrPanel = new JPanel();//update or delete user JPanel
		delusrPanel.setBackground(new Color(0xF50097EE));
		delusrPanel.setBounds(695, 244, 175, 183);
		getContentPane().add(delusrPanel);
		delusrPanel.setLayout(null);

		delusrBtn = new JButton("<html><br><br>Update/Delete User</html>",dltImg);//update or delete user button
		delusrBtn.setForeground(Color.WHITE);
		delusrBtn.setFont(new Font("Verdana", Font.BOLD, 12));
		delusrBtn.setFocusable(false);
		delusrBtn.addActionListener(this);
		delusrBtn.setBackground(new Color(0xF50097EE));
		delusrBtn.setBounds(0, 0, 175, 183);
		delusrBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
		delusrBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		delusrPanel.add(delusrBtn);


		JPanel lendbkPanel = new JPanel();//lend book JPanel
		lendbkPanel.setBackground(new Color(0xF50097EE));
		lendbkPanel.setBounds(100, 454, 175, 183);
		getContentPane().add(lendbkPanel);
		lendbkPanel.setLayout(null);
		
		lendbkBtn = new JButton("<html><br><br>Lend Book</html>",lendImg);//lend book button
		lendbkBtn.setForeground(Color.WHITE);
		lendbkBtn.setFont(new Font("Verdana", Font.BOLD, 12));
		lendbkBtn.setFocusable(false);
		lendbkBtn.setBackground(new Color(0xF50097EE));
		lendbkBtn.setBounds(0, 0, 175, 183);
		lendbkBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
		lendbkBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		lendbkPanel.add(lendbkBtn);


		JPanel addusrPanel = new JPanel();//add usr JPanel
		addusrPanel.setBackground(new Color(0xF50097EE));
		addusrPanel.setBounds(100, 244, 175, 183);
		getContentPane().add(addusrPanel);
		addusrPanel.setLayout(null);

		addusrBtn = new JButton("<html><br><br>Add User</html>",infoImg);//about us button
		addusrBtn.setForeground(Color.WHITE);
		addusrBtn.setFont(new Font("Verdana", Font.BOLD, 12));
		addusrBtn.setFocusable(false);
		addusrBtn.addActionListener(this);
		addusrBtn.setBackground(new Color(0xF50097EE));
		addusrBtn.setBounds(0, 0, 175, 183);
		addusrBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
		addusrBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		addusrPanel.add(addusrBtn);


		JPanel exitPanel = new JPanel();//exit program JPanel
		exitPanel.setBackground(new Color(0xF50097EE));
		exitPanel.setBounds(695, 454, 175, 183);
		getContentPane().add(exitPanel);
		exitPanel.setLayout(null);

		exitBtn = new JButton("<html><br><br>Exit Program</html>",exitImg);//exit program button
		exitBtn.setForeground(new Color(0xFFFFFFFF));
		exitBtn.setFont(new Font("Verdana", Font.BOLD, 12));
		exitBtn.setFocusable(false);
		exitBtn.addActionListener(this);
		exitBtn.setBackground(new Color(0xF50097EE));
		exitBtn.setBounds(0, 0, 175, 183);
		exitBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
		exitBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		exitPanel.add(exitBtn);

		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {// button functionalities
		
		if(e.getSource()== logoutBtn) {//logout button functionality
			this.dispose();
			new adminpanel();
			
		}
		
		if(e.getSource()== addbkBtn) {//add book button
			this.dispose();
			addbook book = new addbook();
		}
		
		if(e.getSource()==addusrBtn) {// add user button
			this.dispose();
			adduser user = new adduser();
		}
		
		if(e.getSource()==delusrBtn) {// add user button
			this.dispose();
			updateuser userDel = new updateuser();
		}
		
		if(e.getSource()== exitBtn) {//exit button
			System.exit(0);
		}
	}
	

	
	
}
