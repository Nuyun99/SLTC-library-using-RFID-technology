import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;


public class SearchBook extends JFrame {
	
	SearchBook() {
	
		this.setBounds(100, 100, 1142, 756);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setExtendedState(JFrame.MAXIMIZED_BOTH);//maximize both
//		this.setUndecorated(true);//maximize both
//		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(231, 130, 45, 13);
		getContentPane().add(lblNewLabel);
		this.setVisible(true);
	
		
	}
}
