package exercises.jdbc;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class SecondConnection {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:derby:zoo";
        Map<Integer, String> idToNameMap = new HashMap<>();
        try (Connection conn = DriverManager.getConnection(url)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select id, name from species");
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                idToNameMap.put(id, name);
            }
            System.out.println(idToNameMap);

            ResultSet rs2 = stmt.executeQuery("select count(*) from animal");
            //if(rs.next())
                rs.absolute(1);
               // System.out.println(rs.getInt(1));
        }
    }
}
