import java.awt.*;
import javax.swing.ImageIcon;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JTextField;
	import javax.swing.border.LineBorder;
	import javax.swing.JButton;
	import javax.swing.border.EtchedBorder;
	import java.awt.event.ActionListener;
	import java.awt.event.*;
	import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

	public class updateuser extends JFrame implements ActionListener{
		
		/*whenever extract text in text field make sure use below JTextField Variables*/
		
		JTextField nameText;
		JTextField emailText;
		JTextField addressText;
		JTextField searchText;
		JTextField phoneText;
		JTextField yearText;
		JTextField nicText;
		JTextField dobText;
		JTextField rfidText;
		
		JButton backBtn;
		JButton srchBtn;
		JButton submitBtn;
		

		updateuser(){
			
			getContentPane().setBackground(new Color(0x5b6c8b));
			
			ImageIcon usr = new ImageIcon("largedeluser.png");
			
			ImageIcon src = new ImageIcon("src.png");
			
			ImageIcon back = new ImageIcon("back.png");
			Image image = back.getImage();
			Image newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			back = new ImageIcon(newimg);

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
			
			JLabel upperLabel = new JLabel("Update/Delete User");
			upperLabel.setForeground(Color.WHITE);
			upperLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 53));
			upperLabel.setBounds(240, 29, 449, 64);
			panel.add(upperLabel);
			
			JLabel imgLabel = new JLabel();
			imgLabel.setBounds(133, 29, 64, 64);
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
			nameLabel.setBounds(78, 251, 60, 13);
			getContentPane().add(nameLabel);
			
			nameText = new JTextField();
			nameText.setForeground(Color.WHITE);
			nameText.setColumns(10);
			nameText.setBorder(new LineBorder(Color.BLACK, 2));
			nameText.setBackground(new Color(0x5B6C8B));
			nameText.setBounds(78, 281, 290, 29);
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
			getContentPane().add(emailText);
			
			addressText = new JTextField();
			addressText.setForeground(Color.WHITE);
			addressText.setColumns(10);
			addressText.setBorder(new LineBorder(Color.BLACK, 2));
			addressText.setBackground(new Color(0x5B6C8B));
			addressText.setBounds(78, 460, 290, 29);
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
			searchText.setText("Enter Email or NIC Number");
			
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
			searchText.setBounds(298, 22, 290, 29);
			bottomPanel.add(searchText);
			
			JSeparator separator = new JSeparator();
			separator.setForeground(Color.BLACK);
			separator.setBounds(298, 51, 315, 10);
			bottomPanel.add(separator);
			
			srchBtn = new JButton();
			srchBtn.setBackground(Color.WHITE);
			srchBtn.setBorder(null);
			srchBtn.setIcon(src);
			srchBtn.setFocusable(false);
			srchBtn.setBounds(623, 23, 32, 32);
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
			getContentPane().add(nicText);
			
			dobText = new JTextField();
			dobText.setForeground(Color.WHITE);
			dobText.setColumns(10);
			dobText.setBorder(new LineBorder(Color.BLACK, 2));
			dobText.setBackground(new Color(0x5B6C8B));
			dobText.setBounds(469, 460, 290, 29);
			getContentPane().add(dobText);
			
			JLabel dobLabel = new JLabel("Date of Birth");
			dobLabel.setForeground(Color.WHITE);
			dobLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
			dobLabel.setBounds(469, 430, 105, 13);
			getContentPane().add(dobLabel);
			
			submitBtn = new JButton("DELETE");
			submitBtn.setForeground(Color.BLACK);
			submitBtn.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
			submitBtn.setFocusable(false);
			submitBtn.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
			submitBtn.setBackground(Color.RED);
			submitBtn.setBounds(641, 604, 118, 29);
			getContentPane().add(submitBtn);
			
			JLabel rfidLabel = new JLabel("Rfid No");
			rfidLabel.setForeground(Color.WHITE);
			rfidLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
			rfidLabel.setBounds(469, 519, 122, 13);
			getContentPane().add(rfidLabel);
			
			rfidText = new JTextField();
			rfidText.setForeground(Color.WHITE);
			rfidText.setColumns(10);
			rfidText.setBorder(new LineBorder(Color.BLACK, 2));
			rfidText.setBackground(new Color(91, 108, 139));
			rfidText.setBounds(469, 547, 290, 29);
			getContentPane().add(rfidText);
			
			JButton updateBtn = new JButton("UPDATE");
			updateBtn.setForeground(Color.WHITE);
			updateBtn.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
			updateBtn.setFocusable(false);
			updateBtn.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
			updateBtn.setBackground(new Color(0x3edad8));
			updateBtn.setBounds(504, 604, 118, 29);
			getContentPane().add(updateBtn);
			
			this.setVisible(true);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==backBtn) {
				this.dispose();
				new adminview();
			}
		}
}

