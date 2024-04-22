import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class MapToCsv {

    // Utility method to format a cell value for CSV
    public static String formatCellValue(String value) {
        // Check if the value contains a comma, newline, or double quote
        if (value.contains(",") || value.contains("\n") || value.contains("\"")) {
            // Escape double quotes in the value
            value = value.replace("\"", "\"\"");
            // Wrap the value in double quotes
            value = "\"" + value + "\"";
        }
        return value;
    }

    public static class Model {
        // Define the properties of your Model class
        private String name;
        private
