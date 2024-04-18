import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WriteMapToFile {
    public static void main(String[] args) {
        // Create a sample map
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);

        // Create an ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Write the map to a JSON file
        try {
            objectMapper.writeValue(new File("map.json"), map);
            System.out.println("Map written to JSON file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ReadMapFromFile {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read the map from the JSON file
            Map<String, Integer> map = objectMapper.readValue(new File("map.json"), Map.class);
            System.out.println("Map read from JSON file: " + map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
