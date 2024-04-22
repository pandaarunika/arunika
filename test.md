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
        
        // Constructor, getters, and setters (if needed)
        public Model(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }
        
        @Override
        public String toString() {
            // Return the Model object as a CSV row (comma-separated values)
            return name + "," + age + "," + salary;
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
        Map<LocalDate, Map<String, List<Model>>> data = Map.of(
            LocalDate.of(2024, 4, 22), Map.of(
                "Department1", List.of(
                    new Model("John Doe", 30, 60000),
                    new Model("Jane Smith", 25, 55000)
                ),
                "Department2", List.of(
                    new Model("Alice Johnson", 35, 70000),
                    new Model("Bob Wilson", 40, 80000)
                )
            )
        );

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
