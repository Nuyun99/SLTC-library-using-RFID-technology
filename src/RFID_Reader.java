import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class RFID_Reader extends Thread{

    private String RFIDnumber ;

    public String getRFIDnumber() {

        return RFIDnumber;
    }

    public void run()
    {
        try {
            while(RFIDnumber == null) {
                System.out.println("running...\n");

                RFIDnumber = txtReader.getRfidNo();
                sleep(1000);
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();

        }

    }


}
