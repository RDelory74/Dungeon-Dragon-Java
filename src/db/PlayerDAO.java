package db;

import Donjon_Dragons.Player;
import Item.PhiltresSoin.Philtre;
import Item.Sortileges.Sort;
import Type.Warrior;
import Type.Wizard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PlayerDAO extends ConnectionDAO {



    public void createPlayer(Player player) {

        // Méthode pour créer un joueur
        String sql = "INSERT INTO Player(id,name, pv, strength, weapon_id, defense_id, gold, exp, level, inventoryCapacity) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            WeaponDAO weaponDAO = new WeaponDAO();
            weaponDAO.createWeapon(player.getWeapon());

            DefenseDAO defenseDAO = new DefenseDAO();
            defenseDAO.createDefense(player.getDefense());

            pstmt.setString(1, player.getName());
            pstmt.setInt(2, player.getVie());
            pstmt.setInt(3, player.getStrength());
            pstmt.setString(4, player.getWeapon().getId().toString()); // new WeaponDAO creatWeapon retourn Id_weapon
            pstmt.setString(5, player.getDefense().getId().toString());
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



    // Méthode pour afficher tous les joueurs
    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT * FROM Player";

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {


            while (rs.next()) {
                Player player = null;
                String type = rs.getString("type");

                // Instanciation selon le type
                if ("Wizard".equalsIgnoreCase(type)) {
                    player = new Wizard(rs.getString("name"));
                } else if ("Warrior".equalsIgnoreCase(type)) {
                    player = new Warrior(rs.getString("name"));
                }

                // Remplir les attributs du joueur
                if (player != null) {
                    player.setPv(rs.getInt("pv"));
                    player.setStrength(rs.getInt("strength"));
                    if ("Wizard".equalsIgnoreCase(type)) {
                        player.setWeapon(new Sort());
                    } else if ("Warrior".equalsIgnoreCase(type)) {
                        player.setDefense(new Philtre());
                    }
                    player.setExp(rs.getInt("exp"));
                    player.setOr(rs.getInt("gold"));
                    player.setLevel(rs.getInt("level"));
                    players.add(player);
                }
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return players;
    }
    public void updatePlayer(Player player) {
        String sql = "UPDATE Player SET name = ?, pv = ?, strength = ?, weapon = ?, defense = ?, type = ?, exp = ?, gold = ?, level = ? WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Mettre à jour les informations du joueur
            pstmt.setString(1, player.getName());
            pstmt.setInt(2, player.getVie());
            pstmt.setInt(3, player.getStrength());
            pstmt.setString(4, player.getWeapon().getName());
            pstmt.setString(5, player.getDefense().getName());
            pstmt.setString(6, player.getType());
            pstmt.setInt(7, player.getExp());
            pstmt.setInt(8, player.getOr());
            pstmt.setInt(9, player.getLevel());
            pstmt.setString(10, player.getId().toString()); // Utilise l'ID comme clé

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
    // Méthode pour récupérer un joueur par son nom

    public Player getPlayerByName(String playerName) {
        String sql = "SELECT * FROM Player WHERE name = ?";
        Player player = null;

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, playerName); // Requête basée sur le nom du joueur

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // Vérification du type pour instancier la bonne sous-classe (Warrior ou Wizard)
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
                        if ("Wizard".equalsIgnoreCase(type)) {
                            player.setWeapon(new Sort());
                        } else if ("Warrior".equalsIgnoreCase(type)) {
                            player.setDefense(new Philtre());
                        }
                        player.setExp(rs.getInt("exp"));
                        player.setOr(rs.getInt("gold"));
                        player.setLevel(rs.getInt("level"));
                    }
                } else {
                    System.out.println("Player not found.");
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

            pstmt.setString(1, playerId); // Utiliser l'ID pour identifier le joueur à supprimer

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
    public Player getLastPlayer() {
        String sql = "SELECT * FROM Player ORDER BY id DESC LIMIT 1";
        Player player = null;

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                // Vérification du type pour instancier la bonne sous-classe (Warrior ou Wizard)
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
                    if ("Wizard".equalsIgnoreCase(type)) {
                        player.setWeapon(new Sort());
                    } else if ("Warrior".equalsIgnoreCase(type)) {
                        player.setDefense(new Philtre());
                    }
                    player.setExp(rs.getInt("exp"));
                    player.setOr(rs.getInt("or"));
                    player.setLevel(rs.getInt("level"));
                }
            } else {
                System.out.println("No players found.");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving last player: " + e.getMessage());
        }

        return player;
    }
}
