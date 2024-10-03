package db;

import Item.Armes.Arme;
import Item.Armures.Bouclier;
import Item.Defense;
import Item.PhiltresSoin.Philtre;
import Item.Sortileges.Sort;
import Item.Weapon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class DefenseDAO extends ConnectionDAO {

    public void createDefense(Defense defense) {
        String sql = "INSERT INTO Defense(id, name, defense,type ,weight, value ) VALUES(?, ?, ?, ?, ?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, defense.getId().toString());
            pstmt.setString(2, defense.getName());
            pstmt.setInt(3, defense.getDefense());
            pstmt.setString(4, defense.getType());
            pstmt.setInt(5, defense.getWeight());
            pstmt.setInt(6, defense.getValue());

            pstmt.executeUpdate();
            System.out.println("Defense created successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public Defense getDefenseById(String id) {
        String sql = "SELECT * FROM Defense WHERE id = id";
        Defense defense = null;

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()){

                if (rs.next()) {
                    String type = rs.getString("type");
                    if("Bouclier".equalsIgnoreCase(type)){
                        defense = new Bouclier();
                    } else if ("Philtre".equalsIgnoreCase(type)){
                        defense = new Philtre();
                    }
                    defense.setId(UUID.fromString(rs.getString("id")));
                    defense.setName(rs.getString("name"));
                    defense.setDefense(rs.getInt("defense"));
                    defense.setType(rs.getString("type"));
                    defense.setValue(rs.getInt("value"));
                    defense.setWeight(rs.getInt("weight"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving weapon: " + e.getMessage());
        }

        return defense;
    }
}
