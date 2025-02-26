import org.json.JSONObject;

public class MergeJsonOrg {
    public static void main(String[] args) {
        JSONObject json1 = new JSONObject("{ \"name\": \"Alice\", \"age\": 25 }");
        JSONObject json2 = new JSONObject("{ \"email\": \"alice@example.com\", \"city\": \"New York\" }");

        for (String key : json2.keySet()) {
            json1.put(key, json2.get(key));
        }

        System.out.println(json1.toString(4));
    }
}
