package db;

import Item.Armes.Arme;
import Item.Sortileges.Sort;
import Item.Weapon;

import java.sql.*;
import java.util.UUID;

public class WeaponDAO extends ConnectionDAO {

    public void createWeapon(Weapon weapon) {
        String sql = "INSERT INTO Weapon(id, name,attack, type, value, weight) VALUES(?, ?, ?, ?, ?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, weapon.getId().toString());
            pstmt.setString(2, weapon.getName());
            pstmt.setInt(3, weapon.getAttack());
            pstmt.setString(4, weapon.getWeaponType());
            pstmt.setInt(5, weapon.getValue());
            pstmt.setInt(6, weapon.getWeight());

            pstmt.executeUpdate();
            System.out.println("Weapon created successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public Weapon getWeaponById(String id) {
        String sql = "SELECT * FROM Weapon WHERE id = id";
        Weapon weapon = null;

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()){

                if (rs.next()) {
                    String type = rs.getString("type");
                    if("Sword".equalsIgnoreCase(type)){
                        weapon = new Arme();
                    } else if ("Sort".equalsIgnoreCase(type)){
                        weapon = new Sort();
                    }
                    weapon.setId(UUID.fromString(rs.getString("id")));
                    weapon.setName(rs.getString("name"));
                    weapon.setAttack(rs.getInt("attack"));
                    weapon.setWeaponType(rs.getString("type"));
                    weapon.setValue(rs.getInt("value"));
                    weapon.setWeight(rs.getInt("weight"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving weapon: " + e.getMessage());
        }
        return weapon;
    }
}

