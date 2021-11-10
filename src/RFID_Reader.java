import javax.swing.*;
import java.awt.*;

public class RFID_Reader extends Thread{
    private String RFIDnumber ="1025859658" ;

    public String getRFIDnumber() {
        return RFIDnumber;
    }

    public void run()
    {   int n=0;

        try {
            while(n<5) {
                System.out.println("running...\n");
                n++;
                sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();

        }

    }


}
