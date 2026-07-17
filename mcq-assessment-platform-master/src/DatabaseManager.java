import java.sql.*;

public class DatabaseManager {

    private static final String URL = "jdbc:mysql://localhost:3306/cyberlearn_db";
    private static final String USER = ""; // enter your username
    private static final String PASSWORD = ""; // enter your password

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ MySQL JDBC Driver Loaded.");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ MySQL JDBC Driver not found. Add the connector .jar to classpath.");
        }
    }

    public static boolean addUser(String username) {
        String queryCheck = "SELECT * FROM users WHERE username = ?";
        String queryInsert = "INSERT INTO users (username, highscore) VALUES (?, 0)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement psCheck = conn.prepareStatement(queryCheck)) {

            psCheck.setString(1, username);
            ResultSet rs = psCheck.executeQuery();

            if (rs.next()) {
                System.out.println("⚠️ User already exists: " + username);
                return false;
            } else {
                try (PreparedStatement psInsert = conn.prepareStatement(queryInsert)) {
                    psInsert.setString(1, username);
                    psInsert.executeUpdate();
                    System.out.println("✅ New user added: " + username);
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void updateHighscore(String username, int newScore) {
        String query = "UPDATE users SET highscore = GREATEST(highscore, ?) WHERE username = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, newScore);
            ps.setString(2, username);
            ps.executeUpdate();
            System.out.println("🏆 Highscore updated for user: " + username);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getUserScore(String username) {
        String query = "SELECT highscore FROM users WHERE username = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("highscore");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1; // No score yet
    }

    public static String getHighscores() {
        StringBuilder sb = new StringBuilder();
        String query = "SELECT username, highscore FROM users ORDER BY highscore DESC";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                sb.append(rs.getString("username"))
                        .append(" - ")
                        .append(rs.getInt("highscore"))
                        .append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

}
