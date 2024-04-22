import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ListToCsv {
    public static void convertListToCsv(List<List<Object>> data, String csvFilePath) throws IOException {
        // Create a FileWriter to write to the CSV file
        try (FileWriter csvWriter = new FileWriter(csvFilePath)) {
            // Iterate through the list of lists
            for (List<Object> row : data) {
                // Iterate through the elements in each row
                for (int i = 0; i < row.size(); i++) {
                    // Write each element to the CSV file
                    // Convert the element to a string and write it
                    csvWriter.write(row.get(i).toString());
                    
                    // If it's not the last element, add a comma
                    if (i < row.size() - 1) {
                        csvWriter.write(",");
                    }
                }
                
                // After each row, write a newline
                csvWriter.write("\n");
            }
        }
    }

    public static void main(String[] args) {
        // Example usage:
        // Define a List of Lists containing data
        List<List<Object>> data = List.of(
            List.of("Name", "Age", "Occupation"),
            List.of("John Doe", 30, "Engineer"),
            List.of("Jane Smith", 25, "Doctor")
        );
        
        // Specify the path to the CSV file
        String csvFilePath = "output.csv";
        
        try {
            // Convert the list of lists to a CSV file
            convertListToCsv(data, csvFilePath);
            System.out.println("CSV file created successfully at " + csvFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
