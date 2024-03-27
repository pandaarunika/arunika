gimport com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFilter {
    public static void main(String[] args) {
        // Path to x.csv and y.csv
        String xFilePath = "x.csv";
        String yFilePath = "y.csv";
        String outputFilePath = "filtered_records.csv";

        // Read accounts from y.csv
        List<String> accounts = readAccounts(yFilePath);

        if (accounts != null) {
            // Filter records from x.csv
            filterRecords(xFilePath, accounts, outputFilePath);
        }
    }

    private static List<String> readAccounts(String filePath) {
        List<String> accounts = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // Assuming accounts are in the first column
                accounts.add(nextLine[0]);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
            return null;
        }
        return accounts;
    }

    private static void filterRecords(String filePath, List<String> accounts, String outputFilePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // Assuming payer_account_number is in the first column and payee_account_number is in the second column
                String payerAccountNumber = nextLine[0];
                String payeeAccountNumber = nextLine[1];
                if (accounts.contains(payerAccountNumber) || accounts.contains(payeeAccountNumber)) {
                    // Write the record to the output CSV file
                    writer.writeNext(nextLine);
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
