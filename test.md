import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class MapToCsv {

    public static class Model {
        // Define the properties of your Model class
        private String name;
        private int age;
        private double salary;
        private Map<String, Integer> dataMap;

        // Constructor, getters, and setters (if needed)
        public Model(String name, int age, double salary, Map<String, Integer> dataMap) {
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.dataMap = dataMap;
        }

        // Method to convert the map to a CSV-compatible format (inner table)
        public String convertMapToInnerTable() {
            // StringBuilder to concatenate the map values as an inner table
            StringBuilder innerTable = new StringBuilder();
            
            // Iterate through the map entries
            for (Map.Entry<String, Integer> entry : dataMap.entrySet()) {
                // Concatenate key-value pairs with a separator (e.g., `:`)
                innerTable.append(entry.getKey()).append(":").append(entry.getValue()).append(",");
            }
            
            // Remove the trailing comma, if present
            if (innerTable.length() > 0) {
                innerTable.deleteCharAt(innerTable.length() - 1);
            }
            
            return innerTable.toString();
        }

        @Override
        public String toString() {
            // Return the Model object as a CSV row
            // Include the inner table representation
            return name + "," + age + "," + salary + "," + convertMapToInnerTable();
        }
    }

    // Function to convert a Map<LocalDate, Map<String, List<Model>>> to a CSV file
    public static void convertMapToCsv(Map<LocalDate, Map<String, List<Model>>> data, String csvFilePath) throws IOException {
        // Create a FileWriter to write to the CSV file
        try (FileWriter csvWriter = new FileWriter(csvFilePath)) {
            // Iterate through the outer map (LocalDate -> Map<String, List<Model>>)
            for (Map.Entry<LocalDate, Map<String, List<Model>>> entry : data.entrySet()) {
                LocalDate date = entry.getKey();
                Map<String, List<Model>> innerMap = entry.getValue();

                // Iterate through the inner map (String -> List<Model>)
                for (Map.Entry<String, List<Model>> innerEntry : innerMap.entrySet()) {
                    String key = innerEntry.getKey();
                    List<Model> modelList = innerEntry.getValue();

                    // Iterate through the list of Model objects
                    for (Model model : modelList) {
                        // Write the date, key, and Model object to the CSV file
                        csvWriter.write(date + "," + key + "," + model.toString() + "\n");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example usage:
        // Define your map of data
        Map<LocalDate, Map<String, List<Model>>> data = // Add your data here

        // Specify the path to the CSV file
        String csvFilePath = "output.csv";

        try {
            // Convert the map of data to a CSV file
            convertMapToCsv(data, csvFilePath);
            System.out.println("CSV file created successfully at " + csvFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
