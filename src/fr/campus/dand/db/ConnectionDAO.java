package fr.campus.dand.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.ClassNotFoundException;

/**
 * The basic Class to call the database.
 * The method connect is called to connect the project to the database via a try and catch
 * In the Try part we have the creation of a class throught is nam (Class.forName) associate to his method .newInstance();
 * This is what we call a reflection
 * Then I integrate in 3 variables String the url the user and the password to reach the MySQL server.
 * Finally catch will throw exception message depending on the connection problem.
 */

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

    /**
     * method to test the connection,  if conn est different de null return a Succesfully short text
     * @return
     */
    public String testConnection() {
        Connection conn = connect(); // Appelle la méthode privée pour établir la connexion
        if (conn != null) {
            return "Successfully connected to the database.";
        } else {
            return "Connection to the database failed.";
        }
    }
}
