import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DynamoDBScanRequest {

    public static void main(String[] args) {
        // Set up DynamoDB client
        DynamoDbClient dynamoDbClient = DynamoDbClient.builder()
                .region(Region.US_EAST_1) // Replace with your desired region
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();

        // Get today's date in the format expected by DynamoDB (YYYY-MM-DD)
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String todayString = today.format(formatter);

        // Specify the table name
        String tableName = "table_name";

        // Define the scan request
        Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
        expressionAttributeValues.put(":date", AttributeValue.builder().s(todayString).build());

        ScanRequest scanRequest = ScanRequest.builder()
                .tableName(tableName)
                .filterExpression("cobDt = :date")
                .expressionAttributeValues(expressionAttributeValues)
                .build();

        // Perform the scan operation
        try {
            ScanResponse response = dynamoDbClient.scan(scanRequest);
            
            // Group the data by source
            Map<String, List<Map<String, AttributeValue>>> groupedBySource = response.items().stream()
                    .collect(Collectors.groupingBy(item -> item.get("source").s()));

            // Print the grouped data
            groupedBySource.forEach((source, items) -> {
                System.out.println("Source: " + source);
                
                // If source is PAYMENTS, further group by subsource
                if ("PAYMENTS".equals(source)) {
                    Map<String, List<Map<String, AttributeValue>>> groupedBySubsource = items.stream()
                            .collect(Collectors.groupingBy(item -> item.get("subsource").s()));
                    groupedBySubsource.forEach((subsource, subItems) -> {
                        System.out.println("\tSubsource: " + subsource);
                        subItems.forEach(item -> System.out.println("\t" + item));
                    });
                } else {
                    items.forEach(item -> System.out.println(item));
                }
            });
        } catch (DynamoDbException e) {
            System.err.println("Unable to scan the table: " + e.getMessage());
        } finally {
            dynamoDbClient.close();
        }
    }
}
