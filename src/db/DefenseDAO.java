package db;

import Item.Defense;
import Item.Weapon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DefenseDAO extends ConnectionDAO {

    public void createDefense(Defense defense) {
        String sql = "INSERT INTO defense(id, name, weight, value, defense ) VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, defense.getId().toString());
            pstmt.setString(2, defense.getName());
            pstmt.setInt(3, defense.getDefense());
            pstmt.setInt(4, defense.getWeight());
            pstmt.setInt(5, defense.getValue());

            pstmt.executeUpdate();
            System.out.println("Defense created successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
