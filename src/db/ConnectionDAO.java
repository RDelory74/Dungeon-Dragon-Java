package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.ClassNotFoundException;

public abstract class ConnectionDAO {

    public  Connection connect() {
        // Connection
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost:3306/DonjonsEtDragons";
            String user = "root";
            String password = "Thehorseinthegalacticmoon4fun!";
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println("Unable to create driver instance: " + e.getMessage());
        }
        return conn;
    }
    public String testConnection() {
        Connection conn = connect(); // Appelle la méthode privée pour établir la connexion
        if (conn != null) {
            return "Successfully connected to the database.";
        } else {
            return "Connection to the database failed.";
        }
    }
}
