import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;


public class SearchBook extends JFrame implements ActionListener{
	
	 JTextField rollText;
	 JTextField nameText;
	 JTextField courseText;
	 JTextField semesterText;
	 JTextField emailText;
	 JTextField phoneText;
	 JTextField booktitleText;
	 JTextField authorText;
	 JTextField bookidText;
	 JTextField editionText;
	 JButton backBtn;
	 JButton submitBtn; 
	 
	
	SearchBook() {
		
		ImageIcon book = new ImageIcon("largebook.png");
		
		ImageIcon close = new ImageIcon("back.png");
		
		//getContentPane().setFont(new Font("Eras Bold ITC", Font.BOLD, 48));
		getContentPane().setBackground(new Color(0x5b6c8b));
	
		this.setBounds(100, 100, 953, 756);
		//this.setDefaultCloseOperation(closeBtn.EXIT_ON_CLOSE);
		//this.setResizable(false);
		this.setUndecorated(true);//title bar disappear
		this.setLocationRelativeTo(null);//this set center our frame
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 966, 124);
		panel.setBackground(new Color(0x1754f1));
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
		backBtn.setBounds(0, 0, 30, 30);
		backBtn.setFocusable(false);
		backBtn.setBackground(new Color(0x1754f1));
		backBtn.setBorder(null);
		backBtn.addActionListener(this);
		backBtn.setIcon(close);
		panel.add(backBtn);
		
		rollText = new JTextField();
		rollText.setForeground(Color.WHITE);
		rollText.setBackground(new Color(0x5b6c8b));
		rollText.setBounds(85, 190, 290, 29);
		rollText.setBorder(new LineBorder(Color.BLACK, 2));
		getContentPane().add(rollText);
		rollText.setColumns(10);
		
		JLabel rollLabel = new JLabel("Roll No");
		rollLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		rollLabel.setForeground(Color.WHITE);
		rollLabel.setBounds(85, 156, 60, 13);
		getContentPane().add(rollLabel);
		
		nameText = new JTextField();
		nameText.setForeground(Color.WHITE);
		nameText.setColumns(10);
		nameText.setBorder(new LineBorder(Color.BLACK, 2));
		nameText.setBackground(new Color(91, 108, 139));
		nameText.setBounds(85, 283, 290, 29);
		getContentPane().add(nameText);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		nameLabel.setBounds(85, 248, 60, 13);
		getContentPane().add(nameLabel);
		
		courseText = new JTextField();
		courseText.setForeground(Color.WHITE);
		courseText.setColumns(10);
		courseText.setBorder(new LineBorder(Color.BLACK, 2));
		courseText.setBackground(new Color(91, 108, 139));
		courseText.setBounds(85, 371, 290, 29);
		getContentPane().add(courseText);
		
		JLabel courseLabel = new JLabel("Course");
		courseLabel.setForeground(Color.WHITE);
		courseLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		courseLabel.setBounds(85, 335, 60, 13);
		getContentPane().add(courseLabel);
		
		semesterText = new JTextField();
		semesterText.setForeground(Color.WHITE);
		semesterText.setColumns(10);
		semesterText.setBorder(new LineBorder(Color.BLACK, 2));
		semesterText.setBackground(new Color(91, 108, 139));
		semesterText.setBounds(85, 454, 290, 29);
		getContentPane().add(semesterText);
		
		JLabel SemesterLabel = new JLabel("Semester");
		SemesterLabel.setForeground(Color.WHITE);
		SemesterLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		SemesterLabel.setBounds(85, 422, 82, 13);
		getContentPane().add(SemesterLabel);
		
		emailText = new JTextField();
		emailText.setForeground(Color.WHITE);
		emailText.setColumns(10);
		emailText.setBorder(new LineBorder(Color.BLACK, 2));
		emailText.setBackground(new Color(91, 108, 139));
		emailText.setBounds(85, 536, 290, 29);
		getContentPane().add(emailText);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		emailLabel.setBounds(85, 505, 60, 13);
		getContentPane().add(emailLabel);
		
