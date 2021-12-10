import java.awt.*;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class adminpanel extends JFrame implements ActionListener  {//extend jframe class and actionlistener interface
	
	JLabel usridLabel;
	JLabel passLabel;
	JButton loginBtn;
	JSeparator passSeparator;
	JSeparator usrSeparator;
	JTextField usridField;
	JTextField rfidField;
	JPasswordField passwordField;
	authUser auth1;

	adminpanel(){
		frontEnd();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==loginBtn) {
			String usr = usridField.getText();//making string variable and store text field user input
			String passwd = passwordField.getText();
			if(usr.equals("admin") && passwd.equals("admin")) {//check user input equals with string
				this.dispose();//when press button first frame will dispose
				new adminview();//if button triggers this join to our page
			}
			else {
				JOptionPane.showMessageDialog(this, "Invalid Username or Password");
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
		this.getContentPane().setLayout(null);//set frame layout as absolute layout

		Border border = BorderFactory.createLineBorder(Color.green,3);//create border object

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

		rfidField = new JTextField();
		rfidField.setForeground(Color.DARK_GRAY);
		rfidField.setBounds(42, 300, 323, 39);
		rfidField.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		rfidField.setCaretColor(Color.DARK_GRAY);
		rfidField.setBackground(Color.DARK_GRAY);
		rfidField.setBorder(null);
		rfidField.setDocument(new libMethod.JTextFieldLimit(10));
		loginPanel.add(rfidField);
		rfidField.setColumns(10);
		JFrame frame = this;
		rfidField.getDocument().addDocumentListener(new DocumentListener() {
			boolean a;
			public void changedUpdate(DocumentEvent e) {
				frame.dispose();
				new adminpanel();

			}
			public void removeUpdate(DocumentEvent e) {
				frame.dispose();
				new adminpanel();

			}
			public void insertUpdate(DocumentEvent e) {
				if (rfidField.getText().length() == 10) {
					auth1 = new authUser(frame, rfidField.getText());
					auth1.start();
					a=true;
				}
			}
		});

		usridField = new JTextField();
		usridField.setForeground(Color.WHITE);
		usridField.setBounds(42, 380, 323, 39);
		usridField.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		usridField.setCaretColor(Color.WHITE);
		usridField.setBackground(Color.DARK_GRAY);
		usridField.setBorder(null);
		usridField.addMouseListener(new MouseAdapter(){//from this method whenever user click on text field already set text will dissapear
			@Override
			public void mouseExited(MouseEvent e){
				usridField.setEditable(false);
				rfidField.requestFocus(true);
			}
			public void mouseEntered(MouseEvent e){
				usridField.setEditable(true);
			}

		});
		loginPanel.add(usridField);
		usridField.setColumns(10);
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setCaretColor(Color.WHITE);
		passwordField.setBackground(Color.DARK_GRAY);
		passwordField.setBounds(46, 531, 323, 39);
		passwordField.setBorder(null);
		passwordField.addMouseListener(new MouseAdapter(){//from this method whenever user click on text field already set text will dissapear
			@Override
			public void mouseExited(MouseEvent e){
				passwordField.setEditable(false);
				rfidField.requestFocus(true);
			}
			public void mouseEntered(MouseEvent e){
				passwordField.setEditable(true);
			}
		});
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