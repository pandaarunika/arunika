import java.util.ArrayList;
import java.util.List;

class Transaction {
    String reportable;
    String error;

    public Transaction(String reportable, String error) {
        this.reportable = reportable;
        this.error = error;
    }

    public String getReportable() {
        return reportable;
    }

    public String getError() {
        return error;
    }
}

public class TransactionFilter {
    public static void main(String[] args) {
        // Sample transactions
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("No", "Some error"));
        transactions.add(new Transaction("Yes", "Another error"));
        transactions.add(new Transaction("No", "Error containing x"));
        transactions.add(new Transaction("Yes", "Error containing y"));
        transactions.add(new Transaction("No", "Error containing z"));

        // Filter transactions
        List<Transaction> filteredTransactions = filterTransactions(transactions);

        // Print filtered transactions
        for (Transaction transaction : filteredTransactions) {
            System.out.println("Reportable: " + transaction.getReportable() + ", Error: " + transaction.getError());
        }
    }

    public static List<Transaction> filterTransactions(List<Transaction> transactions) {
        List<Transaction> filteredTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getReportable().equals("No") && transaction.getError().contains("x/y/z")) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }
}
