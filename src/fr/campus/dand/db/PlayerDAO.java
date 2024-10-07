package fr.campus.dand.db;

import fr.campus.dand.engine.Player;
import fr.campus.dand.type.Warrior;
import fr.campus.dand.type.Wizard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Here is the PLayerDAO class who manage the connections with the database and allow player to save, load, access and
 * modify the héros.
 */

public class PlayerDAO extends ConnectionDAO {


    public void createPlayer(Player player) {
/**
 * In a String sql variable I set the SQL request
 * Then we instance a connection called conn
 * And we instance a PreparedStatement pstmt which is a connection method with my sql request as arguments.
 */
        // Méthode pour créer un joueur
        String sql = "INSERT INTO Player(id,name, pv, strength, weapon_id, defense_id,type, gold, exp, level, inventoryCapacity) VALUES(?, ?,?, ?, ?, ?, ?, ?, ?, ?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
/**
 * For every new player we instance new object weapon and defense that we store in the database.
 */
            WeaponDAO weaponDAO = new WeaponDAO();
            weaponDAO.createWeapon(player.getWeapon());

            DefenseDAO defenseDAO = new DefenseDAO();
            defenseDAO.createDefense(player.getDefense());

            pstmt.setString(1, player.getId().toString());
            pstmt.setString(2, player.getName());
            pstmt.setInt(3, player.getVie());
            pstmt.setInt(4, player.getStrength());
            pstmt.setString(5, player.getWeapon().getId().toString()); // new WeaponDAO creatWeapon retourn Id_weapon
            pstmt.setString(6, player.getDefense().getId().toString());
            pstmt.setString(7, player.getType());
            pstmt.setInt(8, player.getOr());
            pstmt.setInt(9, player.getExp());
            pstmt.setInt(10, player.getLevel());
            pstmt.setInt(11, player.getInventoryCapacity());

            /**
             * With a new pstmt method (executeUpdate) I set the requested values into the indicate index
             * If the Insert is correctly done we show a message to the user
             */

            pstmt.executeUpdate();
            System.out.println("Player created successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * to show all the player, we create a variable sql with the request SQL inside
     * we instance an ArrayList of players
     *  we return in a while loop (condition while rs.next() meanwhile until rs have a next)
     *  we catch the information by String as "name".
     * @return
     */

    // Méthode pour afficher tous les joueurs
    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT * FROM Player";

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {


            while (rs.next()) {
                System.out.print("Sauvegarde "+ rs.getString("name") +
                        " || " + rs.getString("type") +
                        " || "+ rs.getString("pv") +" Point de vie"+
                        " || " + rs.getString("strength")+" Force"+
                        " || "+ rs.getString("gold") +" Or"+
                        " || "+ rs.getString("Level") +" Level"+
                        " || "+ rs.getString("inventoryCapacity")+"\n");



                /*Player player = null;
                player.(rs.getString("name"));
                player.setPv(rs.getInt("pv"));
                player.setStrength(rs.getInt("strength"));
                player.setWeapon(player.getWeapon());
                player.setDefense(player.getDefense());
                player.setExp(rs.getInt("exp"));
                player.setOr(rs.getInt("gold"));
                player.setLevel(rs.getInt("level"));
                player.setInventoryCapacity(rs.getInt("inventoryCapacity"));
                players.add(player);

                System.out.fr.campus.dand.print(player);*/

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return players;
    }
    public void updatePlayer(Player player) {
        String sql = "UPDATE Player SET name = ?, pv = ?, strength = ?, weapon_id = ?, defense_id = ?,type =?, gold = ?, exp = ?, level = ?, inventoryCapacity = ? WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            /**
             * This functionnality allow player to save his héros in the database
             * I am actually working on the possibility to save héros with his weapon and defenses
             * The important goal here is to get the ID of the item (UUID) to keep the persistence of the unique object through the Game
             */

            // Mettre à jour les informations du joueur
            pstmt.setString(1, player.getName());
            pstmt.setInt(2, player.getVie());
            pstmt.setInt(3, player.getStrength());
            pstmt.setString(4, player.getWeapon().getId().toString());
            pstmt.setString(5, player.getDefense().getId().toString());
            pstmt.setString(6, player.getType());
            pstmt.setInt(7, player.getOr());
            pstmt.setInt(8, player.getExp());
            pstmt.setInt(9, player.getLevel());
            pstmt.setInt(10, player.getInventoryCapacity());
            pstmt.setString(11, player.getId().toString());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Player updated successfully.");
            } else {
                System.out.println("Player not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error updating player: " + e.getMessage());
        }
    }

    /**
     * In this case we will create a new instance player with the values of a saved one.
     * @param playerName
     * @return
     */

    public Player getPlayerByName(String playerName) {
        String sql = "SELECT * FROM Player WHERE name = ?";
        Player player = null;

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, playerName); // Requête basée sur le nom du joueur
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // Vérification du fr.campus.dand.type pour instancier la bonne sous-classe (Warrior ou Wizard)
                    String type = rs.getString("type");
                    if ("Warrior".equalsIgnoreCase(type)) {
                        player = new Warrior(rs.getString("name"));
                    } else if ("Wizard".equalsIgnoreCase(type)) {
                        player = new Wizard(rs.getString("name"));
                    }
                    // Remplir les autres attributs
                    if (player != null) {
                        player.setId(UUID.fromString(rs.getString("id")));
                        player.setPv(rs.getInt("pv"));
                        player.setStrength(rs.getInt("strength"));

                        WeaponDAO weaponDAO = new WeaponDAO();
                        DefenseDAO defenseDAO = new DefenseDAO();
/**
 * Functionality problem here, how to get the id of the item back
 */
                        player.setWeapon(weaponDAO.getWeaponById(rs.getString("weapon_id")));
                        player.setDefense(defenseDAO.getDefenseById(rs.getString("defense_id")));


                        player.setExp(rs.getInt("exp"));
                        player.setOr(rs.getInt("gold"));
                        player.setLevel(rs.getInt("level"));
                        player.setInventoryCapacity(rs.getInt("inventoryCapacity"));
                    }
                } else {
                    System.out.println("No players found.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving player: " + e.getMessage());
        }

        return player;
    }

    public void deletePlayer(String playerId) {
        String sql = "DELETE FROM Player WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
/**
 * // Use Id to identify which player to delete.
 */
            pstmt.setString(1, playerId);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Player deleted successfully.");
            } else {
                System.out.println("Player not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting player: " + e.getMessage());
        }
    }
   /* public Player getLastPlayer() {
        String sql = "SELECT * FROM Player ORDER BY id DESC LIMIT 1";
        Player player = null;

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                // Vérification du fr.campus.dand.type pour instancier la bonne sous-classe (Warrior ou Wizard)
                String type = rs.getString("type");
                if ("Warrior".equalsIgnoreCase(type)) {
                    player = new Warrior(rs.getString("name"));
                } else if ("Wizard".equalsIgnoreCase(type)) {
                    player = new Wizard(rs.getString("name"));
                }
                // Remplir les autres attributs
                if (player != null) {
                    player.setPv(rs.getInt("pv"));
                    player.setStrength(rs.getInt("strength"));
                    player.setWeapon(player.getWeapon());
                    player.setDefense(player.getDefense());
                    player.setExp(rs.getInt("exp"));
                    player.setOr(rs.getInt("gold"));
                    player.setLevel(rs.getInt("level"));
                    player.setInventoryCapacity(rs.getInt("inventoryCapacity"));
                }
            } else {
                System.out.println("No players found.");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving last player: " + e.getMessage());
        }

        return player;
    }*/

}
