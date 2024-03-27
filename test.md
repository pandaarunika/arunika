fimport org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CombineCSVFiles {
    public static void main(String[] args) {
        // Specify the directory containing the CSV files
        String folderPath = "/path/to/your/temp/folder";

        // Specify the column indices for columns AC, AY, and AZ
        int[] columnIndices = {28, 50, 51}; // Indices: AC=28, AY=50, AZ=51

        // Initialize a list to store CSV records
        List<List<String>> allRecords = new ArrayList<>();

        // Iterate through each file in the folder
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".csv")) {
                    try (FileReader fileReader = new FileReader(file);
                         CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fileReader)) {

                        // Add records to the list
                        for (CSVRecord record : csvParser) {
                            List<String> selectedColumns = new ArrayList<>();
                            for (int index : columnIndices) {
                                selectedColumns.add(record.get(index));
                            }
                            allRecords.add(selectedColumns);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        // Specify the output file path
        String outputPath = "/path/to/output/folder/combined_data.csv";

        // Write the combined records to a new CSV file
        try (FileWriter fileWriter = new FileWriter(outputPath);
             CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT)) {

            // Write headers
            List<String> headers = new ArrayList<>();
            headers.add("AC");
            headers.add("AY");
            headers.add("AZ");
            csvPrinter.printRecord(headers);

            // Write records
            for (List<String> record : allRecords) {
                csvPrinter.printRecord(record);
            }

            System.out.println("Combined data saved to: " + outputPath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
