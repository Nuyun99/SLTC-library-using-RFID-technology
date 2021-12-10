import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class viewImg {
    private ImageIcon bkcover;
    private JFrame frame;
    viewImg(JFrame viewbkF,ImageIcon bkcover) {
        this.bkcover = bkcover;
        this.frame = viewbkF;
        initialize();
        setMouse(260,375);
    }
    public void setMouse(int x,int y){

        try {
            Robot r = new Robot();
            r.mouseMove( frame.getLocation().x +x, frame.getLocation().y+y);
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }

    private void initialize() {
        frame.getContentPane().setBackground(new Color(91, 108, 139, 255));
        frame.getContentPane().setLayout(null);
        frame.setBounds(0, 0, 563, 670);
        frame.setUndecorated(true);//title bar disappear
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 151, 238, 255));
        panel.setBounds(0, 0, 598, 81);//67
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Book Image");
        lblNewLabel.setBounds(0, 0, 572, 81);
        panel.add(lblNewLabel);
        lblNewLabel.setBackground(new Color(0, 151, 238, 255));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
        lblNewLabel.setForeground(Color.white);

        JLabel bkImgCover = new JLabel(bkcover);
        bkImgCover.setBounds(65, 90, 426, 550);
        bkImgCover.setBorder(new BevelBorder(0, Color.white,Color.white,Color.white,Color.white));

        frame.getContentPane().add(bkImgCover);//BevelBorder.LOWERED
        frame.setVisible(true);
    }
}
