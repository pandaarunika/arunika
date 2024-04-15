import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.Map;

public class DynamoDBResponseConverter {

    public static void main(String[] args) {
        // Assuming `dynamodbResponse` is the DynamoDB response containing the `fileDtls` column
        Map<String, AttributeValue> dynamodbResponse = null; // Assuming you have the actual DynamoDB response

        // Convert `fileDtls` to a model of a map of string and integer values
        Map<String, Object> fileDetailsModel = new HashMap<>();
        Map<String, AttributeValue> fileDtls = dynamodbResponse.get("fileDtls").getM();
        for (Map.Entry<String, AttributeValue> entry : fileDtls.entrySet()) {
            if (entry.getValue().getM() != null) {
                Map<String, AttributeValue> innerMap = entry.getValue().getM();
                Map<String, Integer> innerMapValues = new HashMap<>();
                for (Map.Entry<String, AttributeValue> innerEntry : innerMap.entrySet()) {
                    innerMapValues.put(innerEntry.getKey(), Integer.parseInt(innerEntry.getValue().getN()));
                }
                fileDetailsModel.put(entry.getKey(), innerMapValues);
            } else {
                fileDetailsModel.put(entry.getKey(), entry.getValue().getN()); // Assuming the value is a number
            }
        }

        // Extract inner map values for the `reason` field
        Map<String, Map<String, Integer>> reasonInnerMapValues = new HashMap<>();
        if (fileDtls.containsKey("reason")) {
            Map<String, AttributeValue> reasonOuterMap = fileDtls.get("reason").getM();
            for (Map.Entry<String, AttributeValue> outerEntry : reasonOuterMap.entrySet()) {
                Map<String, AttributeValue> innerMap = outerEntry.getValue().getM();
                Map<String, Integer> innerMapValues = new HashMap<>();
                for (Map.Entry<String, AttributeValue> innerEntry : innerMap.entrySet()) {
                    innerMapValues.put(innerEntry.getKey(), Integer.parseInt(innerEntry.getValue().getN()));
                }
                reasonInnerMapValues.put(outerEntry.getKey(), innerMapValues);
            }
        }

        System.out.println("File Details Model: " + fileDetailsModel);
        System.out.println("Inner Map Values for Reason: " + reasonInnerMapValues);
    }
}
