import javax.xml.bind.*;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws JAXBException {
        Map<LocalDate, Map<String, Model>> data = new HashMap<>();
        
        // Populate your data here
        
        // Create a JAXB context
        JAXBContext jaxbContext = JAXBContext.newInstance(DataWrapper.class);

        // Create a marshaller
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Marshal the data into XML
        StringWriter sw = new StringWriter();
        marshaller.marshal(new DataWrapper(data), sw);

        // Output the XML
        System.out.println(sw.toString());
    }
}

class DataWrapper {
    private Map<LocalDate, Map<String, Model>> data;

    public DataWrapper() {
    }

    public DataWrapper(Map<LocalDate, Map<String, Model>> data) {
        this.data = data;
    }

    public Map<LocalDate, Map<String, Model>> getData() {
        return data;
    }

    public void setData(Map<LocalDate, Map<String, Model>> data) {
        this.data = data;
    }
}

class Model {
    // Define your model class here
}
