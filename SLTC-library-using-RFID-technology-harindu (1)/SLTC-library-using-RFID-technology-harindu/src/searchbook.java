import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class searchbook extends JFrame implements ActionListener{
	
	JTextField searchText;
	
	JButton srchBtn ;
	JButton backBtn;
	JTable table;
	DefaultTableModel model;
	
	searchbook(){
	

		getContentPane().setBackground(new Color(0x5b6c8b));
		
		ImageIcon usr = new ImageIcon("search.png");
		
		ImageIcon src = new ImageIcon("src.png");
		
		ImageIcon back = new ImageIcon("back.png");

		this.setBounds(100, 100, 895, 664);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		//this.setResizable(true);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 904, 124);
		panel.setBackground(new Color(0x1754f1));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel upperLabel = new JLabel("Search Book");
		upperLabel.setBounds(312, 29, 308, 64);
		upperLabel.setForeground(Color.WHITE);
		upperLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 56));
		panel.add(upperLabel);
		
		JLabel imgLabel = new JLabel();
		imgLabel.setBounds(195, 29, 64, 64);
		imgLabel.setIcon(usr);
		panel.add(imgLabel);
		
		backBtn = new JButton();
		backBtn.setFocusable(false);
		backBtn.setBorder(null);
		backBtn.setBackground(new Color(23, 84, 241));
		backBtn.setBounds(0, 0, 30, 30);
		backBtn.setIcon(back);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBounds(0, 125, 895, 71);
		bottomPanel.setLayout(null);
		bottomPanel.setBackground(Color.WHITE);
		getContentPane().add(bottomPanel);
		
		searchText = new JTextField();
		searchText.setForeground(Color.BLACK);
		searchText.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
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
		
		searchText.setText("Enter Book Title or Author Name");
		
		searchText.addMouseListener(new MouseAdapter(){//from this method whenever user click on text field already set text will dissapear
		    @Override
		    public void mouseClicked(MouseEvent e){
		        searchText.setText("");
		    }
		});
		srchBtn.setFocusable(false);
		srchBtn.setBorder(null);
		srchBtn.setBackground(Color.WHITE);
		srchBtn.setIcon(src);
		srchBtn.setBounds(623, 23, 32, 32);
		bottomPanel.add(srchBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(0x5b6c8b));
		scrollPane.setBounds(27, 232, 834, 410);
		getContentPane().add(scrollPane);
		
		
		model = new DefaultTableModel(); // making model object in default table model class
		Object[] coloumns = {"Picture" , "Book name" ,"Title" , "Author"};//coloums as object data type .. if want to change string data type
		
		model.setColumnIdentifiers(coloumns);//pass our String array name 
	

		
		table = new JTable();
		table.setModel(model);//pass our default table model object which is " model"
		//table.setBackground(new Color(0x5b6c8b));//whenever row is added row color is this
		table.setForeground(Color.GRAY);//row text color is this
		table.setRowHeight(60);//row height
		table.setSelectionBackground(new Color(0x1754f1));//this will change color when select row
		table.setShowVerticalLines(false);//not show vertical lines
		
		/*edit table header*/
		table.getTableHeader().setFont(new Font("Georgia",Font.BOLD,14));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(232,57,95));
		table.getTableHeader().setForeground(Color.WHITE);
		
		scrollPane.setViewportView(table);
		
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
