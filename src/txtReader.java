import java.io.*;

import static java.lang.System.in;

public class txtReader {

    static private String RFID_NO = null;

    public static String getRfidNo() throws IOException {
        try{
            RFID_NO = null;
            File file = new File("rfidText.txt");
            BufferedReader br = new BufferedReader(new FileReader("rfidText.txt"));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null)   {
                // Print the content on the console
                System.out.println (strLine);
                RFID_NO = strLine;
            }
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
            //Close the input stream
            in.close();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }finally{
            in.close();
        }
        return RFID_NO;
    }
}
