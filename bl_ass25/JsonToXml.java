import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;

public class JsonToXml {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File("data.json"));

        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(jsonNode);

        System.out.println(xml);
    }
}
