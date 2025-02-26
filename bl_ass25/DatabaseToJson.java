import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class User {
    public int id;
    public String name;
    public String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}

public class DatabaseToJson {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users");

        List<User> users = new ArrayList<>();
        while (rs.next()) {
            users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonReport = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);
        
        System.out.println(jsonReport);

        conn.close();
    }
}
