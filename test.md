import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ListToCsv {

    // Function to convert a list of lists to a CSV file
    public static void convertListToCsv(List<List<Object>> data, List<Object> header, String csvFilePath) throws IOException {
        // Create a FileWriter to write to the CSV file
        try (FileWriter csvWriter = new FileWriter(csvFilePath)) {
            // Write the header
            for (int i = 0; i < header.size(); i++) {
                csvWriter.write(header.get(i).toString());
                
                // Add a comma if it's not the last element in the header
                if (i < header.size() - 1) {
                    csvWriter.write(",");
                }
            }
            // Write a newline after the header row
            csvWriter.write("\n");
            
            // Write each data row
            for (List<Object> row : data) {
                for (int i = 0; i < row.size(); i++) {
                    csvWriter.write(row.get(i).toString());
                    
                    // Add a comma if it's not the last element in the row
                    if (i < row.size() - 1) {
                        csvWriter.write(",");
                    }
                }
                // Write a newline after each row
                csvWriter.write("\n");
            }
        }
    }

    public static void main(String[] args) {
        // Example usage:
        // Define a List of Objects for the header
        List<Object> header = List.of("Name", "Age", "Occupation");

        // Define a List of Lists containing data
        List<List<Object>> data = List.of(
            List.of("John Doe", 30, "Engineer"),
            List.of("Jane Smith", 25, "Doctor")
        );

        // Specify the path to the CSV file
        String csvFilePath = "output.csv";

        try {
            // Convert the list of lists and header to a CSV file
            convertListToCsv(data, header, csvFilePath);
            System.out.println("CSV file created successfully at " + csvFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
