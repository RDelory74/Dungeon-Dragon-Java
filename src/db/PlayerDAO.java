package db;

import Donjon_Dragons.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerDAO {

    private Connection connect() {
        // Connection
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/DonjonsEtDragons";
            String user = "root";
            String password = "password";
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void createPlayer(Player player) {

        // Méthode pour créer un joueur
        String sql = "INSERT INTO Player(name, pv, strength, weapon, defense, type, exp, or, level) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, player.getName());
            pstmt.setInt(2, player.getVie());
            pstmt.setInt(3, player.getStrength());
            pstmt.setString(4, player.getWeapon());
            pstmt.setString(5, player.getDefense());
            pstmt.setString(6, player.getType());
            pstmt.setInt(7, player.getExp());
            pstmt.setInt(8, player.getOr());
            pstmt.setInt(9, player.getLevel());

            pstmt.executeUpdate();
            System.out.println("Player created successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /*
    // Méthode pour afficher tous les joueurs
    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT * FROM Player";

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Player player = new Player();
                player.setName(rs.getString("name"));
                player.setPv(rs.getInt("pv"));
                player.setStrength(rs.getInt("strength"));
                player.setWeapon(rs.getString("weapon"));
                player.setDefense(rs.getString("defense"));
                player.setType(rs.getString("type"));
                player.setExp(rs.getInt("exp"));
                player.setOr(rs.getInt("or"));
                player.setLevel(rs.getInt("level"));
                players.add(player);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return players;
    }
*/
}
