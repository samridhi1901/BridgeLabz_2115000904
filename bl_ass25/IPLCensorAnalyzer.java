import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IPLCensorAnalyzer {
    public static void main(String[] args) throws Exception {
        processJson("ipl_data.json", "ipl_censored.json");
        processCsv("ipl_data.csv", "ipl_censored.csv");
    }

    private static void processJson(String inputFile, String outputFile) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File(inputFile));

        for (JsonNode match : rootNode) {
            maskTeamNames(match, "team1");
            maskTeamNames(match, "team2");
            maskTeamNames(match.get("score"), match.get("team1").asText());
            maskTeamNames(match.get("score"), match.get("team2").asText());
            maskTeamNames(match, "winner");
            ((ObjectNode) match).put("player_of_match", "REDACTED");
        }

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFile), rootNode);
    }

    private static void processCsv(String inputFile, String outputFile) throws Exception {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();

        List<Map<String, String>> records = csvMapper.readerFor(Map.class).with(schema).readValues(new File(inputFile)).readAll();

        for (Map<String, String> record : records) {
            record.put("team1", maskTeam(record.get("team1")));
            record.put("team2", maskTeam(record.get("team2")));
            record.put("winner", maskTeam(record.get("winner")));
            record.put("player_of_match", "REDACTED");
        }

        csvMapper.writer(schema.withHeader()).writeValue(new File(outputFile), records);
    }

    private static void maskTeamNames(JsonNode node, String key) {
        if (node.has(key)) {
            ((ObjectNode) node).put(key, maskTeam(node.get(key).asText()));
        }
    }

    private static String maskTeam(String teamName) {
        String[] parts = teamName.split(" ");
        return parts.length > 1 ? parts[0] + " ***" : teamName;
    }
}