		JLabel phoneLabel = new JLabel("Phone No");
		phoneLabel.setForeground(Color.WHITE);
		phoneLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		phoneLabel.setBounds(85, 594, 82, 13);
		getContentPane().add(phoneLabel);
		
		phoneText = new JTextField();
		phoneText.setForeground(Color.WHITE);
		phoneText.setColumns(10);
		phoneText.setBorder(new LineBorder(Color.BLACK, 2));
		phoneText.setBackground(new Color(91, 108, 139));
		phoneText.setBounds(85, 628, 290, 29);
		getContentPane().add(phoneText);
		
		booktitleText = new JTextField();
		booktitleText.setForeground(Color.WHITE);
		booktitleText.setColumns(10);
		booktitleText.setBorder(new LineBorder(Color.BLACK, 2));
		booktitleText.setBackground(new Color(91, 108, 139));
		booktitleText.setBounds(569, 190, 290, 29);
		getContentPane().add(booktitleText);
		
		JLabel bookTitleLabel = new JLabel("Book Title");
		bookTitleLabel.setForeground(Color.WHITE);
		bookTitleLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		bookTitleLabel.setBounds(569, 156, 95, 13);
		getContentPane().add(bookTitleLabel);
		
		authorText = new JTextField();
		authorText.setForeground(Color.WHITE);
		authorText.setColumns(10);
		authorText.setBorder(new LineBorder(Color.BLACK, 2));
		authorText.setBackground(new Color(91, 108, 139));
		authorText.setBounds(569, 283, 290, 29);
		getContentPane().add(authorText);
		
		JLabel authorLabel = new JLabel("Book Author");
		authorLabel.setForeground(Color.WHITE);
		authorLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		authorLabel.setBounds(569, 248, 110, 13);
		getContentPane().add(authorLabel);
		
		bookidText = new JTextField();
		bookidText.setForeground(Color.WHITE);
		bookidText.setColumns(10);
		bookidText.setBorder(new LineBorder(Color.BLACK, 2));
		bookidText.setBackground(new Color(91, 108, 139));
		bookidText.setBounds(569, 371, 290, 29);
		getContentPane().add(bookidText);
		
		JLabel bookidLabel = new JLabel("Book ID");
		bookidLabel.setForeground(Color.WHITE);
		bookidLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		bookidLabel.setBounds(569, 335, 82, 13);
		getContentPane().add(bookidLabel);
		
		JLabel aboutLabel = new JLabel("About");
		aboutLabel.setForeground(Color.WHITE);
		aboutLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		aboutLabel.setBounds(569, 422, 82, 13);
		getContentPane().add(aboutLabel);
		
		JLabel editionLabel = new JLabel("Edition");
		editionLabel.setForeground(Color.WHITE);
		editionLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		editionLabel.setBounds(569, 594, 82, 13);
		getContentPane().add(editionLabel);
		
		editionText = new JTextField();
		editionText.setForeground(Color.WHITE);
		editionText.setColumns(10);
		editionText.setBorder(new LineBorder(Color.BLACK, 2));
		editionText.setBackground(new Color(91, 108, 139));
		editionText.setBounds(569, 628, 290, 29);
		getContentPane().add(editionText);
		
		JTextArea aboutTextArea = new JTextArea();
		aboutTextArea.setBounds(569, 456, 290, 109);
		getContentPane().add(aboutTextArea);
		aboutTextArea.setBackground(new Color(91, 108, 139));
		aboutTextArea.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		
		submitBtn = new JButton("SUBMIT");
		submitBtn.setBounds(740, 684, 118, 29);
		submitBtn.setForeground(new Color(0, 0, 0));
		//submitBtn.addActionListener(this);//since this keyword for our actionlistner interface
		submitBtn.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		submitBtn.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		submitBtn.setBackground(new Color(242, 12, 39));
		submitBtn.setFocusable(false);
		getContentPane().add(submitBtn);
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
