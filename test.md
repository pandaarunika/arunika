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

        // Specify the table name
        String tableName = "table_name";

        // Define the scan request
        ScanRequest scanRequest = ScanRequest.builder()
                .tableName(tableName)
                .build();

        // Perform the scan operation
        try {
            ScanResponse response = dynamoDbClient.scan(scanRequest);

            // Process the response
            List<CobDtResponse> cobDtResponses = response.items().stream()
                    .map(item -> {
                        String cobDt = item.get("cobDt").s();
                        Map<String, AttributeValue> sourceMap = item.get("Source").m();

                        int paymentSourceCount = (int) sourceMap.values().stream()
                                .map(AttributeValue::s)
                                .filter(source -> source.contains("PAYMENT"))
                                .count();

                        Map<String, Integer> otherSourceCounts = sourceMap.values().stream()
                                .map(AttributeValue::s)
                                .filter(source -> !source.contains("PAYMENT"))
                                .collect(Collectors.toMap(
                                        source -> source,
                                        source -> 1,
                                        Integer::sum
                                ));

                        return new CobDtResponse(cobDt, paymentSourceCount, otherSourceCounts);
                    })
                    .collect(Collectors.toList());

            // Print or process the CobDtResponse objects as needed
            cobDtResponses.forEach(System.out::println);

        } catch (DynamoDbException e) {
            System.err.println("Unable to scan the table: " + e.getMessage());
        } finally {
            dynamoDbClient.close();
        }
    }
}
