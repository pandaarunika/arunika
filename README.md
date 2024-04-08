import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        // Input date string from Oracle
        String oracleDate = "08-APR-24 04:51:41:351340000";

        // Extract the date part from the Oracle date string
        String dateString = oracleDate.substring(0, 9); // Extracts "08-APR-24"

        // Parse the date string into a LocalDate object
        LocalDate localDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd-MMM-yy"));

        // Print the LocalDate
        System.out.println("LocalDate: " + localDate);
    }
}
