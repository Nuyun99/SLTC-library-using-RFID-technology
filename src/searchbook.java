import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.*;
import java.io.*;

public class searchbook extends JFrame implements ActionListener{
	
	JTextField searchText;
	JButton srchBtn ;
	JButton backBtn;
	JTable table;
	DefaultTableModel model;

	searchbook(){
		frontEnd();
	}
	public void clearTable(){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int rows = model.getRowCount();
		if(rows > 0){
			for (int i = 0; i<rows; i++){
				model.removeRow(0);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backBtn) {
			this.dispose();
			new adminview();
		}
		if (e.getSource() == srchBtn){
				try{
					if (!searchText.getText().isEmpty()) {
						Class.forName("java.sql.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbproject", "harindu123", "Zyco@123fuckinggood");
						Statement stmt = con.createStatement();
						String qry = "SELECT * FROM `book_table` WHERE `Book Title` LIKE '%" + searchText.getText() + "%' OR `Book Author` like '%" + searchText.getText() + "%';";
						System.out.println("Searched SQL query: " + qry);
						ResultSet rs = stmt.executeQuery(qry);
						byte[] image = null;
						boolean matchingFound = false;
						while (rs.next()) {
							//have to get byte image from data_base.
							image = rs.getBytes("bookImg");
							Image img = Toolkit.getDefaultToolkit().createImage(image);
							ImageIcon test = libMethod.scaledImg(img,58,44);
							model.addRow(new Object[]{test , rs.getString("Book Title"), rs.getString("Book Author"), rs.getString("Genre"), rs.getString("Edition"), rs.getString("RFID_NO"), rs.getString("Rack Number"), rs.getString("Section"), rs.getString("About")});
							this.setVisible(true);
							matchingFound = true;
						}
						if(!matchingFound){
							JOptionPane.showMessageDialog(null, "No Matching Found");
						}
					}else{
						clearTable();
					}
				}catch(Exception exception){
					exception.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error in Connectivity");
					System.out.println(exception.getLocalizedMessage());
				}
			}
	}
	public void frontEnd(){
		getContentPane().setBackground(new Color(0x5b6c8b));

		ImageIcon usr = new ImageIcon("search.png");
		ImageIcon src = new ImageIcon("src.png");
		ImageIcon back = libMethod.scaledImg("back.png",30,30);

		this.setBounds(100, 100, 895, 664);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		//this.setResizable(true);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 904, 124);
		panel.setBackground(new Color(0xF50097EE));
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
		backBtn.setBackground(new Color(0xF50097EE));
		backBtn.setBounds(5, 5, 30, 30);
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
				clearTable();
				searchText.setText("");

			}
		});
		srchBtn.setFocusable(false);
		srchBtn.setBorder(null);
		srchBtn.setBackground(Color.WHITE);
		srchBtn.setIcon(src);
		srchBtn.setBounds(623, 23, 32, 32);
		srchBtn.addActionListener(this);
		bottomPanel.add(srchBtn);

		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBackground(new Color(0x5B6C8B));
		scrollPane.setBounds(27, 232, 834, 410);
		getContentPane().add(scrollPane);

		model = new DefaultTableModel(); // making model object in default table model class
		Object[] coloumns = {"Picture" , "Book Title" ,"Author" , "Genre" , "Edition" , "RFID_NO"};//coloums as object data type .. if want to change string data type
		model.setColumnIdentifiers(coloumns); // pass our String array name

		table = new JTable(model){



			public boolean editCellAt(int row, int column, java.util.EventObject e) {//prevent from editing text in rows.
				return false;
			}
			public Class getColumnClass(int column) { //show picture in first column.
				return (column == 0) ? Icon.class : Object.class;
			}
		};
		table.setForeground(Color.GRAY);//row text color is this
		table.setRowHeight(60);//row height
		table.setSelectionBackground(new Color(0xF50097EE));//this will change color when select row
		table.setShowVerticalLines(false);//not show vertical lines

		/*edit table header*/
		table.getTableHeader().setFont(new Font("Georgia",Font.BOLD,14));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(232,57,95));
		table.getTableHeader().setForeground(Color.WHITE);
		table.sizeColumnsToFit(8);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );

		table.setFont(new Font("Georgia",Font.BOLD,13));
		scrollPane.setViewportView(table);
		this.setVisible(true);
	}
}
