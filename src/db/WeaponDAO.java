package db;

import Item.Weapon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WeaponDAO extends ConnectionDAO {

    public void createWeapon(Weapon weapon) {
        String sql = "INSERT INTO weapon(id, name, attack, weight, value) VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, weapon.getId().toString());
            pstmt.setString(2, weapon.getName());
            pstmt.setInt(3, weapon.getAttack());
            pstmt.setInt(4, weapon.getWeight());
            pstmt.setInt(5, weapon.getValue());

            pstmt.executeUpdate();
            System.out.println("Weapon created successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
