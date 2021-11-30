import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class book {
    private String bookName;
    private String bookRfid;
    private String bookAuthor;
    private String genre;
    private String edition;
    private String rackNO;
    private String about;
    private String section;
    private String availability;

    public book(String bookRfid) {
        this.bookRfid = bookRfid;
    }
    public book() {

    }
    protected void getInfo(String RFID){
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbproject", "harindu123", "Zyco@123fuckinggood");
            Statement stmt = con.createStatement();
            String qry = "SELECT * FROM `book_table` WHERE `RFID_NO` LIKE '%" + RFID + "%';";
            System.out.println("Searched SQL query: " + qry);
            ResultSet rs = stmt.executeQuery(qry);
            if (rs.next()) {
                bookName= rs.getString("Book Title");
                bookAuthor= rs.getString("Book Author");
                genre = rs.getString("Genre");
                edition = rs.getString("Edition");
                bookRfid = rs.getString("RFID_NO");
                rackNO = rs.getString("Rack Number");
                section = rs.getString("Section");
                about = rs.getString("About");
                availability = rs.getString("Availability");
            }
            else{
                JOptionPane.showMessageDialog(null, "No Matching Found");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookRfid() {
        return bookRfid;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getGenre() {
        return genre;
    }

    public String getEdition() {
        return edition;
    }

    public String getRackNO() {
        return rackNO;
    }

    public String getAbout() {
        return about;
    }

    public String getSection() {
        return section;
    }

    public String getAvailability() {
        return availability;
    }
}
