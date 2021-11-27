import javax.swing.*;
import java.awt.*;

public class libMethod {
    static protected ImageIcon scaledImg(String path, int x, int y) {

        ImageIcon newimageicon = new ImageIcon(path);
        Image image = newimageicon.getImage();
        Image newimg = image.getScaledInstance(x, y,  Image.SCALE_SMOOTH); // scale it the smooth way
        newimageicon = new ImageIcon(newimg);

        return newimageicon;
    }

}
