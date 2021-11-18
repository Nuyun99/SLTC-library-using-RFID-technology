import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;


public class addbook extends JFrame implements ActionListener{
	
	 JTextField rackText;
	 JTextField sectionText;
	 JTextField booktitleText;
	 JTextField authorText;
	 JTextField bookgnrText;
	 JTextField editionText;
	 JButton backBtn;
	 JButton submitBtn; 
	 private JTextField textField;
	 
	
	addbook() {
		
		ImageIcon book = new ImageIcon("largebook.png");
		
		ImageIcon close = new ImageIcon("back.png");
		Image image = close.getImage();
		Image newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		close = new ImageIcon(newimg);
		
		//getContentPane().setFont(new Font("Eras Bold ITC", Font.BOLD, 48));
		getContentPane().setBackground(new Color(0x5B6C8B));
	
		this.setBounds(100, 100, 953, 756);
		//this.setDefaultCloseOperation(closeBtn.EXIT_ON_CLOSE);
		//this.setResizable(false);
		this.setUndecorated(true);//title bar disappear
		this.setLocationRelativeTo(null);//this set center our frame
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 966, 124);
		panel.setBackground(new Color(0xF50097EE));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel upperLabel = new JLabel("Add New Book Entries");
		upperLabel.setForeground(Color.WHITE);
		upperLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 50));
		upperLabel.setBounds(256, 26, 501, 64);
		panel.add(upperLabel);
		
		JLabel bookLabel = new JLabel();
		bookLabel.setBounds(165, 26, 64, 64);
		bookLabel.setIcon(book);
		panel.add(bookLabel);
		
		backBtn = new JButton();//close button
		//closeBtn.setForeground(Color.RED);
		backBtn.setBounds(5, 5, 30, 30);
		backBtn.setFocusable(false);
		backBtn.setBackground(new Color(0xF50097EE));
		backBtn.setBorder(null);
		backBtn.addActionListener(this);
		backBtn.setIcon(close);
		panel.add(backBtn);
		
		rackText = new JTextField();
		rackText.setForeground(Color.WHITE);
		rackText.setBackground(new Color(0x5B6C8B));
		rackText.setBounds(569, 220, 290, 29);
		rackText.setBorder(new LineBorder(Color.BLACK, 2));
		getContentPane().add(rackText);
		rackText.setColumns(10);
		
		JLabel rackLabel = new JLabel("Rack Number");
		rackLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		rackLabel.setForeground(Color.WHITE);
		rackLabel.setBounds(569, 186, 110, 13);
		getContentPane().add(rackLabel);
		
		sectionText = new JTextField();
		sectionText.setForeground(Color.WHITE);
		sectionText.setColumns(10);
		sectionText.setBorder(new LineBorder(Color.BLACK, 2));
		sectionText.setBackground(new Color(0x5B6C8B));
		sectionText.setBounds(569, 313, 290, 29);
		getContentPane().add(sectionText);
		
		JLabel sectionLabel = new JLabel("Section");
		sectionLabel.setForeground(Color.WHITE);
		sectionLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		sectionLabel.setBounds(569, 278, 60, 13);
		getContentPane().add(sectionLabel);
		
		booktitleText = new JTextField();
		booktitleText.setForeground(Color.WHITE);
		booktitleText.setColumns(10);
		booktitleText.setBorder(new LineBorder(Color.BLACK, 2));
		booktitleText.setBackground(new Color(0x5B6C8B));
		booktitleText.setBounds(85, 220, 290, 29);
		getContentPane().add(booktitleText);
		
		JLabel bookTitleLabel = new JLabel("Book Title");
		bookTitleLabel.setForeground(Color.WHITE);
		bookTitleLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		bookTitleLabel.setBounds(85, 186, 95, 13);
		getContentPane().add(bookTitleLabel);
		
		authorText = new JTextField();
		authorText.setForeground(Color.WHITE);
		authorText.setColumns(10);
		authorText.setBorder(new LineBorder(Color.BLACK, 2));
		authorText.setBackground(new Color(0x5B6C8B));
		authorText.setBounds(85, 313, 290, 29);
		getContentPane().add(authorText);
		
		JLabel authorLabel = new JLabel("Book Author");
		authorLabel.setForeground(Color.WHITE);
		authorLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		authorLabel.setBounds(85, 278, 110, 13);
		getContentPane().add(authorLabel);

		bookgnrText = new JTextField();
		bookgnrText.setForeground(Color.WHITE);
		bookgnrText.setColumns(10);
		bookgnrText.setBorder(new LineBorder(Color.BLACK, 2));
		bookgnrText.setBackground(new Color(91, 108, 139));
		bookgnrText.setBounds(85, 401, 290, 29);
		getContentPane().add(bookgnrText);

		JLabel bookgnrLabel = new JLabel("Book Genre");
		bookgnrLabel.setForeground(Color.WHITE);
		bookgnrLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		bookgnrLabel.setBounds(85, 365, 95, 13);
		getContentPane().add(bookgnrLabel);
		
		JLabel aboutLabel = new JLabel("About");
		aboutLabel.setForeground(Color.WHITE);
		aboutLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		aboutLabel.setBounds(569, 365, 82, 13);
		getContentPane().add(aboutLabel);
		
		JLabel editionLabel = new JLabel("Edition");
		editionLabel.setForeground(Color.WHITE);
		editionLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		editionLabel.setBounds(85, 445, 82, 13);
		getContentPane().add(editionLabel);
		
		editionText = new JTextField();
		editionText.setForeground(Color.WHITE);
		editionText.setColumns(10);
		editionText.setBorder(new LineBorder(Color.BLACK, 2));
		editionText.setBackground(new Color(0x5B6C8B));
		editionText.setBounds(85, 479, 290, 29);
		getContentPane().add(editionText);
		
		JTextArea aboutTextArea = new JTextArea();
		aboutTextArea.setBounds(569, 399, 290, 109);
		getContentPane().add(aboutTextArea);
		aboutTextArea.setBackground(new Color(0x5B6C8B));
		aboutTextArea.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		
		submitBtn = new JButton("SUBMIT");
		submitBtn.setBounds(741, 540, 118, 29);
		submitBtn.setForeground(new Color(0, 0, 0));
		//submitBtn.addActionListener(this);//since this keyword for our actionlistner interface
		submitBtn.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		submitBtn.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		submitBtn.setBackground(new Color(0x3edad8));
		submitBtn.setFocusable(false);
		getContentPane().add(submitBtn);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(null);
		bottomPanel.setBounds(0, 622, 953, 75);
		getContentPane().add(bottomPanel);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setColumns(10);
		textField.setBorder(new LineBorder(Color.BLACK, 2));
		textField.setBackground(Color.WHITE);
		textField.setBounds(298, 22, 290, 29);
		bottomPanel.add(textField);
		
		JLabel rfidLabel = new JLabel("RFID NO");
		rfidLabel.setForeground(Color.BLACK);
		rfidLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		rfidLabel.setBackground(Color.WHITE);
		rfidLabel.setBounds(192, 28, 76, 13);
		bottomPanel.add(rfidLabel);
		
		JButton genarateBtn = new JButton("GENARATE");
		genarateBtn.setForeground(Color.WHITE);
		genarateBtn.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		genarateBtn.setFocusable(false);
		genarateBtn.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		genarateBtn.setBackground(Color.DARK_GRAY);
		genarateBtn.setBounds(621, 21, 118, 29);
		bottomPanel.add(genarateBtn);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backBtn) {
			this.dispose();
			new adminview();
		}
	}
	

	public void actionPerformed2(ActionEvent e) {// when submit button press what it should be done code here
		if(e.getSource()==submitBtn) {
			
		}
	}
}
