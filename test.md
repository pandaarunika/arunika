import java.util.HashMap;
import java.util.Map;

public class DynamoDBResponseConverter {

    public static void main(String[] args) {
        // Assuming `dynamodbResponse` is the DynamoDB response containing the `fileDtls` column
        Map<String, Object> dynamodbResponse = new HashMap<>();
        dynamodbResponse.put("fileDtls", Map.of(
                "validation_rejected", Map.of("key1", 10, "key2", 20),
                "reason", Map.of(
                        "inner_key1", Map.of("sub_key1", 100, "sub_key2", 200),
                        "inner_key2", Map.of("sub_key3", 300, "sub_key4", 400)
                )
        ));

        // Convert `fileDtls` to a model of a map of string and integer values
        Map<String, Object> fileDetailsModel = new HashMap<>();
        Map<String, Object> fileDtls = (Map<String, Object>) dynamodbResponse.get("fileDtls");
        for (Map.Entry<String, Object> entry : fileDtls.entrySet()) {
            if (entry.getValue() instanceof Map) {
                Map<String, Object> innerMap = new HashMap<>();
                ((Map<String, Object>) entry.getValue()).forEach((k, v) -> innerMap.put(k, Integer.parseInt(v.toString())));
                fileDetailsModel.put(entry.getKey(), innerMap);
            } else {
                fileDetailsModel.put(entry.getKey(), entry.getValue());
            }
        }

        // Extract inner map values for the `reason` field
        Map<String, Map<String, Integer>> reasonInnerMapValues = new HashMap<>();
        if (fileDtls.containsKey("reason")) {
            Map<String, Map<String, Integer>> reasonOuterMap = (Map<String, Map<String, Integer>>) fileDtls.get("reason");
            reasonOuterMap.forEach((innerKey, innerMap) -> {
                Map<String, Integer> innerMapValues = new HashMap<>();
                innerMap.forEach((k, v) -> innerMapValues.put(k, Integer.parseInt(v.toString())));
                reasonInnerMapValues.put(innerKey, innerMapValues);
            });
        }

        System.out.println("File Details Model: " + fileDetailsModel);
        System.out.println("Inner Map Values for Reason: " + reasonInnerMapValues);
    }
}
