import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Sample list of models
        Map<String, Map<String, Map<String, String>>> modelList = new HashMap<>();

        // Populate the sample data
        modelList.put("cobdate1", Map.of("sor1", Map.of("branch1", "filedtls1"),
                                          "sor2", Map.of("branch2", "filedtls2")));
        modelList.put("cobdate2", Map.of("sor3", Map.of("branch3", "filedtls3"),
                                          "sor4", Map.of("branch4", "filedtls4")));

        // Convert the list to JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(modelList);

        // Print the JSON
        System.out.println(json);
    }
}


<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.8</version> <!-- Or the latest version available -->
</dependency>

