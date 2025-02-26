import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import java.io.File;

public class ValidateEmailJson {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode schemaNode = objectMapper.readTree(new File("schema.json"));
        JsonNode jsonNode = objectMapper.readTree(new File("data.json"));

        JsonSchema schema = JsonSchemaFactory.byDefault().getJsonSchema(schemaNode);
        ProcessingReport report = schema.validate(jsonNode);

        System.out.println(report.isSuccess() ? "Valid JSON" : "Invalid JSON: " + report);
    }
}
